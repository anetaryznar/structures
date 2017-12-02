import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class HashSet<Type> implements Set<Type> {
    private LinkedList<Type> list = new LinkedList<>();

    @Override
    public void add(Type a) {
        if(!contain(a)) {
            list.add(a);
        }
    }

    @Override
    public void remove(Type a) {
        for(int i = 0;i < list.size();++i) {
            if(list.get(i).equals(a)) {
                list.remove(i);
                return;
            }
        }
    }

    @Override
    public boolean contain(Type a) {
        for(int i = 0;i < list.size();++i) {
            if(list.get(i).equals(a)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public Type find(Predicate<Type> predicate) {
        for(int i = 0;i < list.size();++i) {
            if(predicate.test(list.get(i))) {
                return list.get(i);
            }
        }

        return null;
    }

    @Override
    public <ResultType> Set<ResultType> map(Mapper<Type, ResultType> mapper) {
        Set<ResultType> resultSet = new HashSet<>();

        for(int i = 0;i < list.size();++i) {
            ResultType result = mapper.map(list.get(i));
            resultSet.add(result);
        }

        return resultSet;
    }

    @Override
    public void foreach(Consumer<Type> consumer) {
        for(int i = 0;i < list.size();++i) {
            consumer.accept(list.get(i));
        }
    }

    @Override
    public int size() {
        return list.size();
    }


}
