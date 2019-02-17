package frc.robot.commands.climber;
import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Robot;

public class RaiseBack extends Command {

    private boolean isFinished;

    public RaiseBack() {
        requires(Robot.climber);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        isFinished = false;
        Robot.climber.raiseBack();
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