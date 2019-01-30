package com.ozkaraca.java_8_feature;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class PotusTest {

    private List<Wife> wifesOfTrump = Arrays.asList(
            new Wife("Melenia", Arrays.asList(new Child("Berron", 12))),
            new Wife("Marla", Arrays.asList(new Child("John", 16), new Child("Johnathon", 22))),
            new Wife("Ivana", Arrays.asList(
                    new Child("Ivanca", 36),
                    new Child("eric", 34),
                    new Child("Jr donald", 10)))
    );

    List<Potus> potuses = Arrays.asList(
            new Potus("Donald", "Trump", 2016, "Republication", wifesOfTrump),
            new Potus("Barack", "Obama", 2012, "Democration"),
            new Potus("Barack", "Obama", 2008, "Democration"),
            new Potus("George", "Bush", 2004, "Republication"),
            new Potus("George", "Bush", 2000, "Republication"),
            new Potus("Bill", "Clinton", 1996, "Democration"),
            new Potus("Bill", "Clinton", 1992, "Democration")
    );


    @Test
    public void filterMap() {
        potuses.stream()
                .filter(potus -> potus.getElectionYear() > 2000)
                .map(Potus::getLastName)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    @Test
    public void filterMapLimitDistinctCollecct() {
        potuses.stream()
                .filter(potus -> potus.getElectionYear() > 2000)
                .map(Potus::getLastName)
                .distinct()
                .limit(3)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    @Test
    public void flatmapSimple() {
        Potus trump = potuses.get(0);
        List<Child> children = trump.getWifes().stream().flatMap(w -> w.getChildren().stream()).collect(Collectors.toList());
        children.forEach(System.out::println);
    }

    @Test
    public void flatmap_sort_collect() {
        Potus trump = potuses.get(0);
        List<Child> kids = trump.getWifes()
                .stream()
                .flatMap(wife -> wife.getChildren().stream())
                .sorted(Comparator.comparing(Child::getAge))
                .collect(Collectors.toList());
        System.out.println(kids);
    }

    @Test
    public void flatmap_sort() {
        Potus trump = potuses.get(0);
        List<Child> kidsSort = trump.getWifes()
                .stream()
                .flatMap(wife -> wife.getChildren().stream())
                .sorted(Comparator.comparing(Child::getAge))
                .collect(Collectors.toList());
        kidsSort.sort((Child o1, Child o2) -> o1.getAge() - o2.getAge());
        System.out.println("new sort= " + kidsSort);
    }


    @Test
    public void find_and_match() {
        Potus trump = potuses.get(0);
        Optional<Wife> firstWife = trump.getWifes()
                .stream()
                .filter(wife -> wife.getChildren().size() > 2)
                .findFirst();
        System.out.println("first wife-- " + firstWife);
    }

    @Test
    public void simpleFilter() {
        Potus trump = potuses.get(0);
        List<Wife> firstWife = trump.getWifes().stream()
                .filter(wife -> wife.getChildren().size() > 1).collect(Collectors.toList());

        firstWife.forEach(w -> System.out.println("more than 1 children-- " + w));
    }


    @Test
    public void find_and_match_() {
        Potus trump = potuses.get(0);

        Predicate<Wife> more2Children = wife -> wife.getChildren().size() > 2;

        Optional<Wife> firstWife = trump.getWifes()
                .stream()
                .filter(more2Children)
                .findFirst();
        System.out.println("first wife-- " + firstWife);

        boolean everyWifeMore2Child = wifesOfTrump.stream().allMatch(more2Children);
        System.out.println("everyWifeMore2Child " + everyWifeMore2Child);

        boolean anyWifeMore2Child = wifesOfTrump.stream().anyMatch(more2Children);
        System.out.println("anyWifeMore2Child " + anyWifeMore2Child);

        boolean notASingleWifeMore2Child = wifesOfTrump.stream().noneMatch(more2Children);
        System.out.println("notASingleWifeMore2Child " + notASingleWifeMore2Child);

    }

    @Test
    public void paralel_streams() {
        Potus trump = potuses.get(0);
        trump.getWifes()
                .stream()
                .filter(wife -> wife.getName().startsWith("M"))
                .findAny()
                .ifPresent(wife -> System.out.println(wife.getName()));
    }

    @Test
    public void paralel_streams2() {
        Potus trump = potuses.get(0);
        trump.getWifes().stream()
                .filter(wife -> wife.getName().startsWith("M"))
                .forEach(System.out::print);
    }

    @Test
    public void flatmap_usage() {

        Potus trump = potuses.get(0);

        List<List<Child>> flatmap_less = trump.getWifes().stream().map(c -> c.getChildren()).collect(Collectors.toList());

        List<Child> existingFlatmap = trump.getWifes().stream().map(c -> c.getChildren()).flatMap(c -> c.stream()).collect(Collectors.toList());

        existingFlatmap.forEach(x -> System.out.println(x));

    }

    @Test
    public void convertStringToUpperCaseStreams() {
        List<String> collected = Stream.of("a", "b", "hello") // Stream of String
                .map(String::toUpperCase) // Returns a stream consisting of the results of applying the given function to the elements of this stream.
                .collect(Collectors.toList());

        collected.forEach(s -> System.out.println(s));
    }

    @Test
    public void prediceteFunc() {

        Potus trump = potuses.get(0);

        Predicate<Child> childAgeBigThan20 = child -> child.getAge() > 20;

        List<Child> childAgeBiggerThan20 = trump.getWifes().stream().flatMap(wife -> wife.getChildren().stream())
                .filter(childAgeBigThan20).collect(Collectors.toList());

        System.out.println("childAgeBiggerThan20-- " + childAgeBiggerThan20);

    }
}
