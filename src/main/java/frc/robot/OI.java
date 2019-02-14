package frc.robot;


import frc.robot.commands.*;
import frc.robot.commands.Climber.*;
import frc.robot.utils.AnalogAxis;
import frc.robot.utils.ControllerMap;
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
        driverController.setXChannel(ControllerMap.analog.RY);
        driverController.setYChannel(ControllerMap.analog.RX);

        operatorController.setXChannel(ControllerMap.analog.LY);
        operatorController.setYChannel(ControllerMap.analog.LX);

        bindDefButtons();

        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());    
    }

    private void bindDefButtons() {
        Button lowerB = new JoystickButton(driverController, ControllerMap.buttons.A);
        Button raiseB = new JoystickButton(driverController, ControllerMap.buttons.Y);
        Button raiseFrontB = new JoystickButton(driverController, ControllerMap.buttons.B);
        Button raiseBackB = new JoystickButton(driverController, ControllerMap.buttons.X);

        lowerB.whenPressed(new frc.robot.commands.Climber.Lower());
        raiseB.whenPressed(new frc.robot.commands.Climber.Raise());
        raiseFrontB.whenPressed(new frc.robot.commands.Climber.RaiseFront());
        raiseBackB.whenPressed(new frc.robot.commands.Climber.RaiseBack());

        AnalogAxis hatchLower = new AnalogAxis(driverController, ControllerMap.analog.RT, 0.5);
        Button hatchRelease = new JoystickButton(driverController, ControllerMap.buttons.RS);

        hatchLower.whenActive(new frc.robot.commands.Hatch.Lower());
        hatchLower.whenInactive(new frc.robot.commands.Hatch.Raise());
        hatchRelease.whenPressed(new frc.robot.commands.Hatch.Release());
        hatchRelease.whenReleased(new frc.robot.commands.Hatch.Reset());

        Button enableCompressor = new JoystickButton(operatorController, ControllerMap.buttons.Y);
        Button disableCompressor = new JoystickButton(operatorController, ControllerMap.buttons.A);

        enableCompressor.whenPressed(new frc.robot.commands.compressor.Enable());
        disableCompressor.whenPressed(new frc.robot.commands.compressor.Disable());
    }

        //IDK
    public Joystick getJoystick1() {
        return driverController;
    }
}
