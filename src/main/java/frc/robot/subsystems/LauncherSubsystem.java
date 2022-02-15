package frc.robot.subsystems;

import frc.robot.RobotMap;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LauncherSubsystem extends SubsystemBase{
    TalonFX Launcher1 = new TalonFX(RobotMap.Launcher1);
    TalonFX Launcher2 = new TalonFX(RobotMap.Launcher2);

    public LauncherSubsystem(double P, double I, double D) {

        // Set the second Talon to follow the first Talon
        Launcher2.set(ControlMode.Follower, RobotMap.Launcher1);

        // Invert the first Talon (Left and Right can now run the same Velocity PID RPM)
        Launcher1.setInverted(true);

        // Config PID - both motors should be the same
        Launcher1.config_kP(0, P);
        Launcher1.config_kI(0, I);
        Launcher1.config_kD(0, D);
        Launcher1.config_kF(0, FF); // do we need FF???

        Launcher2.config_kP(0, P);
        Launcher2.config_kI(0, I);
        Launcher2.config_kD(0, D);
        Launcher2.config_kF(0, FF); // ^^

    } 

    // do we need both velocity and percent??? and the setpoint stuff since we have a set velocity/output
 

    public void setLauncherVelocity (double setpoint) {
        // Set the first Talon's PID target to the setpoing (second Talon will follow)
        Launcher1.set(ControlMode.Velocity, setpoint);
        Launcher2.set(ControlMode.Velocity, setpoint);
        System.out.println("LAUNCHER: " + Launcher1.getSelectedSensorVelocity());
    }


    public void setLauncherPercent (double percent) {
        Launcher1.set(ControlMode.PercentOutput, percent);
        Launcher2.set(ControlMode.PercentOutput, percent);
        System.out.println("LAUNCHER: " + Launcher1.getSelectedSensorVelocity());
    }


}
