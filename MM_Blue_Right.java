package org.firstinspires.ftc.teamcode.opmodes12833;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name="Blue Stone Right", group="BLUE")

public class MM_Blue_Right extends MM_OpMode {

    @Override
    public void runOpMode() {
        allianceColor = BLUE;

        waitToBegin();

        robot.jewelarm.lowerJewelArm();
        robot.pushIncorrectJewel();
    }
}




