package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.RobotMap;

public class HatchIntake extends Subsystem {

    // Declares the solenoids
    Solenoid HatchReleaseSolenoid;
    Solenoid LowerSolenoidAssembly;
    private Solenoid guideSolenoid;

    public HatchIntake() {
        HatchReleaseSolenoid = new Solenoid(RobotMap.PCM.hatchRelease);
        LowerSolenoidAssembly = new Solenoid(RobotMap.PCM.hatchLower);
        guideSolenoid = new Solenoid(RobotMap.PCM.guide);
    }

    @Override
    public void initDefaultCommand() {

    }

    public void releaseHatch() {
        HatchReleaseSolenoid.set(true);
        SmartDashboard.putBoolean("HatchReleasing", true); 
    }

    public void resetHatch() {
        HatchReleaseSolenoid.set(false);
        SmartDashboard.putBoolean("HatchReleasing", false);
    }
    
    public void lowerHatch() {
        LowerSolenoidAssembly.set(true);
        SmartDashboard.putBoolean("HatchLowered", true); 
    }

    public void raiseHatch() {
        LowerSolenoidAssembly.set(false);
        SmartDashboard.putBoolean("HatchLowered", false); 
    }

    public void lowerGuide() {
        guideSolenoid.set(true);
    }

    public void raiseGuide() {
        guideSolenoid.set(false);
    }

    @Override
    public void periodic() {
        // No periodic code
    }
}

