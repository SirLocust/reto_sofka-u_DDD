package com.devsirlocust.challenger.ddd.domain.poster.command;

import co.com.sofka.domain.generic.Command;
import com.devsirlocust.challenger.ddd.domain.poster.values.id.UserId;
import com.devsirlocust.challenger.ddd.domain.poster.values.id.PosterId;
import com.devsirlocust.challenger.ddd.domain.poster.values.object.Email;
import lombok.Data;

@Data
public class UpgradeEmailOfUser implements Command {

    private PosterId posterId;
    private UserId entityId;
    private Email email;

    public UpgradeEmailOfUser(PosterId posterId, UserId entityId, Email email){
        this.posterId = posterId;

        this.entityId = entityId;
        this.email = email;
    }
}
