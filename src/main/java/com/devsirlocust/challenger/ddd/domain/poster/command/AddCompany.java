package com.devsirlocust.challenger.ddd.domain.poster.command;

import co.com.sofka.domain.generic.Command;
import com.devsirlocust.challenger.ddd.domain.poster.values.id.CompanyId;
import com.devsirlocust.challenger.ddd.domain.poster.values.id.PosterId;
import com.devsirlocust.challenger.ddd.domain.poster.values.object.Rol;
import com.devsirlocust.challenger.ddd.domain.poster.values.object.NameCompany;
import lombok.Getter;

@Getter
public class AddCompany implements Command {

    private PosterId posterId;
    private CompanyId companyId;
    private NameCompany nameCompany;
    private Rol rol;

    public AddCompany(PosterId posterId, CompanyId companyId, NameCompany nameCompany, Rol rol){
        this.posterId = posterId;

        this.companyId = companyId;
        this.nameCompany = nameCompany;
        this.rol = rol;
    }
}
