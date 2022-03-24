// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class AutoDriveCommand extends CommandBase {

  private final double speed;

  public AutoDriveCommand(double percentSpeed) {
    addRequirements(Robot.DriveSubsystem);
    speed = percentSpeed;
  }

  @Override
  public void initialize() {
    Robot.DriveSubsystem.ArcadeDrive(speed, 0.0);
  }

  @Override
  public void end(boolean interrupted) {
    Robot.DriveSubsystem.ArcadeDrive(0.0, 0.0);
  }

}
