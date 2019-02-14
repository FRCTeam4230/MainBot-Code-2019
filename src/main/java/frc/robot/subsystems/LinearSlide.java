package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;;

public class LinearSlide extends Subsystem {

    TalonSRX linearMotor;

    public LinearSlide() {
        linearMotor = new TalonSRX(RobotMap.CAN.linSlide);
        linearMotor.configOpenloopRamp(1);
        this.stopMotor();
    }

    @Override
    public void initDefaultCommand() {

    }

    public void slideUp() {
        linearMotor.set(ControlMode.PercentOutput, -1 * RobotMap.Constants.intake);
    }

    public void slideDown() {
        linearMotor.set(ControlMode.PercentOutput, RobotMap.Constants.intake);
    }

    public void stopMotor() {
        linearMotor.set(ControlMode.PercentOutput, 0);
    }

    @Override
    public void periodic() {
        // No periodic code
    }
}

