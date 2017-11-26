import java.util.Objects;
import java.util.Set;
import java.util.function.BiConsumer;

public class HashMap<Key, Value> implements Map<Key, Value> {
    private HashSet<Pair<Key, Value>> values = new HashSet<>();

    @Override
    public void put(Key key, Value value) {
        values.add(new Pair<>(key, value));
    }

    @Override
    public Value remove(Key key) {
        return null;
    }

    @Override
    public Value get(Key key) {
        Pair<Key, Value> pair = values.find(p -> key.equals(p.key));

        if(pair == null) {
            return null;
        }

        return pair.value;
    }

    @Override
    public int size() {
        return values.size();
    }

    @Override
    public void foreach(BiConsumer<Key, Value> consumer) {
        values.foreach(pair -> consumer.accept(pair.key, pair.value));
    }

    private static class Pair<Key, Value> {
        private Key key;
        private Value value;

        public Pair(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(key, pair.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }
    }
}
