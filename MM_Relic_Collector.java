package org.firstinspires.ftc.teamcode.opmodes12833;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class MM_Relic_Collector {

    private DcMotor arm = null;
    private Servo elbow = null;
    private Servo wrist = null;

    private double currentWristPos;

    private double START_POS_ELBOW = 0;
    private double START_POS_WRIST = 0;
    private double WRIST_ADJUST_AMOUNT = .01;

    private LinearOpMode opMode;

    public MM_Relic_Collector(LinearOpMode opMode) {
        this.opMode = opMode;

        arm = opMode.hardwareMap.get(DcMotor.class, "relic_arm");
        elbow = opMode.hardwareMap.get(Servo.class, "elbow");
        wrist = opMode.hardwareMap.get(Servo.class, "wrist");

        arm.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        elbow.setPosition(START_POS_ELBOW);
        wrist.setPosition(START_POS_WRIST);

        currentWristPos = START_POS_WRIST;
    }

    public void setArmPower(double power) {
        arm.setPower(power);
        opMode.telemetry.addData("Arm Power ", power);
    }
    public void wristDown() {
        if (currentWristPos < 1) {
            currentWristPos += WRIST_ADJUST_AMOUNT;
            wrist.setPosition(currentWristPos);
            opMode.telemetry.addData("Current Wrist Down", currentWristPos);
        }
    }
    public void wristUp() {
        if (currentWristPos > 0) {
            currentWristPos -= WRIST_ADJUST_AMOUNT;
            wrist.setPosition(currentWristPos);
            opMode.telemetry.addData("Current Wrist Up", currentWristPos);
        }
    }
    public void setElbowPosition(double inPosition){
        elbow.setPosition(inPosition);
        opMode.telemetry.addData("Elbow Position ", inPosition);
    }

    public double getCurrentWristPos() {
        return currentWristPos;
    }
}