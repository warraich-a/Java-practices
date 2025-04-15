package OOP.ArrayList;

import java.util.ArrayList;
import java.util.ListIterator;

public class ArrayListListIteratorDemo {
    public static void main(String[] args){

        ArrayList<String> numbers = new ArrayList<>();
        numbers.add("One");
        numbers.add("Two");
        numbers.add("Three");
        numbers.add("Four");

        // Create a ListIterator for bi-directional traversal
        ListIterator<String> listIterator = numbers.listIterator();

        System.out.println("Original list: " + numbers);

        // 🔁 Forward traversal
        while (listIterator.hasNext()) {
            String item = listIterator.next();
            int index = listIterator.nextIndex(); // Index of next element

            // Update the value "Two" to "TWO"
            if (item.equals("Two")) {
                listIterator.set("TWO"); // Safely replaces the current item
            }
        }

        System.out.println("After updating 'Two' to 'TWO': " + numbers);

        // 🔁 Backward traversal
        while (listIterator.hasPrevious()) {
            String item = listIterator.previous();
            int index = listIterator.previousIndex(); // Index of previous element

            // If we're before index 0 (meaning we're at the start), insert "Zero"
            if (index < 0) {
                listIterator.add("Zero"); // Inserts before "One"
                break; // 🛑 Exit the loop after adding once!
            }
        }

        System.out.println("After inserting 'Zero' at the start: " + numbers);
    }
}
