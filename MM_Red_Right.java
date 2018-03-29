package org.firstinspires.ftc.teamcode.opmodes12833;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="Red Right", group="RED")

public class MM_Red_Right extends MM_OpMode {

    @Override
    public void runOpMode() {
        allianceColor = RED;

        waitToBegin();
        robot.drivetrain.brakeOn();

        robot.pushIncorrectJewelGyro(startRange);

        double moveInches = 15;  // default center column

        robot.drivetrain.encoderDrive(.5, -25, 5.0);
        robot.drivetrain.gyroTurn(.35, -90);
        robot.drivetrain.setDriveEncoderMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        switch (robot.getVuMark()) {
            case RIGHT:
                moveInches = 7;
                break;
            case LEFT:
                moveInches = 9 + 2 * 7;
                break;
        }

        robot.drivetrain.encoderDrive(.5, moveInches, 7.0);
        robot.drivetrain.gyroTurn(.35, 180);
        robot.drivetrain.encoderDrive(.8, 1.85, 2.0);
        robot.collector.releaseAuto();
        robot.drivetrain.encoderDrive(.8, -1.8, 2.0);



    }
}