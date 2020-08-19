package com.carta.domain;

public interface SecTransactionService {
    boolean isSubjectToSection16(StakeholderPk stakeholderPk);
    void createForm4Transaction(ExercisePk exercisePk);
}
