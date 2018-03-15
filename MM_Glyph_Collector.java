package org.firstinspires.ftc.teamcode.opmodes12833;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

public class MM_Glyph_Collector {

    private DcMotor leftCollector = null;
    private DcMotor rightCollector = null;
    private ElapsedTime runtime = new ElapsedTime();

    private final static double SQUARE_AND_COLLECT_GLYPH_POWER = .5;
    private final static double RELEASE_GLYPH_POWER = -1;

    private LinearOpMode opMode;

    public MM_Glyph_Collector(LinearOpMode opMode) {
        this.opMode = opMode;

        rightCollector = opMode.hardwareMap.get(DcMotor.class, "right_collector");
        leftCollector = opMode.hardwareMap.get(DcMotor.class, "left_collector");

        leftCollector.setDirection(DcMotor.Direction.REVERSE);
        rightCollector.setDirection(DcMotor.Direction.FORWARD);

        leftCollector.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightCollector.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void pause() {
        setCollectorPower(0);
    }

    public void collect() {
        setCollectorPower(SQUARE_AND_COLLECT_GLYPH_POWER);
    }

    public void release() {
        setCollectorPower(RELEASE_GLYPH_POWER);
    }

    private void setCollectorPower(double power) {
        leftCollector.setPower(power);
        rightCollector.setPower(power);
    }

    public void squareGlyph() {
        leftCollector.setPower(SQUARE_AND_COLLECT_GLYPH_POWER);
    }

    public void releaseAuto() {
        release();
        opMode.sleep(700);
        pause();
    }
}
