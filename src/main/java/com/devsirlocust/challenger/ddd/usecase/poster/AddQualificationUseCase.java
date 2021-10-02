package com.devsirlocust.challenger.ddd.usecase.poster;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.devsirlocust.challenger.ddd.domain.poster.Poster;
import com.devsirlocust.challenger.ddd.domain.poster.command.AddCompany;
import com.devsirlocust.challenger.ddd.domain.poster.command.AddQualification;

public class AddQualificationUseCase extends UseCase<RequestCommand<AddQualification>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddQualification> addBodyRequestCommand) {
        var command = addBodyRequestCommand.getCommand();
        var post = Poster.from(command.getPosterId(),retrieveEvents());
        post.addQualification(command.getEntityId(), command.getScore(), command.getFeedBack());
        emit().onResponse(new ResponseEvents(post.getUncommittedChanges()));
    }
}
