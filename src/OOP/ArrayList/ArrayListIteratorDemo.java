package OOP.ArrayList;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListIteratorDemo {

    public static void main(String[] args){
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Red");
        colors.add("Purple");

        // ❌ Unsafe: Removing directly inside a for-each loop causes ConcurrentModificationException
        // for (String color: colors) {
        //     if(color.equals("Red")) {
        //         colors.remove(color);
        //     }
        // }

        System.out.println("Before removal: " + colors);

        // ✅ Safer approach using an Iterator — directly linked to the original list
        // Iterator provides a safe way to remove elements while looping
        Iterator<String> iterator = colors.iterator();

        // Loop through the list using the iterator
        while (iterator.hasNext()) {
            String color = iterator.next(); // Get the current element

            if (color.equals("Red")) {
                // Removes the current element from the original ArrayList (not a copy)
                // This works safely because remove() is part of Iterator’s design
                iterator.remove();
            }
        }

        // ✅ The original ArrayList is now updated
        System.out.println("After removing 'Red': " + colors);
    }
}
