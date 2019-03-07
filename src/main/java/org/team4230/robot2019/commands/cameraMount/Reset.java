package org.team4230.robot2019.commands.cameraMount;

import edu.wpi.first.wpilibj.command.Command;
import org.team4230.robot2019.Robot;

public class Reset extends Command {
    public Reset() {
        requires(Robot.camMount);
    }

    @Override
    public void execute() {
        Robot.camMount.reset();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}
