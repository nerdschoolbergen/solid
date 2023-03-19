package nerdschool;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmokeSensorTest {

    @Test
    public void testThatIsTriggeredReturnsFalse() {
        SmokeSensor sensor = new SmokeSensor();
        boolean isTriggered = sensor.isTriggered();
        assertFalse(isTriggered);
    }

    @Test
    public void testThatGetLocationReturnsNull(){
        SmokeSensor sensor = new SmokeSensor();
        String location = sensor.getLocation();
        assertNull(location);
    }

    @Test
    public void testThatGetSensorTypeReturnsNull(){
        SmokeSensor sensor = new SmokeSensor();
        String sensorType = sensor.getSensorType();
        assertNull(sensorType);
    }

    @Test
    public void testThatGetBatteryPercentageReturnsNegativeOne(){
        SmokeSensor sensor = new SmokeSensor();
        double batteryPercentage = sensor.getBatteryPercentage();
        assertEquals(-1.0, batteryPercentage);
    }
}
