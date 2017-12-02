import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public interface Set<Type> {
    void add(Type a);
    void remove(Type a);
    boolean contain(Type a);
    Type find(Predicate<Type> predicate);
    <ResultType> Set<ResultType> map(Mapper<Type, ResultType> mapper);

    void foreach(Consumer<Type> consumer);

    int size();
}
