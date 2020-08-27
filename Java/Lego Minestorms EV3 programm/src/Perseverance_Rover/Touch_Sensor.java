package Perseverance_Rover;

import lejos.robotics.SampleProvider;
import lejos.robotics.filter.AbstractFilter;

public class Touch_Sensor extends AbstractFilter{
	
	float[] sample;
	
	public Touch_Sensor(SampleProvider source) {
		super(source);
		sample = new float[sampleSize];
	}

	public static void main(String[] args) {
		
		
	}
	
	public boolean pressed() {
		super.fetchSample(sample, 0);
		if (sample[0] == 0) {
			return false;
		} 
		else {
			return true;
		}
	}
}
