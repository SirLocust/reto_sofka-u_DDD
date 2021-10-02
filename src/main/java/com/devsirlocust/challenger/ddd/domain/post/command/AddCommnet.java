package com.devsirlocust.challenger.ddd.domain.post.command;

import co.com.sofka.domain.generic.Command;
import com.devsirlocust.challenger.ddd.domain.post.values.id.CommentId;
import com.devsirlocust.challenger.ddd.domain.post.values.id.PostId;
import com.devsirlocust.challenger.ddd.domain.post.values.object.Text;
import com.devsirlocust.challenger.ddd.domain.post.values.object.Time;
import lombok.Getter;

@Getter
public class AddCommnet implements Command {

    private PostId postId;
    private CommentId commentId;
    private Time time;
    private Text text;

    public AddCommnet(PostId postId, CommentId commentId, Time time, Text text){
        this.postId = postId;

        this.commentId = commentId;
        this.time = time;
        this.text = text;
    }
}
