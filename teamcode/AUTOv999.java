package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous
//@Disabled
public class AUTOv999 extends LinearOpMode{

        DcMotor RFMotor, RBMotor, LFMotor, LBMotor;
        
        @Override
        public void runOpMode() throws InterruptedException{
        RFMotor = hardwareMap.dcMotor.get("RFMotor");
        RBMotor = hardwareMap.dcMotor.get("RBMotor");
        LFMotor = hardwareMap.dcMotor.get("LFMotor");
        LBMotor = hardwareMap.dcMotor.get("LBMotor");

        LFMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        LBMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RFMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        RBMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        waitForStart();
        
        // Reset enoders to zero
        LFMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        LBMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RFMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        RBMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        LFMotor.setTargetPosition(24400);
        LBMotor.setTargetPosition(24400);
        RFMotor.setTargetPosition(24400);
        RBMotor.setTargetPosition(24400);

        LFMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        LBMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RFMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        RBMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        
        LFMotor.setPower(1);
        LBMotor.setPower(1);
        RFMotor.setPower(1);
        RBMotor.setPower(1);

        telemetry.addData("2 ", "motorFrontLeft:  " + String.format("%d", LFMotor.getTargetPosition()));
        telemetry.addData("3 ", "motorFrontRight:  " + String.format("%d", RFMotor.getTargetPosition()));
        telemetry.addData("4 ", "motorBackLeft:  " + String.format("%d", LBMotor.getTargetPosition()));
        telemetry.addData("5 ", "motorBackRight:  " + String.format("%d", RBMotor.getTargetPosition()));
    }
}
