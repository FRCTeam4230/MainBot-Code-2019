package frc.robot.commands.hatch;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;

public class LowerGuide extends Command {
    
    private boolean isFinished;

    public LowerGuide() {
        requires(Robot.hatchIntake);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        isFinished = false;
        Robot.hatchIntake.lowerGuide();
        isFinished = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return isFinished;
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