package org.firstinspires.ftc.teamcode.opmodes12833;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name="Blue Left", group="BLUE")

public class MM_Blue_Left extends MM_OpMode {

    @Override
    public void runOpMode() {
        allianceColor = BLUE;

        waitToBegin();
        robot.drivetrain.brakeOn();

        robot.pushIncorrectJewel(startRange);

        double moveInches = 14;  // default center column

        robot.drivetrain.encoderDrive(.5, 25, 5.0);
        robot.drivetrain.gyroTurn(.35, -90);

        switch (robot.getVuMark()) {
            case LEFT:
                moveInches = 7;
                break;
            case RIGHT:
                moveInches = 7 + 2 * 7;
                break;
        }

        robot.drivetrain.encoderDrive(.5, moveInches, 5.0);
        robot.drivetrain.gyroTurn(.35, 0);
        robot.drivetrain.encoderDrive(.25, 4, 2.0);
        robot.collector.releaseAuto();
        robot.drivetrain.encoderDrive(.25, -3.0, 2.0);
        //glyph compensate
        robot.drivetrain.gyroTurn(.8, 90);
        robot.drivetrain.strafeRightInches(2);

    }
}




