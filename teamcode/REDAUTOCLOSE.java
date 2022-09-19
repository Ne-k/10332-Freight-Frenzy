package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

// below is the Annotation that registers this OpMode with the FtcRobotController app.
// @Autonomous classifies the OpMode as autonomous, name is the OpMode title and the
// optional group places the OpMode into the Exercises group.
// uncomment the @Disable annotation to remove the OpMode from the OpMode list.

@Autonomous(name="REDAUTOCLOSE")
//@Disabled
public class REDAUTOCLOSE extends LinearOpMode
{
    DcMotor LFMotor;
    DcMotor LBMotor;
    DcMotor RFMotor;
    DcMotor RBMotor;

    // called when init button is  pressed.

    @Override
    public void runOpMode() throws InterruptedException
    {
        LFMotor = hardwareMap.dcMotor.get("LFMotor");
        LBMotor = hardwareMap.dcMotor.get("LBMotor");
        RFMotor = hardwareMap.dcMotor.get("RFMotor");
        RBMotor = hardwareMap.dcMotor.get("RBMotor");

        telemetry.addData("Mode", "waiting");
        telemetry.update();

        // wait for start button.

        waitForStart();

        telemetry.addData("Mode", "running");
        telemetry.update();
 
        // set both motors to 25% power.

        LFMotor.setPower(0.35);
        LBMotor.setPower(0.35);
        RBMotor.setPower(-0.3);
        RFMotor.setPower(-0.3);
        

        sleep(1250);        // wait for 2 seconds.
        
        LFMotor.setPower(-0.35);
        LBMotor.setPower(-0.35);
        RFMotor.setPower(-0.3);
        RFMotor.setPower(-0.3);
        
        sleep(1200);

        LFMotor.setPower(0.35);
        LBMotor.setPower(0.35);
        RBMotor.setPower(-0.35);
        RFMotor.setPower(-0.35);
        
        sleep(600);
        
        LFMotor.setPower(0);
        LBMotor.setPower(0);
        RBMotor.setPower(0);
        RFMotor.setPower(0);
        
    }
}
