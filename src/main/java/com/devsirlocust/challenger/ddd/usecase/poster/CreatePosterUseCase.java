package com.devsirlocust.challenger.ddd.usecase.poster;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.devsirlocust.challenger.ddd.domain.post.Post;
import com.devsirlocust.challenger.ddd.domain.post.command.CreatePost;
import com.devsirlocust.challenger.ddd.domain.poster.Poster;
import com.devsirlocust.challenger.ddd.domain.poster.command.CreatePoster;

public class CreatePosterUseCase extends UseCase<RequestCommand<CreatePoster>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CreatePoster> createPostRequestCommand) {
        var command = createPostRequestCommand.getCommand();
        var post = new Poster(
                command.getEntityId()
                ,command.getNickName()
        );
        emit().onResponse(new ResponseEvents(post.getUncommittedChanges()));
    }
}
