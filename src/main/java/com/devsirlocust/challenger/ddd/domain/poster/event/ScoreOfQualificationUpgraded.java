package com.devsirlocust.challenger.ddd.domain.poster.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.devsirlocust.challenger.ddd.domain.poster.values.id.QualificationId;
import com.devsirlocust.challenger.ddd.domain.poster.values.object.Score;

public class ScoreOfQualificationUpgraded extends DomainEvent {
    private final QualificationId qualificationId;
    private final Score score;

    public ScoreOfQualificationUpgraded(QualificationId entityId, Score score) {
        super("devsirlocust.quilification.scoreofquelificationupgraded");
        this.qualificationId = entityId;
        this.score = score;
    }

    public QualificationId getQualificationId(){
        return this.qualificationId;
    }

    public Score getScore(){
        return this.score;
    }
}
