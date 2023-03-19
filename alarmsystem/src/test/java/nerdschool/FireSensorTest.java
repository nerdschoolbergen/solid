package nerdschool;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class FireSensorTest {

  @Test
  public void testThatIsTriggeredReturnsFalse() {
    FireSensor sensor = new FireSensor();
    boolean isTriggered = sensor.isTriggered();
    assertFalse(isTriggered);
  }

  @Test
  public void testThatGetLocationReturnsNull() {
    FireSensor sensor = new FireSensor();
    String location = sensor.getLocation();
    assertNull(location);
  }

  @Test
  public void testThatGetSensorTypeReturnsNull() {
    FireSensor sensor = new FireSensor();
    String sensorType = sensor.getSensorType();
    assertNull(sensorType);
  }

  @Test
  public void testThatGetBatteryPercentageReturnsNegativeOne() {
    FireSensor sensor = new FireSensor();
    double batteryPercentage = sensor.getBatteryPercentage();
    assertEquals(-1.0, batteryPercentage);
  }
}
