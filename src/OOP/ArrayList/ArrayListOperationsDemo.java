package OOP.ArrayList;

import OOP.models.Fruit;

import java.util.ArrayList;

public class ArrayListOperationsDemo {
    public static void main(String[] args) {

        //

        ArrayList<String> colors = new ArrayList<>();

        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Red");
        colors.add("Purple");

        System.out.println("colors.indexOf(\"Red\") = " + colors.indexOf("Red")); // it will print the first occurrence
        System.out.println("colors.lastIndexOf(\"Red\") = " + colors.lastIndexOf("Red")); // it will print the index of last occurrence

        System.out.println("colors.contains(\"Red\") = " + colors.contains("Red")); // To see if it contains a specific object

        colors.remove("Red"); // to remove a specific object, it will remove the first found

        System.out.println("colors = " + colors);
        colors.removeIf(color -> color.equals("Red")); // quickest way to remove specific kind of object/objects
        System.out.println("colors = " + colors);



        // Creating custom objects of type Fruit
        Fruit fruit1 = new Fruit("Apple", "Green");
        Fruit fruit5 = new Fruit("Apple", "Red");
        Fruit fruit2 = new Fruit("Banana", "Yellow");
        Fruit fruit3 = new Fruit("Strawberry", "Red");
        Fruit fruit4 = new Fruit("Mango", "Orange");

        // Storing Fruit objects in an ArrayList
        ArrayList<Fruit> fruits = new ArrayList<>();
        fruits.add(fruit1);
        fruits.add(fruit2);
        fruits.add(fruit3);
        fruits.add(fruit4);
        fruits.add(fruit5);

        System.out.println("-------------------------------");
        for (int i = 0; i < fruits.size(); i++) {
            System.out.println("Index : " + i + " Fruit "+fruits.get(i));
        }

        System.out.println("fruits.contains(new Fruit(\"Apple\", \"Green\") = " + fruits.contains(new Fruit("Apple", "Green")));

        System.out.println("fruits.indexOf(new Fruit(\"Banana\", \"Yellow\")) = " + fruits.indexOf(new Fruit("Banana", "Yellow")));
        System.out.println("-------------------------------");
        Fruit f = new Fruit("Apple", "Green");
        System.out.println("Removing a specific fruit :" + f);

        fruits.removeIf(fruit -> fruit.equals(f));
        System.out.println("Remaining Fruits:");
        for (Fruit fruit : fruits) {
            System.out.println(fruit);
        }


    }
}
