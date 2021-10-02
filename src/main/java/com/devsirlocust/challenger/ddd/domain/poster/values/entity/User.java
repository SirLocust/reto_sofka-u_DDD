package com.devsirlocust.challenger.ddd.domain.poster.values.entity;

import co.com.sofka.domain.generic.Entity;
import com.devsirlocust.challenger.ddd.domain.poster.values.id.UserId;
import com.devsirlocust.challenger.ddd.domain.poster.values.object.Email;
import com.devsirlocust.challenger.ddd.domain.poster.values.object.NameUser;

import java.util.Objects;

public class User extends Entity<UserId>{

    private NameUser nameUser;
    private Email email;

    public User(UserId entityId , NameUser nameUser, Email email) {
        super(entityId);
        this.email = email;
        this.nameUser = nameUser;
        
    }

    public void upgradeNameUser(NameUser nameUser){
        this.nameUser = Objects.requireNonNull(nameUser);
    }

    public void upgradeEmail(Email email){
        this.email = Objects.requireNonNull(email);
    }

    public NameUser nameUser(){
        return this.nameUser;
    }

    public Email email(){
        return this.email;
    }
    

    
    
}
