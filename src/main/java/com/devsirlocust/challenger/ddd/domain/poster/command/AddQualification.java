package com.devsirlocust.challenger.ddd.domain.poster.command;

import co.com.sofka.domain.generic.Command;
import com.devsirlocust.challenger.ddd.domain.poster.values.id.QualificationId;
import com.devsirlocust.challenger.ddd.domain.poster.values.id.PosterId;
import com.devsirlocust.challenger.ddd.domain.poster.values.object.Score;
import com.devsirlocust.challenger.ddd.domain.poster.values.object.FeedBack;
import lombok.Getter;

@Getter
public class AddQualification implements Command {

    private PosterId posterId;
    private QualificationId entityId;
    private Score score;
    private FeedBack feedBack;

    public AddQualification(PosterId posterId, QualificationId entityId , Score score, FeedBack feedBack){

        this.posterId = posterId;
        this.entityId = entityId;
        this.score = score;
        this.feedBack = feedBack;
    }
}
