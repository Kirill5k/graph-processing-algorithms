package graphs.datatypes.queues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IndexedPriorityQueueTest {
    private IndexedPriorityQueue<Integer, Double> queue;

    @BeforeEach
    void setUp() {
        queue = new IndexedPriorityQueue<>();
    }

    @Test
    void test() {
        assertThrows(UnsupportedOperationException.class, () -> queue.poll(), "queue is empty");
        assertThat(queue.isEmpty()).isTrue();

        queue.put(1, 100.0);
        queue.put(2, 100.0);
        queue.put(3, 50.0);
        queue.put(4, 75.0);

        assertThat(queue.isEmpty()).isFalse();

        assertThat(queue.poll()).isEqualTo(3);
        assertThat(queue.poll()).isEqualTo(4);
        assertThat(queue.poll()).isEqualTo(1);
        assertThat(queue.poll()).isEqualTo(2);

        assertThat(queue.isEmpty()).isTrue();
    }
}