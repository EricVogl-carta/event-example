package com.carta.event;

public interface EventHandler<T extends Event> {
    void handleEvent(T event);
}
