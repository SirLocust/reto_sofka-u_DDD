package com.devsirlocust.challenger.ddd.usecase.post;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.devsirlocust.challenger.ddd.domain.post.Post;
import com.devsirlocust.challenger.ddd.domain.post.command.UpgradeContentOfBody;

public class UpgradeContentOfBodyUseCase extends UseCase<RequestCommand<UpgradeContentOfBody>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpgradeContentOfBody> addBodyRequestCommand) {
        var command = addBodyRequestCommand.getCommand();
        var post = Post.from(command.getPostId(),retrieveEvents());
        post.upgradeContentOfBody(command.getEntityId(), command.getContent());
        emit().onResponse(new ResponseEvents(post.getUncommittedChanges()));
    }
}
