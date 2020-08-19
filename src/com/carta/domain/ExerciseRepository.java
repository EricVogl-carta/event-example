package com.carta.domain;

public interface ExerciseRepository {
    ExercisePk record(ExerciseRequest request);
    Exercise getExercise(ExercisePk exercisePk);
}
