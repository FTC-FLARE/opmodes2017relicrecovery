package org.firstinspires.ftc.teamcode.opmodes12833;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="Red Stone 1", group="RED")

public class MM_Red_Left extends LinearOpMode {

    public MM_Bot robot = new MM_Bot(this);
    public ElapsedTime runtime = new ElapsedTime();

    final static int RED = 1;
    final static int BLUE = 2;
    final static int NOTHING = 0;

    public int allianceColor = 1;

    @Override
    public void runOpMode() {
        robot.init();

        waitForStart();
        robot.jewelarm.lowerJewelArm();
        pushIncorrectJewel();
    }

    public void pushIncorrectJewel() {
        if (allianceColor == robot.jewelarm.getLeftJewelColor()) {
            robot.drivetrain.turnRight(10);
        }
        else if (robot.jewelarm.getLeftJewelColor() == NOTHING){
            robot.drivetrain.setMotorPower(0, 0, 0, 0);
        }
        else {
            robot.drivetrain.turnLeft(10);
        }
        robot.jewelarm.raiseJewelArm();
    }
}




