package com.devsirlocust.challenger.ddd.usecase.post;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;

import com.devsirlocust.challenger.ddd.domain.post.command.AddLink;

import com.devsirlocust.challenger.ddd.domain.post.event.LinkAdded;
import com.devsirlocust.challenger.ddd.domain.post.event.PostCreated;

import com.devsirlocust.challenger.ddd.domain.post.values.id.LinkId;
import com.devsirlocust.challenger.ddd.domain.post.values.id.PostId;
import com.devsirlocust.challenger.ddd.domain.post.values.object.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)

class AddLinkUseCaseTest {


    @Mock
    private DomainEventRepository repository;
    private String tmpId;
    private List<DomainEvent> eventsStore ;

    @BeforeEach
    void setup(){
        this.eventsStore = List.of(new PostCreated(new NamePost("Agregando Link")));
        this.tmpId = "444";


    }



    @Test
    void should_add_new_commnet(){

        var command = new AddLink(
                PostId.of(tmpId),
                LinkId.of("11111"),
                new TitleLink("Referencias A los hechos por la periodista"),
                new Url("https://campus.sofka.com.co/unit/view/id:3994")

        );

        var useCase = new AddLinkUseCase();
        Mockito.when(repository.getEventsBy(tmpId)).thenReturn(this.eventsStore);
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(tmpId)
                .syncExecutor(useCase , new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var eventBodyAdded = (LinkAdded)events.get(0);
        assertEquals("Referencias A los hechos por la periodista", eventBodyAdded.getTitleLink().value());
        assertEquals("https://campus.sofka.com.co/unit/view/id:3994", eventBodyAdded.getUrl().value());


    }
}