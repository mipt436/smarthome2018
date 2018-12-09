package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSE;

public class HallDoorEventProcessor implements EventProcessor {
    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (event.getType() != DOOR_CLOSE) return;
        // событие от двери
        for (Room room : smartHome.getRooms()) {
            if (room.getName().equals("hall")) {
                room.executeAction(objectDoor -> {
                    if (objectDoor instanceof Door) {
                        if (((Door) objectDoor).getId().equals(event.getObjectId())) smartHome.turnOffLights();
                    }
                });
            }

        }
    }
}
