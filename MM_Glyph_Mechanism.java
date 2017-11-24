package org.firstinspires.ftc.teamcode.opmodes12833;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

public class MM_Glyph_Mechanism {

    private DcMotor leftCollector = null;
    private DcMotor rightCollector = null;
    private DcMotor lift = null;
    private TouchSensor digitalChannel = null;
    private ElapsedTime runtime = new ElapsedTime();

    private LinearOpMode opMode;
    
    public MM_Glyph_Mechanism(LinearOpMode opMode) {
        this.opMode = opMode;

        rightCollector = opMode.hardwareMap.get(DcMotor.class, "right_collector");
        leftCollector = opMode.hardwareMap.get(DcMotor.class, "left_collector");
        lift = opMode.hardwareMap.get(DcMotor.class, "lift");


        leftCollector.setDirection(DcMotor.Direction.REVERSE);
        rightCollector.setDirection(DcMotor.Direction.FORWARD);
        lift.setDirection(DcMotor.Direction.FORWARD);

        leftCollector.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightCollector.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        lift.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }


    public void pauseCollector() {
        setCollectorPower(0);
    }
    public void pauseLift() {
        setLiftPower(0);
    }
    public void collect(double power) {
        setCollectorPower(power);
    }

    public void release(double power) {
        setCollectorPower(-power);
    }

    private void setCollectorPower(double power) {
        leftCollector.setPower(power);
        rightCollector.setPower(power);
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
