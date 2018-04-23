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
        robot.lift.raiseLiftTime (.35, 1);

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

        robot.drivetrain.encoderDrive(.65, moveInches, 7.0);
        robot.lift.raiseLiftTime (.35, -1);

        robot.drivetrain.gyroTurn(.4, 180);
        robot.drivetrain.encoderDrive(.8, 3, 2.0);
        robot.collector.releaseAuto();
        robot.drivetrain.encoderDrive(.8, -1.8, 2.0);
/*  ********************** Remove for Detroit **************************************
        robot.collector.releaseAuto();
        robot.drivetrain.encoderDrive(1, -3, 4);

        robot.drivetrain.gyroTurn(.5, -90);
        robot.collector.collect();
        robot.drivetrain.encoderDrive(.8, 35, 5);
        robot.collector.pause();
        robot.drivetrain.gyroTurn(.6, 100);
        robot.lift.raiseLiftTime(2.35, 1);
        robot.drivetrain.encoderDrive(.6, 40, 7);
        robot.collector.release();
        robot.drivetrain.encoderDrive(.5, -5, 2);
        robot.collector.pause();
*/
    }
}