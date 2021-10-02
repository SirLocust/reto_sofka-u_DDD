package com.devsirlocust.challenger.ddd.usecase.post;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.devsirlocust.challenger.ddd.domain.post.Post;
import com.devsirlocust.challenger.ddd.domain.post.command.AddCommnet;
import com.devsirlocust.challenger.ddd.domain.post.command.AddLink;

public class AddLinkUseCase extends UseCase<RequestCommand<AddLink>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddLink> addBodyRequestCommand) {
        var command = addBodyRequestCommand.getCommand();
        var post = Post.from(command.getPostId(),retrieveEvents());
        post.addLink(command.getEntityId(), command.getTitleLink(), command.getUrl());
        emit().onResponse(new ResponseEvents(post.getUncommittedChanges()));
    }
}
