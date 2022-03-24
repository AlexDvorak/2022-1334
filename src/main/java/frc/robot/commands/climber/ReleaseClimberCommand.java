// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.climber;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class ReleaseClimberCommand extends CommandBase {

  public ReleaseClimberCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.ClimberSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.ClimberSubsystem.releaseClimber();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.ClimberSubsystem.stopReleasingClimber();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Robot.ClimberSubsystem.doneReleasing();
  }

}
