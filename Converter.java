public class Converter {
    final double STEP_LENGTH = 0.00075;
    final double STEP_CALORIES = 0.05;

    double lengthStepKm(int sumStep) {
        return (double) (sumStep * STEP_LENGTH);
    }
    double burnCalories(int sumStep) {
        return (double) (sumStep * STEP_CALORIES);
    }
}
