package com.devsirlocust.challenger.ddd.domain.post.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.devsirlocust.challenger.ddd.domain.post.values.object.NamePost;


public class PostCreated extends DomainEvent {
    private final NamePost namePost;
    public PostCreated(NamePost namePost) {
        super("devsirlocust.post.postcreated");
        this.namePost = namePost;
    }

    public NamePost getNamePost(){
        return namePost;
    }
    
}
