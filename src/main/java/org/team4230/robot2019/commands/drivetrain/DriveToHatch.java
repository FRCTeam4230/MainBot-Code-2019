package org.team4230.robot2019.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;

import org.team4230.robot2019.Robot;

public class DriveToHatch extends Command {


    public DriveToHatch() {
        requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Robot.driveTrain.drivePIDRot(0.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return Robot.ultrasonic.getValue() <= 300;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
