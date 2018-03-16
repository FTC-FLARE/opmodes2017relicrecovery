package org.firstinspires.ftc.teamcode.opmodes12833;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name="Blue Right", group="BLUE")

public class MM_Blue_Right extends MM_OpMode {

    @Override
    public void runOpMode() {
        allianceColor = BLUE;

        waitToBegin();
        robot.drivetrain.brakeOn();

        robot.pushIncorrectJewelGyro(startRange);

        double moveInches = 36.5;  // default center column

        switch (robot.getVuMark()) {
            case LEFT:
                moveInches = 28;
                break;
            case RIGHT:
                moveInches = 44;
                break;
        }

        robot.drivetrain.encoderDrive(.5, moveInches, 10.0);
        robot.drivetrain.gyroTurn(.5, 90);
        robot.drivetrain.encoderDrive(.7, 2.2, 3.0);
        robot.drivetrain.encoderDrive(.7, -2.2, 3.0);
        robot.collector.releaseAuto();

//        robot.drivetrain.encoderDrive(.5, moveInches, 5.0);
//        robot.drivetrain.gyroTurn(.35, 90);
//        robot.drivetrain.encoderDrive(.25, 5.0, 2.0);
//        robot.collector.releaseAuto();
//        robot.drivetrain.encoderDrive(.25, -2.0, 2.0);

    }
}




