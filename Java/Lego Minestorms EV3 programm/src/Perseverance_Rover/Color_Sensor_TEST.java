package Perseverance_Rover;

import lejos.hardware.Button;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.UnregulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.Port;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.robotics.Color;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class Color_Sensor_TEST {

	EV3ColorSensor color_sensor;
	SampleProvider colorProvider;
	float[] colorSample;
	
	public static void main(String[] args) {
		new Color_Sensor_TEST();
		
	}
	
	public void Color_Sensor_TEST() {
		
		Port s3 = LocalEV3.get().getPort("S3");
		color_sensor = new EV3ColorSensor(s3);
		colorProvider = color_sensor.getColorIDMode();
		colorSample = new float[colorProvider.sampleSize()];
		
		boolean tr = true;
		
		while (tr) {
			
			Delay.msDelay(50);
			
			int currentDetectedColor = color_sensor.getColorID();
			switch (currentDetectedColor) {
			case Color.NONE:
				LCD.drawString("Please insert key", 0, 2);
				break;
			case Color.BLUE:
				color_sensor.setFloodlight(Color.BLUE);
				LCD.drawString("Correct", 0, 4);
				Delay.msDelay(500);
				LCD.clear(4);
				tr = false;
			default:
				LCD.drawString("Not right test", 0, 4);
				Delay.msDelay(200);
				LCD.clear(4);
				break;
			}
			if (Button.ESCAPE.isDown()) {
				color_sensor.close();
				return;
			}
		}
		
		LCD.clear(2);
		
	}
}
