package com.devsirlocust.challenger.ddd.domain.post.values.entity;

import co.com.sofka.domain.generic.Entity;
import com.devsirlocust.challenger.ddd.domain.post.values.id.CommentId;
import com.devsirlocust.challenger.ddd.domain.post.values.object.Text;
import com.devsirlocust.challenger.ddd.domain.post.values.object.Time;

import java.util.Objects;

public class Comment extends Entity<CommentId> {


    private Time time;
    private Text text;

    public Comment(CommentId entityId, Time time, Text text) {
        super(entityId);
        this.time = time;
        this.text = text;
    }

    public void upgradeTime(Time time){
        this.time = Objects.requireNonNull(time);
    }

    public void upgradeText(Text Text){
        this.text = Objects.requireNonNull(text);
    }

    public Time time(){
        return this.time;
    }

    public Text text(){
        return this.text;
    }


}
