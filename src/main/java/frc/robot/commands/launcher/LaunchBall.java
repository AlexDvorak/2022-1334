// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.launcher;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class LaunchBall extends SequentialCommandGroup {
  public LaunchBall() {
    addCommands(new RunFlywheelPercent(1.0), new WaitCommand(1.5), new FeedLauncher());
  }
}
