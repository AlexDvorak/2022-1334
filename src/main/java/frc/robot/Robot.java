// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.*;
import frc.robot.commands.auto.*;
import frc.robot.commands.*;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  // Autonomous chooser
  private final SendableChooser<Command> autonChooser = new SendableChooser<>();
  private Command autonomousCommand;

  // Initializing subsystems:
  public static DriveSubsystem DriveSubsystem = new DriveSubsystem();
  public static IndexerSubsystem IndexerSubsystem = new IndexerSubsystem();
  public static IntakeSubsystem IntakeSubsystem = new IntakeSubsystem();
  public static LauncherSubsystem FlywheelSubsystem = new LauncherSubsystem();
  public static FeederSubsystem FeederSubsystem = new FeederSubsystem();
  public static SparkMaxClimberSubsystem ClimberSubsystem = new SparkMaxClimberSubsystem();

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    OI.mapControls();

    // Add autonomous options to autonomous chooser
    autonChooser.setDefaultOption("Default Auto", new AutoSequence());
    // autonChooser.addOption("Example Auto", new ExampleAuto());

    // Add autonomous chooser to SmartDashboard
    SmartDashboard.putData("Auto choices", autonChooser);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  @Override
  public void autonomousInit() {
    autonomousCommand = autonChooser.getSelected();
    if (autonomousCommand != null) {
      autonomousCommand.schedule();
      System.out.println("Auto selected: " + autonomousCommand.getName());
    }
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {
    // set DriveCommand as the command to run when the DriveSubsystem isn't being used by another command
    DriveSubsystem.setDefaultCommand(new DriveCommand());
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called once when test mode is enabled. */
  @Override
  public void testInit() {}

}
