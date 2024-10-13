package src.main.java.advancedConcepts.Threading;

import java.util.logging.Logger;

/**
 * implementing runnable interface
 */
public class Thread2 implements Runnable{

    MathProblem mp;
    Logger log = Logger.getLogger(Thread2.class.getName());

    Thread2(MathProblem mp) {
        this.mp = mp;
    }

    @Override
    public void run()
    {
        for(int i=1;i<20;i=i+2)
        {
            //log.info("Thread 2 data : "+ i);
            mp.calculate(i);
        }
    }
}
