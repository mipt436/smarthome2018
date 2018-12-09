package ru.sbt.mipt.oop;

import java.util.Collection;

public class RealSensorEventProvider implements SensorEventProvider {
    final private Collection<SensorEvent> sensorEvents;

    RealSensorEventProvider(Collection<SensorEvent> sensorEvents) {
        this.sensorEvents = sensorEvents;
    }

    @Override
    public SensorEvent getNextSensorEvent() {
        return null;
    }
}
