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

        double moveInches = -30;  // default center column

        switch (robot.getVuMark()) {
            case LEFT:
                moveInches = -37.5;
                break;
            case RIGHT:
                moveInches = -22.5;
                break;
        }

        robot.drivetrain.encoderDrive(.5, moveInches, 5.0);
        robot.drivetrain.gyroTurn(.35, 90);
        robot.drivetrain.encoderDrive(.25, 5.0, 2.0);
        robot.collector.releaseAuto();
        robot.drivetrain.encoderDrive(.25, -2.0, 2.0);
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




