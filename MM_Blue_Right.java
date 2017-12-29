package org.firstinspires.ftc.teamcode.opmodes12833;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name="Blue Right", group="BLUE")

public class MM_Blue_Right extends MM_OpMode {

    @Override
    public void runOpMode() {
        allianceColor = BLUE;

        waitToBegin();
        robot.drivetrain.brakeOn();

        robot.pushIncorrectJewel(startRange, MM_DriveTrain.directionToDrive.BACK);
        robot.drivetrain.driveToRange(48, MM_DriveTrain.directionToDrive.BACK);

/*
        robot.drivetrain.driveForwardTime(.9, .8);
        robot.drivetrain.strafeLeftInches(35);
*/

        //robot.drivetrain.turnLeftDegree(90);
        //robot.drivetrain.driveForwardTime(1, .2);

    }
}




