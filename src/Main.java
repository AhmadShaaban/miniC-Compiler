
import java.io.*;
import java.util.Iterator;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Tokens.readTokens();




     Parser p = new Parser();
    program root = p.parse();
     root.printNode();
    }


}
