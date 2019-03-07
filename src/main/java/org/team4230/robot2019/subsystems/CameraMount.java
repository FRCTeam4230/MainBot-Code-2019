package org.team4230.robot2019.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.team4230.robot2019.RobotMap;

public class CameraMount extends Subsystem {

    private Servo camMotor;

    public CameraMount() {
        camMotor = new Servo(RobotMap.PWM.camServo);
        reset();
    }

    @Override
    public void initDefaultCommand() {

    }

    public void rotate() {
        camMotor.setAngle(180);
    }

    public void reset() {
        camMotor.setAngle(0);
    }
}
