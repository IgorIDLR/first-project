package calculator;

import java.util.Scanner;

public class Сalculator {

public static void main(String[] args) {
		
		Menu menu = new Menu();
		StepTracker step = new StepTracker();
		Converter converter = new Converter();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Здравствуйте!");
		
		while(true) {
			
			menu.starMenu();
			
			int command = sc.nextInt();
			
			if (command == 1) {
				step.stepMenu();
				
			} else if (command == 2) {
				System.out.println("За какой месяц?");
				int month = sc.nextInt();
				step.statistics(month);
				System.out.println("Общее количество шагов: " + step.sumStepMonth(month));
				System.out.println("Максимальное пройденное количество шагов в месяце: " + step.maxStep(month));
				System.out.println("Среднее количество шагов: " + step.avgStep(step.sumStepMonth(month) ,month));
				System.out.println("Пройденная дистанция (в км): " + converter.lengthStepKm(step.sumStepMonth(month)));
				System.out.println("Количество сожжённых килокалорий: " + converter.burnCalories(step.sumStepMonth(month)));
				System.out.println("Лучшая серия из: " + step.bestLengtht(month) + " дней");
				
			} else if (command == 3) {
				System.out.println("Изменение целевого количества шагов: " + step.purpose());
				
			} else if (command == 0) {
				break;
				
			} else {
				System.out.println("Такой команды нет");
			}
		}
		
	}

}

