package com.devsirlocust.challenger.ddd.domain.post.command;

import co.com.sofka.domain.generic.Command;
import com.devsirlocust.challenger.ddd.domain.post.values.id.PostId;
import com.devsirlocust.challenger.ddd.domain.post.values.object.NamePost;
import lombok.Data;

@Data

public class CreatePost implements Command {

    private PostId entityId;
    private NamePost namePost;

    public CreatePost(PostId entityId, NamePost namePost){

        this.entityId = entityId;
        this.namePost = namePost;
    }
}
