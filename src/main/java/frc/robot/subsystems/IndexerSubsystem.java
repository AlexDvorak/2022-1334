// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

/*

Created by: William Kozlowski

Created 2022-02-10

Modified 2022-03-03, by William Kozlowski

Indexer Subsystem, helps to sort/push the ball to fit into the conveyer, and preps the ball to be shot

*/

//imported https://maven.ctr-electronics.com/release/com/ctre/phoenix/Phoenix-frc2022-latest.json

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX; //changed to FX since motors are Falcons now - Zoey

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;



public class IndexerSubsystem extends SubsystemBase {
  /** Creates a new IndexerSubsystem. */

  //replace TalonFX with whatever motor controller we're using
  //we're using FX for now

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
    //varible ControlMode is pulled from the "com.ctre.phoenix.motorcontrol.ControlMode" import
    HigherIndexer.set(ControlMode.PercentOutput, percent);
  }
  
  public void setIndexer2Voltage (double percent) {
    LowerIndexer.set(ControlMode.PercentOutput, percent);
  }
}
