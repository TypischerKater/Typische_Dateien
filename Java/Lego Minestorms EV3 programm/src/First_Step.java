import lejos.hardware.BrickFinder;
import lejos.hardware.lcd.GraphicsLCD;
import lejos.utility.Delay;

public class First_Step {

	public static void main(String[] args) {
		GraphicsLCD g = BrickFinder.getDefault().getGraphicsLCD();
		
		g.drawString("Hello World", 0, 0, GraphicsLCD.VCENTER |
				GraphicsLCD.LEFT);
		
		Delay.msDelay(5000);

	}

}
