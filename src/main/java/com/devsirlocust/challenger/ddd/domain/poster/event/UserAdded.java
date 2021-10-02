package com.devsirlocust.challenger.ddd.domain.poster.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.devsirlocust.challenger.ddd.domain.poster.values.id.UserId;
import com.devsirlocust.challenger.ddd.domain.poster.values.object.Email;
import com.devsirlocust.challenger.ddd.domain.poster.values.object.NameUser;
import lombok.ToString;

@ToString
public class UserAdded extends DomainEvent{
    
    
    private final UserId userId;
    private final NameUser nameUser;
    private final Email email;

    public UserAdded(UserId entityId , NameUser nameUser, Email email) {
        super("devsirlocust.user.useradded");
        
        //TODO Auto-generated constructor stub
        this.userId = entityId;
        this.nameUser = nameUser;
        this.email = email;
    }

    public UserId getUserId(){
        return this.userId;
    }

    public NameUser getNameUser(){
        return this.nameUser;
    }

    public Email getEmail(){
        return this.email;
    }

}
