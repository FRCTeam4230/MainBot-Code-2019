package org.team4230.robot2019.commands.cameraMount;

import edu.wpi.first.wpilibj.command.Command;
import org.team4230.robot2019.Robot;

public class Rotate extends Command {
    public Rotate() {
        requires(Robot.camMount);
    }

    @Override
    public void execute() {
        Robot.camMount.rotate();
    }

    @Override
    protected boolean isFinished() {
        return true;
    }
}