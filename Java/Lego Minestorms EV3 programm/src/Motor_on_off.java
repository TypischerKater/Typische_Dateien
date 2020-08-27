import lejos.hardware.Button;
import lejos.hardware.motor.*;
import lejos.hardware.port.*;
import lejos.utility.Delay;

public class Motor_on_off {

	public static void main(String[] args) {
		
		System.out.println("drive forward and Stop");
		System.out.println("Press any key to start");
		
		Button.LEDPattern(4); // flash green LED
		
		Button.waitForAnyPress();
		
		//create two motor objects to control the motors.
		UnregulatedMotor motorA = new UnregulatedMotor (MotorPort.A);
		UnregulatedMotor motorD = new UnregulatedMotor (MotorPort.D);
		
		//Set Motor to 30% power.
		motorA.setPower(30);
		motorD.setPower(30);
		
		//wait 2 seconds.
		Delay.msDelay(2000);
		
		//stop motors with brakes on.
		motorA.stop();
		motorD.stop();
		
		//free up motor resources.
		motorA.close();
		motorD.close();
	}

}