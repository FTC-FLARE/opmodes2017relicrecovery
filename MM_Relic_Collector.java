package org.firstinspires.ftc.teamcode.opmodes12833;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class MM_Relic_Collector {

    private Servo relicArm = null;
    private Servo relicGrabberLeft = null;
    private Servo relicGrabberRight = null;
    private Servo relicPosition = null;
    private ElapsedTime runtime = new ElapsedTime();

    private LinearOpMode opMode;

    final double START_POSITION = 0;
    final double START_POSITION_LEFT = 0;
    final double START_POSITION_RIGHT = 1;
    final double MOVE_POSITION_LEFT = .5;
    final double MOVE_POSITION_RIGHT = .5;

    public MM_Relic_Collector(LinearOpMode opMode) {
        this.opMode = opMode;

        relicGrabberLeft = opMode.hardwareMap.get(Servo.class, "left_grabber");
        relicGrabberRight = opMode.hardwareMap.get(Servo.class, "right_grabber");
        relicPosition = opMode.hardwareMap.get(Servo.class, "center_grabber");
        relicArm = opMode.hardwareMap.get(Servo.class, "relic_arm");

        relicArm.setPosition(START_POSITION);
        relicGrabberLeft.setPosition(START_POSITION_LEFT);
        relicGrabberRight.setPosition(START_POSITION_RIGHT);
        relicPosition.setPosition(START_POSITION);
    }


    public void grabRelic () {
        relicGrabberRight.setPosition(MOVE_POSITION_RIGHT);
        relicGrabberLeft.setPosition(MOVE_POSITION_LEFT);
    }

    public void releaseRelic() {
        relicGrabberRight.setPosition(START_POSITION_RIGHT);
        relicGrabberLeft.setPosition(START_POSITION_LEFT);
    }

    public void extendRelicArm (double power) {
        setArmPower(power);
    }
    public void retractRelicArm (double power) {
        setArmPower(-power);
    }
    private void setArmPower(double power) {
        relicArm.setPosition(.5);
    }
}