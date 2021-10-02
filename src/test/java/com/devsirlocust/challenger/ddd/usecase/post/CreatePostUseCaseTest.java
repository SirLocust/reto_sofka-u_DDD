package com.devsirlocust.challenger.ddd.usecase.post;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import com.devsirlocust.challenger.ddd.domain.post.command.CreatePost;
import com.devsirlocust.challenger.ddd.domain.post.event.PostCreated;
import com.devsirlocust.challenger.ddd.domain.post.values.id.PostId;
import com.devsirlocust.challenger.ddd.domain.post.values.object.NamePost;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CreatePostUseCaseTest {

    @Test
    void should_created_post(){
        var command = new CreatePost(
                PostId.of("123"),
                new NamePost("Pinguinos Felizes")
        );

        var useCase = new CreatePostUseCase();


        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        var event = (PostCreated)events.get(0);

        Assertions.assertEquals("Pinguinos Felizes", event.getNamePost().value());
    }

}