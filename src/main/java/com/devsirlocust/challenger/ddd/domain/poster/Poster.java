package com.devsirlocust.challenger.ddd.domain.poster;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import com.devsirlocust.challenger.ddd.domain.poster.event.*;
import com.devsirlocust.challenger.ddd.domain.poster.values.entity.User;
import com.devsirlocust.challenger.ddd.domain.poster.values.entity.Company;
import com.devsirlocust.challenger.ddd.domain.poster.values.entity.Qualification;
import com.devsirlocust.challenger.ddd.domain.poster.values.id.UserId;
import com.devsirlocust.challenger.ddd.domain.poster.values.id.CompanyId;
import com.devsirlocust.challenger.ddd.domain.poster.values.id.QualificationId;
import com.devsirlocust.challenger.ddd.domain.poster.values.id.PosterId;
import com.devsirlocust.challenger.ddd.domain.poster.values.object.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


public class Poster extends AggregateEvent<PosterId> {

    protected NickName nickName;
    protected User user;
    protected Company company;
    protected List<Qualification> qualifications;


    
    public Poster(PosterId entityId, NickName nickName) {
        super(entityId);
        //TODO Auto-generated constructor stub
        appendChange(new PosterCreated(nickName)).apply();
    }

    private Poster(PosterId entityId){
        super(entityId);
        subscribe(new PosterChange(this));
    }

    public static Poster from(PosterId posterId, List<DomainEvent> events){
        var post = new Poster(posterId);
        events.forEach(post::applyEvent);
        return post;
    }

    public void addUser(UserId entityId , NameUser nameUser, Email email){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(nameUser);
        Objects.requireNonNull(email);

        appendChange(new UserAdded(entityId, nameUser, email)).apply();
        
    }

    public void addCompany(CompanyId entityId, NameCompany nameCompany, Rol rol){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(nameCompany);
        Objects.requireNonNull(rol);
        appendChange(new CompanyAdded(entityId, nameCompany, rol)).apply();
    }
    public void addQualification(QualificationId entityId , Score score, FeedBack feedBack){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(score);
        Objects.requireNonNull(feedBack);
        appendChange(new QualificationAdded(entityId, score, feedBack)).apply();


    }
    public void upgradeEmailOfUser(UserId entityId, Email email){
        Objects.requireNonNull(entityId);
        Objects.requireNonNull(email);
        appendChange(new EmailOfUserUpgraded(entityId, email)).apply();
    }

    public void upgradeScoreOfQualification(QualificationId entityId , Score score){
        appendChange(new ScoreOfQualificationUpgraded(entityId,score));
    }

    public Optional<Qualification>  getQualificationById(QualificationId id){
       return this.qualifications.stream().filter(qualification -> qualification.identity().equals(id)).findFirst();
    }


    
}
