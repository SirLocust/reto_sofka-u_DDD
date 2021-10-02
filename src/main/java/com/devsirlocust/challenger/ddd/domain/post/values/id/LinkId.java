package com.devsirlocust.challenger.ddd.domain.post.values.id;

import co.com.sofka.domain.generic.Identity;

public class LinkId  extends Identity{
    private LinkId(String uuid) {
        super(uuid);
    }
    public LinkId(){

    }

    public  static LinkId of(String id){
        return  new LinkId(id);
    }
}
