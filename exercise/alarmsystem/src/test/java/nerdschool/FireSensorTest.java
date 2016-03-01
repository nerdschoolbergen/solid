package nerdschool;

import junit.framework.TestCase;

public class FireSensorTest extends TestCase {

    public void testThatIsTriggeredReturnsTrueAbout10PercentOfTheTime() {
        FireSensor sensor = new FireSensor();

        final float nrOfPolls = 100;
        float triggeredCount = 0;

        for (int i = 0; i < nrOfPolls; i++) {
            if (sensor.isTriggered()) {
                triggeredCount++;
            }
        }

        final int allowedOffset = 2;
        final int expectedPercentage = 10;

        float triggeredPercentage =  triggeredCount / nrOfPolls * 100;
        int maxAllowedOffset = expectedPercentage + allowedOffset;
        int minAllowedOffset = expectedPercentage - allowedOffset;

        assertTrue(triggeredPercentage >= minAllowedOffset && triggeredPercentage <= maxAllowedOffset );
    }

    public void testThatGetLocationReturnsNull(){
        FireSensor sensor = new FireSensor();
        String location = sensor.getLocation();
        assertEquals("Lobby 1st floor", location);
    }

    public void testThatGetSensorTypeReturnsNull(){
        FireSensor sensor = new FireSensor();
        String sensorType = sensor.getSensorType();
        assertEquals("Fire", sensorType);
    }

    public void testThatGetBatteryPercentageDrains10PercentBetweenEachPoll(){
        FireSensor sensor = new FireSensor();

        double batteryPercentage1 = sensor.getBatteryPercentage();
        sensor.isTriggered();

        double batteryPercentage2 = sensor.getBatteryPercentage();
        sensor.isTriggered();

        double batteryPercentage3 = sensor.getBatteryPercentage();
        sensor.isTriggered();

        assertEquals(100.0, batteryPercentage1);
        assertEquals(90.0, batteryPercentage2);
        assertEquals(80.0, batteryPercentage3);
    }
}
