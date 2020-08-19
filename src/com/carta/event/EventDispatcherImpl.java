package com.carta.event;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventDispatcherImpl implements EventDispatcher {
    private final Map<Class<? extends Event>, List<EventHandler<? extends Event>>> registeredEvents = new HashMap<>();
    @Override
    public <TEvent extends Event> void dispatch(TEvent event) {
        //It's late cheating with type erasure - contract is enforced by register interface
        @SuppressWarnings("unchecked")
        List<EventHandler<TEvent>> eventHandlers = (List<EventHandler<TEvent>>)(List<?>) registeredEvents.get(event.getClass());
        if (eventHandlers != null) {
            for (EventHandler<TEvent> handler : eventHandlers) {
                handler.handleEvent(event);
            }
        }
    }

    @Override
    public <TEvent extends Event> void register(Class<TEvent> eventType, EventHandler<TEvent> eventHandler) {
        List<EventHandler<? extends Event>> eventHandlers = registeredEvents.get(eventType);
        if (eventHandlers == null) {
            eventHandlers = new ArrayList<>();
        }
        eventHandlers.add(eventHandler);
        registeredEvents.put(eventType, eventHandlers);
    }
}
