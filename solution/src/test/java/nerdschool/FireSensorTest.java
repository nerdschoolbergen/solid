package nerdschool;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class FireSensorTest {

  @Test
  public void testThatIsTriggeredReturnsFalseOnFirstPoll() {
    FireSensor sensor = new FireSensor();
    boolean isTriggered = sensor.isTriggered();
    assertFalse(isTriggered);
  }

  @Test
  public void testThatIsTriggeredReturnsTrue33PercentOfTheTime() {
    FireSensor sensor = new FireSensor();

    final float nrOfPolls = 100;
    float triggeredCount = 0;

    for (int i = 0; i < nrOfPolls; i++) {
      if (sensor.isTriggered()) {
        triggeredCount++;
      }
    }

    float triggeredPercentage = triggeredCount / nrOfPolls * 100;
    double expectedTriggerPercentage = 33.0;
    assertEquals(expectedTriggerPercentage, triggeredPercentage);
  }

  @Test
  public void testThatGetLocationReturnsCorrectLocation() {
    FireSensor sensor = new FireSensor();
    String location = sensor.getLocation();
    assertEquals("Lobby 1st floor", location);
  }

  @Test
  public void testThatGetSensorTypeReturnsNull() {
    FireSensor sensor = new FireSensor();
    String sensorType = sensor.getSensorType();
    assertEquals("Fire", sensorType);
  }

  @Test
  public void testThatGetBatteryPercentageReturns100OBeforeFirstPoll() {
    FireSensor sensor = new FireSensor();
    double batteryPercentage = sensor.getBatteryPercentage();
    assertEquals(100.0, batteryPercentage);
  }

  @Test
  public void testThatGetBatteryPercentageDrains10PercentBetweenEachPoll() {
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
