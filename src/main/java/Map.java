import java.util.function.BiConsumer;

public interface Map<Key, Value> {
    void put(Key key, Value value);
    Value remove(Key key);
    Value get(Key key);
    int size();
    void foreach(BiConsumer<Key, Value> consumer);
}
