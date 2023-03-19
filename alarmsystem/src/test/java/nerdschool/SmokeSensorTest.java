package nerdschool;

import junit.framework.TestCase;

public class SmokeSensorTest extends TestCase {

    public void testThatIsTriggeredReturnsFalse() {
        SmokeSensor sensor = new SmokeSensor();
        boolean isTriggered = sensor.isTriggered();
        assertEquals(false, isTriggered);
    }

    public void testThatGetLocationReturnsNull(){
        SmokeSensor sensor = new SmokeSensor();
        String location = sensor.getLocation();
        assertEquals(null, location);
    }

    public void testThatGetSensorTypeReturnsNull(){
        SmokeSensor sensor = new SmokeSensor();
        String sensorType = sensor.getSensorType();
        assertEquals(null, sensorType);
    }

    public void testThatGetBatteryPercentageReturnsNegativeOne(){
        SmokeSensor sensor = new SmokeSensor();
        double batteryPercentage = sensor.getBatteryPercentage();
        assertEquals(-1.0, batteryPercentage);
    }

}
