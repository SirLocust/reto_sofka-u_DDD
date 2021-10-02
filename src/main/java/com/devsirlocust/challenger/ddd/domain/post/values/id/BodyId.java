package com.devsirlocust.challenger.ddd.domain.post.values.id;

import co.com.sofka.domain.generic.Identity;

public class BodyId extends Identity {

    private BodyId(String uuid) {
        super(uuid);
    }
    public  BodyId(){

    }

    public  static BodyId of(String id){
        return  new BodyId(id);
    }
}
