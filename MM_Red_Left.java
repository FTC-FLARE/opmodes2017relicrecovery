package org.firstinspires.ftc.teamcode.opmodes12833;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "Red Left", group = "RED")

public class MM_Red_Left extends MM_OpMode {

    @Override
    public void runOpMode() {
        allianceColor = RED;

        waitToBegin();
        robot.drivetrain.brakeOn();

        robot.pushIncorrectJewel(startRange, MM_DriveTrain.directionToDrive.FWRD);

        robot.lift.raiseForRangeSensor();

        double stopAtRange = 55.5;  // default center column

        switch (vuMark) {
            case LEFT:
                stopAtRange = 48;
                break;
            case RIGHT:
                stopAtRange = 63;
                break;
        }
        robot.drivetrain.driveToRange(stopAtRange, MM_DriveTrain.directionToDrive.FWRD);

        robot.lift.lowerForRangeSensor();

//        robot.drivetrain.driveBackwardTime(1.2, 1);
//        robot.drivetrain.strafeLeftInches(35);

        //robot.drivetrain.turnLeftDegree(90);
        //robot.drivetrain.driveForwardTime(.2, .2);
    }
}




