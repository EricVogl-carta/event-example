package com.carta.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface HoldingsService {
    BigDecimal getExercisableShares(StakeholderPk stakeholderPk, OptionGrantPk optionGrantPk, LocalDate asOfDate);
}
