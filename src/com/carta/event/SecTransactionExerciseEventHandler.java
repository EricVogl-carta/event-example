package com.carta.event;

import com.carta.domain.Exercise;
import com.carta.domain.ExercisePk;
import com.carta.domain.ExerciseRepository;
import com.carta.domain.SecTransactionService;

public class SecTransactionExerciseEventHandler implements EventHandler<SharesExercisedEvent> {
    private final ExerciseRepository exerciseRepository;
    private final SecTransactionService secTransactionService;
    public SecTransactionExerciseEventHandler(
            ExerciseRepository exerciseRepository,
            SecTransactionService secTransactionService
    ) {
        this.exerciseRepository = exerciseRepository;
        this.secTransactionService = secTransactionService;
    }
    @Override
    public void handleEvent(SharesExercisedEvent event) {
        Exercise exercise = exerciseRepository.getExercise(event.getExercisePk());
        if (secTransactionService.isSubjectToSection16(exercise.getStakeholderPk())) {
            secTransactionService.createForm4Transaction(event.getExercisePk());
        }
    }
}
