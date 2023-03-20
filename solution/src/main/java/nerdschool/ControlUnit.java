package nerdschool;

import java.util.List;

public class ControlUnit {
  private final SensorViewer sensorViewer;
  private final SensorPoller sensorPoller;

  public ControlUnit(SensorViewer sensorViewer, SensorPoller sensorPoller) {
    this.sensorViewer = sensorViewer;
    this.sensorPoller = sensorPoller;
  }

  public void pollSensors() {
    List<Sensor> triggeredSensors = this.sensorPoller.pollSensors();
    this.sensorViewer.displayTriggeredSensors(triggeredSensors);
  }
}
