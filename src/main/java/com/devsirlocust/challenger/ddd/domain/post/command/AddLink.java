package com.devsirlocust.challenger.ddd.domain.post.command;

import co.com.sofka.domain.generic.Command;
import com.devsirlocust.challenger.ddd.domain.post.values.id.LinkId;
import com.devsirlocust.challenger.ddd.domain.post.values.id.PostId;
import com.devsirlocust.challenger.ddd.domain.post.values.object.TitleLink;
import com.devsirlocust.challenger.ddd.domain.post.values.object.Url;
import lombok.Getter;

@Getter
public class AddLink implements Command {

    private PostId postId;
    private LinkId entityId;
    private TitleLink titleLink;
    private Url url;

    public AddLink(PostId postId, LinkId entityId , TitleLink titleLink , Url url){

        this.postId = postId;
        this.entityId = entityId;
        this.titleLink = titleLink;
        this.url = url;
    }
}
