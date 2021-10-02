package com.devsirlocust.challenger.ddd.usecase.poster;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;

import com.devsirlocust.challenger.ddd.domain.poster.command.CreatePoster;
import com.devsirlocust.challenger.ddd.domain.poster.event.PosterCreated;
import com.devsirlocust.challenger.ddd.domain.poster.values.id.PosterId;
import com.devsirlocust.challenger.ddd.domain.poster.values.object.NickName;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreatePosterUseCaseTest {

    @Test
    void should_created_post(){
        var command = new CreatePoster(
                PosterId.of("222"),
                new NickName("El Matador")
        );

        var useCase = new CreatePosterUseCase();


        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();
        var event = (PosterCreated)events.get(0);

        Assertions.assertEquals("El Matador", event.getNickName().value());
    }

}