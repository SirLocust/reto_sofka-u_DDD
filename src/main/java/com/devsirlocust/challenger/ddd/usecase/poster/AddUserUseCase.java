package com.devsirlocust.challenger.ddd.usecase.poster;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import com.devsirlocust.challenger.ddd.domain.post.Post;
import com.devsirlocust.challenger.ddd.domain.post.command.AddBody;
import com.devsirlocust.challenger.ddd.domain.poster.Poster;
import com.devsirlocust.challenger.ddd.domain.poster.command.AddUser;

public class AddUserUseCase extends UseCase<RequestCommand<AddUser>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AddUser> addBodyRequestCommand) {
        var command = addBodyRequestCommand.getCommand();
        var post = Poster.from(command.getPosterId(),retrieveEvents());
        post.addUser(command.getUserId(), command.getNameUser(), command.getEmail());
        emit().onResponse(new ResponseEvents(post.getUncommittedChanges()));
    }
}
