// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class RunIndexer extends CommandBase {

  public RunIndexer() {
    addRequirements(Robot.IndexerSubsystem);
  }

  @Override
  public void initialize() {
    Robot.IndexerSubsystem.runHigher(0.1);
    Robot.IndexerSubsystem.runLower(0.25);
  }

  @Override
  public void end(boolean interrupted) {
    Robot.IndexerSubsystem.stop();
  }

}