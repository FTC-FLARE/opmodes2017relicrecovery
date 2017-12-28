package org.firstinspires.ftc.teamcode.opmodes12833;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name="Blue Left", group="BLUE")

public class MM_Blue_Left extends MM_OpMode {

    @Override
    public void runOpMode() {
        allianceColor = BLUE;
        robot.drivetrain.brakeOn();

        waitToBegin();

        robot.jewelarm.lower();
        robot.pushIncorrectJewel(38);
        robot.drivetrain.driveBackwardInches(20);
        robot.drivetrain.strafeLeftInches(30);
        robot.drivetrain.driveForwardTime(.5, .2);
    }
}




