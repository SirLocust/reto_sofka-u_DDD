package com.devsirlocust.challenger.ddd.domain.post.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.devsirlocust.challenger.ddd.domain.post.values.id.BodyId;
import com.devsirlocust.challenger.ddd.domain.post.values.object.Content;

public class ContentOfBodyUpgraded extends DomainEvent {
    private BodyId entityId;
    private Content content;

    public ContentOfBodyUpgraded(BodyId entityId, Content content) {
        super("devsirlocust.post.contentofbodyupgrade");
        this.entityId = entityId;
        this.content = content;
    }

    public Content getContent(){
        return this.content;
    }
    public BodyId getEntityId(){
        return  entityId;
    }
}
