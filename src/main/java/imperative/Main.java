package imperative;

import java.util.ArrayList;
import java.util.List;
import static imperative.Main.Gender.FEMALE;
import static imperative.Main.Gender.MALE;

public class Main {
    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("Zyra Joy Maquiniana", FEMALE),
            new Person("Peter John Arao", MALE),
            new Person("Divine Biscocho", FEMALE),
            new Person("John Mark Orosco", MALE),
            new Person("Crystalyn Emano", FEMALE),
            new Person("Izyl Clemeña", FEMALE)
        );

        System.out.println("// Imperative approach");
        // Imperative approach

        List<Person> females = new ArrayList<>();
        List<Person> males = new ArrayList<>();

        System.out.println("// Adding females in the list");
        // Adding females in the list
        for (Person person : people) {
            if (person.gender.equals(FEMALE)) {
                females.add(person);
            }
        }
        // Printing females in the list
        for (Person female : females) {
            System.out.println(female);
        }
        System.out.println("// Adding males in the list");
        // Adding females in the list
        for (Person person : people) {
            if (person.gender.equals(MALE)) {
                males.add(person);
            }
        }
        // Printing males in the list
        for (Person male : males) {
            System.out.println(male);
        }

        System.out.println("// Declarative approach");
        // Declarative approach

        System.out.println("// Printing females from the list");
        // Printing females from the list
        people.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .toList()
                .forEach(System.out::println);

        System.out.println("// Printing males from the list");
        // Printing males from the list

        people.stream()
                .filter(person -> MALE.equals(person.gender))
                .toList()
                .forEach(System.out::println);
    }
    static final class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }
    enum Gender {
        MALE, FEMALE
    }
}
