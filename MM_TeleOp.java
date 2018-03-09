package org.firstinspires.ftc.teamcode.opmodes12833;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "MM TeleOp", group = "TeleOp")
//@Disabled
public class MM_TeleOp extends MM_OpMode {

    @Override
    public void runOpMode() {

        waitToBegin();

        while (opModeIsActive()) {
            controlDrivetrain();
            controlGlyphCollector();
            controlLift();
            controlJewelArm();
            controlRelicCollector();

            telemetry.update();
        }
    }

    private void controlDrivetrain() {
        if (gamepad1.b){
            robot.drivetrain.setReverseDriveControl(true);
        }
        else if (gamepad1.a){
            robot.drivetrain.setReverseDriveControl(false);
        }
        robot.drivetrain.driveWithControl();
    }

    private void controlGlyphCollector() {
        if (gamepad2.left_bumper) {
            robot.collector.collect();
        } else if (gamepad2.right_bumper) {
            robot.collector.release();
        } else {
            robot.collector.pause();
            if (gamepad2.x) {
                robot.collector.squareGlyph();
            }
        }
    }

    private void controlLift() {
        if (gamepad2.right_trigger > 0 && !robot.lift.topIsPressed()) {
            telemetry.addData("lift", "You're going up");
            robot.lift.raise();
        } else if (gamepad2.left_trigger > 0 && !robot.lift.bottomIsPressed()) {
            telemetry.addData("lift", "You're going down");
            robot.lift.lower();
        } else {
            telemetry.addData("lift", "You're stopped");
            robot.lift.pause();
        }
    }

    private void controlJewelArm() { // This method is temporary for testing but will be deleted for competition.
        if (gamepad2.y) {
            robot.jewelarm.toggle();
        }
    }

    private void controlRelicCollector() {
        controlGrabber();
        bendWrist();
        moveArm();
    }

    private void controlGrabber() {
        if (gamepad2.a) {
            robot.relic.grabberOpen();
        } else if (gamepad2.b) {
            robot.relic.grabberClose();
        }
        telemetry.addData("Current Wrist", robot.relic.getCurrentGrabberPos());
    }

    private void bendWrist() {
        if (gamepad2.dpad_up)
            robot.relic.raiseWrist();  // to carry relic
        else if (gamepad2.dpad_left)
            robot.relic.midWrist();  // to collect relic
        else if (gamepad2.dpad_down)
            robot.relic.lowerWrist();  // back to start position
    }

    private void moveArm() {
        double currentArmPos = robot.relic.getCurrentArmPos();
        double driverRequestPower = -gamepad2.right_stick_y;
        double movePower = 0;

        if (robot.relic.relicArmRetracted()){
            currentArmPos = 0;
            robot.relic.stopArm();
        }

        if ((driverRequestPower < 0 && !robot.relic.relicArmRetracted()) || (driverRequestPower > 0  && currentArmPos < robot.relic.MAX)) {
            telemetry.addLine("Moving Arm");
            movePower = driverRequestPower;
        }

        if (gamepad2.left_stick_y != 0) {
            movePower = driverRequestPower;
        }

        robot.relic.setArmPower(movePower);

        telemetry.addData("Current Arm Position", currentArmPos);
        telemetry.addData("Y_Stick", gamepad2.right_stick_y);
    }
    private void placeGlyph() {
        if (gamepad1.a) {
            robot.lift.raise();
        } else if (gamepad1.b) {
            robot.lift.lower();
        }
    }

    private void relicAssist() {
        if (gamepad2.dpad_right) {
            robot.relic.midWrist();
            sleep(1000);
            robot.relic.grabberOpen();
            sleep(5000);
            robot.drivetrain.strafeRightInches(5);
            robot.relic.raiseWrist();
            sleep(500);
        }
    }
}