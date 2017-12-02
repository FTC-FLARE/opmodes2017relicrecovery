package org.firstinspires.ftc.teamcode.opmodes12833;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name="Red Stone Left", group="RED")

public class MM_Red_Left extends MM_OpMode {

    @Override
    public void runOpMode() {
        allianceColor = RED;

        waitToBegin();

        robot.jewelarm.lowerJewelArm();
        robot.pushIncorrectJewel();
        robot.drivetrain.backwardTime(1.2, .4);
        robot.drivetrain.turnLeftDegree(90);
        robot.drivetrain.forwardTime(.2, .2);
    }
}




