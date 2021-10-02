package com.devsirlocust.challenger.ddd.domain.post.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.devsirlocust.challenger.ddd.domain.post.values.entity.Link;
import com.devsirlocust.challenger.ddd.domain.post.values.id.BodyId;
import com.devsirlocust.challenger.ddd.domain.post.values.id.LinkId;
import com.devsirlocust.challenger.ddd.domain.post.values.object.Content;
import com.devsirlocust.challenger.ddd.domain.post.values.object.Title;
import com.devsirlocust.challenger.ddd.domain.post.values.object.TitleLink;
import com.devsirlocust.challenger.ddd.domain.post.values.object.Url;

public class LinkAdded extends DomainEvent{


    private final LinkId linkId;
    private final TitleLink titleLink;
    private final Url url;

    public LinkAdded(LinkId entityId , TitleLink titleLink , Url url) {
        super("devsirlocust.link.linkadded");
        
        //TODO Auto-generated constructor stub
        this.linkId = entityId;
        this.titleLink = titleLink;
        this.url = url;
    }

    public LinkId getLinkIdId(){
        return this.linkId;
    }

    public TitleLink getTitleLink(){
        return this.titleLink;
    }

    public Url getUrl(){
        return this.url;
    }

}
