package com.carta.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface ExerciseRequest {
    StakeholderPk getStakeholderPk();
    OptionGrantPk getOptionGrantPk();
    BigDecimal getRequestedQuantity();
    LocalDate getExerciseDate();
}
