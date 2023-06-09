public class Main {
    public static void main(String[] args) {
        
        Stack stack = new Stack(5);

        String phrase = "{}";

        for (int i = 0; i < phrase.length(); i++) {
            char current = phrase.charAt(i);

            if (current == '(' || current == '{' || current == '[') {
                stack.push(current);
            }

            if (current == ')' || current == '}' || current == ']') {
                char last = stack.peek();
                if (current == ')' && last == '(') {
                    stack.pop();
                }
                if (current == '}' && last == '{') {
                    stack.pop();
                }
                if (current == ']' && last == '[') {
                    stack.pop();
                }
            }

        }

        if (stack.size == 0) {
            System.out.println("Hatasiz.");
        } else {
            System.out.println("Hatali");
        }

    }
}