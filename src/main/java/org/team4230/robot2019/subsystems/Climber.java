package org.team4230.robot2019.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.team4230.robot2019.OI;
import org.team4230.robot2019.RobotMap;
import org.team4230.robot2019.commands.climber.JoystickDrive;

public class Climber extends Subsystem {

    public static OI oi;
    // Declares the solenoids for the pistons (THEY ARE SOLENOIDS NOT DOUBLE SOLENOIDS)
    private Solenoid backPiston;
    private Solenoid frontPiston;
    private VictorSPX climberDrive;
    private boolean frontDeployed;
    private boolean backDeployed;
    
    public Climber() {
        // initialize variables
        frontPiston = new Solenoid(RobotMap.PCM.climberFront);
        backPiston = new Solenoid(RobotMap.PCM.climberBack);
        climberDrive = new VictorSPX(RobotMap.CAN.driveClimber);
        climberDrive.configOpenloopRamp(1);
        this.raiseAll();
        frontDeployed = false;
        backDeployed = false;
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new JoystickDrive());
    }

    @Override
    public void periodic() {
        // No periodic code to run
    }

    public void lowerAll() {
        frontPiston.set(true);
        backPiston.set(true);
        frontDeployed = true;
        backDeployed = true;
        SmartDashboard.putBoolean("backPistonState", true);
        SmartDashboard.putBoolean("frontPistonState", true);
        SmartDashboard.putBoolean("Piston Status", true);
    }

    public void raiseAll() {
        frontPiston.set(false);
        backPiston.set(false);
        frontDeployed = false;
        backDeployed = false;
        SmartDashboard.putBoolean("backPistonState", false);
        SmartDashboard.putBoolean("frontPistonState", false);
        SmartDashboard.putBoolean("Piston Status", true);
    }

    public void raiseFront() {
        frontPiston.set(false);
        frontDeployed = false;
        SmartDashboard.putBoolean("frontPistonState", false);
        SmartDashboard.putBoolean("Piston Status", true);
    }

    public void raiseBack() {
        if( ! frontDeployed) {
            backPiston.set(false);
            SmartDashboard.putBoolean("backPistonState", false);
            SmartDashboard.putBoolean("Piston Status", true);
        } else {
            SmartDashboard.putString("Latest Error", "Tried to Retract rear piston while front piston is deployed");
            SmartDashboard.putBoolean("Piston Status", false);
        }
    }

    public void driveClimber(double speed) {
        climberDrive.set(ControlMode.PercentOutput, speed);
    }
}
