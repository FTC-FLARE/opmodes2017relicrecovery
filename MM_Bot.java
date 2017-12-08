package org.firstinspires.ftc.teamcode.opmodes12833;

public class MM_Bot {

    public MM_DriveTrain drivetrain = null;
    public MM_Glyph_Collector collector = null;
    public MM_Glyph_Lift lift = null;
    public MM_Relic_Collector relic = null;
    public MM_Jewel_Scorer jewelarm = null;

    public static final double DRIVE_TIME = .7;
    public static final double DRIVE_POWER = .7;

    private MM_OpMode opMode;

    public MM_Bot(MM_OpMode opMode) {
        this.opMode = opMode;
    }

    public void init() {
        drivetrain = new MM_DriveTrain(opMode);
        collector = new MM_Glyph_Collector(opMode);
        lift = new MM_Glyph_Lift(opMode);
        relic = new MM_Relic_Collector(opMode);
        jewelarm = new MM_Jewel_Scorer(opMode);
    }

    public void pushIncorrectJewel() {
        int jewelColor = jewelarm.getLeftColor();
        opMode.telemetry.addData("Jewel Color", jewelColor);
        opMode.telemetry.update();

        if (jewelColor == opMode.NOTHING) {
            drivetrain.setMotorPower(0, 0, 0, 0);
        } else if (opMode.allianceColor == jewelColor) {
            drivetrain.driveForwardTime(DRIVE_TIME, DRIVE_POWER);
            drivetrain.driveBackwardTime(DRIVE_TIME, DRIVE_POWER);
        } else {
            drivetrain.driveBackwardTime(DRIVE_TIME, DRIVE_POWER);
            drivetrain.driveForwardTime(DRIVE_TIME, DRIVE_POWER);
        }
        jewelarm.raise();
    }
}