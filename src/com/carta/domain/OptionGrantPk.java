package com.carta.domain;

import java.util.Objects;

public class OptionGrantPk {
    private final long id;
    private OptionGrantPk(long id) {
        this.id = id;
    }

    public static OptionGrantPk of(long id) {
        return new OptionGrantPk(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OptionGrantPk that = (OptionGrantPk) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
