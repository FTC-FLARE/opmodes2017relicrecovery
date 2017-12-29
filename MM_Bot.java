package org.firstinspires.ftc.teamcode.opmodes12833;

public class MM_Bot {

    public MM_DriveTrain drivetrain = null;
    public MM_Glyph_Collector collector = null;
    public MM_Glyph_Lift lift = null;
    public MM_Relic_Collector relic = null;
    public MM_Jewel_Scorer jewelarm = null;

    private double MOVE_TO_HIT_JEWEL = 3;

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

    public void pushIncorrectJewel(double startRange, MM_DriveTrain.directionToDrive direction) {
        jewelarm.lower();

        int jewelColor = jewelarm.getLeftColor();
        opMode.telemetry.addData("Jewel Color", jewelColor);
        opMode.telemetry.update();

        if (jewelColor == opMode.NOTHING) {
            drivetrain.setMotorPower(0, 0, 0, 0);
            jewelarm.raise();

        } else {
            double hitRange = startRange + MOVE_TO_HIT_JEWEL;
            if ((opMode.allianceColor == jewelColor && direction == MM_DriveTrain.directionToDrive.FWRD) ||
                    (opMode.allianceColor != jewelColor && direction == MM_DriveTrain.directionToDrive.BACK)) {
                hitRange = startRange - MOVE_TO_HIT_JEWEL;
            }
            drivetrain.driveToRange(hitRange, direction);  // hit opposing alliance jewel
            jewelarm.raise();
            drivetrain.driveToRange(startRange, direction);  // return to start position
        }
    }
}