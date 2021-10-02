package com.devsirlocust.challenger.ddd.domain.poster.values.entity;

import co.com.sofka.domain.generic.Entity;
import com.devsirlocust.challenger.ddd.domain.poster.values.id.QualificationId;
import com.devsirlocust.challenger.ddd.domain.poster.values.object.Score;
import com.devsirlocust.challenger.ddd.domain.poster.values.object.FeedBack;

import java.util.Objects;

public class Qualification extends Entity<QualificationId> {

    private Score score;
    private FeedBack feedBack;

    public Qualification(QualificationId entityId , Score score, FeedBack feedBack) {
        super(entityId);
        this.feedBack = feedBack;
        this.score = score;

    }

    public void upgradeScore(Score score){
        this.score = Objects.requireNonNull(score);
    }

    public void upgradeFeedBack(FeedBack feedBack){
       this.feedBack = Objects.requireNonNull(feedBack);
    }

    public Score score(){
        return this.score;
    }

    public FeedBack feedBack(){
        return this.feedBack;
    }

}
