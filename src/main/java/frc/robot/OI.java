// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

/*-------------------------------------------------------------------------
Author: Clarrie Wang                                     Date: Jan 22 2022
OI: operator interface - maps commands to controls on Xbox Controller.
CURRENTCODEONBOT
---------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Button;

import frc.robot.commands.*;
import frc.robot.commands.climber.*;
import frc.robot.commands.launcher_commands.*;


import frc.robot.commands.ClimbTestingForward;
import frc.robot.commands.ClimbTestingReverse;

public class OI {
    // Driver, initialized with port 0
    public final XboxController Driver = new XboxController(0);

    // Driver, initialized with port 1
    public final XboxController Operator = new XboxController(1);
  
    // Driver Buttons
    public final JoystickButton DriverAButton = new JoystickButton(Driver, XboxController.Button.kA.value);
    public final JoystickButton DriverBButton = new JoystickButton(Driver, XboxController.Button.kB.value);
    public final JoystickButton DriverXButton = new JoystickButton(Driver, XboxController.Button.kX.value);
    public final JoystickButton DriverYButton = new JoystickButton(Driver, XboxController.Button.kY.value);
    
    // Driver Triggers
    public final JoystickButton DriverLeftBumper = new JoystickButton(Driver, XboxController.Button.kLeftBumper.value);
    public final JoystickButton DriverRightBumper = new JoystickButton(Driver, XboxController.Button.kRightBumper.value);

    // Operator Buttons
    public final JoystickButton OperatorAButton = new JoystickButton(Operator, XboxController.Button.kA.value);
    public final JoystickButton OperatorBButton = new JoystickButton(Operator, XboxController.Button.kB.value);
    public final JoystickButton OperatorXButton = new JoystickButton(Operator, XboxController.Button.kX.value);
    public final JoystickButton OperatorYButton = new JoystickButton(Operator, XboxController.Button.kY.value);
    // Allow using the left trigger as a button
    public final Button OperatorLeftTriggerButton = new Button(() -> {return Operator.getRightTriggerAxis() > 0;});
    
    // Operator Triggers
    public final JoystickButton OperatorLeftBumper = new JoystickButton(Operator, XboxController.Button.kLeftBumper.value);
    public final JoystickButton OperatorRightBumper = new JoystickButton(Operator, XboxController.Button.kRightBumper.value);

    /** Maps and initializes controls to the controllers. */
    public void mapControls() {
        DriverAButton.whenPressed(new ToggleSolenoids());
        DriverBButton.whenPressed(new PullUpClimberCommand());
        //DriverBButton.whileHeld(new ClimbTestingForward());
        //DriverXButton.whileHeld(new ClimbTestingReverse());
        DriverXButton.whenPressed(new ReleaseClimberCommand());
        DriverYButton.whenPressed(new ToggleMirrorSolenoid());

        // Inititalize the Operator Controls
        OperatorAButton.whenHeld(new FeederPercentCommand());
        OperatorBButton.whenHeld(new IntakeCommand());
        OperatorXButton.whenHeld(new FlywheelPercentCommand());
        OperatorYButton.whenHeld(new IndexerCommand());
        
        OperatorLeftTriggerButton.whenHeld(new ToggleSolenoids());
    }

    // method that takes speed to go forwards or backwards from bumpers of controller depending on how hard driver presses
    // This double (decimal number) method returns the difference between the left and right Driver triggers (How much to move forwards/backwards)
    public double getDriverSpeed () {
        double accelerate = Driver.getRightTriggerAxis();
        double brake = Driver.getLeftTriggerAxis();

        if (Math.abs(accelerate - brake) > 0.15) {
            return (accelerate - brake) * 0.5; // maybe use 0.5 here, ONLY if tested
        } else {
            return 0.0;
        }
    }
    
    // This double method returns the x-axis of the Driver top/turn joystick. The value returned would determine how much to turn to the left or right
    public double getDriverTurn () {
        double driverTurn = Driver.getLeftX();

        if (Math.abs(driverTurn) > 0.15) {
            return driverTurn;
        } else {
            return 0.0;
        }
    }

    public double getDriverIntake() {
        double driverIntake = Driver.getRightX();

        if (Math.abs(driverIntake) > 0.15) {
            return driverIntake;
        } else {
            return 0.0;
        }
    }

    public double getOperatorLauncher() {
        double operatorLauncher = Operator.getRightTriggerAxis();

        if (Math.abs(operatorLauncher) > 0.15) {
            return operatorLauncher;
        } else {
            return 0.0;
        }
    }

}
