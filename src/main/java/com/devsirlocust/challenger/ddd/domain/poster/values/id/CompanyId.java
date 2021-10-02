package com.devsirlocust.challenger.ddd.domain.poster.values.id;

import co.com.sofka.domain.generic.Identity;

public class CompanyId extends Identity {
    private CompanyId(String uuid) {
        super(uuid);
    }
    public CompanyId(){

    }

    public  static CompanyId of(String id){
        return  new CompanyId(id);
    }
}
