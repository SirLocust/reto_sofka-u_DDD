package com.devsirlocust.challenger.ddd.domain.poster.command;

import co.com.sofka.domain.generic.Command;
import com.devsirlocust.challenger.ddd.domain.poster.values.id.PosterId;
import com.devsirlocust.challenger.ddd.domain.poster.values.object.NickName;
import lombok.Data;

@Data

public class CreatePoster implements Command {

    private PosterId entityId;
    private NickName nickName;

    public CreatePoster(PosterId entityId, NickName nickName){

        this.entityId = entityId;
        this.nickName = nickName;
    }
}
