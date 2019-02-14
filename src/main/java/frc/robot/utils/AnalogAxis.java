package frc.robot.utils;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.*;

/**
 * 
 */
public class AnalogAxis extends Trigger {

    private GenericHID input;
    private int axis;
    private double threshold;

    public AnalogAxis(GenericHID input, int analogAxis, double threshold) {
        this.input = input;
        this.axis = analogAxis;
        this.threshold = threshold;
    }
    
    @Override
    public boolean get() {
        if (input.getRawAxis(axis) >= threshold) {
            return true;
        } else {
            return false;
        }
    }
}