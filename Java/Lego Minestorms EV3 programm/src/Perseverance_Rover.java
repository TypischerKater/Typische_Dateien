import lejos.utility.*;
import lejos.hardware.lcd.*;
import lejos.hardware.Button;
import lejos.hardware.Battery;
import lejos.hardware.motor.*;
import lejos.hardware.port.*;

public class Perseverance_Rover {
	
	public static void main(String[] args) {
		
		//name of the robot
		LCD.drawString("Perseverance", 3, 0);
						
		LCD.drawString("Press any key", 2, 3);
		LCD.drawString("to start", 4, 4);
		Button.LEDPattern(1);
		Button.waitForAnyPress();
		LCD.clear(3);
		LCD.clear(4);
		
		LCD.drawString("starting", 5, 3);
		Button.LEDPattern(6);
		Delay.msDelay(3000);
		
		Battery batteryVoltage = new Battery();
		float batVolt = batteryVoltage.getVoltage();
		
		if(batVolt>6.5) {
			//continue
			if(batVolt>7) {
				Button.LEDPattern(4);
				LCD.drawString("Battery full", 3, 6);
				Delay.msDelay(3000);
				LCD.clear(3);
				LCD.clear(6);
			}
			else {
				Button.LEDPattern(5);
				LCD.drawString("Charge Battery", 2, 6);
				LCD.drawString(batVolt + " Volt", 2, 7);
				Delay.msDelay(3000);
				LCD.clear(3);
				LCD.clear(6);
				LCD.clear(7);
			}
		}
		else {
			//Stop program
			Button.LEDPattern(2);
			LCD.clear(3);
			LCD.drawString(batVolt + " Volt", 2, 3);
			LCD.drawString("Battery is low", 2, 5);
			Delay.msDelay(10000);
			LCD.clear(3);
			LCD.clear(5);
			return;
		}
		
		//create motor objects to control the motors.
		UnregulatedMotor motorA = new UnregulatedMotor(MotorPort.A);
		UnregulatedMotor motorD = new UnregulatedMotor(MotorPort.D);
		
		//continue with the program
		Button.LEDPattern(7);
		LCD.drawString("exploring", 5, 2);
		
		//motor set to 20%
		motorA.setPower(20);
		motorD.setPower(20);
		
		Delay.msDelay(3000);
		
		//stop motors with brakes on.
		motorA.stop();
		motorD.stop();		
				
		//free up resources.
		motorA.close();
		motorD.close();
		
		
	}
}