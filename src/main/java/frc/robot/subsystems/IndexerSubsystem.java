// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class IndexerSubsystem extends SubsystemBase {

  TalonFX HigherIndexer;
  TalonFX LowerIndexer;

  public IndexerSubsystem() {
    HigherIndexer = new TalonFX(RobotMap.HigherIndexer);
    LowerIndexer = new TalonFX(RobotMap.LowerIndexer);

    HigherIndexer.configPeakOutputForward(0.1);
    HigherIndexer.configPeakOutputReverse(-0.1);
    LowerIndexer.configPeakOutputForward(0.5);
    LowerIndexer.configPeakOutputReverse(-0.5);
  }

  public void setIndexer1Voltage (double percent) {
    HigherIndexer.set(ControlMode.PercentOutput, percent);
  }

  public void setIndexer2Voltage (double percent) {
    LowerIndexer.set(ControlMode.PercentOutput, percent);
  }

  public void stop() {
    HigherIndexer.set(ControlMode.PercentOutput, 0);
    LowerIndexer.set(ControlMode.PercentOutput, 0);
  }
}
