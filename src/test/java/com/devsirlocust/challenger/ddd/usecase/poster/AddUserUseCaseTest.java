package com.devsirlocust.challenger.ddd.usecase.poster;

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
import com.devsirlocust.challenger.ddd.domain.poster.Poster;
import com.devsirlocust.challenger.ddd.domain.poster.command.AddUser;
import com.devsirlocust.challenger.ddd.domain.poster.event.PosterCreated;
import com.devsirlocust.challenger.ddd.domain.poster.event.UserAdded;
import com.devsirlocust.challenger.ddd.domain.poster.values.id.PosterId;
import com.devsirlocust.challenger.ddd.domain.poster.values.id.UserId;
import com.devsirlocust.challenger.ddd.domain.poster.values.object.Email;
import com.devsirlocust.challenger.ddd.domain.poster.values.object.NameUser;
import com.devsirlocust.challenger.ddd.domain.poster.values.object.NickName;
import com.devsirlocust.challenger.ddd.usecase.post.AddBodyUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)

class AddUserUseCaseTest  {
    @Mock
    private DomainEventRepository repository;
    private String tmpId;
    private List<DomainEvent> eventsStore ;

    @BeforeEach
    void setup(){
        this.eventsStore = List.of(new PosterCreated(new NickName("El matador 2")));
        this.tmpId = "222";


    }



    @Test
    void should_add_new_User(){

        var command = new AddUser(
                PosterId.of(tmpId),
                UserId.of("11111"),
                new NameUser("arturo rojas"),
                new Email("arturoROjas@sofka.com")

        );

        var useCase = new AddUserUseCase();
        Mockito.when(repository.getEventsBy(tmpId)).thenReturn(this.eventsStore);
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(tmpId)
                .syncExecutor(useCase , new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var eventUserAdded = (UserAdded)events.get(0);
        assertEquals("arturo rojas", eventUserAdded.getNameUser().value());
        assertEquals("arturoROjas@sofka.com", eventUserAdded.getEmail().value());


    }

}