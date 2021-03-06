// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class FeederSubsystem extends SubsystemBase{

    private final TalonSRX LauncherSmallWheel;

    public FeederSubsystem() {
        LauncherSmallWheel = new TalonSRX(RobotMap.LauncherSmallWheel);
    }

    public void runPercent(double percent) {
        LauncherSmallWheel.set(ControlMode.PercentOutput, percent);
    }

    public void stop() {
        LauncherSmallWheel.set(ControlMode.PercentOutput, 0);
    }

}