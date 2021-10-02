package com.devsirlocust.challenger.ddd.domain.poster.values.entity;

import co.com.sofka.domain.generic.Entity;
import com.devsirlocust.challenger.ddd.domain.poster.values.id.CompanyId;
import com.devsirlocust.challenger.ddd.domain.poster.values.object.Rol;
import com.devsirlocust.challenger.ddd.domain.poster.values.object.NameCompany;

import java.util.Objects;

public class Company extends Entity<CompanyId> {


    private NameCompany nameCompany;
    private Rol rol;

    public Company(CompanyId entityId, NameCompany nameCompany, Rol rol) {
        super(entityId);
        this.nameCompany = nameCompany;
        this.rol = rol;
    }

    public void upgradeNameComapany(NameCompany nameCompany){
        this.nameCompany = Objects.requireNonNull(nameCompany);
    }

    public void upgradeRol(Rol Rol){
        this.rol = Objects.requireNonNull(rol);
    }

    public NameCompany nameCompany(){
        return this.nameCompany;
    }

    public Rol rol(){
        return this.rol;
    }


}
