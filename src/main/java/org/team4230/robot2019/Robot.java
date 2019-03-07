package org.team4230.robot2019;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.team4230.lib.sensor.MaxSonar;
import org.team4230.robot2019.commands.AutonomousCommand;
import org.team4230.robot2019.subsystems.*;

public class Robot extends TimedRobot {

    Command autonomousCommand;
    SendableChooser<Command> chooser = new SendableChooser<>();
    public static DriveTrain driveTrain;
    public static Climber climber;
    public static BallIntake ballIntake;
    public static HatchIntake hatchIntake;
    public static CompressorSys compressor;
    public static LinearSlide slide;
    public static Limelight limelight;
    public static MaxSonar ultrasonic;
    public static CameraMount camMount;
    // public static AnalogInput pressure;
    public static OI oi;

    @Override
    public void robotInit() {

        limelight = new Limelight();
        driveTrain = new DriveTrain(() -> limelight.getXOffset());
        climber = new Climber();
        compressor = new CompressorSys();
        ballIntake = new BallIntake();
        hatchIntake = new HatchIntake();
        slide = new LinearSlide();
        ultrasonic = new MaxSonar(RobotMap.AnalogIn.ultrasonicSensor);
        camMount = new CameraMount();
        CameraServer.getInstance().startAutomaticCapture();

        oi = new OI();

        // Add commands to Autonomous Sendable Chooser
        chooser.setDefaultOption("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("Auto mode", chooser);
    }

    private void initSubsystems() {
        climber.raiseAll();
    }


    @Override
    public void disabledInit(){
        // Not implemented
    }

    @Override
    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
        initSubsystems();
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
        initSubsystems();
    }

    /**
     * This function is called periodically during operator control
     */
    @Override
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        // SmartDashboard.putNumber("getvalue", pressure.getValue());
        // SmartDashboard.putNumber("volta", pressure.getVoltage());
        // SmartDashboard.putNumber("getadvalue", pressure.getAverageValue());
        // SmartDashboard.putNumber("getadvolta", pressure.getAverageVoltage());
    }
}
