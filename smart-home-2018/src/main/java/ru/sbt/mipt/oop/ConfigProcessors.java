package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;

class ConfigProcessors {
    static Collection<EventProcessor> configureEventProcessors() {
        Collection<EventProcessor> eventProcessors = new ArrayList<>();
        eventProcessors.add(new LightsEventProcessor());
        eventProcessors.add(new DoorEventProcessor());
        eventProcessors.add(new HallDoorEventProcessor());
        return eventProcessors;
    }
}
