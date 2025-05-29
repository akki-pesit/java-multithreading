import org.akshay.threadruns.JoinExample;
import org.akshay.threadruns.MonitorLockExample;
import org.akshay.threadruns.SimpleThreadExecution;
import org.akshay.threadruns.WaitExample;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(ExecutionMode.SAME_THREAD)
public class TestConcepts {
    @BeforeEach
    void mainStarted() {
        System.out.println("Main program started: " + Thread.currentThread().getName());
    }

    @AfterEach
    void mainEnded() {
        System.out.println("Main program finished: " + Thread.currentThread().getName());
        System.out.println("------------------------------------------------------------------\n");
    }

    @Test
    void testSimpleThread() {
        SimpleThreadExecution simpleThreadExecution = new SimpleThreadExecution();
        simpleThreadExecution.runThreads();
    }

    @Test
    void testJoinExample() throws InterruptedException {
        JoinExample joinExample = new JoinExample();
        joinExample.runThreads();
    }

    @Test
    void testWaitExample() throws InterruptedException {
        WaitExample waitExample = new WaitExample();
        waitExample.runThreads();
    }

    @Test
    void testMonitorLockExample() throws InterruptedException {
        MonitorLockExample monitorLockExample = new MonitorLockExample();
        monitorLockExample.runThread();
    }
}
