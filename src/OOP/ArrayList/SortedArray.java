package OOP.ArrayList;

import OOP.models.Fruit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortedArray {

    public static void main(String[] args) {

        // ----------------------------
        // PART 1: ArrayList of Strings
        // ----------------------------

        ArrayList<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Watermelon");
        fruits.add("Banana");

        System.out.println("Before sorting strings: " + fruits);

        // Sorting using natural order (Strings are Comparable by default)
        Collections.sort(fruits); // Alphabetical sort
        System.out.println("After sorting strings: " + fruits);


        // -----------------------------------------
        // PART 2: ArrayList of Custom Fruit Objects
        // -----------------------------------------

        // Creating custom objects of type Fruit
        Fruit fruit1 = new Fruit("Apple", "Green");
        Fruit fruit5 = new Fruit("Apple", "Red");

//        System.out.println(fruit1.equals(fruit5)); // false, as it checks the memory of the object
//        System.out.println(fruit1.name.equals(fruit5.name)); // true, as it is checking only a specific string value

        Fruit fruit2 = new Fruit("Banana", "Yellow");
        Fruit fruit3 = new Fruit("Strawberry", "Red");
        Fruit fruit4 = new Fruit("Mango", "Orange");

        // Storing Fruit objects in an ArrayList
        ArrayList<Fruit> fruits1 = new ArrayList<>();
        fruits1.add(fruit1);
        fruits1.add(fruit2);
        fruits1.add(fruit3);
        fruits1.add(fruit4);
        fruits1.add(fruit5);

//        Fruit fr = new Fruit("Apple", "Green");
//        System.out.println(fruits1.contains(fr));

        System.out.println("\nOriginal list of Fruit objects:");
        for (Fruit fruit : fruits1) {
            System.out.println(fruit);
        }

        // ------------------------------------------------------------------
        // SORT OPTION 1: Sort by name using Comparable (implemented in class)
        // ------------------------------------------------------------------

        // This uses the compareTo() method defined inside the Fruit class
        Collections.sort(fruits1);

        System.out.println("\nSorted by name (using Comparable):");
        for (Fruit fruit : fruits1) {
            System.out.println(fruit);
        }

        // ------------------------------------------------------------------
        // SORT OPTION 2: Sort by color using a Comparator
        // ------------------------------------------------------------------

        // We're using an anonymous class that implements Comparator
        // This does NOT depend on the compareTo() method inside Fruit
        fruits1.sort(new Comparator<Fruit>() {
            @Override
            public int compare(Fruit f1, Fruit f2) {
                // Same idea as compareTo — compares color alphabetically
                return f1.color.compareTo(f2.color);
            }
        });

        System.out.println("\nSorted by color (using Comparator):");
        for (Fruit fruit : fruits1) {
            System.out.println(fruit);
        }

        // ------------------------------------------------------------------
        // SORT OPTION 3: Sort by color descending (using Lambda Expression)
        // ------------------------------------------------------------------

        // A lambda is a short way to write the Comparator
        // This one reverses the order (Z to A)
        fruits1.sort((f1, f2) -> f2.color.compareTo(f1.color));

        System.out.println("\nSorted by color descending (lambda):");
        for (Fruit fruit : fruits1) {
            System.out.println(fruit);
        }

        // ------------------------------------------------------------------
        // SORT OPTION 4: Sort by Name, then by color
        // ------------------------------------------------------------------

        // This is useful when two fruits have the same name
        // In that case, we want to sort them by color instead
        // If names are the same, compare colors
        fruits1.sort(Comparator.comparing((Fruit f) -> f.name).thenComparing(f -> f.color));

        System.out.println("\nSorted by name, then color:");
        for (Fruit fruit : fruits1) {
            System.out.println(fruit);
        }
    }
}
