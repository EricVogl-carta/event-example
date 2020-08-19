package com.carta.domain;

import com.carta.event.EventDispatcher;
import com.carta.event.SharesExercisedEvent;

import java.math.BigDecimal;

public class ExerciseService_WithEvents {
    private final HoldingsService holdingsService;
    private final ExerciseRepository exerciseRepository;
    private final EventDispatcher eventDispatcher;

    public ExerciseService_WithEvents(
            HoldingsService holdingsService,
            ExerciseRepository exerciseRepository,
            EventDispatcher eventDispatcher
    ) {
        this.holdingsService = holdingsService;
        this.exerciseRepository = exerciseRepository;
        this.eventDispatcher = eventDispatcher;
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
        eventDispatcher.dispatch(SharesExercisedEvent.of(exercisePk));
        return exercisePk;
    }
}
