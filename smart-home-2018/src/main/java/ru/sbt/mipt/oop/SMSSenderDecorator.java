package ru.sbt.mipt.oop;

public class SMSSenderDecorator implements EventProcessor {
    final private EventProcessor processor;

    SMSSenderDecorator(EventProcessor processor) {
        this.processor = processor;
    }

    @Override
    public void processEvent(SmartHome smartHome, SensorEvent event) {
        if (smartHome.getAlarm().getAlarmState() instanceof ActivatedAlarmState || smartHome.getAlarm().getAlarmState() instanceof AlarmModeAlarmState) {
            System.out.println("Sending sms");
            return;
        }
        processor.processEvent(smartHome, event);
    }
}
