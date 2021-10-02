package com.devsirlocust.challenger.ddd.domain.post.event;

import co.com.sofka.domain.generic.DomainEvent;

import com.devsirlocust.challenger.ddd.domain.post.values.entity.Comment;
import com.devsirlocust.challenger.ddd.domain.post.values.id.BodyId;
import com.devsirlocust.challenger.ddd.domain.post.values.id.CommentId;
import com.devsirlocust.challenger.ddd.domain.post.values.object.Content;
import com.devsirlocust.challenger.ddd.domain.post.values.object.Text;
import com.devsirlocust.challenger.ddd.domain.post.values.object.Time;
import com.devsirlocust.challenger.ddd.domain.post.values.object.Title;
import lombok.Getter;

@Getter
public class CommentAdded extends DomainEvent{


    private CommentId entityId;
    private Time time;
    private Text text;

    public CommentAdded(CommentId entityId, Time time, Text text) {
        super("devsirlocust.comment.commentadded");
        this.entityId = entityId;
        this.time = time;
        this.text = text;


    }

    public CommentId getCommentId(){
        return this.entityId;
    }

    public Time getTime(){
        return this.time;
    }

    public Text getText(){
        return this.text;
    }

}
