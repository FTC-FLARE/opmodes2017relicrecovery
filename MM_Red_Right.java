package org.firstinspires.ftc.teamcode.opmodes12833;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name="Red Right", group="RED")

public class MM_Red_Right extends MM_OpMode {

    @Override
    public void runOpMode() {
        allianceColor = RED;

        waitToBegin();
        robot.drivetrain.brakeOn();

        robot.pushIncorrectJewel(startRange);

        robot.drivetrain.encoderDrive(.5, -25, 5.0);

        double moveInches = 14;  // default center column
        robot.drivetrain.gyroTurn(.35, -90);

        switch (robot.getVuMark()) {
            case LEFT:
                moveInches = 7 + 2 * 7;
                break;
            case RIGHT:
                moveInches = 7;
                break;
        }

        robot.drivetrain.encoderDrive(.5, moveInches, 5.0);
        robot.drivetrain.gyroTurn(.35, -180);
        robot.drivetrain.encoderDrive(.25, 4, 2.0);
        robot.collector.releaseAuto();
        robot.drivetrain.encoderDrive(.25, -3.0, 2.0);


    }
}