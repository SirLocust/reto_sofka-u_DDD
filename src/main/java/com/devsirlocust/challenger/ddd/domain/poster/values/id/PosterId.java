package com.devsirlocust.challenger.ddd.domain.poster.values.id;


import co.com.sofka.domain.generic.Identity;

public class PosterId extends Identity {


    private PosterId(String uuid) {
        super(uuid);
    }
    public PosterId(){

    }

    public  static PosterId of(String id){
        return  new PosterId(id);
    }
}
