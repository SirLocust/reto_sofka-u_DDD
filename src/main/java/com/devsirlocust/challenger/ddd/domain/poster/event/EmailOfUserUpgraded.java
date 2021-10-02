package com.devsirlocust.challenger.ddd.domain.poster.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.devsirlocust.challenger.ddd.domain.poster.values.id.UserId;
import com.devsirlocust.challenger.ddd.domain.poster.values.object.Email;

public class EmailOfUserUpgraded extends DomainEvent {
    private UserId entityId;
    private Email email;

    public EmailOfUserUpgraded(UserId entityId, Email email) {
        super("devsirlocust.poster.emailofuserupgrade");
        this.entityId = entityId;
        this.email = email;
    }

    public Email getEmail(){
        return this.email;
    }
    public UserId getEntityId(){
        return  entityId;
    }
}
