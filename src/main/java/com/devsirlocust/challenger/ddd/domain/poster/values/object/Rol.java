package com.devsirlocust.challenger.ddd.domain.poster.values.object;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Rol implements ValueObject {     private final String value;

    public Rol(String value){
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }
}
