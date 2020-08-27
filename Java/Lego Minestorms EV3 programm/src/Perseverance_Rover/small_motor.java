package Perseverance_Rover;

import lejos.hardware.motor.Motor;
import lejos.utility.Delay;

public class small_motor {

	public static void main(String[] args) {
	}
		public void small_motor_1() {
		Motor.B.forward(); //look right
		Delay.msDelay(150);
		Motor.B.stop();
		Delay.msDelay(500); //wait
		Motor.B.backward(); //look left
		Delay.msDelay(150);
		Motor.B.stop();
		Delay.msDelay(500); //wait
		Motor.B.backward(); //look left
		Delay.msDelay(150);
		Motor.B.stop();
		Delay.msDelay(500); //wait
		Motor.B.forward(); //look right
		Delay.msDelay(150);
		Motor.B.stop();
		Delay.msDelay(500); //wait
		
		Motor.B.close();
		
		}
	

}
