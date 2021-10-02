package com.devsirlocust.challenger.ddd.domain.post.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.devsirlocust.challenger.ddd.domain.post.values.id.BodyId;
import com.devsirlocust.challenger.ddd.domain.post.values.object.Content;
import com.devsirlocust.challenger.ddd.domain.post.values.object.Title;

public class TitleOfBodyUpgraded extends DomainEvent {
    private BodyId entityId;
    private Title title;

    public TitleOfBodyUpgraded(BodyId entityId, Title title) {
        super("devsirlocust.post.contentofbodyupgrade");
        this.entityId = entityId;
        this.title = title;
    }

    public Title getContent(){
        return this.title;
    }
    public BodyId getEntityId(){
        return  entityId;
    }
}
