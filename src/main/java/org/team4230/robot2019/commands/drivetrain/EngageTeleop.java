package org.team4230.robot2019.commands.drivetrain;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class EngageTeleop extends CommandGroup {

    public EngageTeleop() {
        addSequential(new RemapForTeleop());
        addSequential(new DriveTeleop());
    }

}

