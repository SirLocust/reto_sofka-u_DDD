package com.devsirlocust.challenger.ddd.domain.poster.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.devsirlocust.challenger.ddd.domain.poster.values.id.QualificationId;
import com.devsirlocust.challenger.ddd.domain.poster.values.object.Score;
import com.devsirlocust.challenger.ddd.domain.poster.values.object.FeedBack;

public class QualificationAdded extends DomainEvent{


    private final QualificationId qualificationId;
    private final Score score;
    private final FeedBack feedBack;

    public QualificationAdded(QualificationId entityId , Score score, FeedBack feedBack) {
        super("devsirlocust.quilification.qualificationadded");
        
        //TODO Auto-generated constructor stub
        this.qualificationId = entityId;
        this.score = score;
        this.feedBack = feedBack;
    }

    public QualificationId getQualificationId(){
        return this.qualificationId;
    }

    public Score getScore(){
        return this.score;
    }

    public FeedBack getFeedBack(){
        return this.feedBack;
    }

}
