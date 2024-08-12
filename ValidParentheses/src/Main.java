import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        Boolean result = isValid("(]");
        System.out.println(result);
    }

    public static boolean isValid(String input) {
        Character[] validParantheses = new Character[]{
                '(', '{', '['
        };
        Deque<Character> openCharactersResult = new ArrayDeque<>();

        for (char symbol : input.toCharArray()) {
            if (Arrays.asList(validParantheses).contains(symbol)) {
                openCharactersResult.push(symbol);
            } else {
                if (openCharactersResult.isEmpty()) {
                    return false;
                }
                char lastOpen = openCharactersResult.pop();
                if (!isMatchingPair(lastOpen, symbol)) {
                    return false;
                }
            }
        }

        return openCharactersResult.isEmpty();
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }
}