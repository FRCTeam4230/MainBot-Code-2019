package frc.robot.subsystems;

import frc.robot.commands.*;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.Robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;


public class BallIntake extends Subsystem {

    VictorSPX intakeMotor;

    public BallIntake() {
        intakeMotor = new VictorSPX(RobotMap.CAN.ballIntake);
        intakeMotor.configOpenloopRamp(1);
    }

    @Override
    public void initDefaultCommand() {

    }

    public void ballIn() {
        intakeMotor.set(ControlMode.PercentOutput, RobotMap.Constants.intake);
    }

    public void ballOut() {
        intakeMotor.set(ControlMode.PercentOutput, -1 * RobotMap.Constants.intake);
    }

    public void stopMotor() {
        intakeMotor.set(ControlMode.PercentOutput, 0);
    }

    @Override
    public void periodic() {
        // intakeMotor.set(ControlMode.PercentOutput, Robot.oi.operatorController.getRawAxis(0));
        // linearSlideMotor.set(ControlMode.PercentOutput, Robot.oi.operatorController.getRawAxis(1));
    }
}

