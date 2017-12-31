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

        robot.drivetrain.encoderDrive(.5, -28, 5.0);

/*
        robot.pushIncorrectJewel(startRange, MM_DriveTrain.directionToDrive.BACK);

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
*/
    }
}




