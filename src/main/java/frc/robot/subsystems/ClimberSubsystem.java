// package frc.robot.subsystems;

// import frc.robot.RobotMap;
// import com.ctre.phoenix.motorcontrol.can.TalonFX;
// import com.ctre.phoenix.motorcontrol.NeutralMode;

// //unused imports
// // import com.ctre.phoenix.motion.MotionProfileStatus;
// // import com.ctre.phoenix.motorcontrol.ControlMode;
// // import com.ctre.phoenix.motorcontrol.FeedbackDevice;

// import edu.wpi.first.wpilibj2.command.SubsystemBase;

// public class ClimberSubsystem extends SubsystemBase{
//     TalonFX LeftClimbMotor = new TalonFX(RobotMap.LeftClimbMotor);
//     TalonFX RightClimbMotor = new TalonFX(RobotMap.RightClimbMotor);


// //public void whenPressed(ClimberRelease)    
//     public void ClimberRelease(TalonFX leftClimbMotor, TalonFX rightClimbMotor) {
        
//         LeftClimbMotor.setSelectedSensorPosition(0);
//         RightClimbMotor.setSelectedSensorPosition(0);
//         //RightClimbMotor.set(ControlMode.Follower, RobotMap.LeftClimbMotor);
        
//         //set motors to neutral so spring can expand (coast)
//         LeftClimbMotor.setNeutralMode(NeutralMode.Coast);
//         RightClimbMotor.setNeutralMode(NeutralMode.Coast);

//         boolean Latching = true;

//         while (Latching) {
        
//         //get encoder value
//         double MotorPos = LeftClimbMotor.getSelectedSensorPosition();
        
//         //stop motors once they reach target distance (or set them to hold position)
//             if (MotorPos > 180) {
//                 Latching = false;
//                 LeftClimbMotor.setNeutralMode(NeutralMode.Brake);
//                 RightClimbMotor.setNeutralMode(NeutralMode.Brake);
//             }
//         }
        
        
//     } 


// }
