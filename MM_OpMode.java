package org.firstinspires.ftc.teamcode.opmodes12833;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

public abstract class MM_OpMode extends LinearOpMode {

    public MM_Bot robot = new MM_Bot(this);
    public ElapsedTime runtime = new ElapsedTime();

    final static int RED = 1;
    final static int BLUE = 2;
    final static int NOTHING = 0;

    public int allianceColor = 0;

    public void waitToBegin() {
        robot.init();

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();
    }
}




