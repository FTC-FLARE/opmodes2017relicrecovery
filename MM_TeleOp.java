package org.firstinspires.ftc.teamcode.opmodes12833;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="MM TeleOp", group="TeleOp")
//@Disabled
public class MM_TeleOp extends MM_OpMode {

    private MM_Bot robot = new MM_Bot(this);

    @Override
    public void runOpMode() {

        robot.init();

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        robot.relic.grabRelic();

        while (opModeIsActive()) {
            robot.drivetrain.driveWithControl();
            collectOrReleaseGlyph();
            raiseOrLowerGlyph();
            raiseOrLowerJewelArm();
            closeOrRelease();
            upOrDown();
            bendElbow();
            moveArm();

            telemetry.update();
        }
    }

    private void moveArm() {
        robot.relic.setArmPower_K(gamepad2.right_stick_x * .25);
    }

    private void bendElbow() {
        if (-gamepad2.left_stick_y >.9)
            robot.relic.setElbowPower(1);
        else if (-gamepad2.left_stick_y < -.9)
            robot.relic.setElbowPower(-1);
        else
            robot.relic.setElbowPower(-gamepad2.left_stick_y * .40);
    }

    private void collectOrReleaseGlyph(){
        if (gamepad2.left_bumper) {
            robot.collector.collect(.25);
        }
        else if (gamepad2.right_bumper) {
            robot.collector.release(1); //Positive because in the release method power was set to negative.
        }
        else {
            robot.collector.pauseCollector();
        }
    }

    /*
        private void raiseOrLowerGlyph() {
            if (gamepad2.left_trigger > 0) {
                robot.lift.lowerGlpyhCollector(1);
            }
            else if (gamepad2.right_trigger > 0){
                robot.lift.raiseGlpyhCollector(1);
            }
            else {
                robot.lift.pauseLift();
            }
        }
    */
    private void raiseOrLowerJewelArm() { // This method is temporary for testing but will be deleted for competition.
        if (gamepad2.dpad_down) {
            robot.jewelarm.lowerJewelArm();
        }
        else if (gamepad2.dpad_up) {
            robot.jewelarm.raiseJewelArm();
        }
    }

    private void placeGlyph () {
        if (gamepad1.a) {
            robot.lift.raiseGlpyhCollector(1);
        }
        else if (gamepad1.b) {
            robot.lift.lowerGlpyhCollector(1);
        }
    }
    private void closeOrRelease () {
        if (gamepad2.dpad_left) {
            robot.relic.close();
        }
        else if (gamepad2.dpad_right) {
            robot.relic.open();
        }
    }
    private void upOrDown () {
        if (gamepad2.a) {
            robot.relic.wristDown();
        }
        else if (gamepad2.b) {
            robot.relic.wristUp();
        }
    }

    private void raiseOrLowerGlyph() {
        if (!robot.lift.bottomIsPressed() && gamepad2.right_trigger > 0) {
            telemetry.addData("lift", "You're going down");
            robot.lift.lowerGlpyhCollector(1);
        } else if (!robot.lift.topIsPressed() && gamepad2.left_trigger > 0) {
            telemetry.addData("lift", "You're going up");
            robot.lift.raiseGlpyhCollector(1);
        } else if (robot.lift.topIsPressed()) {
            telemetry.addData("lift", "You're stopped");
            robot.lift.pauseLift();
        } else if (robot.lift.bottomIsPressed()) {
            telemetry.addData("lift", "You're stopped");
            robot.lift.pauseLift();
        } else if (gamepad2.right_trigger == 0) {
            telemetry.addData("lift", "You're stopped");
            robot.lift.pauseLift();
        } else if (gamepad2.right_trigger == 0) {
            telemetry.addData("lift", "You're stopped");
            robot.lift.pauseLift();
        }
    }
}
