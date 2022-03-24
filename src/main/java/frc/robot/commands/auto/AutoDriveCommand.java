// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class AutoDriveCommand extends CommandBase {

  private long endTime, startTime;
  private final double speed;

  public AutoDriveCommand(long millisecondsToDrive, double percentSpeed) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.DriveSubsystem);
    speed = percentSpeed;
    endTime = millisecondsToDrive;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime = System.currentTimeMillis();
    Robot.DriveSubsystem.ArcadeDrive(speed, 0.0);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.DriveSubsystem.ArcadeDrive(0.0, 0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return System.currentTimeMillis() >= (startTime + endTime);
  }

}
