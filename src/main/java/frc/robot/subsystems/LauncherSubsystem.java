// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class LauncherSubsystem extends SubsystemBase{

  TalonFX LauncherLeft;
  TalonFX LauncherRight;

  public LauncherSubsystem() {
    LauncherLeft = new TalonFX(RobotMap.LauncherLeft);
    LauncherRight = new TalonFX(RobotMap.LauncherRight);

    // Configure the default Integrated Sensors for the Talons
    LauncherLeft.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    LauncherRight.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);

    // Set the second Talon to follow the first Talon
    LauncherRight.set(ControlMode.Follower, RobotMap.LauncherLeft);

    // Invert the first Talon (Left and Right can now run the same Velocity PID RPM)
    LauncherLeft.setInverted(true);
  }

  // This void method sets a velocity PID setpoint on the Talons
  public void runVelocity(double setpoint) {
    // Set the first Talon's PID target to the setpoing (second Talon will follow)
    LauncherLeft.set(ControlMode.Velocity, setpoint);
    LauncherRight.set(ControlMode.Velocity, setpoint);
  }

  // This void method manually sets the percent power input to the Launcher Falcons
  public void runPercent(double percent) {
    LauncherLeft.set(ControlMode.PercentOutput, percent);
    LauncherRight.set(ControlMode.PercentOutput, percent);
  }

  public void stop() {
    LauncherLeft.set(ControlMode.PercentOutput, 0);
    LauncherRight.set(ControlMode.PercentOutput, 0);
  }

}
