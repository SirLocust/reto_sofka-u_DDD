package com.devsirlocust.challenger.ddd.domain.post.values.id;


import co.com.sofka.domain.generic.Identity;

public class PostId extends Identity {


    private PostId(String uuid) {
        super(uuid);
    }
    public  PostId(){

    }

    public  static PostId of(String id){
        return  new PostId(id);
    }
}
