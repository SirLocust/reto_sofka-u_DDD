package com.devsirlocust.challenger.ddd.domain.poster.command;

import co.com.sofka.domain.generic.Command;
import com.devsirlocust.challenger.ddd.domain.poster.values.id.UserId;
import com.devsirlocust.challenger.ddd.domain.poster.values.id.PosterId;
import com.devsirlocust.challenger.ddd.domain.poster.values.object.Email;
import com.devsirlocust.challenger.ddd.domain.poster.values.object.NameUser;
import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
public class AddUser implements Command {


    private PosterId posterId;
    private UserId userId;
    private NameUser nameUser;
    private Email email;

    public AddUser(PosterId entityId , UserId userId, NameUser nameUser, Email email){

        this.posterId = entityId;
        this.userId = userId;
        this.nameUser = nameUser;
        this.email = email;
    }
}
