package com.devsirlocust.challenger.ddd.usecase.post;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.devsirlocust.challenger.ddd.domain.post.command.AddBody;
import com.devsirlocust.challenger.ddd.domain.post.event.BodyAdded;
import com.devsirlocust.challenger.ddd.domain.post.event.PostCreated;
import com.devsirlocust.challenger.ddd.domain.post.values.id.BodyId;
import com.devsirlocust.challenger.ddd.domain.post.values.id.PostId;
import com.devsirlocust.challenger.ddd.domain.post.values.object.Content;
import com.devsirlocust.challenger.ddd.domain.post.values.object.NamePost;
import com.devsirlocust.challenger.ddd.domain.post.values.object.Title;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)

class AddBodyUseCaseTest {
    @Mock
    private DomainEventRepository repository;
    private String tmpId;
    private List<DomainEvent> eventsStore ;

    @BeforeEach
    void setup(){
        this.eventsStore = List.of(new PostCreated(new NamePost("mayo")));
        this.tmpId = "222";


    }



    @Test
    void should_add_new_body(){

        var command = new AddBody(
                PostId.of(tmpId),
                BodyId.of("11111"),
                new Title("anuncios"),
                new Content("loreme ipsu")

        );

        var useCase = new AddBodyUseCase();
        Mockito.when(repository.getEventsBy(tmpId)).thenReturn(this.eventsStore);
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(tmpId)
                .syncExecutor(useCase , new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var eventBodyAdded = (BodyAdded)events.get(0);
        assertEquals("anuncios", eventBodyAdded.getTitle().value());
        assertEquals("loreme ipsu", eventBodyAdded.getContent().value());


    }




}