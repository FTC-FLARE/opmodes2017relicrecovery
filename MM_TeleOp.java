package org.firstinspires.ftc.teamcode.opmodes12833;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "MM TeleOp", group = "TeleOp")
//@Disabled
public class MM_TeleOp extends MM_OpMode {

    private MM_Bot robot = new MM_Bot(this);

    @Override
    public void runOpMode() {

        waitToBegin();

        robot.relic.grabRelic(); // set grabber to begin

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
        grabOrReleaseRelic();
        controlWrist();
        bendElbow();
        // moveArm();
    }

    private void moveArm() {
        robot.relic.setArmPower_K(gamepad2.right_stick_x * .25);
    }

    private void bendElbow() {
        if (-gamepad2.left_stick_y > .9)
            robot.relic.setElbowPower(1);
        else if (-gamepad2.left_stick_y < -.9)
            robot.relic.setElbowPower(-1);
        else
            robot.relic.setElbowPower(-gamepad2.left_stick_y * .40);
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

    /*
        private void controlLift() {
            if (gamepad2.left_trigger > 0) {
                robot.lift.lower(1);
            }
            else if (gamepad2.right_trigger > 0){
                robot.lift.raise(1);
            }
            else {
                robot.lift.pause();
            }
        }
    */
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

    private void grabOrReleaseRelic() {
        if (gamepad2.dpad_left) {
            robot.relic.close();
        } else if (gamepad2.dpad_right) {
            robot.relic.open();
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
        if (!robot.lift.bottomIsPressed() && gamepad2.right_trigger > 0) {
            telemetry.addData("lift", "You're going down");
            robot.lift.lower();
        } else if (!robot.lift.topIsPressed() && gamepad2.left_trigger > 0) {
            telemetry.addData("lift", "You're going up");
            robot.lift.raise();
        } else if (robot.lift.topIsPressed()) {
            telemetry.addData("lift", "You're stopped");
            robot.lift.pause();
        } else if (robot.lift.bottomIsPressed()) {
            telemetry.addData("lift", "You're stopped");
            robot.lift.pause();
        } else if (gamepad2.right_trigger == 0) {
            telemetry.addData("lift", "You're stopped");
            robot.lift.pause();
        } else if (gamepad2.right_trigger == 0) {
            telemetry.addData("lift", "You're stopped");
            robot.lift.pause();
        }
    }
}
