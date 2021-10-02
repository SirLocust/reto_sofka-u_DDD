package com.devsirlocust.challenger.ddd.usecase.poster;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.devsirlocust.challenger.ddd.domain.poster.command.UpgradeEmailOfUser;
import com.devsirlocust.challenger.ddd.domain.poster.event.*;
import com.devsirlocust.challenger.ddd.domain.poster.values.id.PosterId;
import com.devsirlocust.challenger.ddd.domain.poster.values.id.QualificationId;
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

class UpgradeScoreOfQualificationUseCaseTest {

    @Mock
    private DomainEventRepository repository;
    private String tmpId;
    private List<DomainEvent> eventsStore ;

    @BeforeEach
    void setup(){
        this.eventsStore = List.of(
                new PosterCreated(new NickName("Dulces dias")),
                new QualificationAdded(QualificationId.of("222"),new Score(20), new FeedBack("mejorar la edicion")
                ));
        this.tmpId = "333";


    }



    @Test
    void should_update_content_of_existing_body_in_post(){

        var event = new ScoreOfQualificationUpgraded(

                QualificationId.of("222"),
                new Score(30)


        );
        event.setAggregateRootId(tmpId);
        var useCase = new UpgradeScoreOfQualificationUseCase();
        Mockito.when(repository.getEventsBy(tmpId)).thenReturn(this.eventsStore);
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(tmpId)
                .syncExecutor(useCase , new TriggeredEvent<ScoreOfQualificationUpgraded>(event))
                .orElseThrow()
                .getDomainEvents();




    }
}