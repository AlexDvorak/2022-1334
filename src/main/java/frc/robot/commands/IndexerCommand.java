// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

/*

Created by: William Kozlowski

Created 2022-02-20

Modified 2022-03-03, by William Kozlowski

Indexer Subsystem, helps to sort/push the ball to fit into the conveyer, and preps the ball to be shot

*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class IndexerCommand extends CommandBase {

  public IndexerCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.IndexerSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.IndexerSubsystem.setIndexer1Voltage(0.1);
    Robot.IndexerSubsystem.setIndexer2Voltage(0.25);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.IndexerSubsystem.setIndexer1Voltage(0.0);
    Robot.IndexerSubsystem.setIndexer2Voltage(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

}