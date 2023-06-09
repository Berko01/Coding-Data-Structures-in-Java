import java.util.Stack;

import javax.lang.model.util.ElementScanner14;

public class Main {

    public static int process(char process, int num1, int num2) {
        int sum;
        if (process == '+') {
            return sum = num1 + num2;
        } else if (process == '-') {
            return sum = num1 - num2;
        } else if (process == '*') {
            return sum = num1 * num2;
        } else {
            return sum = num1 / num2;
        }

    }

    public static boolean isNumber(char character) {
        if (character == '+' || character == '-' || character == '/' || character == '*') {
            return false;
        } else
            return true;

    }

    public static int resultPostfix(String postfix) {
        int result = 1;
        Stack stack = new Stack<Integer>();
        for (int i = 0; i < postfix.length(); i++) {
            char character = postfix.charAt(i);
            String copy = String.valueOf(character);

            if (isNumber(character) == true) {

                stack.push(Integer.parseInt(copy));
            } else {
                if (!stack.isEmpty()) {
                    result = process(character, (int) stack.pop(), (int) stack.pop());

                }
                stack.push(result);
            }

        }
        System.out.println(result);
        return result;



    }

    public static int priority(char character) {

        if (character == '+' || character == '-') {
            return 1;
        } else if (character == '*' || character == '/') {
            return 2;
        } else if (character == '^') {
            return 3;
        } else
            return -1;

    }

    public static String writePostfix(String infix) {
        String postfix = "";
        Stack stack = new Stack<Character>();

        for (int i = 0; i < infix.length(); i++) {
            char character = infix.charAt(i);
            if (character == '(') {
                stack.push(character);
            } else if (character == ')') {
                while ((char) stack.peek() != '(') {

                    postfix += stack.pop();
                }
                stack.pop();
            } else if (priority(character) > 0) {
                while (!stack.isEmpty() && priority((char) stack.peek()) >= priority(character)) {
                    postfix = postfix + stack.pop();

                }
                stack.push(character);

            } else {
                postfix = postfix + character;
            }

        }

        while (!stack.isEmpty()) {

            postfix += stack.pop();

        }
        System.out.println(postfix);
        return postfix;

    }

    public static String reverse(String infix) {
        Stack stack = new Stack<String>();
        String reverse = "";
        for (int i = 0; i < infix.length(); i++) {

            stack.push(infix.charAt(i));

        }
        for (int i = 0; i < infix.length(); i++) {
            if ((char) stack.peek() == '(') {
                stack.pop();
                reverse += ")";
            } else if ((char) stack.peek() == ')') {
                stack.pop();
                reverse += "(";
            } else
                reverse += stack.pop();

        }

        return reverse;

    }

    public static String InfixtoPrefix(String infix) {
        String reverseInfix = reverse(infix);
        String reversePostfix = writePostfix(reverseInfix);
        String prefix = reverse(reversePostfix);
        System.out.println(prefix);
        return prefix;

    }

    public static int prefixprocess(String prefix){

       return resultPostfix(reverse(prefix));
    }

    public static void main(String[] args) {
        String infix2 = "(3+5)*(7+8*4)";
        String infix = "2+3*5";

        /*
        writePostfix(infix);
        writePostfix(infix2);

        String postfix = "235*+";

        resultPostfix(postfix);
        resultPostfix("35+784*+*");
        System.out.println("result bu:");
        resultPostfix("35*578*++");

        InfixtoPrefix(infix);
        InfixtoPrefix(infix2);
        InfixtoPrefix("35*578*++");
        prefixprocessYap("+*35*578+");
        */
        writePostfix(infix2);
        resultPostfix("35+784*+*");
        InfixtoPrefix(infix2);
        prefixprocess("*+35+7*84");

        
        
    }

}
