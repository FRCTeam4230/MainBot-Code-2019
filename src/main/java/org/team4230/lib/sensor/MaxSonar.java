package org.team4230.lib.sensor;

import edu.wpi.first.wpilibj.AnalogInput;

public class MaxSonar implements SensorI{

    private AnalogInput port;

    public MaxSonar(int analogPort) {
        port = new AnalogInput(analogPort);
    }

    /**
     * Get the distance from the sensor in centimeters
     * @return distance fromt eh ultrasonic sensor in millimeters
     */
    @Override
    public double getValue() {
        return 0.0009770212*port.getVoltage() + 300;
    }
}
