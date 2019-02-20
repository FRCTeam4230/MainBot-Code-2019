package org.team4230.robot2019.commands.drivetrain;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutoDriveToHatch extends CommandGroup {

    public AutoDriveToHatch() {
        addSequential(new RemapForAuto());
        addSequential(new DriveToHatch());
    }

}
