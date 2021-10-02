package com.devsirlocust.challenger.ddd.domain.post;

import java.util.List;
import java.util.Objects;

import co.com.sofka.domain.generic.DomainEvent;
import com.devsirlocust.challenger.ddd.domain.post.event.*;
import com.devsirlocust.challenger.ddd.domain.post.values.entity.Body;
import com.devsirlocust.challenger.ddd.domain.post.values.entity.Comment;
import com.devsirlocust.challenger.ddd.domain.post.values.entity.Link;
import com.devsirlocust.challenger.ddd.domain.post.values.id.BodyId;
import com.devsirlocust.challenger.ddd.domain.post.values.id.CommentId;
import com.devsirlocust.challenger.ddd.domain.post.values.id.LinkId;
import com.devsirlocust.challenger.ddd.domain.post.values.id.PostId;
import com.devsirlocust.challenger.ddd.domain.post.values.object.*;


import co.com.sofka.domain.generic.AggregateEvent;


public class Post extends AggregateEvent<PostId> {

    protected NamePost namePost;
    protected Body body;
    protected List<Comment> comments;
    protected List<Link> links;


    
    public Post(PostId entityId, NamePost namePost) {
        super(entityId);
        //TODO Auto-generated constructor stub
        appendChange(new PostCreated(namePost)).apply();
    }

    private Post(PostId entityId){
        super(entityId);
        subscribe(new PostChange(this));
    }

    public static Post from(PostId postId  , List<DomainEvent> events){
        var post = new Post(postId);
        events.forEach(post::applyEvent);
        return post;
    }

    public void addBody(BodyId entityId , Title title , Content content){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(title);
        Objects.requireNonNull(content);

        appendChange(new BodyAdded(entityId, title, content)).apply();
        
    }

    public void addComment(CommentId entityId, Time time, Text text){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(time);
        Objects.requireNonNull(text);
        appendChange(new CommentAdded(entityId,time,text)).apply();
    }
    public void addLink(LinkId entityId , TitleLink titleLink , Url url){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(titleLink);
        Objects.requireNonNull(url);
        appendChange(new LinkAdded(entityId,titleLink,url)).apply();


    }
    public void upgradeContentOfBody(BodyId entityId, Content content){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(content);
        appendChange(new ContentOfBodyUpgraded(entityId,content)).apply();
    }


    
}
