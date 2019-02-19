package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.RobotMap;

public class HatchIntake extends Subsystem {

    // Declares the solenoids
    DoubleSolenoid HatchRelease;
    Solenoid LowerSolenoidAssembly;
    private Solenoid guideSolenoid;

    public HatchIntake() {
        HatchRelease = new DoubleSolenoid(RobotMap.PCM.hatchReleaseForward, RobotMap.PCM.hatchReleaseReverse);
        LowerSolenoidAssembly = new Solenoid(RobotMap.PCM.hatchLower);
        guideSolenoid = new Solenoid(RobotMap.PCM.guide);
    }

    @Override
    public void initDefaultCommand() {

    }

    public void releaseHatch() {
        HatchRelease.set(Value.kForward);
        SmartDashboard.putBoolean("HatchReleasing", true); 
    }

    public void resetHatch() {
        HatchRelease.set(Value.kReverse);
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
