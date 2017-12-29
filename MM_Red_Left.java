package org.firstinspires.ftc.teamcode.opmodes12833;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name="Red Left", group="RED")

public class MM_Red_Left extends MM_OpMode {

    @Override
    public void runOpMode() {
        allianceColor = RED;

        waitToBegin();
        robot.drivetrain.brakeOn();

        robot.pushIncorrectJewel(startRange, MM_DriveTrain.directionToDrive.FWRD);
        robot.drivetrain.driveToRange(48, MM_DriveTrain.directionToDrive.FWRD);

//        robot.drivetrain.driveBackwardTime(1.2, 1);
//        robot.drivetrain.strafeLeftInches(35);

        //robot.drivetrain.turnLeftDegree(90);
        //robot.drivetrain.driveForwardTime(.2, .2);
    }
}




