package OOP.ArrayList.Streams;

import OOP.models.Fruit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingDemo {
    public static void main(String[] args){

        // ✅ Create Fruit objects with name and color
        Fruit fruit1 = new Fruit("Apple", "Zet");
        Fruit fruit5 = new Fruit("Apple", "Red");
        Fruit fruit2 = new Fruit("Banana", "Yellow");
        Fruit fruit3 = new Fruit("Strawberry", "Red");
        Fruit fruit4 = new Fruit("Mango", "Orange");

        List<Fruit> fruits = new ArrayList<>();
        fruits.add(fruit1);
        fruits.add(fruit2);
        fruits.add(fruit3);
        fruits.add(fruit4);
        fruits.add(fruit5);

        System.out.println("Original fruit objects: " + fruits);

        // ✅ Group fruits by their color using Collectors.groupingBy
        //
        // Result: Map where
        // - Key = fruit color
        // - Value = list of all fruits with that color
        //
        // e.g. "Red" → [Apple(Red), Strawberry(Red)]
        Map<String, List<Fruit>> fruitsGroupedByColor = fruits.stream()
                .collect(Collectors.groupingBy(fruit -> fruit.color));

        // Print each group nicely
        System.out.println("Grouped fruits by color:");
        fruitsGroupedByColor.forEach((color, fruitList) -> {
            System.out.println(color + ": " + fruitList);
        });

        System.out.println("Grouping with count " );

        Map<String, Long> colorCounts = fruits.stream()
                                        .collect(Collectors.groupingBy(
                                                fruit -> fruit.name,
                                                Collectors.counting()
                                        ));

        System.out.println("colorCounts = " + colorCounts);

    }
}
