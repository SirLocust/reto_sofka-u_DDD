package com.devsirlocust.challenger.ddd.domain.poster.values.id;

import co.com.sofka.domain.generic.Identity;

public class QualificationId extends Identity{
    private QualificationId(String uuid) {
        super(uuid);
    }
    public QualificationId(){

    }

    public  static QualificationId of(String id){
        return  new QualificationId(id);
    }
}
