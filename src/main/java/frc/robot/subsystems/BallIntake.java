package frc.robot.subsystems;

import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;


public class BallIntake extends Subsystem {

    TalonSRX linearSlideMotor;
    VictorSPX intakeMotor;

    public BallIntake() {
        linearSlideMotor = new TalonSRX(7);
        intakeMotor = new VictorSPX(6);
    }

    @Override
    public void initDefaultCommand() {

    }

    @Override
    public void periodic() {
        // intakeMotor.set(ControlMode.PercentOutput, Robot.oi.operatorController.getRawAxis(0));
        // linearSlideMotor.set(ControlMode.PercentOutput, Robot.oi.operatorController.getRawAxis(1));
    }
}

