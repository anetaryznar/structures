@FunctionalInterface
public interface Mapper<In, Out> {
    Out map(In in);
}
