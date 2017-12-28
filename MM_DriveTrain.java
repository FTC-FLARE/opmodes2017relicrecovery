package org.firstinspires.ftc.teamcode.opmodes12833;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class MM_DriveTrain {

    private DcMotor frontLeft = null;
    private DcMotor frontRight = null;
    private DcMotor backLeft = null;
    private DcMotor backRight = null;

    public ModernRoboticsI2cRangeSensor rangeSensor;

    private LinearOpMode opMode;
    private ElapsedTime runtime = new ElapsedTime();

    public double frontLeftPower;
    public double frontRightPower;
    public double backLeftPower;
    public double backRightPower;

    //degrees calculations for testbot
    final static double MOTOR_RPM = 160; //ANDYMARK 40 TO 1
    final static double WHEEL_DIAM = 4;
    final static double OUTPUT_RPS = MOTOR_RPM / 60;
    final static double DRIVE_POWER = .18;
    final static double DRIVE_RPS = MOTOR_RPM / 60;
    final static double DRIVE_INCHES_PER_SEC = DRIVE_RPS * WHEEL_DIAM * Math.PI;
    final static double TURN_POWER = .8;
    final static double WHEEL_BASE = 15.5;
    final static double TURN_RPS = TURN_POWER * OUTPUT_RPS;
    final static double TURN_DEGRESS_PER_SEC = TURN_RPS * WHEEL_DIAM * 360 / WHEEL_BASE;

    final static double MIN_TO_MOVE = .15;
    final static double RANGE_TOLERANCE = .5;

    public enum directionToDrive {
        FWRD,
        BACK,
        LEFT,
        RIGHT,
        STOP
    }

    public MM_DriveTrain(LinearOpMode opMode){
        this.opMode = opMode;

        frontLeft  = opMode.hardwareMap.get(DcMotor.class, "flMotor");
        frontRight  = opMode.hardwareMap.get(DcMotor.class, "frMotor");
        backLeft  = opMode.hardwareMap.get(DcMotor.class, "blMotor");
        backRight  = opMode.hardwareMap.get(DcMotor.class, "brMotor");

        rangeSensor = opMode.hardwareMap.get(ModernRoboticsI2cRangeSensor.class, "range");

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
        double drive = -opMode.gamepad1.left_stick_y;
        double strafe = opMode.gamepad1.left_stick_x;
        double rotate = opMode.gamepad1.right_stick_x;

        frontLeftPower = Math.pow(drive + strafe + rotate, 3);
        frontRightPower = Math.pow(drive - strafe - rotate, 3);
        backLeftPower = Math.pow(drive - strafe + rotate, 3);
        backRightPower = Math.pow(drive + strafe - rotate, 3);

        addMinimumPower();   // make sure there is enough power to move the robot
        normalize();   // get all drive powers within -1 to 1 range

        setMotorPower(frontLeftPower, frontRightPower, backLeftPower, backRightPower);   // start moving
    }
    public void driveToRange(double target, directionToDrive direction){
        boolean reachedTarget = false;
        while (!reachedTarget & opMode.opModeIsActive()){
            double current = rangeSensor.getDistance(DistanceUnit.INCH);
            opMode.telemetry.addData("Driving", direction);
            opMode.telemetry.addData("Range - Target", target);
            opMode.telemetry.addData("      - Current", current);

            if (Math.abs(current - target) <= RANGE_TOLERANCE) {
                reachedTarget = true;
                stopRobot();
            }else {
                stopRobot();

                if (current > target) {
                    opMode.telemetry.addData("Move", direction);
                    driveDirection(direction);
                } else {
                    opMode.telemetry.addData("Switch to", oppositeDirection(direction));
                    driveDirection(oppositeDirection(direction));
                }
            }

           opMode.telemetry.update();
        }
    }

    private void driveDirection(directionToDrive direction){
        switch (direction){
            case FWRD: driveForward();
            break;
            case BACK: driveBackward();
            break;
            case LEFT: strafeLeft();
            break;
            case RIGHT: strafeRight();
            break;
            default: stopRobot();
        }
    }

    private directionToDrive oppositeDirection(directionToDrive direction){
        opMode.telemetry.addData("Was", direction);

        switch (direction){
            case FWRD:
                opMode.telemetry.addData("Now", directionToDrive.BACK);
                return directionToDrive.BACK;
            case BACK:
                opMode.telemetry.addData("Now", directionToDrive.FWRD);
                return directionToDrive.FWRD;
            case LEFT:
                opMode.telemetry.addData("Now", directionToDrive.RIGHT);
                return directionToDrive.RIGHT;
            case RIGHT:
                opMode.telemetry.addData("Now", directionToDrive.LEFT);
                return directionToDrive.LEFT;
            default: return directionToDrive.STOP;
        }
    }

    public void setMotorPower(double frontLeftPower, double frontRightPower, double backLeftPower, double backRightPower) {
        frontLeft.setPower(frontLeftPower);
        frontRight.setPower(frontRightPower);
        backLeft.setPower(backLeftPower);
        backRight.setPower(backRightPower);
    }
    public void driveForward(){
        setMotorPower(DRIVE_POWER, DRIVE_POWER, DRIVE_POWER, DRIVE_POWER);
    }
    public void driveBackward(){
        setMotorPower(-DRIVE_POWER, -DRIVE_POWER, -DRIVE_POWER, -DRIVE_POWER);
    }
    public void strafeLeft(){
        setMotorPower(-DRIVE_POWER, DRIVE_POWER, DRIVE_POWER, -DRIVE_POWER);
    }
    public void strafeRight(){
        setMotorPower(DRIVE_POWER, -DRIVE_POWER, -DRIVE_POWER, DRIVE_POWER);
    }
    public void stopRobot() {
        setMotorPower(0, 0, 0, 0);
    }
    public void driveForwardTime(double sec, double power) {

        frontLeft.setPower(power);
        frontRight.setPower(power);
        backLeft.setPower(power);
        backRight.setPower(power);

        runtime.reset();
        while (opMode.opModeIsActive() && (runtime.seconds() < sec)) {
            opMode.telemetry.addData("drive time", "forward: %2.2f S Elapsed", runtime.seconds());
            opMode.telemetry.update();
        }
        stopRobot();
    }

    public void brakeOn() {
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void driveBackwardTime(double sec, double power) {
        frontLeft.setPower(-power);
        frontRight.setPower(-power);
        backLeft.setPower(-power);
        backRight.setPower(-power);

        runtime.reset();
        while (opMode.opModeIsActive() && (runtime.seconds() < sec)) {
            opMode.telemetry.addData("drive time", "backward: %2.2f S Elapsed", runtime.seconds());
            opMode.telemetry.update();
        }
        stopRobot();
    }
    public void turnRightTime(double sec, double power) {
        frontLeft.setPower(power);
        frontRight.setPower(-power);
        backLeft.setPower(power);
        backRight.setPower(-power);

        runtime.reset();
        while (opMode.opModeIsActive() && (runtime.seconds() < sec)) {
            opMode.telemetry.addData("drive time", "turn right %2.2f S Elapsed", runtime.seconds());
            opMode.telemetry.update();
        }
        stopRobot();
    }
    public void turnLeftTime(double sec, double power) {
        frontLeft.setPower(-power);
        frontRight.setPower(power);
        backLeft.setPower(-power);
        backRight.setPower(power);

        runtime.reset();
        while (opMode.opModeIsActive() && (runtime.seconds() < sec)) {
            opMode.telemetry.addData("drive time", "turn right %2.2f S Elapsed", runtime.seconds());
            opMode.telemetry.update();
        }
        stopRobot();
    }
    public void turnRightDegree(double degrees) {
        double secondsToPointTurn = degrees / TURN_DEGRESS_PER_SEC;
        turnRightTime(secondsToPointTurn, TURN_POWER);
    }
    public void turnLeftDegree(double degrees) {
        double secondsToPointTurn = degrees / TURN_DEGRESS_PER_SEC;
        turnLeftTime(secondsToPointTurn, TURN_POWER);
    }
    public void driveForwardInches (double inches) {
        double secondsToDrive = inches / DRIVE_INCHES_PER_SEC;
        driveForwardTime(secondsToDrive, DRIVE_POWER);
    }
    public void driveBackwardInches (double inches) {
        double secondsToDrive = inches / DRIVE_INCHES_PER_SEC;
        driveBackwardTime(secondsToDrive, DRIVE_POWER);
    }
    public void strafeRightTime(double sec, double power) {
        frontLeft.setPower(power);
        frontRight.setPower(-power);
        backLeft.setPower(-power);
        backRight.setPower(power);

        runtime.reset();
        while (opMode.opModeIsActive() && (runtime.seconds() < sec)) {
            opMode.telemetry.addData("drive time", "strafe right %2.2f S Elapsed", runtime.seconds());
            opMode.telemetry.update();
        }
        stopRobot();
    }
    public void strafeLeftTime(double sec, double power) {
        frontLeft.setPower(-power);
        frontRight.setPower(power);
        backLeft.setPower(power);
        backRight.setPower(-power);

        runtime.reset();
        while (opMode.opModeIsActive() && (runtime.seconds() < sec)) {
            opMode.telemetry.addData("drive time", "strafe right %2.2f S Elapsed", runtime.seconds());
            opMode.telemetry.update();
        }
        stopRobot();
    }
    public void strafeRightInches(double inches) {
        double secondsToDrive = inches / DRIVE_INCHES_PER_SEC;
        strafeRightTime(secondsToDrive, DRIVE_POWER);
    }
    public void strafeLeftInches(double inches) {
        double secondsToDrive = inches / DRIVE_INCHES_PER_SEC;
        strafeLeftTime(secondsToDrive, DRIVE_POWER);
    }
    private void normalize() {
        double maxPower = Math.max(Math.abs(frontLeftPower), Math.abs(frontRightPower));
        maxPower = Math.max(maxPower, Math.abs(backLeftPower));
        maxPower = Math.max(maxPower, Math.abs(backRightPower));

        if (maxPower > 1.0){
            frontLeftPower /= maxPower;
            frontRightPower /= maxPower;
            backLeftPower /= maxPower;
            backRightPower /= maxPower;
        }
    }
    private void addMinimumPower() {
        if (frontLeftPower > 0) frontLeftPower += MIN_TO_MOVE;
        else if (frontLeftPower < 0) frontLeftPower -= MIN_TO_MOVE;

        if (frontRightPower > 0) frontRightPower += MIN_TO_MOVE;
        else if (frontRightPower < 0) frontRightPower -= MIN_TO_MOVE;

        if (backLeftPower > 0) backLeftPower += MIN_TO_MOVE;
        else if (backLeftPower < 0) backLeftPower -= MIN_TO_MOVE;

        if (backRightPower > 0) backRightPower += MIN_TO_MOVE;
        else if (backRightPower < 0) backRightPower -= MIN_TO_MOVE;
    }
}
