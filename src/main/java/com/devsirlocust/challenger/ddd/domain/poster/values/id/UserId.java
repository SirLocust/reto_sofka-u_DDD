package com.devsirlocust.challenger.ddd.domain.poster.values.id;

import co.com.sofka.domain.generic.Identity;

public class UserId extends Identity {

    private UserId(String uuid) {
        super(uuid);
    }
    public UserId(){

    }

    public  static UserId of(String id){
        return  new UserId(id);
    }
}
