package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import edu.wpi.first.wpilibj.SpeedControllerGroup;

import com.revrobotics.CANSparkMax;


import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.commands.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;


public class DriveTrain extends Subsystem {

    private DifferentialDrive driveSys;
    // Multiplier control for the speed/turn input mappings
    private int iMult;
    private double multMap[] = {0.5, 1};

    public DriveTrain() {
       Boolean sq = false;
        // sets the motor types and declares the object 
       CANSparkMax m_frontLeft = new CANSparkMax(RobotMap.CAN.driveLH1, MotorType.kBrushless);
       CANSparkMax m_rearLeft = new CANSparkMax(RobotMap.CAN.driveLH2, MotorType.kBrushless);
       // Declares the motor group 
       SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);
       // sets the motor types and declares the object 
	   CANSparkMax m_frontRight = new CANSparkMax(RobotMap.CAN.driveRH1, MotorType.kBrushless);
       CANSparkMax m_rearRight = new CANSparkMax(RobotMap.CAN.driveRH2, MotorType.kBrushless); 
       // Declares the motor group 
       SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_rearRight); 
       // sets the ramp rate for the motors using an array
       CANSparkMax[] motors = {m_frontLeft, m_frontRight, m_rearLeft, m_rearRight};
       

       for(CANSparkMax motor : motors) {
           motor.setRampRate(1);
       }

	   
       driveSys = new DifferentialDrive(m_left, m_right);
       iMult = 0;
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new frc.robot.commands.drivetrain.DriveTeleop());
    }

    public void drive(double speed, double rot) {
        driveSys.arcadeDrive(speed * multMap[iMult], rot * multMap[0], true);
    }

    public void shiftSpeedSet() {
        iMult = (iMult + 1) % 2;
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
    }
}

