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
        Button lowerB = new JoystickButton(operatorController, ControllerMap.buttons.Y);
        Button raiseB = new JoystickButton(operatorController, ControllerMap.buttons.X);
        Button raiseFrontB = new JoystickButton(operatorController, ControllerMap.buttons.B);
        Button raiseBackB = new JoystickButton(operatorController, ControllerMap.buttons.A);

        lowerB.whenPressed(new frc.robot.commands.Climber.Lower());
        raiseB.whenPressed(new frc.robot.commands.Climber.Raise());
        raiseFrontB.whenPressed(new frc.robot.commands.Climber.RaiseFront());
        raiseBackB.whenPressed(new frc.robot.commands.Climber.RaiseBack());

        AnalogAxis hatchLower = new AnalogAxis(driverController, ControllerMap.analog.RT, 0.5);
        AnalogAxis hatchRelease = new AnalogAxis(driverController, ControllerMap.analog.LT, 0.5);

        hatchLower.whenActive(new frc.robot.commands.Hatch.LowerHatch());
        hatchLower.whenInactive(new frc.robot.commands.Hatch.RaiseHatch());
        hatchRelease.whenActive(new frc.robot.commands.Hatch.Release());
        hatchRelease.whenInactive(new frc.robot.commands.Hatch.Reset());

        Button intakeIn = new JoystickButton(driverController, ControllerMap.buttons.Y);
        Button intakeOut = new JoystickButton(driverController, ControllerMap.buttons.A);

        intakeIn.whenPressed(new frc.robot.commands.intake.BallIn());
        intakeIn.whenReleased(new frc.robot.commands.intake.StopMotor());
        intakeOut.whenPressed(new frc.robot.commands.intake.BallOut());
        intakeOut.whenReleased(new frc.robot.commands.intake.StopMotor());

        Button slideUp = new JoystickButton(operatorController, ControllerMap.buttons.LS);
        Button slideDown = new JoystickButton(operatorController, ControllerMap.buttons.RS);

        slideUp.whenPressed(new frc.robot.commands.slide.SlideUp());
        slideUp.whenReleased(new frc.robot.commands.slide.StopMotor());
        slideDown.whenPressed(new frc.robot.commands.slide.SlideDown());
        slideDown.whenReleased(new frc.robot.commands.slide.StopMotor());

        Button speedShift = new JoystickButton(driverController, ControllerMap.buttons.LS);

        speedShift.whenPressed(new frc.robot.commands.drivetrain.ShiftSpeed());

        Button compressorOff = new JoystickButton(driverController, ControllerMap.buttons.left);
        Button compressorOn = new JoystickButton(driverController, ControllerMap.buttons.right);

        compressorOff.whenPressed(new frc.robot.commands.compressor.Disable());
        compressorOn.whenPressed(new frc.robot.commands.compressor.Enable());
    }

    public double getDriveSpeed() {
        return -1 * driverController.getRawAxis(ControllerMap.analog.LY);
    }

    public double getDriveRot() {
        return driverController.getRawAxis(ControllerMap.analog.RX);
    }

        //IDK
    public Joystick getJoystick1() {
        return driverController;
    }
}
