package OOP.ArrayList.Streams;

import OOP.models.Fruit;

import java.util.*;
import java.util.stream.Collectors;

public class SortedDemo {
    public static void main(String[] args) {
        // Original list of names (unsorted, includes duplicate "Anas")
        List<String> names = Arrays.asList("Anas", "Ali", "Zara", "Ahmad", "Anas");

        System.out.println("Original names: " + names);

        // Use Stream.sorted() to sort in natural (lexicographic) order
        //
        // - sorted() without arguments sorts using the default ordering
        // - For String: it's alphabetical (A → Z)
        // - This does not modify the original list (non-destructive)
        //
        List<String> namesSorted = names.stream()
                .sorted()     // Intermediate operation
                .toList();    // Terminal operation (Java 16+)

        System.out.println("Sorted names: " + namesSorted);

        customObjectSort();
    }


    static void customObjectSort() {
// Create Fruit objects with name and color (some names are the same)
        Fruit fruit1 = new Fruit("Apple", "Zet");
        Fruit fruit5 = new Fruit("Apple", "Red"); // Same name, different color
        Fruit fruit2 = new Fruit("Banana", "Yellow");
        Fruit fruit3 = new Fruit("Strawberry", "Red");
        Fruit fruit4 = new Fruit("Mango", "Orange");

// Add them to a list
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(fruit1);
        fruits.add(fruit2);
        fruits.add(fruit3);
        fruits.add(fruit4);
        fruits.add(fruit5);

        System.out.println("Original fruit objects: " + fruits);

// Use Stream to sort the fruits
        List<Fruit> sortedFruits = fruits.stream()
                .sorted(
                        Comparator.comparing((Fruit f) -> f.name)       // Primary sort: by name
                                .thenComparing(f -> f.color)          // Secondary sort: by color
                )
                .toList();  // Collect into a new list

        System.out.println("Sorted fruits: " + sortedFruits);

        // Use Stream to sort the fruits
        List<Fruit> sortedDescendingOrderFruits = fruits.stream()
                .sorted(
                        Comparator.comparing((Fruit f) -> f.color).reversed())          // Secondary sort: by color
                .toList();  // Collect into a new list


        System.out.println("sortedDescendingOrderFruits = " + sortedDescendingOrderFruits);

    }


}
