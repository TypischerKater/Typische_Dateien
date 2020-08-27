package Perseverance_Rover;

import lejos.hardware.Battery;
import lejos.hardware.Button;
import lejos.hardware.Brick;
import lejos.hardware.BrickFinder;
import lejos.hardware.lcd.*;
import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.*;
import lejos.hardware.port.MotorPort;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.utility.Delay;

public class Perseverance_Rover {

	public static void main(String[] args) {
		
		//name of the robot
		LCD.drawString("Perseverance", 3, 0);
		
		//rover login program with color sensor
		Color_Sensor rover_login = new Color_Sensor();
		rover_login.Color_Sensor_login();
		
		LCD.drawString("Press any key", 2, 3);
		LCD.drawString("to start", 4, 4);
		Button.LEDPattern(1);
		Button.waitForAnyPress();
		LCD.clear(3);
		LCD.clear(4);
		if (Button.ESCAPE.isDown()) {
			return; //terminate the program
		}
		
//		//starting program
		LCD.drawString("starting", 5, 3);
		Button.LEDPattern(6);	
		for (int i = 0; i <= 100; i++) {
			LCD.drawString(i + " %", 7, 2);
			Delay.msDelay(50);
			if (Button.ESCAPE.isDown()) {
				return; //terminate the program
			}
		}
		
		//Battery Check
		float batVolt = Battery.getVoltage();
		
		if(batVolt>6.5) {

			if(batVolt>7) {
				Button.LEDPattern(4);
				LCD.drawString("Battery full", 3, 6);
				Delay.msDelay(3000);
				LCD.clear(2);
				LCD.clear(3);
				LCD.clear(6);
			}
			else {
				Button.LEDPattern(5);
				LCD.drawString("Charge Battery", 2, 6);
				LCD.drawString(batVolt + " Volt", 2, 7);
				Delay.msDelay(3000);
				LCD.clear(2);
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
			LCD.clear(2);
			LCD.clear(3);
			LCD.clear(5);
			return; //terminate the program
		}	
		
		//create motor objects to control the motors.
		UnregulatedMotor motorA = new UnregulatedMotor(MotorPort.A);
		UnregulatedMotor motorD = new UnregulatedMotor(MotorPort.D);
		
		//Import program from pack
		Touch_Sensor touch;
		Ultrasonic_Sensor ultrasonic;
		
		//Brick
		Brick Touch = BrickFinder.getDefault();
		Brick Ultrasonic = BrickFinder.getDefault();
		
		//Port
		Port s1 = Touch.getPort("S1");
		Port s2 = Ultrasonic.getPort("S2");
		
		//Ev3 TouchSensor & UltrasonicSensor
		EV3TouchSensor touchsensor = new EV3TouchSensor(s1);
		EV3UltrasonicSensor ultrasonicsensor = new EV3UltrasonicSensor(s2);
		
		//Touch & Ultrasonic
		touch = new Touch_Sensor(touchsensor);
		ultrasonic = new Ultrasonic_Sensor(ultrasonicsensor);
		
		//boolean for while-loop
		boolean tr = true;
		
//		//continue with the program
		Button.LEDPattern(7);
		LCD.drawString("exploring", 4, 2);
		
		motorA.setPower(25);
		motorD.setPower(25);
		
		while(tr) {
			
			Delay.msDelay(50);
			
			if (touch.pressed()) {
				motorA.stop();
				motorD.stop();
				motorA.close();
				motorD.close();
				tr = false;
			}
			else if (ultrasonic.distance()<0.3) {
				motorA.stop();
				motorD.stop();
				motorA.close();
				motorD.close();
				tr = false;
			}
			else if (Button.ESCAPE.isDown()) {
				return;
			}
		}
		
//		//Done with the program
		Button.LEDPattern(1);
		LCD.drawString("Done", 6, 4);
		LCD.drawString(ultrasonic.distance()+ " cm", 4, 6);
		Delay.msDelay(5000);
		LCD.clear(2);
		LCD.clear(4);
		LCD.clear(6);
		LCD.drawString("MARS 2020", 4, 3);
		Delay.msDelay(3000);
	}
}
