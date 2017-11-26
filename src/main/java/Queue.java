public interface Queue<Type> {
    void add(Type a);
    Type poll();

    boolean isEmpty();
}
