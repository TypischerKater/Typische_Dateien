import lejos.hardware.Button;
import lejos.hardware.motor.*;
import lejos.hardware.port.*;
import lejos.utility.Delay;

public class Back_and_for {
	
	public static void main(String[] args) {
		System.out.println("Drive in a Square pattern");
		System.out.println("Press any key to start");
		
		Button.LEDPattern(3);  //flash green led
		
		Button.waitForAnyPress();
		
		//create two motr objects to contol the motors.
		UnregulatedMotor motorA = new UnregulatedMotor(MotorPort.A);
		UnregulatedMotor motorD = new UnregulatedMotor(MotorPort.D);
			
			//set motors to 30% power.
			motorA.setPower(30);
			motorD.setPower(30);
			
			//wait 2 seconds.
			Delay.msDelay(5000);
			
			//stop motors with brakes on.
			motorA.stop();
			motorD.stop();
			
			//turn right by reversing the right motor.
			motorA.forward();
			motorD.backward();
			
			//make a turn
			motorA.setPower(30);
			motorD.setPower(30);
			
			//adjust time to get a 90% turn.
			Delay.msDelay(3080);
			
			motorA.stop();
			motorD.stop();
			
			//set right motor back to forward motion.
			motorA.forward();
			motorD.forward();
		
			// free up motor resources. 
	        motorA.close(); 
	        motorD.close();
		
	}
}