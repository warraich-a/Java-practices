package OOP.ArrayList.Streams;

import java.util.Arrays;
import java.util.List;

public class FilterDemo {
    public static void main(String[] args) {

        // Using List instead of ArrayList — here's why:
        //
        // List is an *interface* that defines the general behavior of a list.
        // ArrayList is one *implementation* of that interface.
        //
        // We use:
        //   List<String> names = new ArrayList<>();
        // instead of:
        //   ArrayList<String> names = new ArrayList<>();
        //
        // ✅ Best practice: code to the interface (List) to make your code flexible.
        //    That way, you can easily switch to LinkedList or another List type later
        //    without changing the rest of your code.
        //
        // For example: List<String> names = new LinkedList<>(); would still work.

        List<String> names = Arrays.asList("Anas", "Ali", "Zara", "Ahmad", "Anas");

        // Streams allow processing data in a functional style.
        // Think of this as a "pipeline" that transforms and filters data.

        // Step 1: Convert list into a stream (a stream of Strings)
        // Step 2: Filter out names that start with "A"
        // Step 3: Collect the results back into a new List
        List<String> notANames = names.stream()                          // Create a stream
                .filter(n -> !n.startsWith("A"))                         // Keep only names that DON'T start with "A"
                .toList();                          // Collect results into a new List

        // Print the result
        System.out.println("Names not starting with A: " + notANames);
    }


}
