import java.util.Scanner;
import java.util.Stack;
/**
 *  Name:
 *  Class Group:
 */
public class CA3_Question8 {

    /*
        Reads in an equation from the user
     */

    /* The algorithm is as follows:
    if you read a number, push it onto the number stack.
    else if you read a (, push in on the operator stack.
    Else if you read an operator op,
    while the top of the stack has a higher precendence than op,
    evaluate the top.
    Then push op onto the operator stack.
    Else if you read a ),
    while the top of the operator stack is not a (,
    evaluate the top.
    Pop the (.
    Else if there is no more input,
    evaluate the top.

    at the end the remaining value on the number stack is the value of the expression.

    evaluate the top:
    pop two numbers off the number stack.
    pop an operator off the operator stack.
    combine the numbers with that operator.
    push the result onto the number stack.
     */
    public static  int evaluateExpression(String expression){
        Stack<Integer> numberStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        for(int i = 0; i < expression.length(); i++){
            char c = expression.charAt(i);
            if(Character.isDigit(c)){
                numberStack.push(c - '0');
            }else if(c == '('){
                operatorStack.push(c);
            }else if(c == ')'){
                while(operatorStack.peek() != '('){
                    evaluateTop(numberStack, operatorStack);
                }
                operatorStack.pop();
            }else if(c == '+' || c == '-' || c == '*' || c == '/'){
                while(!operatorStack.isEmpty() && (int)precedence(c) <= (int)precedence(operatorStack.peek())){
                    evaluateTop(numberStack, operatorStack);
                }
                operatorStack.push(c);
            }
        }
        while(!operatorStack.isEmpty()){
            evaluateTop(numberStack, operatorStack);
        }
        return numberStack.pop();
    }

    //method to check the precedence of the operators
    private static Object precedence(Character peek) {
        if(peek == '+' || peek == '-'){
            return 1;
        }else if(peek == '*' || peek == '/'){
            return 2;
        }
        return 0;
    }

//method to evaluate the top of the stack
    private static void evaluateTop(Stack<Integer> numberStack, Stack<Character> operatorStack) {
        int num2 = numberStack.pop();
        int num1 = numberStack.pop();
        char operator = operatorStack.pop();
        int result = 0;
        switch (operator){
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
        }
        numberStack.push(result);
    }




    public static void main(String[] args) {
        String equation;
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter equation");
        equation = in.nextLine().trim();
        System.out.println("The result is: " + evaluateExpression(equation));


    }
}
