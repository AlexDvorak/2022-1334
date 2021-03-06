// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutoSequence extends SequentialCommandGroup {
  public AutoSequence() {
    addCommands(
      new AutoDriveCommand(-0.25).withTimeout(3),
      new AutoLaunchCommand().withTimeout(3)
    );
  }
}
