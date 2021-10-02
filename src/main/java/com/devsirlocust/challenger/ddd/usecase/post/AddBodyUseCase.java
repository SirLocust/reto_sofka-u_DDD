package com.devsirlocust.challenger.ddd.usecase.post;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.devsirlocust.challenger.ddd.domain.post.Post;
import com.devsirlocust.challenger.ddd.domain.post.command.AddBody;
import com.devsirlocust.challenger.ddd.domain.post.values.entity.Body;

public class AddBodyUseCase extends UseCase<RequestCommand<AddBody>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddBody> addBodyRequestCommand) {
        var command = addBodyRequestCommand.getCommand();
        var post = Post.from(command.getPostId(),retrieveEvents());
        post.addBody(command.getBodyId(), command.getTitle(), command.getContent());
        emit().onResponse(new ResponseEvents(post.getUncommittedChanges()));
    }
}
