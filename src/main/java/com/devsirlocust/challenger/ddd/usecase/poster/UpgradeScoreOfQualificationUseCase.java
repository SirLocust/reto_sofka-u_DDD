package com.devsirlocust.challenger.ddd.usecase.poster;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import com.devsirlocust.challenger.ddd.domain.poster.Poster;
import com.devsirlocust.challenger.ddd.domain.poster.event.ScoreOfQualificationUpgraded;
import com.devsirlocust.challenger.ddd.domain.poster.values.id.PosterId;

public class UpgradeScoreOfQualificationUseCase extends UseCase<TriggeredEvent<ScoreOfQualificationUpgraded>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<ScoreOfQualificationUpgraded> upgradeScoreOfQualificationUseCaseTriggeredEvent) {
        var event = upgradeScoreOfQualificationUseCaseTriggeredEvent.getDomainEvent();
        var poster = Poster.from(PosterId.of(event.aggregateRootId()), this.retrieveEvents());
        emit().onResponse(new ResponseEvents(poster.getUncommittedChanges()));
    }
}
