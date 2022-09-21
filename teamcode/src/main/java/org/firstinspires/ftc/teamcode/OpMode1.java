package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;

@TeleOp
public class OpMode1 extends LinearOpMode
{
    public void runOpMode() throws InterruptedException {
        final DcMotor LFMotor = (DcMotor)this.hardwareMap.dcMotor.get("LFMotor");
        final DcMotor LBMotor = (DcMotor)this.hardwareMap.dcMotor.get("LBMotor");
        final DcMotor RFMotor = (DcMotor)this.hardwareMap.dcMotor.get("RFMotor");
        final DcMotor RBMotor = (DcMotor)this.hardwareMap.dcMotor.get("RBMotor");
        final DcMotor SpinnerMotor = (DcMotor)this.hardwareMap.dcMotor.get("SpinnerMotor");
        final DcMotor IntakeMotor = (DcMotor)this.hardwareMap.dcMotor.get("IntakeMotor");
        final Servo extServo = (Servo)this.hardwareMap.servo.get("extServo");
        final Servo extServo2 = (Servo)this.hardwareMap.servo.get("extServo2");
        final Servo bucketServo = (Servo)this.hardwareMap.servo.get("bucketServo");
        final DcMotor slideMotorOne = (DcMotor)this.hardwareMap.dcMotor.get("slideMotorOne");
        final DcMotor slideMotorTwo = (DcMotor)this.hardwareMap.dcMotor.get("slideMotorTwo");
        ColorSensor color_sensor;
        color_sensor = hardwareMap.colorSensor.get("color");

        RFMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        RBMotor.setDirection(DcMotorSimple.Direction.REVERSE);


        this.waitForStart();
        if (this.isStopRequested()) {
            return;
        }
        while (this.opModeIsActive()) {
            final double y = (-this.gamepad1.left_stick_y)* .7;
            final double x = -this.gamepad1.left_stick_x * .7;
            final double rx = this.gamepad1.right_stick_x*.5;
            final double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1.0);
            final double frontLeftPower = (y + x + rx) / denominator;
            final double backLeftPower = (y - x + rx) / denominator;
            final double frontRightPower = (y - x - rx) / denominator;
            final double backRightPower = (y + x - rx) / denominator;
            LFMotor.setPower(frontLeftPower);
            LBMotor.setPower(backLeftPower);
            RFMotor.setPower(frontRightPower);
            RBMotor.setPower(backRightPower);
            //.35
            final double spinnerPow = .45;
            final double spinnerPowRev = -.45;
            if(color_sensor.red() > 200 && !(gamepad1.y || gamepad2.y)){
                    bucketServo.setPosition(0.15);
                }


            
            if (this.gamepad1.back || this.gamepad2.back) {
                SpinnerMotor.setPower(spinnerPow);
            }
            
            else if (this.gamepad1.start || this.gamepad2.start) {
                SpinnerMotor.setPower(spinnerPowRev);
            }
            else if (!this.gamepad1.back || !this.gamepad2.back || !this.gamepad1.start || !this.gamepad2.start) {
                SpinnerMotor.setPower(0.0);
            }
            
            

            //telemetry.addData("yellow", color.yellow());

            final double servoMiddlePos = 0.125;
            if((gamepad1.x || gamepad2.x)){
                extServo.setPosition(servoMiddlePos);
                extServo2.setPosition(servoMiddlePos);
            }
            
            final double intakePow = 0.8;
            final double intakePowRev = -0.8;
            if (this.gamepad1.left_bumper || gamepad2.left_bumper) {
                IntakeMotor.setPower(intakePow);
            }
            else if (this.gamepad1.right_bumper || gamepad2.right_bumper) {
                IntakeMotor.setPower(intakePowRev);
            }
            else if (!this.gamepad1.left_bumper || !this.gamepad1.right_bumper || gamepad2.left_bumper || gamepad2.left_bumper) {
                IntakeMotor.setPower(0.0);
            }
            final double bucketPos1 = 0.0;
            final double bucketPos2 = 0.55;
            final double middlePos = 0.2;
            if (this.gamepad1.y || this.gamepad2.y) {
                bucketServo.setPosition(bucketPos2);
            }
            else if (this.gamepad1.a || this.gamepad2.a) {
                bucketServo.setPosition(bucketPos1);
            }
            final double servoPos1 = 0.0;
            final double servoPos2 = 0.4;
            extServo2.setDirection(Servo.Direction.REVERSE);
            if (this.gamepad1.dpad_left || this.gamepad2.dpad_left) {
                extServo.setPosition(servoPos1);
                extServo2.setPosition(servoPos1);
            }
            else if (this.gamepad1.dpad_right || this.gamepad2.dpad_right) {
                extServo.setPosition(servoPos2);
                extServo2.setPosition(servoPos2);
            }
            if (this.gamepad1.dpad_down || this.gamepad2.dpad_down) {
                slideMotorOne.setPower(-0.6);
                slideMotorTwo.setPower(0.6);
            }
            else if (this.gamepad1.dpad_up || this.gamepad2.dpad_up) {
                slideMotorOne.setPower(1);
                slideMotorTwo.setPower(-1);
                bucketServo.setPosition(middlePos);
            }
            else if (gamepad1.b || gamepad2.b){
                slideMotorOne.setPower(1);
                slideMotorTwo.setPower(-1);
                bucketServo.setPosition(.41);
            }

            else {
                if ((this.gamepad1.dpad_down || this.gamepad2.dpad_down) && (this.gamepad1.dpad_up || this.gamepad2.dpad_up) && (gamepad1.b || gamepad2.b)) {
                    continue;
                }
                slideMotorOne.setPower(0.0);
                slideMotorTwo.setPower(0.0);
            }
        }
    }
}