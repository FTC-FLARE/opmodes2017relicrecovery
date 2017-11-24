package org.firstinspires.ftc.teamcode.opmodes12833;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class MM_Jewel_Scorer {

    private Servo jewelArm = null;
    private ColorSensor colorSensor = null;
    private ElapsedTime runtime = new ElapsedTime();

    private LinearOpMode opMode;

    final static int RED = 1;
    final static int BLUE = 2;
    final static int NOTHING = 0;

    final double START_POSITION = 0;

    final double MOVE_POSITION = 0.5;

    public MM_Jewel_Scorer(LinearOpMode opMode) { //Constructor
        this.opMode = opMode;

        jewelArm = opMode.hardwareMap.servo.get("jewel_arm");
        jewelArm.setPosition(START_POSITION);

        colorSensor = opMode.hardwareMap.colorSensor.get("sensor_color_distance");
        colorSensor.enableLed(true);
    }
    public int getLeftJewelColor () {
        int jewelColor = NOTHING;
        if (colorSensor.red() > colorSensor.blue()){
            jewelColor = RED;
        }
        else if (colorSensor.blue() > colorSensor.red()){
            jewelColor = BLUE;
        }
        opMode.telemetry.addData("Jewel Color", jewelColor);
        return jewelColor;
    }

    public void raiseJewelArm() {
        jewelArm.setPosition(START_POSITION);
    }
    public void lowerJewelArm () {
        jewelArm.setPosition(MOVE_POSITION);
    }

}

