package org.firstinspires.ftc.teamcode.opmodes12833;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name="Blue Right", group="BLUE")

public class MM_Blue_Right extends MM_OpMode {

    @Override
    public void runOpMode() {
        allianceColor = BLUE;

        waitToBegin();
        robot.drivetrain.brakeOn();
        robot.lift.raiseLiftTime (.35, 1);
        robot.pushIncorrectJewelGyro(startRange);

        double moveInches = 36.5;  // default center column

        switch (robot.getVuMark()) {
            case LEFT:
                moveInches = 28;
                break;
            case RIGHT:
                moveInches = 42;
                break;
        }

        robot.drivetrain.encoderDrive(.2, moveInches, 10.0);
        robot.lift.raiseLiftTime (.35, -1);
        robot.drivetrain.gyroTurn(.3, 90);
        robot.drivetrain.encoderDrive(.4, 3.9, 3.0);
        robot.drivetrain.encoderDrive(.4, -2.2, 3.0);
        robot.collector.releaseAuto();
        robot.drivetrain.encoderDrive(1, -3, 4);

/*  ********************** Remove for Detroit **************************************
        robot.drivetrain.gyroTurn(.5, -90);
        robot.collector.collect();
        robot.drivetrain.encoderDrive(.8, 35, 5);
        robot.collector.pause();
        robot.drivetrain.gyroTurn(.5,-90);
        robot.drivetrain.gyroTurn(.5, 90);
        robot.lift.raiseLiftTime(2.35, 1);
        robot.drivetrain.encoderDrive(.6, 40, 7);
        robot.collector.release();
        robot.drivetrain.encoderDrive(.1, -5, 2);
        robot.collector.pause();
*/
    }
}




