import lejos.hardware.Button;
import lejos.hardware.motor.*;
import lejos.hardware.port.*;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;
import lejos.hardware.lcd.*;
import lejos.hardware.Battery;

public class Perseverance_driving {

	public static void main(String[] args) {
		
		System.out.println("Perseverance Rover");
		
		System.out.println("Press any key to start");
		Button.LEDPattern(1);	//LED green	
		Button.waitForAnyPress();
		
		Button.LEDPattern(6);	//LED orange flashing
		System.out.println("starting");
		Delay.msDelay(3000);
		
		//Battery object
		Battery batteryVoltage = new Battery();
		float batVolt = batteryVoltage.getVoltage();
		
		//clear lcd screen
		
		
		//create two motor objects to control the motors.
		UnregulatedMotor motorA = new UnregulatedMotor (MotorPort.A);
		UnregulatedMotor motorD = new UnregulatedMotor (MotorPort.D);
		
		LCD.clear();		
		Button.LEDPattern(7);	//LED green long flash short flash
		System.out.println("exploring");

		if(batVolt>8) {
			
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
		else {
			System.out.println("Battery is low");
			System.out.println(batVolt + " Volt");
		}
		
		Button.LEDPattern(2);
		Delay.msDelay(5000);
		
	}
}
