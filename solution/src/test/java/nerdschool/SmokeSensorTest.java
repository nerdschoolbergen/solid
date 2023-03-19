package nerdschool;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class SmokeSensorTest {

  @Test
  public void testThatIsTriggeredReturnsFalse() {
    SmokeSensor sensor = new SmokeSensor();
    boolean isTriggered = sensor.isTriggered();
    assertFalse(isTriggered);
  }

  @Test
  public void testThatIsTriggeredReturnsTrue50PercentOfTheTime() {
    SmokeSensor sensor = new SmokeSensor();

    final float nrOfPolls = 100;
    float triggeredCount = 0;

    for (int i = 0; i < nrOfPolls; i++) {
      if (sensor.isTriggered()) {
        triggeredCount++;
      }
    }

    float triggeredPercentage =  triggeredCount / nrOfPolls * 100;
    double expectedTriggerPercentage = 50.0;
    assertEquals(expectedTriggerPercentage, triggeredPercentage );
  }

  @Test
  public void testThatGetLocationReturnsNull() {
    SmokeSensor sensor = new SmokeSensor();
    String location = sensor.getLocation();
    assertEquals("In the auditorium", location);
  }

  @Test
  public void testThatGetSensorTypeReturnsCorrectType() {
    SmokeSensor sensor = new SmokeSensor();
    String sensorType = sensor.getSensorType();
    assertEquals("Smoke", sensorType);
  }

  @Test
  public void testThatGetBatteryPercentageReturns100Percent() {
    SmokeSensor sensor = new SmokeSensor();
    double batteryPercentage = sensor.getBatteryPercentage();
    assertEquals(100.0, batteryPercentage);
  }


  @Test
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
