package com.devsirlocust.challenger.ddd.domain.post.values.object;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Text implements ValueObject {     private final String value;

    public Text(String value){
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public String value() {
        return value;
    }
}
