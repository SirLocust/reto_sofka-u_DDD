package com.devsirlocust.challenger.ddd.usecase.post;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.devsirlocust.challenger.ddd.domain.post.Post;
import com.devsirlocust.challenger.ddd.domain.post.command.AddBody;
import com.devsirlocust.challenger.ddd.domain.post.command.AddCommnet;

public class AddCommetUseCase extends UseCase<RequestCommand<AddCommnet>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddCommnet> addBodyRequestCommand) {
        var command = addBodyRequestCommand.getCommand();
        var post = Post.from(command.getPostId(),retrieveEvents());
        post.addComment(command.getCommentId(), command.getTime(), command.getText());
        emit().onResponse(new ResponseEvents(post.getUncommittedChanges()));
    }
}
