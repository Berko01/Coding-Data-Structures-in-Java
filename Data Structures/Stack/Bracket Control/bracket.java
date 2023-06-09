import java.util.Stack;

public class bracket {
    public static void main(String[] args) {
        String phrase = "(6+8)-(2+7*{2-9})";

        System.out.println(bracketKontrol(phrase));

    }

    public static boolean bracketKontrol(String phrase) {

        Stack stack = new Stack<Character>();

        for (int i = 0; i < phrase.length(); i++) {
            char current = phrase.charAt(i);

            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);
            } else if (current == ')' || current == '}' || current == ']') {

                if ((char) stack.peek() == '(' && current == ')' || (char) stack.peek() == '{' && current == '}'
                        || (char) stack.peek() == '[' && current == ']') {
                    stack.pop();
                } else {
                    return false;
                }
            }

        }
        return true;

    }

}
