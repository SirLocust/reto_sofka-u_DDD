package com.devsirlocust.challenger.ddd.domain.post.command;

import co.com.sofka.domain.generic.Command;
import com.devsirlocust.challenger.ddd.domain.post.values.id.BodyId;
import com.devsirlocust.challenger.ddd.domain.post.values.id.PostId;
import com.devsirlocust.challenger.ddd.domain.post.values.object.Content;
import com.devsirlocust.challenger.ddd.domain.post.values.object.Title;
import lombok.Getter;
import lombok.ToString;


@Getter
@ToString
public class AddBody implements Command {


    private PostId postId;
    private BodyId bodyId;
    private Title title;
    private Content content;

    public AddBody(PostId entityId ,BodyId bodyId , Title title , Content content){

        this.postId = entityId;
        this.bodyId = bodyId;
        this.title = title;
        this.content = content;
    }
}
