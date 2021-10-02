package com.devsirlocust.challenger.ddd.domain.poster.event;

import co.com.sofka.domain.generic.DomainEvent;
import com.devsirlocust.challenger.ddd.domain.poster.values.id.CompanyId;
import com.devsirlocust.challenger.ddd.domain.poster.values.object.Rol;
import com.devsirlocust.challenger.ddd.domain.poster.values.object.NameCompany;
import lombok.Getter;

@Getter
public class CompanyAdded extends DomainEvent{


    private CompanyId entityId;
    private NameCompany nameCompany;
    private Rol rol;

    public CompanyAdded(CompanyId entityId, NameCompany nameCompany, Rol rol) {
        super("devsirlocust.company.companyadded");
        this.entityId = entityId;
        this.nameCompany = nameCompany;
        this.rol = rol;


    }

    public CompanyId getEntityId(){
        return this.entityId;
    }

    public NameCompany getNameCompany(){
        return this.nameCompany;
    }

    public Rol getRol(){
        return this.rol;
    }

}
