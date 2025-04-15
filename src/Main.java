import OOP.models.Animal;
import OOP.models.Cat;
import OOP.models.Dog;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        Animal animal;

        System.out.print("Chose 1 = Dog, 2 = cat");
        int choice = scanner.nextInt();
        scanner.nextLine();

//        runtime polymorphism = when the methods that gets executed is decided on the runtime based on the actual
//        type of the object
        if (choice == 1){
            animal = new Dog();
            animal.speak();
        } else if (choice == 2){
            animal = new Cat();
            animal.speak();
        }



    }
}
