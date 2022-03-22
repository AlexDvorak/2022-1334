package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class ClimberSRXSubsystem extends SubsystemBase{

    TalonSRX climbMotor;
    
    // Limit switches
    DigitalInput lowerSwitch;
    DigitalInput upperSwitch;

    boolean isClimbing = false;
    boolean isReleasing = false;
    int upRevolution = 0;
    int downRevolution = 0;

    public ClimberSRXSubsystem() {
        climbMotor = new TalonSRX(RobotMap.climbMotor);
        climbMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);

        lowerSwitch = new DigitalInput(0);
        upperSwitch = new DigitalInput(1);

        climbMotor.setNeutralMode(NeutralMode.Brake);
    }

    public void pullUpRobot() {
        isClimbing = true;
        climbMotor.set(ControlMode.PercentOutput, -1.0);
        
        while (isClimbing) {
            if (lowerSwitch.get()) {
                downRevolution += 1;
            }

            if (downRevolution >= 5) {
                climbMotor.set(ControlMode.PercentOutput, 0.0);
                climbMotor.setNeutralMode(NeutralMode.Brake);
                isClimbing = false;
            }
        }
    }

    public void climberRelease() {
        isReleasing = true;
        climbMotor.setNeutralMode(NeutralMode.Coast);
        climbMotor.set(ControlMode.PercentOutput, 1.0);

        while (isReleasing) {
            if (upperSwitch.get()) {
                upRevolution += 1;
            }

            if (upRevolution >= 5) {
                climbMotor.set(ControlMode.PercentOutput, 0.0);
                climbMotor.setNeutralMode(NeutralMode.Brake);
                isReleasing = false;
            }
        }

        // C1encoder.setPosition(0);
        // C2encoder.setPosition(0);
        //RightClimbMotor.set(ControlMode.Follower, RobotMap.LeftClimbMotor);
        
        //set motors to neutral so spring can expand (coast)
        // RightClimbMotor.setNeutralMode(NeutralMode.Coast);
        //RightClimbMotor.setIdleMode(IdleMode.kCoast);
        //ClimbMotor.setIdleMode(IdleMode.kCoast);
        //Climb_encoder = ClimbMotor.getEncoder();
        //Right_encoder = RightClimbMotor.getEncoder();

        //boolean Latching = true;

        // while (Latching) {
        
        // //check encoder value to make sure it doesn't go too far
        // // double MotorPos = LeftClimbMotor.getSelectedSensorPosition();
        // // double MotorPos = m_encoder.getPosition();

        // //stop motors once they reach target distance (or set them to hold position)
        // //4096 encoder counts in a single revoloution of CANSpark    
        // if (Left_encoder.getPosition() >= 2048) {
        //         Latching = false;
        //         // LeftClimbMotor.setNeutralMode(NeutralMode.Brake);
        //         // RightClimbMotor.setNeutralMode(NeutralMode.Brake);
        //         //RightClimbMotor.setIdleMode(IdleMode.kBrake);
        //         ClimbMotor.setIdleMode(IdleMode.kBrake);
        //     }
        // }
        
    }

}