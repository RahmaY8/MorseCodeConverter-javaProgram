import java.util.Random;
import java.util.Scanner;

public class MorseGame {
    private MorseCode morsecode;
    private Random random = new Random();
    private int score = 0;

    public MorseGame(MorseCode morsecode) {
        this.morsecode = morsecode;
    }

    private char getrandomletter() {
        char[] letters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
                'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
        return letters[random.nextInt(letters.length)];
    }

    public void GameStart(Scanner sc) {
        System.out.println("=== Game Started! Type EXIT to quit..Score 5 points to WIN! ===");
        Boolean gameEnd = false;

        while (score < 5) {
            Character RandomLetter = getrandomletter();
            String morse = morsecode.getMorse(RandomLetter);

            System.out.print("morse code: " + morse + "\nYour answer: ");
            long starttime = System.currentTimeMillis();
            String answer = sc.nextLine().toUpperCase();
            long endtime = System.currentTimeMillis();
            long timetaken = (endtime - starttime) / 1000;

            if (answer.equals("EXIT")) {
                gameEnd = true;
                break;
            }

            if (answer.equals(String.valueOf(RandomLetter))) {
                if (timetaken <= 10) {
                    score++;
                    System.out.println("You got a point! you answered in " + timetaken + " seconds!\n");
                    if (score >= 5)
                        break;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Too Slow! You answered in " + timetaken + " seconds\n");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            else {
                score = Math.max(0, score - 1);
                System.out.println("Wrong answer! the actual letter is " + RandomLetter + ".\n");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Current score: " + score);
            System.out.println();
        }
        if (gameEnd) {
            System.out.println("game ended! See you later");
        } else {
            System.out.println("Congrats you got 5 correct letters on time!");
        }

    }
}