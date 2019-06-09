package graphs.datatypes.queues;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class IndexedPriorityQueue<T, V extends Comparable<V>> {
    private final Map<T, V> queue;

    public IndexedPriorityQueue() {
        queue = new HashMap<>();
    }

    public void put(T index, V value) {
        queue.put(index, value);
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public T poll() {
        T index = queue.entrySet().stream()
                .min(Comparator.comparing((Map.Entry::getValue)))
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new UnsupportedOperationException("queue is empty"));

        queue.remove(index);
        return index;
    }
}
