import java.util.Random;

public class MyThread extends Thread {
    int coP = 0;
    int NcoP = 0;
    static int runTimes;
    public void run(){
        int val1;
        int val2;
        Random rand = new Random();

        for (int i = 0; i < runTimes; i++){
            val1 = rand.nextInt(0,Integer.MAX_VALUE);
            val2 = rand.nextInt(0,Integer.MAX_VALUE);
            if (GCD(val1, val2) == 1) coP++;
            else NcoP++;
        }
    }
    public int GCD(int a, int b){
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }
}
