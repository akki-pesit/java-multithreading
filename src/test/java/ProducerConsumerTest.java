import org.akshay.producerconsumer.ProducerConsumerExample;
import org.junit.jupiter.api.Test;

public class ProducerConsumerTest {

    @Test
    void producerConsumerTest() throws InterruptedException {
        ProducerConsumerExample pc = new ProducerConsumerExample();
        pc.start();
        Thread.sleep(20000); // Test thread to be suspended for 20 sec
    }
}
