package ru.sbt.mipt.oop.adapter;

import com.coolcompany.smarthome.events.SensorEventsManager;
import ru.sbt.mipt.oop.*;

class EventManagerAdapter implements EventManager {
    final private SensorEventsManager sensorEventsManager;
    final private Observer observer;

    EventManagerAdapter(Observer observer) {
        this.observer = observer;
        sensorEventsManager = new SensorEventsManager();
    }

    @Override
    public void runEventsCycle(SmartHome smartHome) {
        sensorEventsManager.registerEventHandler(ccSensorEvent -> {
            SensorEvent event = new SensorEventAdapter(ccSensorEvent);
            observer.notifySubscribers(smartHome, event);
        });
        sensorEventsManager.start();
    }
}
