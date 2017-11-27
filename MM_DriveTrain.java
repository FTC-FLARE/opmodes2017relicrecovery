package org.firstinspires.ftc.teamcode.opmodes12833;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class MM_DriveTrain {

    public DcMotor frontLeft = null;
    public DcMotor frontRight = null;
    public DcMotor backLeft = null;
    public DcMotor backRight = null;

    private LinearOpMode opMode;

    public double frontLeftPower;
    public double frontRightPower;
    public double backLeftPower;
    public double backRightPower;

    public MM_DriveTrain(LinearOpMode opMode){
        this.opMode = opMode;

        frontLeft  = opMode.hardwareMap.get(DcMotor.class, "flMotor");
        frontRight  = opMode.hardwareMap.get(DcMotor.class, "frMotor");
        backLeft  = opMode.hardwareMap.get(DcMotor.class, "blMotor");
        backRight  = opMode.hardwareMap.get(DcMotor.class, "brMotor");

        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        frontRight.setDirection(DcMotor.Direction.FORWARD);
        backLeft.setDirection(DcMotor.Direction.REVERSE);
        backRight.setDirection(DcMotor.Direction.FORWARD);

        setToRunWithoutEncoders();
    }

    private void setToRunWithoutEncoders() {
        frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void driveWithControl (){
        frontLeftPower = -opMode.gamepad1.left_stick_y + opMode.gamepad1.left_stick_x + opMode.gamepad1.right_stick_x;
        frontRightPower = -opMode.gamepad1.left_stick_y - opMode.gamepad1.left_stick_x - opMode.gamepad1.right_stick_x;
        backLeftPower = -opMode.gamepad1.left_stick_y - opMode.gamepad1.left_stick_x + opMode.gamepad1.right_stick_x;
        backRightPower = -opMode.gamepad1.left_stick_y + opMode.gamepad1.left_stick_x - opMode.gamepad1.right_stick_x;

        setMotorPower(frontLeftPower, frontRightPower, backLeftPower, backRightPower);
    }
    public void setMotorPower(double frontLeftPower, double frontRightPower, double backLeftPower, double backRightPower) {
        frontLeft.setPower(frontLeftPower);
        frontRight.setPower(frontRightPower);
        backLeft.setPower(backLeftPower);
        backRight.setPower(backRightPower);
    }
    public void strafeLeft(){
        setMotorPower(-.25, .25, .25, -.25);

    }
    public void strafeRight(){
        setMotorPower(.25, -.25, -.25, .25);

    }
    public void turnRight(double power){
        setMotorPower(power, -power, power, -power);
    }
    public void turnLeft(double power){
        setMotorPower(-power, power, -power, power);
    }
    public void stopRobot() {
        setMotorPower(0, 0, 0, 0);
    }

}
