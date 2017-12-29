package org.firstinspires.ftc.teamcode.opmodes12833;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name="Red Right", group="RED")

public class MM_Red_Right extends MM_OpMode {

    @Override
    public void runOpMode() {
        allianceColor = RED;

        waitToBegin();
        robot.drivetrain.brakeOn();

        robot.pushIncorrectJewel(startRange, MM_DriveTrain.directionToDrive.BACK);
        robot.drivetrain.driveToRange(24, MM_DriveTrain.directionToDrive.BACK);
/*
        robot.drivetrain.driveBackwardInches(40);
        robot.drivetrain.strafeRightInches(30);
        robot.drivetrain.driveForwardTime(.5, .2);
*/
    }
}




