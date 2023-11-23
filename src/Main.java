import java.util.Arrays;
import java.util.Collections;

public class Main {
//    public static void main(String[] args) {
//        System.out.println("Hello world!");
//    }

    public static int fixMyBikesPlease(int n, int[] starttimes, int[] durations) {
        int employeesNeeded = 0;
        Bike[] bikes = new Bike[n + 1]; // n + 1 because zero-indexed

        for (int i = 1; i <= n; i++) {
            int finishingTime = starttimes[i] + durations[i];
            bikes[i] = new Bike(starttimes[i], durations[i]);
        }
        Arrays.sort(bikes, 1, n + 1); // earliest finishing time first

//        for (Bike b : bikes) {
//            if (b == null) continue;
//            System.out.println(b.getFinishingTime());
//        } used to verify correct ordering
        for (int i = 1; i < n; i++) {
            if (bikes[i].getFinishingTime() > bikes[i+1].getFinishingTime()) {
                employeesNeeded++;
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

    public int getDuration() {
        return duration;
    }

    public int getFinishingTime() {
        return finishingTime;
    }

    @Override
    public int compareTo(Bike b) {
        return Integer.compare(this.startTime, b.startTime);
    }
}