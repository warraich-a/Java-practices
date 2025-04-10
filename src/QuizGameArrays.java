import java.util.Scanner;

public class QuizGameArrays {
    public  static void main(String[] args){

        String[] questions = {
                    "What is the main function of a router?",
                    "Which part of the computer is considered the brain?",
                    "What year was Facebook launched?",
                    "Who is known as the father of computer?",
                    "What was the first programming language?"
        };

        String[][] options = {
                                {"1. Storing files", "2. Encrypting data", "3. Directing internet traffic", "4. Managing passwords"},
                                {"1. CPU", "2. Hard drive", "3. RAM", "4. GPU"},
                                {"1. 2000", "2. 2004", "3. 2006", "4. 2006"},
                                {"1. Steve jobs", "2. Bill Gates", "3. Alan turing", "4. Charles Babbage"},
                                { "1. COBOL", "2. C", "3. Fortran", "4. Assembly"},

                            };
        int[] answers = {3, 1, 2, 4, 3};

        int score = 0;

        int guess = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("*****************************");
        System.out.println("Welcome to the JAVA quiz game");
        System.out.println("*****************************");


        for (int i = 0; i < questions.length; i++) {
            System.out.print("Question no: " + i);
            System.out.print(" "+ questions[i]);
            System.out.println();
            for (String ans: options[i]){
                System.out.println(ans);

            }
            System.out.println();

            System.out.print("Type the number of the correct answer: ");
            guess = scanner.nextInt();


            if(answers[i]==guess){
                System.out.println("*******");
                System.out.println("The answer is correct");
                System.out.println("*******");
                score++;
            }
            else {
                System.out.println("*******");
                System.out.println("Wrong answer");
                System.out.println("*******");
            }




        }
        System.out.println("-------------------");
        System.out.println("Total score "+score);
        System.out.println("-------------------");



        scanner.close();
    }
}
