package org.firstinspires.ftc.teamcode.opmodes12833;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name="Red Stone Right", group="RED")

public class MM_Red_Right extends MM_OpMode {

    @Override
    public void runOpMode() {
        allianceColor = RED;

        waitToBegin();

        robot.jewelarm.lowerJewelArm();
        robot.pushIncorrectJewel();
    }
}




