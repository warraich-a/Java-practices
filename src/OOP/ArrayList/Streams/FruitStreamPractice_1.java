package OOP.ArrayList.Streams;

import OOP.models.Fruit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitStreamPractice_1 {
    public static void main(String[] args) {
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

        //Challenge 1, filter fruits with only one color
        System.out.println("Challenge 1, filter fruits with only one color");
        List<Fruit> filterFruitsWithRedColor = fruits.stream().filter(fruit -> fruit.color.equals("Red")).toList();
        System.out.println("filterFruitsWithRedColor = " + filterFruitsWithRedColor);
        System.out.println("--------------------");


        System.out.println("Challenge 2, Create a List<String> that contains only the names of the fruits, no duplicates.");
        List<String> fruitsNames = fruits.stream().map(f -> f.name).distinct().toList();
        System.out.println("fruitsNames = " + fruitsNames);
        System.out.println("--------------------");

        System.out.println("Challenge 3, Create a new list of fruits sorted by color in reverse alphabetical order.");
        List<Fruit> fruitsDescendingOrder = fruits.stream().sorted(Comparator.comparing((Fruit f) -> f.color).reversed()).toList();
        System.out.println("fruitsDescendingOrder = " + fruitsDescendingOrder);
        System.out.println("--------------------");

        System.out.println("Challenge 4, Group all fruits by their color and print out how many fruits there are for each color.");
        Map<String, Long> groupFruitsByColor = fruits.stream()
                                            .collect(Collectors.groupingBy(f -> f.color, Collectors.counting()));

        System.out.println("groupFruitsByColor = " + groupFruitsByColor);

    }
}
