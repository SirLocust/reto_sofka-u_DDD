package com.devsirlocust.challenger.ddd.domain.post.values.object;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TitleLink implements ValueObject<String> {
    private final String value;

    public TitleLink(String value){
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }
}
