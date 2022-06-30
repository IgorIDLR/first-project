package calculator;

import java.util.Scanner;

public class StepTracker {
	int[][] days;
	String[] month = {"Январь","Февраль","Март","Апрель","Май","Июнь","Июль","Август","Сентябрь","Октюбрь","Ноябрь","Декабрь"};
	int step = 0;
	int intentionStep = 10;
	
	StepTracker() {
		days = new int[12][];
		days[0] = new int [31];
		days[1] = new int [28];
		days[2] = new int [31];
		days[3] = new int [30];
		days[4] = new int [31];
		days[5] = new int [30];
		days[6] = new int [31];
		days[7] = new int [31];
		days[8] = new int [30];
		days[9] = new int [31];
		days[10] = new int [30];
		days[11] = new int [31];
	}
	Scanner sc = new Scanner(System.in);
	
	void stepMenu() {
		
		System.out.print("Какой месяц? ");
		int command = sc.nextInt();
		
		if(command > 0 && command <= 12) {
			System.out.print(month[command-1]+ ".");
			
			System.out.print("Какой день?: ");
			int comDays = sc.nextInt();
			if(comDays > 0 && comDays <= days[command-1].length) {
				System.out.println("Введите количество шагов: ");
				this.step = sc.nextInt();
				if (step >= 0) {
				days[command - 1][comDays - 1] += step;
				System.out.println("Данные сохранены!");
				}
			}
		}
	}
	void statistics (int Month) {
		
		System.out.println(month[Month-1]);
		for(int i = 0; i < days[Month-1].length; i++) {	
			System.out.print((i+1) + " День: " + days[Month-1][i] + ", ");
			}
		System.out.println();
		}
	
	 int sumStepMonth (int Month) {
		int sum = 0;
		for(int i = 0; i < days[Month-1].length; i++) {	
			sum += days[Month-1][i];
		}
		return sum;
	}
	
	int maxStep (int Month) {
		int max = 0;
		for (int i = 0; i < days[Month-1].length; i++) {
			if (days[Month-1][i] > max) {
				max = days[Month-1][i];
			}
		}
		return max;
	}
	
	int avgStep (int sum, int Month) {
		return Math.round(sum/days[Month-1].length);
	}
	
	int purpose() {
		System.out.println("На данный момент цель составляет: " + intentionStep + " шагов в день");
		int newPurpose = sc.nextInt();
		if (newPurpose >= 0) {
			intentionStep += newPurpose;
		}
		return intentionStep;
	}
	
	int bestLengtht(int month) {
		int series = 0;
		int result = 0;
		for(int i = 0; i < days[month-1].length; i++) {
			if(days[month-1][i] >= intentionStep) {
				series++;
				if(result < series) {
					result = series;
				}
			} else {
				series = 0;
			}
		} if (result == 1) {
		return result = 0;
		} else {
			return result;
		}
	}
} 

