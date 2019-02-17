package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.commands.AutonomousCommand;
import frc.robot.utils.AnalogAxis;
import frc.robot.utils.ControllerMap;

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

        lowerB.whenPressed(new frc.robot.commands.climber.Lower());
        raiseB.whenPressed(new frc.robot.commands.climber.Raise());
        raiseFrontB.whenPressed(new frc.robot.commands.climber.RaiseFront());
        raiseBackB.whenPressed(new frc.robot.commands.climber.RaiseBack());

        AnalogAxis hatchLower = new AnalogAxis(driverController, ControllerMap.analog.RT, 0.5);
        AnalogAxis hatchRelease = new AnalogAxis(driverController, ControllerMap.analog.LT, 0.5);
        Button guideDeploy = new JoystickButton(driverController, ControllerMap.buttons.RS);

        hatchLower.whenActive(new frc.robot.commands.hatch.LowerHatch());
        hatchLower.whenInactive(new frc.robot.commands.hatch.RaiseHatch());
        hatchRelease.whenActive(new frc.robot.commands.hatch.Release());
        hatchRelease.whenInactive(new frc.robot.commands.hatch.Reset());
        guideDeploy.whenPressed(new frc.robot.commands.hatch.LowerGuide());
        guideDeploy.whenReleased(new frc.robot.commands.hatch.RaiseGuide());

        AnalogAxis intakeIn = new AnalogAxis(operatorController, ControllerMap.analog.RT, 0.5);
        AnalogAxis intakeOut = new AnalogAxis(operatorController, ControllerMap.analog.LT, 0.5);

        intakeIn.whenActive(new frc.robot.commands.intake.BallIn());
        intakeIn.whenInactive(new frc.robot.commands.intake.StopMotor());
        intakeOut.whenActive(new frc.robot.commands.intake.BallOut());
        intakeOut.whenInactive(new frc.robot.commands.intake.StopMotor());

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

    private double scaleRawSpeed(double rawSpeed, double speedMult) {
        double speed = rawSpeed*rawSpeed;
        if( rawSpeed < 0) {
            speed *= -1;
        }
        speed *= speedMult;
        return speed;
    }

    public double getClimberDriveSpeed() {
        return scaleRawSpeed(operatorController.getRawAxis(ControllerMap.analog.RY),
                             RobotMap.Constants.climberDriveSpeedMult);
    }

    public double getLiftSpeed() {
        return scaleRawSpeed(operatorController.getRawAxis(ControllerMap.analog.LY),
                             RobotMap.Constants.liftSpeedMult);
    }
        //IDK
    public Joystick getJoystick1() {
        return driverController;
    }
}
