package ru.sbt.mipt.oop;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DoorEventProcessorTest {
    private SensorEvent event;
    private SmartHome smartHome;

    @Before
    public void init() {
        smartHome = InitTestHome.init();
    }

    @Test
    public void processEventTest_openOpenedDoor() {
        event = new SensorEvent(SensorEventType.DOOR_OPEN, "1");
        new DoorEventProcessor().processEvent(smartHome, event);
        Collection<Room> rooms = smartHome.getRooms();
        for (Room room : rooms) {
            Door door = room.getDoorById("1");
            assertTrue(door.isOpen());
        }
    }

    @Test
    public void processEventTest_openClosedDoor() {
        event = new SensorEvent(SensorEventType.DOOR_OPEN, "2");
        new DoorEventProcessor().processEvent(smartHome, event);
        Collection<Room> rooms = smartHome.getRooms();
        for (Room room : rooms) {
            Door door = room.getDoorById("2");
            assertTrue(door.isOpen());
        }
    }

    @Test
    public void processEventTest_closeClosedDoor() {
        event = new SensorEvent(SensorEventType.DOOR_CLOSE, "2");
        new DoorEventProcessor().processEvent(smartHome, event);
        Collection<Room> rooms = smartHome.getRooms();
        for (Room room : rooms) {
            Door door = room.getDoorById("2");
            assertFalse(door.isOpen());
        }
    }

    @Test
    public void processEventTest_closeOpenedDoor() {
        event = new SensorEvent(SensorEventType.DOOR_CLOSE, "1");
        new DoorEventProcessor().processEvent(smartHome, event);
        Collection<Room> rooms = smartHome.getRooms();
        for (Room room : rooms) {
            Door door = room.getDoorById("1");
            assertFalse(door.isOpen());
        }
    }
}
