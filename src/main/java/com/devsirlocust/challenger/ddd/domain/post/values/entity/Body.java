package com.devsirlocust.challenger.ddd.domain.post.values.entity;

import java.util.Objects;

import com.devsirlocust.challenger.ddd.domain.post.values.id.BodyId;
import com.devsirlocust.challenger.ddd.domain.post.values.object.Content;
import com.devsirlocust.challenger.ddd.domain.post.values.object.Title;

import co.com.sofka.domain.generic.Entity;

public class Body extends Entity<BodyId>{

    private  Title title;
    private  Content content;

    public Body(BodyId entityId , Title title , Content content) {
        super(entityId);
        this.content = content;
        this.title = title;
        
    }

    public void upgradeTitle(Title title){
        this.title = Objects.requireNonNull(title);
    }

    public void upgradeContent(Content content){
        this.content = Objects.requireNonNull(content);
    }

    public Title title(){
        return this.title;
    }

    public Content content(){
        return this.content;
    }
    

    
    
}
