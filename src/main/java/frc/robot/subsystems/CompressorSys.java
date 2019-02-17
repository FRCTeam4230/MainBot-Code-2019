package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.RobotMap;

public class CompressorSys extends Subsystem {

    private Compressor compressor;
    private AnalogInput pressureSensor;

    public CompressorSys() {
        compressor = new Compressor(0);
        pressureSensor = new AnalogInput(RobotMap.AnalogIn.pressureSensor);
        this.enable();
    }

    @Override
    public void initDefaultCommand() {

    }

    public void enable() {
        compressor.setClosedLoopControl(true);
    }

    public void disable() {
        compressor.setClosedLoopControl(false);
        compressor.stop();
    }

    public double getPressure() {
        double volts = pressureSensor.getVoltage();
        double pressure = volts*RobotMap.Constants.pressureMult - RobotMap.Constants.pressureSub;
        return (int) pressure;
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Pressure", getPressure());
    }
}