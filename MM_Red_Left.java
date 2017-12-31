package org.firstinspires.ftc.teamcode.opmodes12833;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "Red Left", group = "RED")

public class MM_Red_Left extends MM_OpMode {

    @Override
    public void runOpMode() {
        allianceColor = RED;

        waitToBegin();
        robot.drivetrain.brakeOn();

        robot.pushIncorrectJewel(startRange);

        double moveInches = -32;  // default center column

        switch (vuMark) {
            case LEFT:
                moveInches = -24.5;
                break;
            case RIGHT:
                moveInches = -39.5;
                break;
        }

        robot.drivetrain.encoderDrive(.5, moveInches, 5.0);
/*
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
*/
    }
}




