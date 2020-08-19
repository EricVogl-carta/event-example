package com.carta.domain;

import java.util.Objects;

public class StakeholderPk {
    private final long id;
    private StakeholderPk(long id) {
        this.id = id;
    }

    public static StakeholderPk of(long id) {
        return new StakeholderPk(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StakeholderPk that = (StakeholderPk) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
