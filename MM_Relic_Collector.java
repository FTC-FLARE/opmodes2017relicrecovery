package org.firstinspires.ftc.teamcode.opmodes12833;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class MM_Relic_Collector {

//    private CRServo armAsCR = null;
    private Servo grabberLeft = null;
    private Servo grabberRight = null;
    private Servo wrist = null;
    private DcMotor elbow = null;
    private ElapsedTime runtime = new ElapsedTime();

    private LinearOpMode opMode;

    private double currentLeftPosition;
    private double currentRightPosition;
    private double currentWristPos;

    final double START_POSITION_WRIST = .9;
    final double START_POSITION_LEFT = 1;
    final double START_POSITION_RIGHT = 1;
    final double MOVE_POSITION_LEFT = .55;
    final double MOVE_POSITION_RIGHT = .45;
    final double MOVE_POSITION_WRIST = .5;

    public MM_Relic_Collector(LinearOpMode opMode) {
        this.opMode = opMode;

        grabberLeft = opMode.hardwareMap.get(Servo.class, "left_grabber");
        grabberRight = opMode.hardwareMap.get(Servo.class, "right_grabber");
        wrist = opMode.hardwareMap.get(Servo.class, "center_grabber");
//        armAsCR = opMode.hardwareMap.get(CRServo.class, "relic_arm");
        elbow = opMode.hardwareMap.get(DcMotor.class, "elbow");


//        relicXRail.setPosition(START_POSITION_WRIST);
        grabberLeft.setPosition(START_POSITION_LEFT);
        grabberRight.setPosition(START_POSITION_RIGHT);
        wrist.setPosition(START_POSITION_WRIST);

        //Variable
        currentLeftPosition = START_POSITION_LEFT;
        currentRightPosition = START_POSITION_RIGHT;
        currentWristPos = START_POSITION_WRIST;

/*
        elbow.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        elbow.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
*/
        elbow.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }


    public void grabRelic () {
        grabberRight.setPosition(MOVE_POSITION_RIGHT);
        grabberLeft.setPosition(MOVE_POSITION_LEFT);
        currentLeftPosition = MOVE_POSITION_LEFT;
        currentRightPosition = MOVE_POSITION_RIGHT;
    }

    public void releaseRelic() {
        grabberRight.setPosition(START_POSITION_RIGHT);
        grabberLeft.setPosition(START_POSITION_LEFT);
        currentLeftPosition = START_POSITION_LEFT;
        currentRightPosition = START_POSITION_RIGHT;
    }

    public void extendArm (double power) {
        setArmPower(power);
    }
    public void retractArm (double power) {
        setArmPower(-power);
    }
    private void setArmPower(double power) {
//        relicXRail.setPosition(.5);
    }
    public void close () {
        if (currentLeftPosition < .8){
            currentLeftPosition = currentLeftPosition + .01;
            grabberLeft.setPosition(currentLeftPosition);
        }
        if (currentRightPosition > .2) {
            currentRightPosition = currentRightPosition - .01;
            grabberRight.setPosition(currentRightPosition);
        }
    }
    public void open () {
        if (currentLeftPosition > 0){
            currentLeftPosition = currentLeftPosition - .01;
            grabberLeft.setPosition(currentLeftPosition);
        }
        if (currentRightPosition < 1) {
            currentRightPosition = currentRightPosition + .01;
            grabberRight.setPosition(currentRightPosition);
        }
    }
    public void elbow() {
    }
    public void wristDown() {
        if (currentWristPos < 1) {
            currentWristPos = currentWristPos + .01;
            wrist.setPosition(currentWristPos);
            opMode.telemetry.addData("Current Wrist Down", currentWristPos);
        }
    }
    public void wristUp() {
        if (currentWristPos > 0) {
            currentWristPos = currentWristPos - .01;
            wrist.setPosition(currentWristPos);
            opMode.telemetry.addData("Current Wrist Up", currentWristPos);
        }
    }
    public void setElbowPower(double inPower){
        elbow.setPower(inPower);
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