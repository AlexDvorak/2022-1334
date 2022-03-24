// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.InstantCommand;

import frc.robot.commands.auto.*;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

public class Robot extends TimedRobot {

  // Initializing subsystems:
  public static DriveSubsystem DriveSubsystem = new DriveSubsystem();
  public static IndexerSubsystem IndexerSubsystem = new IndexerSubsystem();
  public static IntakeSubsystem IntakeSubsystem = new IntakeSubsystem();
  public static LauncherSubsystem FlywheelSubsystem = new LauncherSubsystem();
  public static FeederSubsystem FeederSubsystem = new FeederSubsystem();
  public static SparkMaxClimberSubsystem ClimberSubsystem = new SparkMaxClimberSubsystem();

  // Color Sensor (unused)
  public static ColorSensor ColorSensor = new ColorSensor(I2C.Port.kOnboard);
  public static Alliance ourAlliance;

  // Autonomous chooser
  private final SendableChooser<Command> autonChooser = new SendableChooser<>();
  private Command autonomousCommand;

  /* This function is run once when the robot is first started up. */
  @Override
  public void robotInit() {
    OI.mapControls();

    // Add autonomous options to autonomous chooser
    autonChooser.setDefaultOption("Default Auto", new AutoSequence());
    autonChooser.addOption("Do Nothing", new InstantCommand());

    // Add autonomous chooser to SmartDashboard
    SmartDashboard.putData("Auto choices", autonChooser);
  }

  /* This function is run once at the start of autonomous */
  @Override
  public void autonomousInit() {
    autonomousCommand = autonChooser.getSelected();

    if (autonomousCommand != null) {
      autonomousCommand.schedule();
      System.out.println("Auto selected: " + autonomousCommand.getName());
    }

    ourAlliance = DriverStation.getAlliance();
  }

  /* This function is run once at the start of teleop */
  @Override
  public void teleopInit() {
    // set DriveCommand as the command to run when the DriveSubsystem isn't being used by another command
    DriveSubsystem.setDefaultCommand(new DriveCommand());

    ourAlliance = DriverStation.getAlliance();
  }

  @Override
  public void disabledInit() {}

  @Override
  public void testInit() {}

  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

}
