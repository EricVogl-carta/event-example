package com.carta.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface Exercise {
    ExercisePk getExercisePk();
    OptionGrantPk getOptionGrantPk();
    StakeholderPk getStakeholderPk();
    BigDecimal getQuantityExercised();
    LocalDate getExerciseDate();
}
