package org.firstinspires.ftc.teamcode.opmodes12833;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "MM TeleOp", group = "TeleOp")
//@Disabled
public class MM_TeleOp extends MM_OpMode {

    @Override
    public void runOpMode() {

        waitToBegin();

        while (opModeIsActive()) {
            robot.drivetrain.driveWithControl();

            controlGlyphCollector();
            controlLift();
            controlJewelArm();
            controlRelicCollector();

            telemetry.update();
        }
    }

    private void controlRelicCollector() {
        controlWrist();
        bendElbow();
        moveArm();
    }

    private void moveArm() {
        robot.relic.setArmPower(gamepad2.right_stick_x * .25);
    }

    private void bendElbow() {
        if (-gamepad2.left_stick_y < 0)
            robot.relic.setElbowPosition(0);
        else if (-gamepad2.left_stick_y > 0)
            robot.relic.setElbowPosition(.04);
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

    private void controlJewelArm() { // This method is temporary for testing but will be deleted for competition.
        if (gamepad2.dpad_down) {
            robot.jewelarm.lower();
        } else if (gamepad2.dpad_up) {
            robot.jewelarm.raise();
        }
    }

    private void placeGlyph() {
        if (gamepad1.a) {
            robot.lift.raise();
        } else if (gamepad1.b) {
            robot.lift.lower();
        }
    }

    private void controlWrist() {
        if (gamepad2.a) {
            robot.relic.wristDown();
        } else if (gamepad2.b) {
            robot.relic.wristUp();
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
}
