// package
package frc.robot;
import edu.wpi.first.wpilibj.Compressor;


// Nuematics stuff
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// Spark Max


// Commands and Subsystems.
import frc.robot.commands.*;
import frc.robot.subsystems.*;



// FRC Stuff

//Talaron code

//import com.revrobotics.CANSparkMax;
// Spark MAX
//import com.sun.tools.classfile.StackMapTable_attribute.stack_map_frame;

public class Robot extends TimedRobot {

    Command autonomousCommand;
    SendableChooser<Command> chooser = new SendableChooser<>();


  
    public static DriveTrain driveTrain;
    public static Climber climber;
    public static BallIntake ballIntake;
    public static HatchIntake hatchIntake;

   // public static AnalogInput pressure;
    public static OI oi;    

    Compressor compressor;

    @Override
    public void robotInit() {
        compressor = new Compressor(0);
        compressor.setClosedLoopControl(true);
    

        driveTrain = new DriveTrain();
        climber = new Climber();
        ballIntake = new BallIntake();
        hatchIntake = new HatchIntake();
        
        oi = new OI();
       
        
        // Add commands to Autonomous Sendable Chooser
        
        chooser.setDefaultOption("Autonomous Command", new AutonomousCommand());

    
        SmartDashboard.putData("Auto mode", chooser);
    }


    @Override
    public void disabledInit(){

    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
        autonomousCommand = chooser.getSelected();
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    @Override
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
      
    }

    @Override
    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
        
        Scheduler.getInstance().run();
     //   SmartDashboard.putNumber("getvalue", pressure.getValue());
      //  SmartDashboard.putNumber("volta", pressure.getVoltage());
     //   SmartDashboard.putNumber("getadvalue", pressure.getAverageValue());
      //  SmartDashboard.putNumber("getadvolta", pressure.getAverageVoltage());
       
        
    }
}
