public class expr_stmt implements Node {
    //17 - expr_stmt → expr ;
    // | ;
    expr obj1;
    Token token;
    public expr_stmt(expr obj1,Token token){
        this.obj1 = obj1;
        this.token = token;
    }
    public expr_stmt(Token token){
        this.token = token;
    }

    @Override
    public void printNode() {
        System.out.println("Rule 17");
        if (obj1!=null)
            obj1.printNode();
        if(token!=null)
            System.out.println(token.value);
    }
}
