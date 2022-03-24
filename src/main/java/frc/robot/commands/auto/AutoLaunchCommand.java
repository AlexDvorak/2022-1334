// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class AutoLaunchCommand extends CommandBase {

  public AutoLaunchCommand() {
    addRequirements(Robot.FlywheelSubsystem, Robot.FeederSubsystem);
  }

  @Override
  public void initialize() {
    Robot.FeederSubsystem.runPercent(0.3);
    Robot.FlywheelSubsystem.runPercent(0.5);
  }

  @Override
  public void end(boolean interrupted) {
    Robot.FeederSubsystem.stop();
    Robot.FlywheelSubsystem.stop();
  }

}
