package ru.sbt.mipt.oop;

import java.util.Collection;

public interface Observer {
    void subscribe(EventProcessor processor);
    void subscribe(Collection<EventProcessor> processors);
    void unsubscribe(EventProcessor processor);
    void notifySubscribers(SmartHome smartHome, SensorEvent event);
}
