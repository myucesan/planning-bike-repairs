import java.util.Arrays;

public class Main {
//    public static void main(String[] args) {
//        System.out.println("Hello world!");
//    }

    public static int fixMyBikesPlease(int n, int[] starttimes, int[] durations) {
        int employeesNeeded = 0;
        Bike[] bikes = new Bike[n + 1];
        for (int i = 1; i <= n; i++) {
            bikes[i] = new Bike(starttimes[i], durations[i]);
        }
        Arrays.sort(bikes, 1 , n + 1); // earliest finishing time first
        for (int i = 2; i <= n; i++) {
            int count =  1;
            for (int j = 1; j < i; j++) {
                if (bikes[j].getFinishingTime() > bikes[i].getStartTime()) {
                    count++;
                }
            }
            if (count > employeesNeeded){
                employeesNeeded = count;
            }
        }


        return employeesNeeded;
    }
}

class Bike implements Comparable<Bike> {
    int startTime;
    int duration;
    int finishingTime;

    public Bike(int startTime, int duration) {
        this.startTime = startTime;
        this.duration = duration;
        this.finishingTime = startTime + duration;
    }

    public int getStartTime() {
        return startTime;
    }


    public int getFinishingTime() {
        return finishingTime;
    }

    @Override
    public int compareTo(Bike b) {
        return Integer.compare(this.getStartTime(), b.getStartTime());
    }
}