import java.util.Scanner;

public class Arrays {
    public static void main(String[] args){
//      stringArray();
//        System.out.println(add(1,2,3,4));
        twoDArray();
    }

    static void stringArray(){
        Scanner scanner = new Scanner(System.in);
        int numberOfFood;
        String[] foods;


        System.out.print("Enter the number of foods = ");

        numberOfFood = scanner.nextInt();
        scanner.nextLine();
        foods = new String[numberOfFood];


        for (int i = 0; i < foods.length; i++) {
            System.out.print("Enter a food: ");
            foods[i] = scanner.nextLine();
        }

        for (String food: foods){
            System.out.println("string = " + food);
        }

        scanner.close();
    }

    // this is a alternative of overloaded methods, instead of creating all those overloaded methods, you can use this
    static int add(int... numbers){
        int sum = 0;
        for (int number: numbers)
        {
            sum += number;
        }
        return sum;
    }

    // 2D array = An array where each element is an array
    // useful for storing matrix of data
    static void twoDArray(){

        char[] row1 = {'1', '2', '3'};
        char[] row2 = {'3', '5', '6'};
        char[] row3 = {'7', '8', '9'};
        char[] row4 = {'*', '2', '#'};



        char [][] telephone = {
                                row1, row2, row3, row4
                               };
//        how to access array from the 2d array, first index is the row number, second is the column, so here 1 is the
        // row1 and 0 is the 3.
        telephone[1][0] = '4';
        telephone[3][1] = '0';

        for (char[] chars: telephone){
            for (char c: chars){
                System.out.print(c + " ");
            }
            System.out.println();
        }

    }
}
