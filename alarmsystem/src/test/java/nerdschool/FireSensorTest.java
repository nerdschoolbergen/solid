package nerdschool;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FireSensorTest {

    @Test
    public void testThatIsTriggeredReturnsFalse() {
        FireSensor sensor = new FireSensor();
        boolean isTriggered = sensor.isTriggered();
        assertEquals(false, isTriggered);
    }

    @Test
    public void testThatGetLocationReturnsNull(){
        FireSensor sensor = new FireSensor();
        String location = sensor.getLocation();
        assertEquals(null, location);
    }

    @Test
    public void testThatGetSensorTypeReturnsNull(){
        FireSensor sensor = new FireSensor();
        String sensorType = sensor.getSensorType();
        assertEquals(null, sensorType);
    }

    @Test
    public void testThatGetBatteryPercentageReturnsNegativeOne(){
        FireSensor sensor = new FireSensor();
        double batteryPercentage = sensor.getBatteryPercentage();
        assertEquals(-1.0, batteryPercentage);
    }
}
