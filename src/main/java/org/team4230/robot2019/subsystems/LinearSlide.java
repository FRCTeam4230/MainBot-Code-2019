package org.team4230.robot2019.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.team4230.robot2019.RobotMap;
import org.team4230.robot2019.commands.slide.JoystickBind;

public class LinearSlide extends Subsystem {

    TalonSRX linearMotor;

    public LinearSlide() {
        linearMotor = new TalonSRX(RobotMap.CAN.linSlide);
        linearMotor.configOpenloopRamp(1);
        this.stopMotor();
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new JoystickBind());
    }

    public void slideUp() {
        linearMotor.set(ControlMode.PercentOutput, -1 * RobotMap.Constants.intake);
    }

    public void slideDown() {
        linearMotor.set(ControlMode.PercentOutput, RobotMap.Constants.intake);
    }

    public void operateSlide(double speed) {
        linearMotor.set(ControlMode.PercentOutput, speed);
    }

    public void stopMotor() {
        linearMotor.set(ControlMode.PercentOutput, 0);
    }

    @Override
    public void periodic() {
        // No periodic code
    }
}
