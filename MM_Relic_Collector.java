package org.firstinspires.ftc.teamcode.opmodes12833;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class MM_Relic_Collector {

//    private CRServo armAsCR = null;
    private Servo relicGrabberLeft = null;
    private Servo relicGrabberRight = null;
    private Servo relicWrist = null;
    private DcMotor relicElbow = null;
    private ElapsedTime runtime = new ElapsedTime();

    private LinearOpMode opMode;

    private double currentLeftPosition;
    private double currentRightPosition;
    private double currentWristPos;

    final double START_POSITION = .9;
    final double START_POSITION_LEFT = 1;
    final double START_POSITION_RIGHT = 1;
    final double MOVE_POSITION_LEFT = .5;
    final double MOVE_POSITION_RIGHT = .5;
    final double MOVE_POSITION = .5;

    public MM_Relic_Collector(LinearOpMode opMode) {
        this.opMode = opMode;

        relicGrabberLeft = opMode.hardwareMap.get(Servo.class, "left_grabber");
        relicGrabberRight = opMode.hardwareMap.get(Servo.class, "right_grabber");
        relicWrist = opMode.hardwareMap.get(Servo.class, "center_grabber");
//        armAsCR = opMode.hardwareMap.get(CRServo.class, "relic_arm");
        relicElbow = opMode.hardwareMap.get(DcMotor.class, "elbow");


//        relicXRail.setPosition(START_POSITION);
        relicGrabberLeft.setPosition(START_POSITION_LEFT);
        relicGrabberRight.setPosition(START_POSITION_RIGHT);
        relicWrist.setPosition(START_POSITION);

        //Variable
        currentLeftPosition = START_POSITION_LEFT;
        currentRightPosition = START_POSITION_RIGHT;
        currentWristPos = START_POSITION;

/*
        relicElbow.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        relicElbow.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
*/
        relicElbow.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
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
//        relicXRail.setPosition(.5);
    }
    public void close () {
        if (currentLeftPosition < 1){
            currentLeftPosition = currentLeftPosition + .01;
            relicGrabberLeft.setPosition(currentLeftPosition);
        }
        if (currentRightPosition > 0) {
            currentRightPosition = currentRightPosition - .01;
            relicGrabberRight.setPosition(currentRightPosition);
        }
    }
    public void open () {
        if (currentLeftPosition > 0){
            currentLeftPosition = currentLeftPosition - .01;
            relicGrabberLeft.setPosition(currentLeftPosition);
        }
        if (currentRightPosition < 1) {
            currentRightPosition = currentRightPosition + .01;
            relicGrabberRight.setPosition(currentRightPosition);
        }
    }
    public void elbow() {
    }
    public void wristDown() {
        if (currentWristPos < 1) {
            currentWristPos = currentWristPos + .01;
            relicWrist.setPosition(currentWristPos);
            opMode.telemetry.addData("Current Wrist Down", currentWristPos);
        }
    }
    public void wristUp() {
        if (currentWristPos > 0) {
            currentWristPos = currentWristPos - .01;
            relicWrist.setPosition(currentWristPos);
            opMode.telemetry.addData("Current Wrist Up", currentWristPos);
        }
    }
    public void setElbowPower(double inPower){
        relicElbow.setPower(inPower);
        opMode.telemetry.addData("Elbow Power ", inPower);
    }

    public void setArmPower_K(double inPower) {
        if(inPower < 0){
//            armAsCR.setDirection(DcMotor.Direction.REVERSE);
        }
//        armAsCR.setPower(inPower);
        opMode.telemetry.addData("Arm Power ", inPower);
    }

}