package org.team4230.robot2019;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.team4230.robot2019.commands.AutonomousCommand;
import org.team4230.lib.utils.AnalogAxis;
import org.team4230.lib.utils.ControllerMap;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

    // Declares the joystick objects
    public Joystick driverController;
    public Joystick operatorController;
    private CommandGroup activeAutoMode;

    public OI() {
        // Initialize the objects Joystick(R and L)
        driverController = new Joystick(0);
        operatorController = new Joystick(1);
        // Set the channels on the Joysticks
        driverController.setXChannel(ControllerMap.analog.RY);
        driverController.setYChannel(ControllerMap.analog.RX);

        operatorController.setXChannel(ControllerMap.analog.LY);
        operatorController.setYChannel(ControllerMap.analog.LX);
        activeAutoMode = new org.team4230.robot2019.commands.drivetrain.AutoDriveToHatch();

        bindDefButtons();

        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
    }

    private CommandGroup engageAutoDrive() {
        activeAutoMode.close();
        activeAutoMode = new org.team4230.robot2019.commands.drivetrain.AutoDriveToHatch();
        return activeAutoMode;
    }

    /**
     * Bind the default buttons on both controllers
     */
    private void bindDefButtons() {
        // climber button mappings
        Button lowerB = new JoystickButton(operatorController, ControllerMap.buttons.Y);
        Button raiseB = new JoystickButton(operatorController, ControllerMap.buttons.X);
        Button raiseFrontB = new JoystickButton(operatorController, ControllerMap.buttons.B);
        Button raiseBackB = new JoystickButton(operatorController, ControllerMap.buttons.A);

        lowerB.whenPressed(new org.team4230.robot2019.commands.climber.Lower());
        raiseB.whenPressed(new org.team4230.robot2019.commands.climber.Raise());
        raiseFrontB.whenPressed(new org.team4230.robot2019.commands.climber.RaiseFront());
        raiseBackB.whenPressed(new org.team4230.robot2019.commands.climber.RaiseBack());

        // operator hatch button mappings
        Button oHatchLower = new JoystickButton(operatorController, ControllerMap.buttons.RS);
        Button oHatchRelease = new JoystickButton(operatorController, ControllerMap.buttons.LS);

        oHatchLower.whenPressed(new org.team4230.robot2019.commands.hatch.LowerHatch());
        oHatchLower.whenReleased(new org.team4230.robot2019.commands.hatch.RaiseHatch());
        oHatchRelease.whenPressed(new org.team4230.robot2019.commands.hatch.Release());
        oHatchRelease.whenReleased(new org.team4230.robot2019.commands.hatch.Reset());

        // driver hatch button mappings
        AnalogAxis dHatchLower = new AnalogAxis(driverController, ControllerMap.analog.RT, 0.5);
        AnalogAxis dHatchRelease = new AnalogAxis(driverController, ControllerMap.analog.LT, 0.5);
        Button guideDeploy = new JoystickButton(driverController, ControllerMap.buttons.RS);

        dHatchLower.whenActive(new org.team4230.robot2019.commands.hatch.LowerHatch());
        dHatchLower.whenInactive(new org.team4230.robot2019.commands.hatch.RaiseHatch());
        dHatchRelease.whenActive(new org.team4230.robot2019.commands.hatch.Release());
        dHatchRelease.whenInactive(new org.team4230.robot2019.commands.hatch.Reset());
        guideDeploy.whenPressed(new org.team4230.robot2019.commands.hatch.LowerGuide());
        guideDeploy.whenReleased(new org.team4230.robot2019.commands.hatch.RaiseGuide());

        // ball intake button mappings
        AnalogAxis intakeIn = new AnalogAxis(operatorController, ControllerMap.analog.RT, 0.5);
        AnalogAxis intakeOut = new AnalogAxis(operatorController, ControllerMap.analog.LT, 0.5);

        intakeIn.whenActive(new org.team4230.robot2019.commands.intake.BallIn());
        intakeIn.whenInactive(new org.team4230.robot2019.commands.intake.StopMotor());
        intakeOut.whenActive(new org.team4230.robot2019.commands.intake.BallOut());
        intakeOut.whenInactive(new org.team4230.robot2019.commands.intake.StopMotor());

        // drivetrain speedshift button mappings
        Button speedShift = new JoystickButton(driverController, ControllerMap.buttons.LS);

        speedShift.whenPressed(new org.team4230.robot2019.commands.drivetrain.ShiftSpeed());
        speedShift.whenReleased(new org.team4230.robot2019.commands.drivetrain.ShiftSpeed());


        // Compressor button mappings
        Button compressorOff = new JoystickButton(driverController, ControllerMap.buttons.left);
        Button compressorOn = new JoystickButton(driverController, ControllerMap.buttons.right);

        compressorOff.whenPressed(new org.team4230.robot2019.commands.compressor.Disable());
        compressorOn.whenPressed(new org.team4230.robot2019.commands.compressor.Enable());

        Button seekingDrive = new JoystickButton(driverController, ControllerMap.buttons.Y);
        seekingDrive.whenPressed(engageAutoDrive());
    }

    public void remapForAutoMode() {
        for(int i = 1; i < 11; ++i) {
            Button button = new JoystickButton(driverController, i);
            button.whenPressed(new org.team4230.robot2019.commands.drivetrain.EngageTeleop());
        }
    }

    public void remapForTeleop() {
        for(int i = 1; i < 11; ++i) {
            Button button = new JoystickButton(driverController, i);
            button.whenPressed(new org.team4230.robot2019.commands.NullCommand());
        }
        bindDefButtons();
    }

    /**
     * Gets the drive speed value from the stick. Input sensitivity curves
     * should be applied here.
     *
     * @return a value between -1 and 1 porportional to drivetrain speed
     */
    public double getDriveSpeed() {
        return -1 * driverController.getRawAxis(ControllerMap.analog.LY);
    }

    /**
     * Gets the drivetrain rotation from the stick. Input sensitivity curves
     * should be applied here.
     *
     * @return a value between -1 and 1 porportional to the drivetrain rotation
     *         rate
     */
    public double getDriveRot() {
        return driverController.getRawAxis(ControllerMap.analog.RX) * 0.625;
    }

    /**
     * Scale a raw input from the controller to new desired range. The input
     * sensitivity curve is applied here.
     *
     * @param rawSpeed The raw speed input from the stick
     * @param speedMult The multiplier that should be applied to the raw input
     * @return a value between -1 and 1 representing the scaled speed
     */
    private double scaleRawSpeed(double rawSpeed, double speedMult) {
        double speed = rawSpeed*rawSpeed;
        if( rawSpeed < 0) {
            speed *= -1;
        }
        speed *= speedMult;
        return speed;
    }

    /**
     * Gets the climber speed from the control stick.
     *
     * @return a value between -1 and 1 proportional to the climber motor speed
     */
    public double getClimberDriveSpeed() {
        return scaleRawSpeed(operatorController.getRawAxis(ControllerMap.analog.RY),
                             RobotMap.Constants.climberDriveSpeedMult);
    }

    /**
     * Gets the lift speed from the control stick
     *
     * @return a value between -1 and 1 porportional to the desired speed of
     *         the climber motor
     */
    public double getLiftSpeed() {
        return scaleRawSpeed(operatorController.getRawAxis(ControllerMap.analog.LY),
                             RobotMap.Constants.liftSpeedMult);
    }
        //IDK
    public Joystick getJoystick1() {
        return driverController;
    }
}
