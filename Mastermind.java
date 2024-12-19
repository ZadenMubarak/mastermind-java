import java.util.Random;
import java.util.Scanner;

public class Mastermind {

    public static void main(String[] args){
        //main scope

        //initialize random
        Random random = new Random();

        String[] colors = {"blue", "black", "red", "yellow", "brown", "magenta", "orange", "pink", "purple"};

        String[] secret = new String[4];
        String[] guess = new String[4];

        // step to add random numbers to secret

        int i = 0;

        while (i < 4){

            String random_color = colors[random.nextInt(colors.length)];

            if (!IsInArray(guess, random_color)){
                secret[i] = random_color;
                i ++;
                
            }
        }

        for (String element: secret){
            System.out.println("element: " + element);
        }

        System.out.println("'now begin guessing \n'");

        game(secret, guess);

              
    }

    //outside main scope

    //main function of the mastermind game

    static void game(String[] secret, String[] guess){

        Scanner input = new Scanner(System.in);

        int i = 0;

        int correct = 0;
        int correctish = 0;

        while (i < 4){
            System.out.println("Input a color of your choice: ");
            guess[i] = input.nextLine();
            i ++;
        }

        for (int iterator = 0; iterator < secret.length; iterator ++){

            if (guess[iterator].equals(secret[iterator])){
                correct ++;
            }

            else if (IsInArray(secret, guess[iterator]) && secret[iterator] != guess[iterator]){
                correctish ++;
            }


        }

        System.out.println("correct: " + correct + " correctish: " + correctish);
    }

    // method to check if an element is in an array
    static boolean IsInArray(String[] array, String item){

        // note this is my fave method so far !!!!

        for (String element: array){
            if (element != null && element.equals(item)){
                return true;
            }
        }

        return false;
    }
    
}
