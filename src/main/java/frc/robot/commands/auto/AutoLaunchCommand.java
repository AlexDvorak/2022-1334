// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class AutoLaunchCommand extends CommandBase {
  /** Creates a new AutoLaunchCommand. */
  long endTime;
  long startTime;

  public AutoLaunchCommand(long time) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.FlywheelSubsystem);
    addRequirements(Robot.FeederSubsystem);
    endTime = time;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime = System.currentTimeMillis();
    Robot.FeederSubsystem.setLauncherPercent(0.3);
    Robot.FlywheelSubsystem.setLauncherPercent(0.5);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.FeederSubsystem.setLauncherPercent(0.0);
    Robot.FlywheelSubsystem.setLauncherPercent(0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return System.currentTimeMillis() >= (startTime + endTime);
  }
}
