package src.main.java.advancedConcepts.Threading;

public class MainClass {

    public static void main(String[] args) {

        // we notice that each thread run concurrently and there is no specific sequence
        // to maintain order for critical section we use synchronisation or locking mechanism
        MathProblem mp = new MathProblem();
        Thread1 t1 = new Thread1(mp);
        Thread t2 = new Thread(new Thread2(mp));
        t1.start();
        t2.start();
    }
}
