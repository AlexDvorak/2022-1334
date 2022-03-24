// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.*;
import frc.robot.commands.climber.*;
import frc.robot.commands.launcher_commands.*;

public class OI {

    public static final Controller Driver = new Controller(0);
    public static final Controller Operator = new Controller(1);

    /** Maps and initializes controls to the controllers. */
    public static void mapControls() {
        // Driver Controls
        Driver.ButtonA.whenPressed(new ToggleIntakePosition());
        Driver.ButtonB.whenPressed(new PullUpClimberCommand());
        // Driver.ButtonB.whileHeld(new ClimbTestingForward());
        // Driver.ButtonX.whileHeld(new ClimbTestingReverse());
        Driver.ButtonY.whenPressed(new ReleaseClimberCommand());
        Driver.ButtonY.whenPressed(new ToggleMirrorSolenoid());

        // Operator Controls
        Operator.ButtonA.whenHeld(new RunFeeder());
        Operator.ButtonB.whenHeld(new RunIntake());
        Operator.ButtonX.whenHeld(new RunFlywheelPercent(1.0));
        Operator.ButtonY.whenHeld(new RunIndexer());

        Operator.LeftTrigger.whenPressed(new ToggleIntakePosition());
    }

    /**
     * Method that takes speed to go forwards or backwards from triggers
     * of controller depending on how hard driver presses.
     * @return How much to move forwards/backwards
     */
    public static double getDriverSpeed () {
        double accelerate = Driver.getRightTrigger();
        double brake = Driver.getLeftTrigger();

        if (Math.abs(accelerate - brake) > 0.15) {
            return (accelerate - brake) * 0.5; // maybe use 0.5 here, ONLY if tested
        } else {
            return 0.0;
        }
    }

    /**
     * @return How much to turn to the left or right
     */
    public static double getDriverTurn () {
        double driverTurn = Driver.getLeftStickX();

        if (Math.abs(driverTurn) > 0.15) {
            return driverTurn;
        } else {
            return 0.0;
        }
    }

    public static double getDriverIntake() {
        double driverIntake = Driver.getRightStickX();

        if (Math.abs(driverIntake) > 0.15) {
            return driverIntake;
        } else {
            return 0.0;
        }
    }

    public static double getOperatorLauncher() {
        double operatorLauncher = Operator.getRightTrigger();

        if (Math.abs(operatorLauncher) > 0.15) {
            return operatorLauncher;
        } else {
            return 0.0;
        }
    }

}
