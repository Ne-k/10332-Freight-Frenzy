package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

// below is the Annotation that registers this OpMode with the FtcRobotController app.
// @Autonomous classifies the OpMode as autonomous, name is the OpMode title and the
// optional group places the OpMode into the Exercises group.
// uncomment the @Disable annotation to remove the OpMode from the OpMode list.

@Autonomous(name="Redv2")
//@Disabled
public class Redv2 extends LinearOpMode
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
        DcMotor slideMotorOne = hardwareMap.dcMotor.get("slideMotorOne");
        DcMotor slideMotorTwo = hardwareMap.dcMotor.get("slideMotorTwo");
        Servo extServo = hardwareMap.servo.get("extServo");
        Servo extServo2 = hardwareMap.servo.get("extServo2");
        Servo bucketServo = hardwareMap.servo.get("bucketServo");
        DcMotor SpinnerMotor = hardwareMap.dcMotor.get("SpinnerMotor");
        
        ColorSensor color_sensor;
        color_sensor = hardwareMap.colorSensor.get("color");
        
        
        RBMotor.setDirection(DcMotor.Direction.REVERSE);
        RFMotor.setDirection(DcMotor.Direction.REVERSE);
        
        final double servoPosOut2 = 1;
        final double servoPosOut1 = -1;
        final double servoPosIn2 = -1;
        final double servoPosIn1 = 1;
        

        telemetry.addData("Mode", "waiting");
        telemetry.update();

        // wait for start button.

        waitForStart();

        telemetry.addData("Mode", "running");
        telemetry.update();
 
        // set both motors to 25% power.

        LFMotor.setPower(-0.48);
        LBMotor.setPower(0.5);
        RBMotor.setPower(-0.5);
        RFMotor.setPower(0.5);
        
        sleep(1600);        // wait for 2 seconds.
        
        LFMotor.setPower(0);
        LBMotor.setPower(0);
        RBMotor.setPower(0);
        RFMotor.setPower(0);
        
        slideMotorOne.setPower(.8);
        slideMotorTwo.setPower(-.8);
        bucketServo.setPosition(.2);
        
        sleep(1800);
        
        slideMotorOne.setPower(0);
        slideMotorTwo.setPower(0);
        
        extServo.setPosition(servoPosOut1);
        extServo2.setPosition(servoPosOut2);
        
        sleep(1000);
        
        bucketServo.setPosition(.65);
        
        sleep(1000);
        
        bucketServo.setPosition(0);
        extServo.setPosition(servoPosIn1);
        extServo2.setPosition(servoPosIn2);
        slideMotorOne.setPower(-.6);
        slideMotorTwo.setPower(.6);
        
        sleep(1000);
        
        RFMotor.setPower(0.5);
        RBMotor.setPower(0.5);
        
        sleep(1000);
        
        LFMotor.setPower(-0.5);
        LBMotor.setPower(0.5);
        RBMotor.setPower(-0.5);
        RFMotor.setPower(0.5);
        
        sleep(1700);
        
        LFMotor.setPower(0);
        LBMotor.setPower(0);
        RBMotor.setPower(0);
        RFMotor.setPower(0);
        
        sleep(1000);
        
        
        LFMotor.setPower(0.17);
        LBMotor.setPower(0.17);
        RBMotor.setPower(0.17);
        RFMotor.setPower(0.17);
        //3800
        sleep(5000);
        
        LFMotor.setPower(0);
        LBMotor.setPower(0);
        RBMotor.setPower(0);
        RFMotor.setPower(0);
        
        sleep(1600);
        
        SpinnerMotor.setPower(-.4);
        
        sleep(4000);
        
        SpinnerMotor.setPower(0);
        
        LFMotor.setPower(-0.3);
        LBMotor.setPower(-0.3);
        RBMotor.setPower(-0.3);
        RFMotor.setPower(-0.3);
        
        sleep(900);
        
        LFMotor.setPower(0);
        LBMotor.setPower(0);
        RBMotor.setPower(0);
        RFMotor.setPower(0);
        
       
    }
}
