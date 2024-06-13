package org.example.functional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExercises {
    public static void main(String[] args) {
        List<Citizen> citizens = List.of(
                new Citizen("Mike", 28, "student", false),
                new Citizen("Amanda", 35, "artist", true),
                new Citizen("Nick", 24, "designer", true),
                new Citizen("Pete", 45, "artist", false)
        );

        List<Citizen> result = citizens.stream().filter(citizen -> citizen.age() > 40).toList();
        System.out.println(result);

        List<String> names = citizens.stream().map(Citizen::name).toList();
        System.out.println(names);

        System.out.println(citizens.stream().filter(Citizen::married).count());

        System.out.println(citizens.stream().allMatch(citizen -> citizen.profession().equals("artist")));
        System.out.println(citizens.stream().anyMatch(citizen -> citizen.profession().equals("artist")));

        System.out.println(citizens.stream().mapToInt(Citizen::age).average().orElse(0));

        System.out.println(citizens.stream().map(Citizen::profession).reduce((accumulator, iterator) -> accumulator + " " + iterator));

        System.out.println(citizens.stream().sorted(Comparator.comparingInt(Citizen::age).reversed()).toList());

        System.out.println(citizens
                .stream()
                .sorted(Comparator.comparing(Citizen::profession).thenComparingInt(citizen -> -citizen.age()))
                .toList());

        Stream<String> stringStream = citizens.stream().map(citizen -> {
            System.out.println(citizen.name());
            return citizen.name();
        });
        System.out.println("After intermediate and before final operation");
        System.out.println(stringStream.toList());
    }
}

record Citizen(String name, int age, String profession, boolean married) {

}
