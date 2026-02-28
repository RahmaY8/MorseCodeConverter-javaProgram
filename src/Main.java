import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MorseCode morseCode = new MorseCode();
        MorseGame game = new MorseGame(morseCode);

        System.out.println("===== MORSE CODE PROGRAM =====");
        System.out.println("1. Alphabet to Morse");
        System.out.println("2. Morse to Alphabet");
        System.out.println("3. Mini Quiz Game");

        System.out.print("Choose option: ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1:
                System.out.print("Enter your alphabet text: ");
                String text = scanner.nextLine();
                System.out.print("Translated text: " + morseCode.convertToMorse(text));
                break;
            case 2:
                System.out.print("Enter your Morse Code text: ");
                String text2 = scanner.nextLine();
                System.out.print("Translated text: " + morseCode.convertToAlphabet(text2));
                break;
            case 3:
                game.GameStart(scanner);
                break;
            default:
                System.out.println("invalid choice");
        }
        scanner.close();
    }
}