package org.team4230.robot2019.commands.slide;

import edu.wpi.first.wpilibj.command.Command;

import org.team4230.robot2019.Robot;

public class SlideUp extends Command {
    
    private boolean isFinished;

    public SlideUp() {
        requires(Robot.slide);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        isFinished = false;
        Robot.slide.slideUp();
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
