package org.firstinspires.ftc.teamcode.opmodes12833;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class MM_Jewel_Scorer {

    private Servo jewelArm = null;
    private ColorSensor colorSensor = null;
    private ElapsedTime runtime = new ElapsedTime();

    private MM_OpMode opMode;

    final double START_POSITION = 0;

    final double MOVE_POSITION_PART1 = 0.5;
    final double MOVE_POSITION_PART2 = 0.6;

    public MM_Jewel_Scorer(MM_OpMode opMode) { //Constructor
        this.opMode = opMode;

        jewelArm = opMode.hardwareMap.servo.get("jewel_arm");
        jewelArm.setPosition(START_POSITION);

        colorSensor = opMode.hardwareMap.colorSensor.get("sensor_color_distance");
        colorSensor.enableLed(true);
    }
    public int getLeftColor() {
        int jewelColor = opMode.NOTHING;
        if (colorSensor.red() > colorSensor.blue()){
            jewelColor = opMode.RED;
        }
        else if (colorSensor.blue() > colorSensor.red()){
            jewelColor = opMode.BLUE;
        }
        opMode.telemetry.addData("Jewel Color", jewelColor);
        opMode.telemetry.update();
        return jewelColor;
    }

    public void raise() {
        jewelArm.setPosition(START_POSITION);
        opMode.sleep(2000);
        }
    public void lower() {
        jewelArm.setPosition(MOVE_POSITION_PART1);
        opMode.sleep(1000);
        jewelArm.setPosition(MOVE_POSITION_PART2);
        opMode.sleep(300);
        }
    }

