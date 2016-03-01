package nerdschool;

import junit.framework.TestCase;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class ControlUnitTest extends TestCase {

    public void testThatControlUnitPollsGivenSensors(){
        Sensor sensor1 = mock(Sensor.class);
        Sensor sensor2 = mock(Sensor.class);
        Sensor sensor3 = mock(Sensor.class);

        ControlUnit controlUnit = new ControlUnit(sensor1, sensor2, sensor3);
        controlUnit.pollSensors();

        verify(sensor1, times(1)).isTriggered();
        verify(sensor2, times(1)).isTriggered();
        verify(sensor3, times(1)).isTriggered();
    }


}
