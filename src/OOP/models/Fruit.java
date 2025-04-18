package OOP.models;

// The Fruit class implements Comparable, which means
// Fruit objects can be compared to each other using the compareTo method.

//import lombok.Data;
//
//@Data
public class Fruit implements Comparable<Fruit> {
    public String name;
    public String color;

    public Fruit(String name, String color) {
        this.name = name;
        this.color = color;
    }

    // This method is used when you want to print the object
    // e.g., System.out.println(fruit) will show: Apple (Green)
    @Override
    public String toString() {
        return name + " : " + color;
    }

    // This method defines the "natural order" of Fruit objects.
    // Here, we are sorting based on the name of the fruit.
    @Override
    public int compareTo(Fruit other) {
        // If this.name comes before other.name alphabetically, it returns a negative number
        // If they are the same, it returns 0
        // If this.name comes after, it returns a positive number
        return this.name.compareTo(other.name);
    }

    @Override
    public boolean equals(Object obj) {
        // Step 1: Check if the two references are the same
        if (this == obj) return true;

        // Step 2: Check if the passed object is null or not a Fruit
        if (obj == null || getClass() != obj.getClass()) return false;

        // Step 3: Type cast the object to a Fruit
        Fruit other = (Fruit) obj;

        // Step 4: Compare relevant fields (name and color)
        return this.name.equals(other.name) && this.color.equals(other.color);
    }
    @Override
    public int hashCode() {
        return java.util.Objects.hash(name, color);
    }

}
