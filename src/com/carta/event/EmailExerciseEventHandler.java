package com.carta.event;

import com.carta.domain.EmailMessage;
import com.carta.domain.EmailNotifier;
import com.carta.domain.Exercise;
import com.carta.domain.ExerciseRepository;

public class EmailExerciseEventHandler implements EventHandler<SharesExercisedEvent> {
    private final ExerciseRepository exerciseRepository;
    private final EmailNotifier emailNotifier;
    public EmailExerciseEventHandler(
            ExerciseRepository exerciseRepository,
            EmailNotifier emailNotifier
    ) {
        this.exerciseRepository = exerciseRepository;
        this.emailNotifier = emailNotifier;
    }
    @Override
    public void handleEvent(SharesExercisedEvent event) {
        Exercise exercise = exerciseRepository.getExercise(event.getExercisePk());
        emailNotifier.sendEmail(new EmailMessage("Exercise!!", "You exercised " + exercise.getQuantityExercised() + " shares."));
    }
}
