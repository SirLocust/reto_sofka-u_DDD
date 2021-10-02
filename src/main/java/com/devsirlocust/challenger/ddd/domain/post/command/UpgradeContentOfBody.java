package com.devsirlocust.challenger.ddd.domain.post.command;

import co.com.sofka.domain.generic.Command;
import com.devsirlocust.challenger.ddd.domain.post.values.id.BodyId;
import com.devsirlocust.challenger.ddd.domain.post.values.id.PostId;
import com.devsirlocust.challenger.ddd.domain.post.values.object.Content;
import lombok.Data;

@Data
public class UpgradeContentOfBody implements Command {

    private PostId postId;
    private BodyId entityId;
    private Content content;

    public UpgradeContentOfBody(PostId postId, BodyId entityId, Content content){
        this.postId = postId;

        this.entityId = entityId;
        this.content = content;
    }
}
