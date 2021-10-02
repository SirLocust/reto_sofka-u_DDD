package com.devsirlocust.challenger.ddd.domain.poster.values.object;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Score implements ValueObject<Integer> {
    private final Integer value;

    public Score(Integer value){
        this.value = Objects.requireNonNull(value);
    }

    @Override
    public Integer value() {
        return value;
    }
}
