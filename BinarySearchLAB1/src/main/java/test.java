import java.util.Stack;

/**
 * Created by alexander on 2016-11-11.
 */
public class test {

    public static void fun(char[] input) {
        Stack s = new Stack();
        for (int i = 0; i < input.length; i++) {
            if (input[i] == '+') {
                s.push(input[i]);
            } else if (input[i] == '*') {
                s.push(input[i]);
            } else if (input[i] == ')') {
                System.out.print(s.pop() + " ");
            } else if (input[i] == '(') {
                System.out.print("");
            } else {
                System.out.print(input[i] + " ");
            }
        }
        System.out.println();
    }
}
