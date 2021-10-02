package com.devsirlocust.challenger.ddd.usecase.post;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.devsirlocust.challenger.ddd.domain.post.Post;
import com.devsirlocust.challenger.ddd.domain.post.command.CreatePost;

public class CreatePostUseCase extends UseCase<RequestCommand<CreatePost>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreatePost> createPostRequestCommand) {
        var command = createPostRequestCommand.getCommand();
        var post = new Post(
                command.getEntityId()
                ,command.getNamePost()
        );
        emit().onResponse(new ResponseEvents(post.getUncommittedChanges()));
    }
}
