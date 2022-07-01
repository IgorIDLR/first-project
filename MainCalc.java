import java.util.Scanner;

public class MainCalc {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Здравствуйте!" + "\n");
        StepTracker step = new StepTracker();
        Converter converter = new Converter();

        while(true) {
            Menu.startMenu();

            int point = sc.nextInt();
            if (point == 1) {
                step.addStep();
            } else if (point == 2) {
                System.out.print("Месяц: ");
                int mon = sc.nextInt();
                step.stat(mon);
                System.out.println("Общее количество шагов за месяц: " + step.sumStepMonth(mon));
                System.out.println("Максимальное пройденное количество шагов в месяце: " + step.maxStepMonth(mon));
                System.out.println("Среднее количество шагов: " + step.avgStepMonth(mon));
                System.out.printf("%s %.3f\n","Пройденная дистанция (в км): ",
                        converter.lengthStepKm(step.sumStepMonth(mon)));
                System.out.printf("%s %.0f\n","Количество сожжённых килокалорий: ",
                        converter.burnCalories(step.sumStepMonth(mon)));
                System.out.println("Лучшая серия: " + step.seriesStep(mon));
            } else if (point == 3) {
                System.out.println("Теперь целевое количества шагов составляет: " + step.purpose());
            } else if (point == 4) {
                return;
            } else {
                System.out.println("Такой команды нет");
            }
        }
    }
}
