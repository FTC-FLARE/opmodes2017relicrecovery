package org.firstinspires.ftc.teamcode.opmodes12833;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

public class MM_Relic_Collector {

    private DcMotor arm = null;
    private Servo elbow = null;
    private Servo wrist = null;

    private ElapsedTime runtime = new ElapsedTime();

    private LinearOpMode opMode;

    private double START_POS_ELBOW = 0;
    private double START_POS_WRIST = 0;

    private double currentWristPos;

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

    public void extendArm (double power) {
        setArmPower(power);
    }
    public void retractArm (double power) {
        setArmPower(-power);
    }
    public void setArmPower(double power) {
        arm.setPower(power);
        opMode.telemetry.addData("Arm Power ", power);
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
    public void setElbowPosition(double inPosition){
        elbow.setPosition(inPosition);
        opMode.telemetry.addData("Elbow Position ", inPosition);
    }

}