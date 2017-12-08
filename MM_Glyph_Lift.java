package org.firstinspires.ftc.teamcode.opmodes12833;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

public class MM_Glyph_Lift {

    private DcMotor lift = null;
    private DigitalChannel touchTop = null;
    private DigitalChannel touchBottom = null;
    private ElapsedTime runtime = new ElapsedTime();

    private final static double LIFT_POWER = 1;

    private LinearOpMode opMode;

    public MM_Glyph_Lift(LinearOpMode opMode) {
        this.opMode = opMode;

        lift = opMode.hardwareMap.get(DcMotor.class, "lift");
        lift.setDirection(DcMotor.Direction.FORWARD);
        lift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        touchTop = opMode.hardwareMap.get(DigitalChannel.class, "touch_top");
        touchBottom = opMode.hardwareMap.get(DigitalChannel.class, "touch_bottom");
    }

    public void pause() {
        lift.setPower(0);
    }

    public void raise() {
        lift.setPower(LIFT_POWER);
    }

    public void lower() {
        lift.setPower(-LIFT_POWER);
    }

    public boolean topIsPressed() {
        if (touchTop.getState() == true) {
            return false;
        }
        return true;
    }
    public boolean bottomIsPressed() {
        if (touchBottom.getState() == true) {
            return false;
        }
        return true;
    }
}
