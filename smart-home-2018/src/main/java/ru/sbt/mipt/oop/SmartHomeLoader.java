package ru.sbt.mipt.oop;

import java.io.IOException;

public interface SmartHomeLoader {
    SmartHome loadSmartHome() throws IOException;
    SmartHome loadSmartHome(String path) throws IOException;
}
