// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

/*-------------------------------------------------------------------------

Author: Clarrie Wang                                     Date: Jan 22 2022

DriveSubsystem class for differential drivetrain using 4 NEO brushless motors.

---------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
// import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxPIDController;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

// import edu.wpi.first.wpilibj.drive.DifferentialDrive;
// import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class DriveSubsystem extends SubsystemBase {

  DoubleSolenoid mirrorSol;

  // using 4 Spark Max motor controllers, 2 for front motors, 2 for back
  CANSparkMax L1motor;
  CANSparkMax L2motor;
  CANSparkMax R1motor;
  CANSparkMax R2motor;

  // Grouping together the motor controllers on the left side
  MotorControllerGroup LeftMotors;
  MotorControllerGroup RightMotors;

  // Differential drivetrain object (aka West Coast/Tank drive)
  DifferentialDrive DifferentialDriveTrain;

  public DriveSubsystem() {
    L1motor = new CANSparkMax(RobotMap.L1motor, MotorType.kBrushless);
    L2motor = new CANSparkMax(RobotMap.L2motor, MotorType.kBrushless);  
    R1motor = new CANSparkMax(RobotMap.R1motor, MotorType.kBrushless);
    R2motor = new CANSparkMax(RobotMap.R2motor, MotorType.kBrushless);

    // invert left side motors of the drivetrain
    L1motor.setInverted(true);
    L2motor.setInverted(true);

    // reset encoders to start at 0
    L1motor.getEncoder().setPosition(0);
    L2motor.getEncoder().setPosition(0);    
    R1motor.getEncoder().setPosition(0);
    R2motor.getEncoder().setPosition(0);
    
    // Grouping together the motor controllers on each side
    LeftMotors = new MotorControllerGroup(L1motor, L2motor);
    RightMotors = new MotorControllerGroup(R1motor, R2motor);

    DifferentialDriveTrain = new DifferentialDrive(LeftMotors, RightMotors);
  }

  // feed percent voltage power into both sides of drive train
  // mapping individual motors to voltage 
  public void TankDrive(double Left, double Right) {
    DifferentialDriveTrain.tankDrive(Left, Right);
  }

  // wrapper function that allows for turning in tank drive
  public void ArcadeDrive(double speed, double turn) {
    DifferentialDriveTrain.arcadeDrive(speed, turn);
  }

  public void toggleMirrorSolenoid() {
    mirrorSol.toggle();   
  }
}
