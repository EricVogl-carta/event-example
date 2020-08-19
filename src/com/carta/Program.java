package com.carta;

import com.carta.domain.EmailNotifier;
import com.carta.domain.ExerciseRepository;
import com.carta.domain.SecTransactionService;
import com.carta.event.EmailExerciseEventHandler;
import com.carta.event.EventDispatcher;
import com.carta.event.SecTransactionExerciseEventHandler;
import com.carta.event.SharesExercisedEvent;

public class Program {
    private final ExerciseRepository exerciseRepository;
    private final SecTransactionService secTransactionService;
    private final EventDispatcher eventDispatcher;
    private final EmailNotifier emailNotifier;

    public Program(
        ExerciseRepository exerciseRepository,
        SecTransactionService secTransactionService,
        EventDispatcher eventDispatcher,
        EmailNotifier emailNotifier
    ) {
        this.exerciseRepository = exerciseRepository;
        this.secTransactionService = secTransactionService;
        this.eventDispatcher = eventDispatcher;
        this.emailNotifier = emailNotifier;
    }

    public void registerEvents() {
        eventDispatcher.register(SharesExercisedEvent.class, new SecTransactionExerciseEventHandler(exerciseRepository, secTransactionService));
        eventDispatcher.register(SharesExercisedEvent.class, new EmailExerciseEventHandler(exerciseRepository, emailNotifier));
    }
}
