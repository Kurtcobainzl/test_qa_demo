package algorithm;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Stack;

public class Demo {
    public static void main(String[] args) {
        System.out.println(isValid2("()"));
        System.out.println(isValid2("([{}]{})"));
        System.out.println(isValid2("(}[{}]{})"));
    }


    public static boolean isValid2(String s) {

        Stack<Character> stack = new Stack<Character>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }

        return stack.isEmpty();
    }


    public static boolean isValid(String s) {

        HashMap map;
        Hashtable table;
//        transient


        if (s.length() == 0)
            return true;
        if (s.length() % 2 == 1)
            return false;
        String s1;
        while (s.length() > 0) {
            s1 = s.replace("()", "").replace("[]", "").replace("{}", "");
            if (s1.length() == 0)
                return true;
            if (s1.equals(s)) {
                if (s1.length() > 0) {
                    return false;
                } else {
                    return true;
                }
            }
            s = s1;

        }
        return true;
    }
}
