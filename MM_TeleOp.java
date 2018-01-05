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
/*
        if (gamepad2.y) {
            robot.jewelarm.lower();
        } else if (gamepad2.y) { //    ******* fix this to toggle *******
            robot.jewelarm.raise();
        }
*/
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
        robot.relic.setArmPower(gamepad2.right_stick_y * -.15);
    }

    private void placeGlyph() {
        if (gamepad1.a) {
            robot.lift.raise();
        } else if (gamepad1.b) {
            robot.lift.lower();
        }
    }
}
