package org.firstinspires.ftc.teamcode.opmodes12833;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.Servo;

public class MM_Relic_Collector {

    private DcMotor arm = null;
    private Servo wrist = null;
    private Servo grabber = null;
    private DigitalChannel touchRelicArm = null;

    private double currentGrabberPos;

    private double WRIST_START_POSITION = 0.22;
    private double WRIST_MID_POSITION = .195;
    private double WRIST_LIFT_POSITION = .13;

    private double GRABBER_START_POS = .8;
    private double GRABBER_ADJUST_AMOUNT = .01;
    public double MAX = 7550;

    private LinearOpMode opMode;

    public MM_Relic_Collector(LinearOpMode opMode) {
        this.opMode = opMode;

        arm = opMode.hardwareMap.get(DcMotor.class, "relic_arm");
        wrist = opMode.hardwareMap.get(Servo.class, "wrist");
        grabber = opMode.hardwareMap.get(Servo.class, "grabber");
        touchRelicArm = opMode.hardwareMap.get(DigitalChannel.class, "touch_relic_arm");

        arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        arm.setDirection(DcMotorSimple.Direction.FORWARD);
        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        wrist.setPosition(WRIST_START_POSITION);
        grabber.setPosition(GRABBER_START_POS);

        currentGrabberPos = GRABBER_START_POS;
    }

    public void setArmPower(double power) {
        arm.setPower(power);
        opMode.telemetry.addData("Arm Power ", power);
    }
    public void grabberOpen() {
        if (currentGrabberPos < 1) {
            currentGrabberPos += GRABBER_ADJUST_AMOUNT;
            grabber.setPosition(currentGrabberPos);
        }
    }
    public void grabberClose() {
        if (currentGrabberPos > 0) {
            currentGrabberPos -= GRABBER_ADJUST_AMOUNT;
            grabber.setPosition(currentGrabberPos);
        }
    }
    public void raiseWrist() {
        setWristPosition(WRIST_LIFT_POSITION);
    }
    public void midWrist() {
        setWristPosition(WRIST_MID_POSITION);
    }
    public void lowerWrist() {
        setWristPosition(WRIST_START_POSITION);
    }
    public void setWristPosition(double inPosition) {
        wrist.setPosition(inPosition);
        opMode.telemetry.addData("Wrist Position ", inPosition);
    }
    public double getCurrentGrabberPos() {
        return currentGrabberPos;
    }
    public double getCurrentArmPos() {
        return arm.getCurrentPosition();
    }
    public boolean relicArmRetracted() {
        if (touchRelicArm.getState() == true) {
            return false;
        }
        return true;
    }
    public void stopArm() {
        setArmPower(0);
    }
}