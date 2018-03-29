package org.firstinspires.ftc.teamcode.opmodes12833;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name = "Red Left", group = "RED")

public class MM_Red_Left extends MM_OpMode {

    @Override
    public void runOpMode() {
        allianceColor = RED;

        waitToBegin();
        robot.drivetrain.brakeOn();

        robot.pushIncorrectJewelGyro(startRange);

        double moveInches = -32;  // default center column

        switch (robot.getVuMark()) {
            case LEFT:
                moveInches = -42;
                break;
            case RIGHT:
                moveInches = -25;
                break;
        }

        robot.drivetrain.encoderDrive(.5, moveInches, 10.0);
        robot.drivetrain.gyroTurn(.7, 90);
        robot.drivetrain.encoderDrive(.9, 2, 3.0);
        robot.drivetrain.encoderDrive(.9, -2, 3.0);
        robot.collector.releaseAuto();
        robot.drivetrain.gyroTurn(.9, 270);
        robot.drivetrain.strafeRightInches(20);
        robot.drivetrain.strafeLeftInches(10);

        robot.drivetrain.gyroTurn(1, -90);
        robot.collector.collect();
        robot.drivetrain.encoderDrive(1, 60, 5);


//        robot.drivetrain.encoderDrive(.5, moveInches, 5.0);
//        robot.drivetrain.gyroTurn(.35, 90);
//        robot.drivetrain.encoderDrive(.25, 5.0, 2.0);
//        robot.collector.releaseAuto();
//        robot.drivetrain.encoderDrive(.25, -2.0, 2.0);


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




