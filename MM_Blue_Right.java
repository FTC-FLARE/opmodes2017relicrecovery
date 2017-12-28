package org.firstinspires.ftc.teamcode.opmodes12833;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name="Blue Right", group="BLUE")

public class MM_Blue_Right extends MM_OpMode {

    @Override
    public void runOpMode() {
        allianceColor = BLUE;
        robot.drivetrain.brakeOn();

        waitToBegin();

        robot.jewelarm.lower();
        robot.pushIncorrectJewel(14);
        robot.drivetrain.driveForwardTime(.9, .8);
        robot.drivetrain.strafeLeftInches(35);

        //robot.drivetrain.turnLeftDegree(90);
        //robot.drivetrain.driveForwardTime(1, .2);

    }
}




