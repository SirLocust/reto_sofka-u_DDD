package com.devsirlocust.challenger.ddd.domain.post.values.id;

import co.com.sofka.domain.generic.Identity;

public class CommentId extends Identity {
    private CommentId(String uuid) {
        super(uuid);
    }
    public  CommentId(){

    }

    public  static CommentId of(String id){
        return  new CommentId(id);
    }
}
