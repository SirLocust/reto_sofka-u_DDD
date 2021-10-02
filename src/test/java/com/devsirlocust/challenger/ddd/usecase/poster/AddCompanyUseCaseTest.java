package com.devsirlocust.challenger.ddd.usecase.poster;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import com.devsirlocust.challenger.ddd.domain.poster.command.AddCompany;
import com.devsirlocust.challenger.ddd.domain.poster.command.AddUser;
import com.devsirlocust.challenger.ddd.domain.poster.event.CompanyAdded;
import com.devsirlocust.challenger.ddd.domain.poster.event.PosterCreated;
import com.devsirlocust.challenger.ddd.domain.poster.event.UserAdded;
import com.devsirlocust.challenger.ddd.domain.poster.values.id.CompanyId;
import com.devsirlocust.challenger.ddd.domain.poster.values.id.PosterId;
import com.devsirlocust.challenger.ddd.domain.poster.values.id.UserId;
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

class AddCompanyUseCaseTest {
    @Mock
    private DomainEventRepository repository;
    private String tmpId;
    private List<DomainEvent> eventsStore ;

    @BeforeEach
    void setup(){
        this.eventsStore = List.of(new PosterCreated(new NickName("El matador 4")));
        this.tmpId = "222";

    }



    @Test
    void should_add_new_User(){

        var command = new AddCompany(
                PosterId.of(tmpId),
                CompanyId.of("11111"),
                new NameCompany("Sofka"),
                new Rol("Gerente")

        );

        var useCase = new AddCompanyUseCase();
        Mockito.when(repository.getEventsBy(tmpId)).thenReturn(this.eventsStore);
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(tmpId)
                .syncExecutor(useCase , new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        var eventCompanyAdded = (CompanyAdded)events.get(0);
        assertEquals("Sofka", eventCompanyAdded.getNameCompany().value());
        assertEquals("Gerente", eventCompanyAdded.getRol().value());


    }

}