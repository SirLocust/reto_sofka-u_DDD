package com.devsirlocust.challenger.ddd.usecase.poster;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.devsirlocust.challenger.ddd.domain.poster.command.AddCompany;
import com.devsirlocust.challenger.ddd.domain.poster.command.AddQualification;
import com.devsirlocust.challenger.ddd.domain.poster.event.CompanyAdded;
import com.devsirlocust.challenger.ddd.domain.poster.event.PosterCreated;
import com.devsirlocust.challenger.ddd.domain.poster.event.QualificationAdded;
import com.devsirlocust.challenger.ddd.domain.poster.values.id.CompanyId;
import com.devsirlocust.challenger.ddd.domain.poster.values.id.PosterId;
import com.devsirlocust.challenger.ddd.domain.poster.values.id.QualificationId;
import com.devsirlocust.challenger.ddd.domain.poster.values.object.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)

class AddQualificationUseCaseTest {

    @Mock
    private DomainEventRepository repository;
    private String tmpId;
    private List<DomainEvent> eventsStore ;

    @BeforeEach
    void setup(){
        this.eventsStore = List.of(new PosterCreated(new NickName("quita Sue;os")));
        this.tmpId = "222";

    }



    @Test
    void should_add_new_User(){

        var command = new AddQualification(
                PosterId.of(tmpId),
                QualificationId.of("11111"),
                new Score(20),
                new FeedBack("agregar las enlaces para verificar la informacion")

        );

        var useCase = new AddQualificationUseCase();
        Mockito.when(repository.getEventsBy(tmpId)).thenReturn(this.eventsStore);
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(tmpId)
                .syncExecutor(useCase , new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var eventQualificationAdded = (QualificationAdded)events.get(0);
        assertEquals(20, eventQualificationAdded.getScore().value());
        assertEquals("agregar las enlaces para verificar la informacion", eventQualificationAdded.getFeedBack().value());


    }

}