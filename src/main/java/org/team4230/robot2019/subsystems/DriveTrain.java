package org.team4230.robot2019.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import org.team4230.robot2019.RobotMap;
import org.team4230.robot2019.commands.drivetrain.DriveTeleop;

import java.util.function.DoubleSupplier;

public class DriveTrain extends PIDSubsystem {

    private DifferentialDrive driveSys;
    // Multiplier control for the speed/turn input mappings
    private int iMult;
    private double multMap[] = {0.75, 0.55};
    private DoubleSupplier getPIDInput;
    private PIDController controller;

    public DriveTrain(DoubleSupplier PIDInputFunc) {
        super("Drivetrain", 1, 0 , 0);
        Boolean sq = false;
        // sets the motor types and declares the object
        CANSparkMax m_frontLeft = new CANSparkMax(RobotMap.CAN.driveLH1, MotorType.kBrushless);
        CANSparkMax m_rearLeft = new CANSparkMax(RobotMap.CAN.driveLH2, MotorType.kBrushless);
        // Declares the motor group
        SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);
        // sets the motor types and declares the object
        CANSparkMax m_frontRight = new CANSparkMax(RobotMap.CAN.driveRH1, MotorType.kBrushless);
        CANSparkMax m_rearRight = new CANSparkMax(RobotMap.CAN.driveRH2, MotorType.kBrushless);
        // Declares the motor group
        SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_rearRight);
        // sets the ramp rate for the motors using an array
        CANSparkMax[] motors = {m_frontLeft, m_frontRight, m_rearLeft, m_rearRight};


        for(CANSparkMax motor : motors) {
            motor.setOpenLoopRampRate(1);
        }


        driveSys = new DifferentialDrive(m_left, m_right);
        getPIDInput = PIDInputFunc;
        controller = getPIDController();
        controller.setContinuous(false);
        setInputRange(-27, 27);
        setOutputRange(-0.6, 0.6);
        setAbsoluteTolerance(1);
        iMult = 0;
    }

    @Override
    public void initDefaultCommand() {
        setDefaultCommand(new DriveTeleop());
    }

    @Override
    protected double returnPIDInput() {
        return getPIDInput.getAsDouble();
    }

    @Override
    protected void usePIDOutput(double output) {
        // not used
    }

    public void drive(double speed, double rot) {
        driveSys.arcadeDrive(speed*0.75, rot*multMap[iMult], true);
    }

    public void drivePIDRot(double speed) {
        driveSys.arcadeDrive(speed, controller.get());
    }

    public void shiftSpeedSet() {
        iMult = (iMult + 1) % 2;
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
    }
}
