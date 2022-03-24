// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.launcher_commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class RunFlywheelPercent extends CommandBase {

  private final double percent;

  public RunFlywheelPercent(double percentOutput) {
    this.percent = percentOutput;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.FlywheelSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.FlywheelSubsystem.runPercent(this.percent);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.FlywheelSubsystem.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }

}
