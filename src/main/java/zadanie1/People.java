package zadanie1;

import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class People {

    public static void main(String[] args) {


        InputStream is = People.class.getResourceAsStream("PersonalData.txt");
        Scanner scanner = new Scanner(is);


        Collection<Person> people = new LinkedList<>();
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            System.out.println(line);

            String[] data = line.split(";");
            //split  - przyjmuje wyraznie regulerne ktore rozdziela stringa

            String name = data[0];
            String surname = data[1];
            float height = Float.parseFloat(data[2]);
            float weight = Float.parseFloat(data[3]);


            Person person = new Person(name, surname, height, weight);

            people.add(person);
            System.out.println(person.toString());


        }
        System.out.println("Min height" + findByHeight(people));

    }


    private static Collection<Person> findByHeight(Collection<Person> people) {

        if (people.isEmpty()) {
            return Collections.emptyList();

        }

        Collection<Person> min = new LinkedList<>();
        min.add( people.iterator().next());


        for (Person person : people) {
            if (person.getHeight() < min.iterator().next().getHeight()) {
                min.clear();
                min.add(person);
            }else if (person.getHeight()==min.iterator().next().getHeight()){
                min.add(person);
            }
        }

        return min;
    }

//    private static Person findMaxHeight (Collection<Person>people){
//
//    }

}
