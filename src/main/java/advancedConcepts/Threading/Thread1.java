package src.main.java.advancedConcepts.Threading;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

/**
 * extending thread class
 */
public class Thread1 extends Thread{

    MathProblem mp;
    Logger log = Logger.getLogger(Thread1.class.getName());

    Thread1(MathProblem mp)
    {
        this.mp = mp;
    }
    @Override
    public void run()
    {
        for(int i=0;i<20;i=i+2)
        {
            //log.info("Thread 1 data : " + i);
            mp.calculate(i);

        }
    }
}
