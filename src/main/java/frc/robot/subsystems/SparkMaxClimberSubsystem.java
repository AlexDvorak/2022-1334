// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class SparkMaxClimberSubsystem extends SubsystemBase {

  CANSparkMax climbMotor;
  RelativeEncoder encoder;

  public SparkMaxClimberSubsystem() {
    climbMotor = new CANSparkMax(RobotMap.climbMotor, MotorType.kBrushless);
    climbMotor.setIdleMode(IdleMode.kBrake);
    climbMotor.setSmartCurrentLimit(40);

    encoder = climbMotor.getEncoder();
    encoder.setPosition(0);
  }

  public void releaseClimber() {
    // Set the motor to coast so the bars are released
    climbMotor.setIdleMode(IdleMode.kCoast);
    climbMotor.set(0.2);
  }

  public void stopReleasingClimber() {
    climbMotor.set(0.0);
    climbMotor.setIdleMode(IdleMode.kBrake);
  }

  public boolean stopReleasingCheck() {
    return encoder.getPosition() >= 2;
  }

  public void pullRobot() {
    encoder.setPosition(0);
    // Motor spins to pull up the robot
    climbMotor.set(-0.2);
  }

  public void stopPullingRobot() {
    climbMotor.set(0.0);
    climbMotor.setIdleMode(IdleMode.kBrake);
  }

  public boolean stopPullingCheck() {
    return encoder.getPosition() >= 2;
  }





  public void testingForward() {
    climbMotor.setIdleMode(IdleMode.kCoast);
    climbMotor.set(0.1);
  }

  public void testingReverse() {
    climbMotor.setIdleMode(IdleMode.kCoast);
    climbMotor.set(-0.1);
  }

}