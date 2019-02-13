package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import edu.wpi.first.wpilibj.SpeedControllerGroup;

import com.revrobotics.CANSparkMax;


import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;


public class DriveTrain extends Subsystem {


    public static DifferentialDrive DriveSys; 
    public static OI oic; 



    public DriveTrain() {
       oic = new OI();
       Boolean sq = false;
        // sets the motor types and declares the object 
       CANSparkMax m_frontLeft = new CANSparkMax(1, MotorType.kBrushless);
       CANSparkMax m_rearLeft = new CANSparkMax(2, MotorType.kBrushless);
       
       // Declares the motor group 
       SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);
       
       // sets the motor types and declares the object 
	   CANSparkMax m_frontRight = new CANSparkMax(3, MotorType.kBrushless);
       CANSparkMax m_rearRight = new CANSparkMax(4, MotorType.kBrushless); 

       // Declares the motor group 
       SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_rearRight);
       
       // sets the ramp rate for the motors using an array
       CANSparkMax[] motors = {m_frontLeft, m_frontRight, m_rearLeft, m_rearRight};
       

       for(CANSparkMax motor : motors) {
           motor.setRampRate(1);
       }

	   
       DriveSys = new DifferentialDrive(m_left, m_right);
    }

    @Override
    public void initDefaultCommand() {
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop


        // Main command of the arcadeDrive.class , it get the data from the controller and sends it to the Speed Controller groups
        DriveSys.arcadeDrive(oic.driverController.getRawAxis(1),  oic.driverController.getRawAxis(4), true);
    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

}

