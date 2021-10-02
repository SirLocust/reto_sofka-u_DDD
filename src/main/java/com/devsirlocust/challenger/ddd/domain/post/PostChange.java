package com.devsirlocust.challenger.ddd.domain.post;

import co.com.sofka.domain.generic.EventChange;
import com.devsirlocust.challenger.ddd.domain.post.event.BodyAdded;
import com.devsirlocust.challenger.ddd.domain.post.event.CommentAdded;
import com.devsirlocust.challenger.ddd.domain.post.event.ContentOfBodyUpgraded;
import com.devsirlocust.challenger.ddd.domain.post.event.PostCreated;
import com.devsirlocust.challenger.ddd.domain.post.values.entity.Body;
import com.devsirlocust.challenger.ddd.domain.post.values.entity.Comment;

import java.util.ArrayList;
import java.util.Objects;

public class PostChange extends EventChange {
        public PostChange(Post post){
            apply((PostCreated event) ->{
                post.comments = new ArrayList<>();
                post.links = new ArrayList<>();
            });

            apply((BodyAdded event)-> {
                post.body = new Body(
                        event.getBodyId(),
                        event.getTitle(),
                        event.getContent()
                );
            });

            apply((ContentOfBodyUpgraded event) ->{
                var body = post.body;
                Objects.requireNonNull(body);
                body.upgradeContent(event.getContent());

            });

            apply((CommentAdded event) -> {
                post.comments.add(new Comment(
                        event.getCommentId(),
                        event.getTime(),
                        event.getText()
                ));
            });

        }
}
