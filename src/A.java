public class A implements Node {
//27 - A  → = expr | [ expr ] Q | ε | ( args) | . size | expr
    expr obj1,obj2;
    args obj3;
    Token token1,token2,token3;
    Q q;
    public A(expr obj1){
        this.obj1 = obj1;
    }
    public A (Token token1, expr obj1 ){
        this.obj1 = obj1;
        this.token1 = token1;
    }

    public A(){
        //
    }
    public A(Token token1, expr obj1, Token token2 ,Q q){
        this.token1 = token1;
        this.token2 = token2;
        this.obj1 = obj1;
        this.q = q;
    }
    public A (Token token1,args obj3, Token token2){
        this.token1 = token1;
        this.obj3 = obj3;
        this.token2 = token2;
    }
    public A(Token toke1,Token token2){
        this.token1 = token1;
        this.token2 = token2;
    }

    @Override
    public void printNode() {
        System.out.println("Rule 27");
        if (token1!=null){
            System.out.println(token1.value);
        }
        if (obj1!=null)
            obj1.printNode();
        if(obj3!=null)
            obj3.printNode();
        if (token2!=null){
            System.out.println(token2.value);
        }
        if (token3!=null){
            System.out.println(token3.value);
        }
        if (obj2!=null)
            obj2.printNode();

    }
}
