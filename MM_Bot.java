package org.firstinspires.ftc.teamcode.opmodes12833;

public class MM_Bot {

    public MM_DriveTrain drivetrain = null;
    public MM_Glyph_Collector collector = null;
    public MM_Glyph_Lift lift = null;
    public MM_Relic_Collector relic = null;
    public MM_Jewel_Scorer jewelarm = null;

    private MM_OpMode opMode;

    public MM_Bot(MM_OpMode opMode){
        this.opMode = opMode;
    }

    public void init(){
        drivetrain = new MM_DriveTrain(opMode);
        collector = new MM_Glyph_Collector(opMode);
        lift = new MM_Glyph_Lift(opMode);
        relic = new MM_Relic_Collector(opMode);
        jewelarm = new MM_Jewel_Scorer(opMode);
    }
    public void pushIncorrectJewel() {
        int jewelColor = jewelarm.getLeftJewelColor();
        opMode.telemetry.addData("Jewel Color", jewelColor);
        opMode.telemetry.update();

        if (opMode.allianceColor == jewelColor) {
            drivetrain.turnRight(.5);
        }
        else if (jewelColor == opMode.NOTHING){
            drivetrain.setMotorPower(0, 0, 0, 0);
        }
        else {
            drivetrain.turnLeft(.5);
        }
        opMode.sleep(500);
        jewelarm.raiseJewelArm();
    }

} 