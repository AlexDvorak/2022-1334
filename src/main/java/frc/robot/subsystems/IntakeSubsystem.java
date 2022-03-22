// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class IntakeSubsystem extends SubsystemBase {

    TalonSRX intakeMotor;

    DoubleSolenoid IntakeSol;

    public IntakeSubsystem() {
        intakeMotor = new TalonSRX(RobotMap.intakeMotor);
        IntakeSol = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 3);

        // Start with Intake up
        IntakeSol.set(Value.kReverse);
    }

    // This method makes the motor spin based on a percentage based voltage input
    public void runMotorPercent(double output) {
        intakeMotor.set(ControlMode.PercentOutput, output);
    }

    public void stopMotor() {
        runMotorPercent(0);
    }

    // toggles the solenoid to get intake up and down
    public void togglePosition() {
        IntakeSol.toggle();
    }

}