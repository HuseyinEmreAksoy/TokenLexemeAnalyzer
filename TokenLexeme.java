
import java.util.Scanner;
import java.io.*;

public class TokenLexeme {
    public static void main(String[] args) {
        Scanner inputStream = null;
        PrintWriter outputStream = null;
        try {
            inputStream = new Scanner(new File(args[0]));
            outputStream = new PrintWriter(args[1]);

        } catch (Exception e) {
            System.out.println("hata");
            System.exit(0);
        }
        boolean flag = true;
        while (inputStream.hasNext() && flag) {
            String line = inputStream.nextLine().replaceAll("\\s", "");
            for (int i = 0; i < line.length() && flag; i++) {
                if (line.charAt(i) == '(')
                    outputStream.println("Next token is LPARANT Next lexeme is (");
                else if (line.charAt(i) == ')')
                    outputStream.println("Next token is RPARANT Next lexeme is )");
                else if (line.charAt(i) == '=')
                    outputStream.println("Next token is ASSIGNM Next lexeme is =");
                else if (line.charAt(i) == ';')
                    outputStream.println("Next token is SEMICOLON Next lexeme is ;");
                else if (line.charAt(i) == '>' && line.charAt(i + 1) == '=')
                    outputStream.println("Next token is GRE_EQ Next lexeme is >=");
                else if (line.charAt(i) == '<' && line.charAt(i + 1) == '=')
                    outputStream.println("Next token is LESS_EQ Next lexeme is <=");
                else if (line.charAt(i) == '>')
                    outputStream.println("Next token is GREATER Next lexeme is >");
                else if (line.charAt(i) == '<')
                    outputStream.println("Next token is LESS Next lexeme is <");
                else if (line.charAt(i) == 'f' && line.charAt(i + 1) == 'o' && line.charAt(i + 2) == 'r') {
                    outputStream.println("Next token is FOR_STATEMENT Next lexeme is for");
                    i = i + 2;
                } else if (line.charAt(i) == 'i' && line.charAt(i + 1) == 'n' && line.charAt(i + 2) == 't') {
                    outputStream.println("Next token is INT_TYPE Next lexeme is int");
                    i = i + 2;
                } else if (line.charAt(i) == 'c' && line.charAt(i + 1) == 'h' && line.charAt(i + 2) == 'a' && line.charAt(i + 3) == 'r') {
                    outputStream.println("Next token is CHAR_TYPE Next lexeme is char");
                    i = i + 3;
                } else if (line.charAt(i) == '{')
                    outputStream.println("Next token is LCURLYB Next lexeme is {");
                else if (line.charAt(i) == '}')
                    outputStream.println("Next token is RCURLYB Next lexeme is }");
                else if (line.charAt(i) == 'r' && line.charAt(i + 1) == 'e' && line.charAt(i + 2) == 't' && line.charAt(i + 3) == 'u' && line.charAt(i + 4) == 'r' && line.charAt(i + 5) == 'n') {
                    outputStream.println("Next token is RETURN_STMT Next lexeme is return");
                    i = i + 5;
                } else if (line.charAt(i) == '-')
                    outputStream.println("Next token is SUBT Next lexeme is -");
                else if (line.charAt(i) == '/')
                    outputStream.println("Next token is DIV Next lexeme is /");
                else if (line.charAt(i) == '+')
                    outputStream.println("Next token is ADD Next lexeme is +");
                else if (line.charAt(i) == '*')
                    outputStream.println("Next token is MULT Next lexeme is *");
                else if (isNumeric("" + line.charAt(i))) {
                    int count = 0;
                    String num = "" + line.charAt(i);
                    while (isNumeric("" + line.charAt(i + count + 1))){
                        num += line.charAt(i + count + 1);
                        count++;
                    }
                    outputStream.println("Next token is INT_LIT Next lexeme is " + num);
                    i += count;
                }
                else if ((line.charAt(i) - 'a' > -1 && line.charAt(i) - 'a' < 26) || (line.charAt(i) - 'A' > -1 && line.charAt(i) - 'A' < 26)) {
                    if (line.charAt(i + 1) == '=' || line.charAt(i + 1) == '+' || line.charAt(i + 1) == '-' || line.charAt(i + 1) == '*' || line.charAt(i + 1) == '>' || line.charAt(i + 1) == '<'|| line.charAt(i + 1) == ';'|| line.charAt(i + 1) == ')')
                        outputStream.println("Next token is identifier Next lexeme is " + line.charAt(i));
                    else{
                        outputStream.println("Unknown identifier error");
                        flag = false;
                    }

                }
                else {
                    outputStream.println("Unknown operator error");
                    flag = false;
                }

            }

        }
        inputStream.close();
        outputStream.close();
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
