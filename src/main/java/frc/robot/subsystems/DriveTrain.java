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

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import edu.wpi.first.wpilibj.SpeedControllerGroup;

import com.revrobotics.CANSparkMax;


import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Robot;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class DriveTrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    public static DifferentialDrive DriveSys; 

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public DriveTrain() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
      //  CANSparkMax m_frontLeft = new CANSparkMax(1, MotorType.kBrushless);
	   // CANSparkMax m_rearLeft = new CANSparkMax(2, MotorType.kBrushless);
	  //  SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);

	 ///   CANSparkMax m_frontRight = new CANSparkMax(3, MotorType.kBrushless);
	  //  CANSparkMax m_rearRight = new CANSparkMax(4, MotorType.kBrushless);
	  //  SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_rearRight);
      //  DriveSys = new DifferentialDrive(m_left, m_right);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }


    @Override
    public void periodic() {
        // Put code here to be run every loop
//DriveSys.arcadeDrive(Robot.oi.driver.getY(),  Robot.oi.driver.getX());
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}
