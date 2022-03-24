// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.*;
import frc.robot.commands.climber.*;
import frc.robot.commands.launcher.*;
// import frc.robot.commands.testing.*;

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
        Operator.ButtonA.whenHeld(new FeedLauncher());
        Operator.ButtonB.whenHeld(new RunIntake());
        Operator.ButtonX.whenHeld(new RunFlywheelPercent(1.0));
        Operator.ButtonY.whenHeld(new RunIndexer());

        Operator.LeftTrigger.whenPressed(new ToggleIntakePosition());
    }

    public static double getDriverSpeed () {
        double accelerate = Driver.getRightTrigger();
        double brake = Driver.getLeftTrigger();
        return threshold(accelerate - brake, 0.15) * 0.5; // maybe use 0.5 here, ONLY if tested
    }

    public static double getDriverTurn () {
        double driverTurn = Driver.getLeftStickX();
        return threshold(driverTurn, 0.15);
    }

    public static double getDriverIntake() {
        double driverIntake = Driver.getRightStickX();
        return threshold(driverIntake, 0.15);
    }

    public static double getOperatorLauncher() {
        double operatorLauncher = Operator.getRightTrigger();
        return threshold(operatorLauncher, 0.15);
    }

    /** Returns 0 if the absolute value of the input is less than the threshold, otherwise returns the input */
    private static double threshold(double input, double thresh) {
      return Math.abs(input) > thresh ? input : 0;
    }

}
