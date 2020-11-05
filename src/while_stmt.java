public class while_stmt implements Node {
    //while_stmt → WHILE ( expr ) stmt
    Token token1,token2,token3;
    expr obj1;
    stmt obj2;
    public while_stmt(Token token1,Token token2,expr obj1, Token token3, stmt obj2){
        this.token1 = token1;
        this.token2 = token2;
        this.obj1 = obj1;
        this.token3 = token3;
        this.obj2 = obj2;
    }

    @Override
    public void printNode() {
        System.out.println("Rule18");
        if (token1!=null){
            System.out.println(token1.value);
        }
        if (token2!=null){
            System.out.println(token2.value);
        }
        if (obj1!=null)
            obj1.printNode();
        if (token3!=null){
            System.out.println(token3.value);
        }
        if (obj2!=null)
            obj2.printNode();

    }
}
