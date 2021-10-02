package com.devsirlocust.challenger.ddd.usecase.poster;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.devsirlocust.challenger.ddd.domain.post.Post;
import com.devsirlocust.challenger.ddd.domain.post.command.AddCommnet;
import com.devsirlocust.challenger.ddd.domain.poster.Poster;
import com.devsirlocust.challenger.ddd.domain.poster.command.AddCompany;

public class AddCompanyUseCase extends UseCase<RequestCommand<AddCompany>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddCompany> addBodyRequestCommand) {
        var command = addBodyRequestCommand.getCommand();
        var post = Poster.from(command.getPosterId(),retrieveEvents());
        post.addCompany(command.getCompanyId(), command.getNameCompany(), command.getRol());
        emit().onResponse(new ResponseEvents(post.getUncommittedChanges()));
    }
}
