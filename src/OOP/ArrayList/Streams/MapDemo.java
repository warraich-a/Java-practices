package OOP.ArrayList.Streams;

import OOP.models.Fruit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapDemo {

    public static void main(String[] args) {

        // Simple list of names
        List<String> names = Arrays.asList("Anas", "Ali", "Zara", "Ahmad", "Anas");
        System.out.println("Original list: " + names);

        // Using Stream.map() to convert all names to uppercase
        // map() applies the given function (toUpperCase) to each element in the stream
        List<String> newMappedList = names.stream()
                .map(n -> n.toUpperCase())    // could also use String::toUpperCase
                .toList();                    // Collect results into a new List (Java 16+)

        System.out.println("Mapped list (uppercase): " + newMappedList);

        FruitExampleWithStreams();  // Call the method that handles custom objects
    }

    // 💡 Streams are non-destructive: original data remains unchanged unless explicitly modified or collected

    public static void FruitExampleWithStreams() {
        // Creating custom Fruit objects
        Fruit fruit1 = new Fruit("Apple", "Green");
        Fruit fruit5 = new Fruit("Apple", "Red");
        Fruit fruit2 = new Fruit("Banana", "Yellow");
        Fruit fruit3 = new Fruit("Strawberry", "Red");
        Fruit fruit4 = new Fruit("Mango", "Orange");

        // Add all fruits to a list
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(fruit1);
        fruits.add(fruit2);
        fruits.add(fruit3);
        fruits.add(fruit4);
        fruits.add(fruit5);

        System.out.println("Original fruit objects: " + fruits);

        // 🔹 Extract just the names of all fruits using map()
        List<String> mapWithOnlyFruitName = fruits.stream()
                .map(f -> f.name)  // Access the 'name' field of each Fruit
                .toList();         // Collect results

        System.out.println("Mapped fruit names: " + mapWithOnlyFruitName);

        // 🔹 Extract just the colors of all fruits
        List<String> mapWithOnlyFruitColor = fruits.stream()
                .map(f -> f.color) // Access the 'color' field
                .toList();

        System.out.println("Mapped fruit colors: " + mapWithOnlyFruitColor);
    }
}
