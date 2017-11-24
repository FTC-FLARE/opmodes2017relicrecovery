package org.firstinspires.ftc.teamcode.opmodes12833;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

public class MM_Bot {

    public MM_DriveTrain drivetrain = null;
    public MM_Glyph_Mechanism collector = null;
    public MM_Relic_Collector relic = null;
    public MM_Jewel_Scorer jewelarm = null;

    private LinearOpMode opMode;

    public MM_Bot(LinearOpMode opMode){
        this.opMode = opMode;
    }

    public void init(){
        drivetrain = new MM_DriveTrain(opMode);
        collector = new MM_Glyph_Mechanism(opMode);
        relic = new MM_Relic_Collector(opMode);
        jewelarm = new MM_Jewel_Scorer(opMode);
    }

}