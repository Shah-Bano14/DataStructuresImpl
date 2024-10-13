package src.main.java.advancedConcepts.Threading;

public class MathProblem {
    int newNo = 1;

    /**
     * We can either synchronise the method or the block of code or the critical section
     * @param n
     */
    synchronized public void calculate(int n) {

        synchronized (this) {
            if (n % 2 == 0) {
                newNo++;
                System.out.println(n + " " + newNo);
            } else if (n % 2 != 0) {
                newNo += 2;
                System.out.println(n + " " + newNo);
            }
        }
    }
}
