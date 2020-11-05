import java.util.Stack;
import java.util.Vector;

public class expr implements Node{
    //26 - expr → IDENT  A
    //28 - expr → expr`
    //31 - expr	 → ! expr | - expr | + expr
    // → ( expr )
    //→ IDENT1 |
    // IDENT2 [ expr ]
    // | IDENT3 ( args )
    // | IDENT4 . size
    //→ BOOL_LIT | INT_LIT | FLOAT_LIT
    // | NEW type_spec [ expr ]
    Token open,close;
    Token IDENT,IDENT1,IDENT2,IDENT3,IDENT4;
    A obj;
    expr1 obj2;
    Token token1,token2,token3,token4;
    expr obj3;
    args obj4;
    type_spec obj5;
    public static Stack<Integer> c = new Stack<>();
    public expr(Token token4, type_spec obj5, Token open, expr obj3, Token close){
        this.token4 = token4;
        this.obj5 = obj5;
        this.open= open;
        this.obj3 = obj3;
        this.close = close;
    }
    public expr(Token IDENT4,Token token1,Token token2){
        this.IDENT4 = IDENT4;
        this.token1 = token1;
        this.token2 = token2;
    }
    public expr(Token IDENT3, Token open,args obj4, Token close){
        this.IDENT3 = IDENT3;
        this.open = open;
        this.obj4 = obj4;
        this.close = close;
    }
    public expr(Token IDENT2, Token token2, expr obj3, Token token3){
        this.IDENT2 = IDENT2;
        this.token2 = token2;
        this.token3 = token3;
        this.obj3 = obj3;
    }
    public expr(Token IDENT1){
        this.IDENT1 = IDENT1;
    }
    public expr(Token IDENT, A obj){
        this.IDENT = IDENT;
        this.obj = obj;
    }
    public expr(Token open, expr obj3, Token close){
        this.open = open;
        this.close = close;
        this.obj3 = obj3;
    }
    public expr(expr1 obj2){
        this.obj2 = obj2;
    }
    public expr(Token token1,expr obj3){
        this.token1 = token1;
        this.obj3 = obj3;
    }
    @Override
    public void printNode() {

        if(IDENT!=null){
            System.out.println("Rule26");
            System.out.println(IDENT.value);
            if (obj!=null)
                obj.printNode();
        }
        else if (obj2!=null){
            System.out.println("Rule28");
            obj2.printNode();
        }
        else if (IDENT4!=null){
            System.out.println("Rule31");
            System.out.println(IDENT4.value);
            System.out.println(token1.value);
            System.out.println(token2.value);
        }
        else if(token1!=null){
            System.out.println("Rule31");
            System.out.println(token1.value);
            if(obj3!=null)
                obj3.printNode();
        }
        else if (IDENT3!=null){
            System.out.println("Rule31");
            System.out.println(IDENT3.value);
            System.out.println(open.value);
            if (obj4!=null)
                obj4.printNode();
            System.out.println(close.value);
        }
        else if (token4 != null){
            System.out.println("Rule31");
            if (obj5!=null)
                obj5.printNode();
            System.out.println(open.value);
            if (obj3!=null)
                obj3.printNode();
            System.out.println(close.value);

        }
        else if (open!=null){
            System.out.println("Rule31");
            System.out.println(open.value);
            if(obj3!=null)
                obj3.printNode();
            System.out.println(close.value);

        }
        else if (IDENT1 != null){
            System.out.println("Rule31");
            System.out.println(IDENT1.value);
        }
        else if (IDENT2 != null){
            System.out.println("Rule31");
            System.out.println(IDENT2.value);
            System.out.println(token2.value);
            if (obj3!=null)
                obj3.printNode();
            System.out.println(token3.value);
        }
    }
}
