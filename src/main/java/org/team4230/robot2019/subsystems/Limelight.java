package org.team4230.robot2019.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Limelight extends Subsystem {

    private NetworkTable limelight;

    public Limelight() {
        limelight = NetworkTableInstance.getDefault().getTable("limelight");
    }

    @Override
    public void initDefaultCommand() {

    }

    public boolean hasTarget() {
        return limelight.getEntry("tv").getDouble(0) == 1;
    }

    public double getXOffset() {
        return limelight.getEntry("tx").getDouble(0);
    }

    public double getYOffset() {
        return limelight.getEntry("ty").getDouble(0);
    }
}
