package com.carta.event;

public interface EventDispatcher {
    <TEvent extends Event> void dispatch(TEvent event);
    <TEvent extends Event> void register(Class<TEvent> eventType, EventHandler<TEvent> eventHandler);
}
