import java.util.Deque;
import java.util.LinkedList;
import java.io.*;
import java.util.Scanner;

public class Tokens  {
    public static Deque<Token> myTokens = new LinkedList<>();
    public static Deque<Token> temp = new LinkedList<>();

    public static void readTokens() throws FileNotFoundException{
        File file = new File("/Users/ahmadshaaban/desktop/Compilers - phase 2/TestCase1.txt");
        Scanner sc = new Scanner(file);
        while (sc.hasNext()){
            String type,value;
            type = sc.next();
            type = type.substring(1,type.length()-1);
            sc.next();
            value = sc.next();
            Token temp = new Token(type,value);
            myTokens.add(temp);

        }
    }





}
