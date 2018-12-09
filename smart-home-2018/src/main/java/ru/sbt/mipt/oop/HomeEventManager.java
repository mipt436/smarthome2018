package ru.sbt.mipt.oop;

public class HomeEventManager implements EventManager {
    final private Observer observer;
    final private SensorEventProvider sensorEventProvider;

    public HomeEventManager(Observer observer, SensorEventProvider sensorEventProvider) {
        this.observer = observer;
        this.sensorEventProvider = sensorEventProvider;
    }

    @Override
    public void runEventsCycle(SmartHome smartHome) {
        // начинаем цикл обработки событий
        SensorEvent event = sensorEventProvider.getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            observer.notifySubscribers(smartHome, event);
            event = sensorEventProvider.getNextSensorEvent();
        }
    }
}
