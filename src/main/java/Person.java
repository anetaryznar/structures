import java.util.Objects;

public class Person {
    private String name;
    private String surname;
    private String idNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(idNumber, person.idNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNumber);
    }
}
