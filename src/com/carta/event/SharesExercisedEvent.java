package com.carta.event;

import com.carta.domain.ExercisePk;

public class SharesExercisedEvent implements Event {
    private final ExercisePk exercisePk;
    private SharesExercisedEvent(ExercisePk exercisePk) {
        this.exercisePk = exercisePk;
    }

    public static SharesExercisedEvent of(ExercisePk exercisePk) {
        return new SharesExercisedEvent(exercisePk);
    }

    public ExercisePk getExercisePk() {
        return exercisePk;
    }
}
