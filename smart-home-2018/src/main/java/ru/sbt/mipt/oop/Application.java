package ru.sbt.mipt.oop;

import java.io.IOException;

public class Application {
    private static SmartHomeLoader smartHomeLoader = new FileSmartHomeLoader();

    public static void setSmartHomeLoader(SmartHomeLoader smartHomeLoader) {
        Application.smartHomeLoader = smartHomeLoader;
    }

    public static void main(String... args) throws IOException {
        //Load home
        SmartHome smartHome = smartHomeLoader.loadSmartHome();
        //Configure observer and subscribers
        Observer observer = new HomeEventsObserver();
        observer.subscribe(ConfigProcessors.configureEventProcessors());
        //Start events
        EventManager eventManager = new HomeEventManager(observer, new RandomSensorEventProvider());
        eventManager.runEventsCycle(smartHome);
    }
}
