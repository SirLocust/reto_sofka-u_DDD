package com.devsirlocust.challenger.ddd.domain.poster;

import co.com.sofka.domain.generic.EventChange;
import com.devsirlocust.challenger.ddd.domain.poster.event.*;
import com.devsirlocust.challenger.ddd.domain.poster.values.entity.Company;
import com.devsirlocust.challenger.ddd.domain.poster.values.entity.Qualification;
import com.devsirlocust.challenger.ddd.domain.poster.values.entity.User;

import java.util.ArrayList;
import java.util.Objects;

public class PosterChange extends EventChange {
    public PosterChange(Poster poster){
        apply((PosterCreated event) ->{

            poster.qualifications = new ArrayList<>();
        });

        apply((UserAdded event)-> {
            poster.user = new User(
                    event.getUserId(),
                    event.getNameUser(),
                    event.getEmail()
            );
        });

        apply((EmailOfUserUpgraded event) ->{
            var user = poster.user;
            Objects.requireNonNull(user);
            user.upgradeEmail(event.getEmail());

        });

        apply((CompanyAdded event) -> {
            poster.company = new Company(event.getEntityId(),event.getNameCompany(),event.getRol());


        });

        apply((QualificationAdded event) -> {
            poster.qualifications.add( new Qualification( event.getQualificationId(), event.getScore(), event.getFeedBack()));
        });

        apply((ScoreOfQualificationUpgraded event) ->{
            var qualification = poster.getQualificationById(event.getQualificationId()).orElseThrow();
            qualification.upgradeScore(event.getScore());
        });


    }

}
