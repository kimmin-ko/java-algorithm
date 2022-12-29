package cracking.interview.stack_and_queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiStackTest {

    @Test
    void test() throws FullStackException {
        MultiStack ms = new MultiStack(3, 5);
        ms.push(0, 1);
        ms.push(0, 2);
        ms.push(0, 3);
        ms.push(0, 4);
        ms.push(0, 5);
        ms.push(0, 6);
        ms.push(0, 7);

        Assertions.assertEquals(ms.pop(0), 7);
        Assertions.assertEquals(ms.pop(0), 6);
        Assertions.assertEquals(ms.pop(0), 5);
        Assertions.assertEquals(ms.pop(0), 4);
        Assertions.assertEquals(ms.pop(0), 3);
        Assertions.assertEquals(ms.pop(0), 2);
        Assertions.assertEquals(ms.pop(0), 1);
    }
}