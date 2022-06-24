package calculator;

public class Converter {
	
	final double stepLength = 0.00075;
	final double stepCalories = 0.05;
	
	double lengthStepKm (int sumStep) {
		return (double)(sumStep * stepLength);
		
	}
	 double burnCalories(int sumStep) {
		 return (double)(sumStep * stepCalories);
	 }
}
