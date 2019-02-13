package frc.robot.subsystems;


import frc.robot.commands.*;
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

    public HatchIntake() {
        HatchReleaseSolenoid = new Solenoid(6);
      LowerSolenoidAssembly = new Solenoid(3);
 
    }

    @Override
    public void initDefaultCommand() {
        
    }
    @Override
    public void periodic() {
        // Put code here to be run every loop

        // sets the solenoids of the hatch release assembly on or of (release hatch)
        if (Robot.oi.driverController.getRawButton(6)){

            HatchReleaseSolenoid.set(true);
            SmartDashboard.putBoolean("HatchLowered", true);    
        }
        else{
            HatchReleaseSolenoid.set(false);
            SmartDashboard.putBoolean("HatchLowered", false); 
        }
        // sets the solenoids for the hatch intake assembly to go down or up (hatch down)
        if (Robot.oi.driverController.getRawButton(5)){

            LowerSolenoidAssembly.set(true);
            SmartDashboard.putBoolean("HatchReleasing", true);    
        }
        else{
           LowerSolenoidAssembly.set(false);
            SmartDashboard.putBoolean("HatchReleasing", false); 
        }
    }
}

