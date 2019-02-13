// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package frc.robot.subsystems;

import frc.robot.Robot;

import frc.robot.OI;

import edu.wpi.first.wpilibj.command.Subsystem;

// import the SmartDashboard 
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import com.ctre.phoenix.motorcontrol.ControlMode;
// imports the CRTE libriry
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

// import solenoid class
import edu.wpi.first.wpilibj.Solenoid;


public class Climber extends Subsystem {
    //Declares the solenoids for the pistons (THEY ARE SOLENOIDS NOT DOUBLE SOLENOIDS)
    private Solenoid backPiston;
    private Solenoid frontPiston;
    private VictorSPX climberDrive;


    public static OI oi;


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public Climber() {
        // initialize variables
        frontPiston = new Solenoid(4);
        backPiston = new Solenoid(5);
        climberDrive = new VictorSPX(5);
        frontPiston.set(false);
        backPiston.set(false);
    }

    @Override
    public void initDefaultCommand() {
        // No default command
    }

    @Override
    public void periodic() {
        // No periodic code to run
    }

    public void lowerAll() {
        frontPiston.set(true);
        backPiston.set(true);
        SmartDashboard.putBoolean("backPistonState", true);
        SmartDashboard.putBoolean("frontPistonState", true); 
    }

    public void raiseAll() {
        frontPiston.set(false);
        backPiston.set(false);
        SmartDashboard.putBoolean("backPistonState", false);
        SmartDashboard.putBoolean("frontPistonState", false); 
    }

    public void raiseFront() {
        if( frontPiston.get()){
            frontPiston.set(false);
            SmartDashboard.putBoolean("frontPistonState", false);
        }
    }

    public void raiseBack() {
        if( backPiston.get()){
            backPiston.set(false);
            SmartDashboard.putBoolean("backPistonState", false);
        }
    }


}

