package com.carta.domain;

import java.util.Objects;

public class ExercisePk {
    private final long id;
    private ExercisePk(long id) {
        this.id = id;
    }

    public static ExercisePk of(long id) {
        return new ExercisePk(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExercisePk that = (ExercisePk) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
