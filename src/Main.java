import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<MyThread> threads = new ArrayList<>();
        System.out.println("How many threads to dedicate: ");
        int numberOfThreads = input.nextInt();
        System.out.println("How many times should each thread run: ");
        int runTimes = input.nextInt();
        MyThread.runTimes = runTimes;

        for (int thread = 0; thread < numberOfThreads; thread++) {
            threads.add(new MyThread());
        }
        for (MyThread thread : threads){
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("hi");
                e.printStackTrace();
            }
        }
        int coP = 0;
        int NcoP = 0;
        for (MyThread thread : threads){
            coP += thread.coP;
            NcoP += thread.NcoP;
        }
        double probability = (double) coP / (coP + NcoP);
        System.out.println(("Times run: " + (NcoP + coP)));
        System.out.println("Estimation of PI = " + (Math.sqrt(6/probability)));

    }
}
