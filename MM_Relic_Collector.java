package org.firstinspires.ftc.teamcode.opmodes12833;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class MM_Relic_Collector {

    private Servo relicArm = null;
    private Servo relicGrabber = null;
    private ElapsedTime runtime = new ElapsedTime();

    private LinearOpMode opMode;

    public MM_Relic_Collector(LinearOpMode opMode) {
        this.opMode = opMode;

        relicGrabber = opMode.hardwareMap.get(Servo.class, "left_grabber");
        relicGrabber = opMode.hardwareMap.get(Servo.class, "right_grabber");
        relicGrabber = opMode.hardwareMap.get(Servo.class, "center_grabber");
        relicArm = opMode.hardwareMap.get(Servo.class, "relic_arm");

        relicArm.setPosition(.5);
        relicGrabber.setPosition(.5);
    }


    public void pause() {
        setGrabberPower(0);
    }

    public void grabRelic (double power) {
        setGrabberPower(power);
    }

    public void releaseRelic(double power) {
        setGrabberPower(-power);
    }

    private void setGrabberPower(double power) {
        relicArm.setPosition(.5);
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