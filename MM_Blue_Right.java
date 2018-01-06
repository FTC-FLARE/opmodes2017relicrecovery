package org.firstinspires.ftc.teamcode.opmodes12833;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous(name="Blue Right", group="BLUE")

public class MM_Blue_Right extends MM_OpMode {

    @Override
    public void runOpMode() {
        allianceColor = BLUE;

        waitToBegin();
        robot.drivetrain.brakeOn();

        robot.pushIncorrectJewel(startRange);

        double moveInches = 32;  // default center column

        switch (robot.getVuMark()) {
            case LEFT:
                moveInches = 24.5;
                break;
            case RIGHT:
                moveInches = 39.5;
                break;
        }

        robot.drivetrain.encoderDrive(.5, moveInches, 5.0);
        robot.drivetrain.gyroTurn(.35, 90);
        robot.drivetrain.encoderDrive(.25, 6.0, 2.0);
        robot.collector.releaseAuto();
        robot.drivetrain.encoderDrive(.25, -1.0, 2.0);
    }
}




