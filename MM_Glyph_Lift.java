package org.firstinspires.ftc.teamcode.opmodes12833;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

public class MM_Glyph_Lift {

    private DcMotor lift = null;
    private TouchSensor digitalChannel = null;
    private ElapsedTime runtime = new ElapsedTime();

    private LinearOpMode opMode;

    public MM_Glyph_Lift(LinearOpMode opMode) {
        this.opMode = opMode;

        lift = opMode.hardwareMap.get(DcMotor.class, "lift");


        lift.setDirection(DcMotor.Direction.FORWARD);

        lift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }


    public void pauseLift() {
        setLiftPower(0);
    }
    public void raiseGlpyhCollector (double power) {
        setLiftPower(power);
    }
    public void lowerGlpyhCollector (double power) {
        setLiftPower(-power);
    }
    private void setLiftPower(double power) {
        lift.setPower(power);
    }
}
