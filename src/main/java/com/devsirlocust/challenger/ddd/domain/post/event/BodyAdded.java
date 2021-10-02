package com.devsirlocust.challenger.ddd.domain.post.event;

import com.devsirlocust.challenger.ddd.domain.post.values.id.BodyId;
import com.devsirlocust.challenger.ddd.domain.post.values.object.Content;
import com.devsirlocust.challenger.ddd.domain.post.values.object.Title;

import co.com.sofka.domain.generic.DomainEvent;
import lombok.ToString;

@ToString
public class BodyAdded extends DomainEvent{
    
    
    private final BodyId bodyId;
    private final Title title;
    private final Content content;

    public BodyAdded(BodyId entityId , Title title , Content content) {
        super("devsirlocust.body.bodyadded");
        
        //TODO Auto-generated constructor stub
        this.bodyId = entityId;
        this.title = title;
        this.content = content;
    }

    public BodyId getBodyId(){
        return this.bodyId;
    }

    public Title getTitle(){
        return this.title;
    }

    public Content getContent(){
        return this.content;
    }

}
