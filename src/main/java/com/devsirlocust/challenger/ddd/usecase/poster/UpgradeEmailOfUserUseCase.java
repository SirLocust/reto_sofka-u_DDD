package com.devsirlocust.challenger.ddd.usecase.poster;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.devsirlocust.challenger.ddd.domain.poster.Poster;
import com.devsirlocust.challenger.ddd.domain.poster.command.UpgradeEmailOfUser;

public class UpgradeEmailOfUserUseCase  extends UseCase<RequestCommand<UpgradeEmailOfUser>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<UpgradeEmailOfUser> addBodyRequestCommand) {
        var command = addBodyRequestCommand.getCommand();
        var poster = Poster.from(command.getPosterId(),retrieveEvents());
        poster.upgradeEmailOfUser(command.getEntityId(), command.getEmail());
        emit().onResponse(new ResponseEvents(poster.getUncommittedChanges()));
    }
}
