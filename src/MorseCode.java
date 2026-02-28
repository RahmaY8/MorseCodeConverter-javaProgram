import java.util.HashMap;

public class MorseCode {
    private HashMap<Character, String> MorseMap = new HashMap<>();
    private HashMap<String, Character> AlphabetMap = new HashMap<>();

    public MorseCode() {
        InitializeMap();
    }

    public String convertToMorse(String text) {
        StringBuilder convertedText = new StringBuilder();

        for (Character c : text.toUpperCase().toCharArray()) {
            if (MorseMap.containsKey(c)) {
                convertedText.append(MorseMap.get(c) + " ");
            } else
                convertedText.append(c);
        }
        return convertedText.toString();
    }

    public String convertToAlphabet(String text) {
        StringBuilder convertedText = new StringBuilder();
        String[] arr = text.split(" ");
        Boolean LastWasSpace = false;

        for (String str : arr) {
            if (!str.isEmpty() && AlphabetMap.containsKey(str)) {
                convertedText.append(AlphabetMap.get(str));
                LastWasSpace = false;
            } else if (str.isEmpty() && !LastWasSpace) {
                convertedText.append(" ");
                LastWasSpace = true;
            }

        }
        return convertedText.toString();
    }

    public String getMorse(char letter) {
        return MorseMap.get(Character.toUpperCase(letter));
    }

    private void InitializeMap() {
        MorseMap.put('A', ".-");
        MorseMap.put('B', "-...");
        MorseMap.put('C', "-.-.");
        MorseMap.put('D', "-..");
        MorseMap.put('E', ".");
        MorseMap.put('F', "..-.");
        MorseMap.put('G', "--.");
        MorseMap.put('H', "....");
        MorseMap.put('I', "..");
        MorseMap.put('J', ".---");
        MorseMap.put('K', "-.-");
        MorseMap.put('L', ".-..");
        MorseMap.put('M', "--");
        MorseMap.put('N', "-.");
        MorseMap.put('O', "---");
        MorseMap.put('P', ".--.");
        MorseMap.put('Q', "--.-");
        MorseMap.put('R', ".-.");
        MorseMap.put('S', "...");
        MorseMap.put('T', "-");
        MorseMap.put('U', "..-");
        MorseMap.put('V', "...-");
        MorseMap.put('W', ".--");
        MorseMap.put('X', "-..-");
        MorseMap.put('Y', "-.--");
        MorseMap.put('Z', "--..");

        AlphabetMap.put(".-", 'A');
        AlphabetMap.put("-...", 'B');
        AlphabetMap.put("-.-.", 'C');
        AlphabetMap.put("-..", 'D');
        AlphabetMap.put(".", 'E');
        AlphabetMap.put("..-.", 'F');
        AlphabetMap.put("--.", 'G');
        AlphabetMap.put("....", 'H');
        AlphabetMap.put("..", 'I');
        AlphabetMap.put(".---", 'J');
        AlphabetMap.put("-.-", 'K');
        AlphabetMap.put(".-..", 'L');
        AlphabetMap.put("--", 'M');
        AlphabetMap.put("-.", 'N');
        AlphabetMap.put("---", 'O');
        AlphabetMap.put(".--.", 'P');
        AlphabetMap.put("--.-", 'Q');
        AlphabetMap.put(".-.", 'R');
        AlphabetMap.put("...", 'S');
        AlphabetMap.put("-", 'T');
        AlphabetMap.put("..-", 'U');
        AlphabetMap.put("...-", 'V');
        AlphabetMap.put(".--", 'W');
        AlphabetMap.put("-..-", 'X');
        AlphabetMap.put("-.--", 'Y');
        AlphabetMap.put("--..", 'Z');
    }
}