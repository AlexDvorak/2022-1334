// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.testing;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.Robot;

public class ClimbTestingForward extends CommandBase {

  public ClimbTestingForward() {
    addRequirements(Robot.ClimberSubsystem);
  }

  @Override
  public void initialize() {
    Robot.ClimberSubsystem.testingForward();
  }

  @Override
  public void end(boolean interrupted) {
    Robot.ClimberSubsystem.stopPullingRobot();
  }

}
