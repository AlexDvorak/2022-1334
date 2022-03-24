// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.util.Color;
import frc.robot.Robot;

import com.revrobotics.ColorSensorV3;
import com.revrobotics.ColorMatchResult;
import com.revrobotics.ColorMatch;

public class ColorSensor {

    private final int minimumDistance = 800; // TODO find a good value
    private final double minColorConfidence = 0.90; // TODO make sure this a correct value

    // Tune these at each field if you want to know the color of the balls
    private final Color Red = new Color(0.18, 0.41, 0.43);
    private final Color Blue = new Color(0.45, 0.39, 0.16);

    private final ColorSensorV3 sensor;
    private final ColorMatch colorMatch = new ColorMatch();

    public ColorSensor(I2C.Port port) {
        sensor = new ColorSensorV3(port);

        colorMatch.addColorMatch(Red);
        colorMatch.addColorMatch(Blue);
        colorMatch.setConfidenceThreshold(minColorConfidence);
    }

    public boolean ballPresent() {
        return sensor.getProximity() > minimumDistance;
    }

    public boolean isBallOurs() {
        return getDetectedBall() == Robot.ourAlliance;
    }

    private Alliance getDetectedBall() {
        Color detectedColor = sensor.getColor();
        ColorMatchResult match = colorMatch.matchColor(detectedColor);

        if (match != null) {
            if (match.color == Red) return Alliance.Red;
            if (match.color == Blue) return Alliance.Blue;
        }

        return Alliance.Invalid;
    }
}