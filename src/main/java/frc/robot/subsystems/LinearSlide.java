package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;

import frc.robot.RobotMap;

public class LinearSlide extends Subsystem {

    TalonSRX linearMotor;

    public LinearSlide() {
        linearMotor = new TalonSRX(RobotMap.CAN.linSlide);
        linearMotor.configOpenloopRamp(1);
        this.stopMotor();
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new frc.robot.commands.slide.JoystickBind());
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
