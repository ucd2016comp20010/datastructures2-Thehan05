package project20280.stacksqueues;

class BracketChecker {

    public static boolean checkParentheses(String in) {
        ArrayStack<Character> stack = new ArrayStack<>();

        for (int i = 0; i < in.length(); i++) {
            char ch = in.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) return false;
                if (!matches(stack.pop(), ch)) return false;
            }
        }

        return stack.isEmpty();
    }

    private static boolean matches(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        String[] inputs = {
                "[]]()()",
                "c[d]",
                "a{b[c]d}e",
                "a{b(c]d}e",
                "a[b{c}d]e}",
                "a{b(c) ",
                "][]][][[]][]][][[[",
                "(((abc))((d)))))",
                "{[()]}",
                "{[(])}",
                "{{[[(())]]}}",
        };

        for (String input : inputs) {
            boolean isBalanced = checkParentheses(input);
            System.out.println("isBalanced " + (isBalanced ? " yes! " : " no! ") + input);
        }
    }
}