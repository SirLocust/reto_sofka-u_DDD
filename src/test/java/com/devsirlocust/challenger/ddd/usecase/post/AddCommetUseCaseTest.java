package com.devsirlocust.challenger.ddd.usecase.post;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.devsirlocust.challenger.ddd.domain.post.command.AddBody;
import com.devsirlocust.challenger.ddd.domain.post.command.AddCommnet;
import com.devsirlocust.challenger.ddd.domain.post.event.BodyAdded;
import com.devsirlocust.challenger.ddd.domain.post.event.CommentAdded;
import com.devsirlocust.challenger.ddd.domain.post.event.PostCreated;
import com.devsirlocust.challenger.ddd.domain.post.values.id.BodyId;
import com.devsirlocust.challenger.ddd.domain.post.values.id.CommentId;
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

class AddCommetUseCaseTest {


    @Mock
    private DomainEventRepository repository;
    private String tmpId;
    private List<DomainEvent> eventsStore ;

    @BeforeEach
    void setup(){
        this.eventsStore = List.of(new PostCreated(new NamePost("Agregando Comentario")));
        this.tmpId = "333";


    }



    @Test
    void should_add_new_commnet(){

        var command = new AddCommnet(
                PostId.of(tmpId),
                CommentId.of("11111"),
                new Time("23213213123"),
                new Text("me gusto mucho")

        );

        var useCase = new AddCommetUseCase();
        Mockito.when(repository.getEventsBy(tmpId)).thenReturn(this.eventsStore);
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(tmpId)
                .syncExecutor(useCase , new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var eventBodyAdded = (CommentAdded)events.get(0);
        assertEquals("23213213123", eventBodyAdded.getTime().value());
        assertEquals("me gusto mucho", eventBodyAdded.getText().value());


    }
}