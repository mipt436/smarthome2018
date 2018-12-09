package ru.sbt.mipt.oop;

public class Alarm {
    private AlarmState alarmState;

    Alarm() {
        this.alarmState = new DeactivatedAlarmState(this);
    }

    AlarmState getAlarmState() {
        return alarmState;
    }

    void changeAlarmState(AlarmState alarmState) {
        this.alarmState = alarmState;
    }

    void activate(String password) {
        alarmState.activate(password);
    }

    void deactivate(String password) {
        alarmState.deactivate(password);
    }

    void setAlarmMode() {
        alarmState.setAlarmMode();
    }
}
