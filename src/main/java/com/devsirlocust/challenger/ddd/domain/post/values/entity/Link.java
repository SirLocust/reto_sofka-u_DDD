package com.devsirlocust.challenger.ddd.domain.post.values.entity;

import co.com.sofka.domain.generic.Entity;
import com.devsirlocust.challenger.ddd.domain.post.values.id.LinkId;

import com.devsirlocust.challenger.ddd.domain.post.values.object.TitleLink;
import com.devsirlocust.challenger.ddd.domain.post.values.object.Url;

import java.util.Objects;

public class Link extends Entity<LinkId> {

    private TitleLink titleLink;
    private Url url;

    public Link(LinkId entityId , TitleLink titleLink , Url url) {
        super(entityId);
        this.url = url;
        this.titleLink = titleLink;

    }

    public void upgradeTitleLink(TitleLink titleLink){
        this.titleLink = Objects.requireNonNull(titleLink);
    }

    public void upgradeUrl(Url url){
       this.url = Objects.requireNonNull(url);
    }

    public TitleLink titleLink(){
        return this.titleLink;
    }

    public Url url(){
        return this.url;
    }

}
