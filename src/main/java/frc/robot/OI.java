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
        Button guideDeploy = new JoystickButton(driverController, ControllerMap.buttons.RS);

        hatchLower.whenActive(new frc.robot.commands.Hatch.LowerHatch());
        hatchLower.whenInactive(new frc.robot.commands.Hatch.RaiseHatch());
        hatchRelease.whenActive(new frc.robot.commands.Hatch.Release());
        hatchRelease.whenInactive(new frc.robot.commands.Hatch.Reset());
        guideDeploy.whenPressed(new frc.robot.commands.Hatch.LowerGuide());
        guideDeploy.whenReleased(new frc.robot.commands.Hatch.RaiseGuide());

        AnalogAxis intakeIn = new AnalogAxis(operatorController, ControllerMap.analog.RT, 0.5);
        AnalogAxis intakeOut = new AnalogAxis(operatorController, ControllerMap.analog.LT, 0.5);

        intakeIn.whenActive(new frc.robot.commands.intake.BallIn());
        intakeIn.whenInactive(new frc.robot.commands.intake.StopMotor());
        intakeOut.whenActive(new frc.robot.commands.intake.BallOut());
        intakeOut.whenInactive(new frc.robot.commands.intake.StopMotor());

        Button speedShift = new JoystickButton(driverController, ControllerMap.buttons.LS);

        speedShift.whenActive(new frc.robot.commands.drivetrain.ShiftSpeed());

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

    public double getClimberDriveSpeed() {
        double rawSpeed = operatorController.getRawAxis(ControllerMap.analog.RY);
        double speed = rawSpeed*rawSpeed;
        if( rawSpeed < 0) {
            speed *= -1;
        }
        speed *= RobotMap.Constants.climberDriveSpeedMult;
        return speed;
    }

    public double getLiftSpeed() {
        double rawSpeed = operatorController.getRawAxis(ControllerMap.analog.LY);
        double speed = rawSpeed*rawSpeed;
        if( rawSpeed < 0) {
            speed *= -1;
        }
        speed *= RobotMap.Constants.liftSpeedMult;
        return speed;
    }
        //IDK
    public Joystick getJoystick1() {
        return driverController;
    }
}
