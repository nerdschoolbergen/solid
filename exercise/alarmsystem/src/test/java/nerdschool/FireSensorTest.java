package nerdschool;

import junit.framework.TestCase;

public class FireSensorTest extends TestCase {

    public void testThatIsTriggeredReturnsFalse() {
        FireSensor sensor = new FireSensor();
        boolean isTriggered = sensor.isTriggered();
        assertEquals(false, isTriggered);
    }

    public void testThatGetLocationReturnsNull(){
        FireSensor sensor = new FireSensor();
        String location = sensor.getLocation();
        assertEquals(null, location);
    }

    public void testThatGetSensorTypeReturnsNull(){
        FireSensor sensor = new FireSensor();
        String sensorType = sensor.getSensorType();
        assertEquals(null, sensorType);
    }

    public void testThatGetBatteryPercentageReturnsNegativeOne(){
        FireSensor sensor = new FireSensor();
        double batteryPercentage = sensor.getBatteryPercentage();
        assertEquals(-1.0, batteryPercentage);
    }
}
