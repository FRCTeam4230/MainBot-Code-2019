package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class CompressorSys extends Subsystem {

    private Compressor compressor;

    public CompressorSys() {
        compressor = new Compressor(0);
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

    @Override
    public void periodic() {
        // not implemented
    }
}