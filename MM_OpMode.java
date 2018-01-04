package org.firstinspires.ftc.teamcode.opmodes12833;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.RelicRecoveryVuMark;

public abstract class MM_OpMode extends LinearOpMode {

    public MM_Bot robot = new MM_Bot(this);
    public ElapsedTime runtime = new ElapsedTime();

    final static int RED = 1;
    final static int BLUE = 2;
    final static int NOTHING = 0;

    public int allianceColor = 0;
    public double startRange;
    public RelicRecoveryVuMark vuMark;

    public void waitToBegin() {
        robot.init();

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        while (!isStarted()) {
            telemetry.addData("Range", "%.2f inches", robot.getCurrentDistance());
            telemetry.addData("Heading", robot.drivetrain.getCurrentHeading());
            if (this.getClass() != MM_TeleOp.class) {
                telemetry.addData("VuMark", robot.getVuMark());
            }
            robot.jewelarm.getLeftColor();
            robot.drivetrain.currentDrivePositionTelemetry();
            telemetry.update();
        }
    }
}




