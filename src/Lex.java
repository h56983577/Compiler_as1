import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Lex {
    public static void main(String[] args) throws IOException {
        char ch;
        int state = 0;
        StringBuilder s = null;
        Set<Character> chTable = new HashSet<Character>(
                Arrays.asList('+', '*', ',', '(', ')'));
        Set<String> keyTable = new HashSet<String>(
                Arrays.asList("BEGIN", "END", "FOR", "IF", "THEN", "ELSE"));
        FileReader reader = new FileReader(args[0]);
        while (true) {
            switch (state) {
                case 0:
                    ch = (char)reader.read();
                    if (Character.isLowerCase(ch) || Character.isUpperCase(ch)) {
                        s = new StringBuilder();
                        s.append(ch);
                        state = 1;
                    } else if (Character.isDigit(ch)) {
                        s = new StringBuilder();
                        s.append(ch);
                        state = 2;
                    } else if (ch == ':') {
                        state = 3;
                    } else if (chTable.contains(ch)) {
                        switch (ch) {
                            case '+':
                                System.out.println("Plus");
                                break;
                            case '*':
                                System.out.println("Star");
                                break;
                            case ',':
                                System.out.println("Comma");
                                break;
                            case '(':
                                System.out.println("LParenthesis");
                                break;
                            case ')':
                                System.out.println("RParenthesis");
                        }
                    } else if (ch == (char)-1) state = 5;
                    else if (ch == ' ' || ch == '\t' || ch == '\n') state = 0;
                    else state = 4;
                    break;
                case 1:
                    ch = (char)reader.read();
                    if (Character.isLowerCase(ch) || Character.isUpperCase(ch) || Character.isDigit(ch)) {
                        s.append(ch);
                    } else {
                        String id = s.toString();
                        if (keyTable.contains(id)) {
                            switch (id) {
                                case "BEGIN":
                                    System.out.println("Begin");
                                    break;
                                case "END":
                                    System.out.println("End");
                                    break;
                                case "FOR":
                                    System.out.println("For");
                                    break;
                                case "IF":
                                    System.out.println("If");
                                    break;
                                case "THEN":
                                    System.out.println("Then");
                                    break;
                                case "ELSE":
                                    System.out.println("Else");
                            }
                        } else System.out.println("Ident(" + id + ")");
                        if (ch == ':') {
                            state = 3;
                        } else if (chTable.contains(ch)) {
                            switch (ch) {
                                case '+':
                                    System.out.println("Plus");
                                    break;
                                case '*':
                                    System.out.println("Star");
                                    break;
                                case ',':
                                    System.out.println("Comma");
                                    break;
                                case '(':
                                    System.out.println("LParenthesis");
                                    break;
                                case ')':
                                    System.out.println("RParenthesis");
                            }
                            state = 0;
                        } else if (ch == (char)-1) state = 5;
                        else if (ch == ' ' || ch == '\t' || ch == '\n') state = 0;
                        else state = 4;
                    }
                    break;
                case 2:
                    ch = (char)reader.read();
                    if (Character.isDigit(ch)) {
                        s.append(ch);
                    } else {
                        long num = Long.parseLong(s.toString());
                        System.out.println("Int(" + num + ")");
                        if (Character.isLowerCase(ch) || Character.isUpperCase(ch)) {
                            s = new StringBuilder();
                            s.append(ch);
                            state = 1;
                        } else if (ch == ':') {
                            state = 3;
                        } else if (chTable.contains(ch)) {
                            switch (ch) {
                                case '+':
                                    System.out.println("Plus");
                                    break;
                                case '*':
                                    System.out.println("Star");
                                    break;
                                case ',':
                                    System.out.println("Comma");
                                    break;
                                case '(':
                                    System.out.println("LParenthesis");
                                    break;
                                case ')':
                                    System.out.println("RParenthesis");
                            }
                            state = 0;
                        } else if (ch == (char)-1) state = 5;
                        else if (ch == ' ' || ch == '\t' || ch == '\n') state = 0;
                        else state = 4;
                    }
                    break;
                case 3:
                    ch = (char)reader.read();
                    if (ch == '=') {
                        System.out.println("Assign");
                    } else {
                        System.out.println("Colon");
                        if (Character.isLowerCase(ch) || Character.isUpperCase(ch)) {
                            s = new StringBuilder();
                            s.append(ch);
                            state = 1;
                        } else if (Character.isDigit(ch)) {
                            s = new StringBuilder();
                            s.append(ch);
                            state = 2;
                        } else if (ch == ':') {
                        } else if (chTable.contains(ch)) {
                            switch (ch) {
                                case '+':
                                    System.out.println("Plus");
                                    break;
                                case '*':
                                    System.out.println("Star");
                                    break;
                                case ',':
                                    System.out.println("Comma");
                                    break;
                                case '(':
                                    System.out.println("LParenthesis");
                                    break;
                                case ')':
                                    System.out.println("RParenthesis");
                            }
                            state = 0;
                        } else if (ch == (char)-1) state = 5;
                        else if (ch == ' ' || ch == '\t' || ch == '\n') state = 0;
                        else state = 4;
                    }
                    break;
                case 4:
                    System.out.println("Unknown");
                    state = 5;
            }
            if (state == 5) break;
        }
    }
}
