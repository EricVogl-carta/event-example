package com.carta.domain;

import java.math.BigDecimal;

public class ExerciseService_WithoutEvents {
    private final HoldingsService holdingsService;
    private final ExerciseRepository exerciseRepository;
    private final EmailNotifier emailNotifier;
    private final SecTransactionService secTransactionService;
    public ExerciseService_WithoutEvents(
            HoldingsService holdingsService,
            ExerciseRepository exerciseRepository,
            EmailNotifier emailNotifier,
            SecTransactionService secTransactionService

    ) {
        this.holdingsService = holdingsService;
        this.exerciseRepository = exerciseRepository;
        this.emailNotifier = emailNotifier;
        this.secTransactionService = secTransactionService;
    }

    public ExercisePk exerciseShares(ExerciseRequest request) throws NotEnoughSharesException {
        BigDecimal exercisableShares = holdingsService.getExercisableShares(
                request.getStakeholderPk(),
                request.getOptionGrantPk(),
                request.getExerciseDate()
        );
        if (exercisableShares.compareTo(request.getRequestedQuantity()) < 0) {
            throw new NotEnoughSharesException("Not enough shares");
        }
        ExercisePk exercisePk = exerciseRepository.record(request);
        emailNotifier.sendEmail(new EmailMessage("Exercise!!", "You exercised " + request.getRequestedQuantity() + " shares."));
        if (secTransactionService.isSubjectToSection16(request.getStakeholderPk())) {
            secTransactionService.createForm4Transaction(exercisePk);
        }
        return exercisePk;
    }
}
