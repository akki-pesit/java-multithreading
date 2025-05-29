import org.akshay.problems.OddEven;
import org.junit.jupiter.api.Test;

public class ProblemsTest {

    @Test
    void oddEvenThreadTest() throws InterruptedException {
        OddEven oe = new OddEven();
        oe.printOddEven();
        Thread.sleep(50); // Test thread to be suspended for 50ms
    }
}
