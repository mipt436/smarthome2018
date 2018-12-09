package ru.sbt.mipt.oop;

public class DeactivatedAlarmState implements AlarmState {
    private Alarm alarm;

    DeactivatedAlarmState(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void activate(String password) {
        alarm.changeAlarmState(new ActivatedAlarmState(alarm, password));
    }

    @Override
    public void deactivate(String password) {

    }

    @Override
    public void setAlarmMode() {

    }
}
