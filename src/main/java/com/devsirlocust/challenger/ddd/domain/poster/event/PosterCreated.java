package com.devsirlocust.challenger.ddd.domain.poster.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.devsirlocust.challenger.ddd.domain.poster.values.object.NickName;


public class PosterCreated extends DomainEvent {
    private final NickName nickName;
    public PosterCreated(NickName nickName) {
        super("devsirlocust.poster.postercreated");
        this.nickName = nickName;
    }

    public NickName getNickName(){
        return nickName;
    }

}
