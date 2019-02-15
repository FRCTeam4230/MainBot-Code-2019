package frc.robot.subsystems;

import frc.robot.commands.*;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;

// import the solenoid class
import edu.wpi.first.wpilibj.Solenoid;

// import the SmartDashboard
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// import the solenoid code
import edu.wpi.first.wpilibj.Solenoid;

// import robot class
import frc.robot.Robot;


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

