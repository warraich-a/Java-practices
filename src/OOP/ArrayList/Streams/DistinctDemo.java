package OOP.ArrayList.Streams;

import OOP.models.Fruit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DistinctDemo {
    public static void main(String[] args) {

        // List with duplicate entries
        List<String> names = Arrays.asList("Anas", "Ali", "Zara", "Ahmad", "Anas", "Ali", "Anas");

        System.out.println("Original list: " + names);

        // Use distinct() to filter out duplicate values
        // distinct() relies on equals() to identify duplicates
        List<String> distinct = names.stream()
                .distinct() // Removes all duplicates, keeps only the first occurrence
                .toList();  // Java 16+ collector

        System.out.println("List with duplicates removed: " + distinct);

        distinctWithCustomObjects();
    }

    public static void distinctWithCustomObjects() {
        // Creating custom Fruit objects
        Fruit fruit1 = new Fruit("Apple", "Green");
        Fruit fruit5 = new Fruit("Apple", "Green"); // Duplicate by value (same name + color)
        Fruit fruit2 = new Fruit("Banana", "Yellow");
        Fruit fruit3 = new Fruit("Strawberry", "Red");
        Fruit fruit4 = new Fruit("Mango", "Orange");

        // Add all fruits to a list
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(fruit1);
        fruits.add(fruit5); // This is the duplicate that we expect to remove
        fruits.add(fruit2);
        fruits.add(fruit3);
        fruits.add(fruit4);

        // Print original list (with duplicates)
        System.out.println("Original fruit objects: " + fruits);

        // Use Stream.distinct() to remove duplicates
        // ⚠️ This only works correctly because we've overridden both equals() and hashCode() in the Fruit class
        //
        // distinct() compares objects using: (both are these present in Fruits class)
        //   1. equals() → checks if the values match
        //   2. hashCode() → checks if the objects are likely equal before calling equals()
        //
        // Without a proper hashCode(), distinct() cannot detect duplicates in custom objects
        List<Fruit> distinctFruits = fruits.stream()
                .distinct()   // Removes duplicates based on value
                .toList();    // Collects into a new List

        // Print the final list without duplicates
        System.out.println("Distinct fruit list: " + distinctFruits);

    }
}
