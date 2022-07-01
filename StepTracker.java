import java.util.Scanner;
public class StepTracker {
    MonthDays[] month;
    int sum = 0;
    int intentionStep = 10_000;
    Scanner sc = new Scanner(System.in);
    StepTracker() {
        month = new MonthDays[12];
        for(int i = 0; i < month.length; i++) {
            month[i] = new MonthDays();
        }
    }
    public void addStep () {
        System.out.print("Месяц: ");
        int mon = sc.nextInt();
        if(mon > 0 && mon <= 12) {
            System.out.print("День: ");
            int day = sc.nextInt();
            if (day >= 1 && day <= 30) {
                System.out.print("Шаги: ");
                int step = sc.nextInt();
                if (step > 0) {
                    month[mon-1].days[day-1] += step;
                    return;
                }
            }
        }
    }
    void stat (int a) {
        for(int i = 0; i < month[a-1].days.length; i++) {
            System.out.print((i+1) + ". День: " + month[a-1].days[i] + "; ");
        }
        System.out.println();
    }
    int sumStepMonth (int a) {
        int sum = 0;
        for(int i = 0; i < month[a-1].days.length; i++) {
            sum += month[a-1].days[i];
        }
        return sum;
    }
    int maxStepMonth (int a) {
        int max = 0;
        for(int i = 0; i < month[a-1].days.length; i++) {
            if(max < month[a-1].days[i]) {
                max = month[a-1].days[i];
            }
        }
        return max;
    }
    int avgStepMonth (int a) {
        return sumStepMonth(a)/month[a-1].days.length;
    }

    int seriesStep(int a) {
        int series = 0;
        int seriesMax = 0;
        for(int i : month[a-1].days) {
            if (month[a-1].days[i] >= intentionStep) {
                series++;
                if (seriesMax < series) {
                    seriesMax = series;
                } else {
                    series = 0;
                }
            }
        }
        if (seriesMax == 1) return 0;
        else return seriesMax;
    }
    int purpose () {
        System.out.println("На данный момент цель составляет: " + intentionStep + " шагов в день");
        System.out.print("Изменение целевого количества шагов на: ");
        int newPurpose = sc.nextInt();
        if(newPurpose >= 0) {
            intentionStep += newPurpose;
        }
        return intentionStep;
    }
}
class MonthDays {
    int[] days = new int[30];
}