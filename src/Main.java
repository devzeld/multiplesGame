import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void insertNumbers(int[] arr, int nrElements){
        Random r = new Random();
        for (int i = 0; i < nrElements; i++) {
            int n = 1 + r.nextInt(100) ;
            arr[i] = n;
        }
    }
    public static int countMultiples(int[] arr){
        int counter = 0;
        for (int i = 0; i < arr.length - 1 && arr[i] != 0; i++) {
            if(i == 0) {
                if (arr[i] % arr[i + 1] == 0) {
                    counter++;
                }
                continue;
            }
            if (arr[i] % arr[i - 1] == 0 || arr[i] % arr[i + 1] == 0 && i != arr.length - 1) {
                counter++;
                continue;
            }
            if(i == arr.length - 1) {
                if (arr[i + 1] % arr[i] == 0) {
                    counter++;
                }
            }
        }
        return counter;
    }
    public static int getUserNum(){
        System.out.print("Insert the number of multiples: ");
        return sc.nextInt();
    }
    public static void startGame(){
        int levelGame = 0;
        int counterToGuess;
        int userCounter;
        do{
            levelGame++;
            int[] numbers = new int[levelGame + 1];
            System.out.printf("Level %s: \n", levelGame);
            insertNumbers(numbers, numbers.length);
            counterToGuess = countMultiples(numbers);
            for (int number : numbers) {
                System.out.print(number + " ");
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.print("\r");
            userCounter = getUserNum();
        }while(userCounter == counterToGuess && levelGame != 50);
        System.out.println(levelGame == 50? "Good, you won the game.": "You lose.\nYour best result is level " + levelGame + "\nThe right number was " + counterToGuess);
    }

    public static void main(String[] args) {
        startGame();
    }
}
