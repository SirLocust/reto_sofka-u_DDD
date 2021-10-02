package com.devsirlocust.challenger.ddd.usecase.poster;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.devsirlocust.challenger.ddd.domain.post.event.ContentOfBodyUpgraded;
import com.devsirlocust.challenger.ddd.domain.post.values.id.BodyId;
import com.devsirlocust.challenger.ddd.domain.post.values.id.PostId;
import com.devsirlocust.challenger.ddd.domain.post.values.object.Content;
import com.devsirlocust.challenger.ddd.domain.poster.command.UpgradeEmailOfUser;
import com.devsirlocust.challenger.ddd.domain.poster.event.EmailOfUserUpgraded;
import com.devsirlocust.challenger.ddd.domain.poster.event.PosterCreated;
import com.devsirlocust.challenger.ddd.domain.poster.event.UserAdded;
import com.devsirlocust.challenger.ddd.domain.poster.values.id.PosterId;
import com.devsirlocust.challenger.ddd.domain.poster.values.id.UserId;
import com.devsirlocust.challenger.ddd.domain.poster.values.object.Email;
import com.devsirlocust.challenger.ddd.domain.poster.values.object.NameUser;
import com.devsirlocust.challenger.ddd.domain.poster.values.object.NickName;
import com.devsirlocust.challenger.ddd.usecase.post.UpgradeContentOfBodyUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)


class UpgradeEmailOfUserUseCaseTest {

    @Mock
    private DomainEventRepository repository;
    private String tmpId;
    private List<DomainEvent> eventsStore ;

    @BeforeEach
    void setup(){
        this.eventsStore = List.of(
                new PosterCreated(new NickName("Dulces dias")),
                new UserAdded(UserId.of("222"),new NameUser("raul"), new Email("Raul@sofka.com")
                ));
        this.tmpId = "333";


    }



    @Test
    void should_update_content_of_existing_body_in_post(){

        var command = new UpgradeEmailOfUser(
                PosterId.of(tmpId),
                UserId.of("222"),
                new Email("Raul_alzate@sofka.com")


        );

        var useCase = new UpgradeEmailOfUserUseCase();
        Mockito.when(repository.getEventsBy(tmpId)).thenReturn(this.eventsStore);
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(tmpId)
                .syncExecutor(useCase , new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var eventEmailOfUserUpgraded = (EmailOfUserUpgraded)events.get(0);
        assertEquals("Raul_alzate@sofka.com", eventEmailOfUserUpgraded.getEmail().value());



    }
}