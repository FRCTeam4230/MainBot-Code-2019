package frc.robot;


import frc.robot.commands.*;
import frc.robot.commands.Climber.*;
import frc.robot.utils.AnalogAxis;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    // Declares the joystick objects
    public Joystick driverController;
    public Joystick operatorController;

    public OI() {
        // Initialize the objects Joystick(R and L)
        driverController = new Joystick(0);
        operatorController = new Joystick(1);
        // Set the channels on the Joysticks
        driverController.setXChannel(5);
        driverController.setYChannel(4);

        operatorController.setXChannel(1);
        operatorController.setYChannel(0);

        bindDefButtons();

        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());    
    }

    private void bindDefButtons() {
        Button lowerB = new JoystickButton(driverController, 1);
        Button raiseB = new JoystickButton(driverController, 4);
        Button raiseFrontB = new JoystickButton(driverController, 2);
        Button raiseBackB = new JoystickButton(driverController, 3);

        lowerB.whenPressed(new frc.robot.commands.Climber.Lower());
        raiseB.whenPressed(new frc.robot.commands.Climber.Raise());
        raiseFrontB.whenPressed(new frc.robot.commands.Climber.RaiseFront());
        raiseBackB.whenPressed(new frc.robot.commands.Climber.RaiseBack());

        AnalogAxis hatchLower = new AnalogAxis(driverController, 3, 0.5);
        Button hatchRelease = new JoystickButton(driverController, 6);

        hatchLower.whenActive(new frc.robot.commands.Hatch.Lower());
        hatchLower.whenInactive(new frc.robot.commands.Hatch.Raise());
        hatchRelease.whenPressed(new frc.robot.commands.Hatch.Release());
        hatchRelease.whenReleased(new frc.robot.commands.Hatch.Reset());
    }

        //IDK
    public Joystick getJoystick1() {
        return driverController;
    }
}
