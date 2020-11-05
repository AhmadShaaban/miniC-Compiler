public class if_stmt implements Node{
    //23 - if_stmt → IF  ( expr ) stmt if_stmt`

    Token token1,token2,token3;
    expr obj1;
    stmt obj2;
    if_stmt1 obj3;
    public if_stmt(Token token1, Token token2, expr obj1, Token token3, stmt obj2, if_stmt1 obj3){
        this.token1 = token1;
        this.token2 = token2;
        this.obj1 = obj1;
        this.token3 = token3;
        this.obj2 = obj2;
        this.obj3 = obj3;
    }
    @Override
    public void printNode() {
        System.out.println("Rule23");
        System.out.println(token1.value);
        System.out.println(token2.value);
        if (obj1!=null)
            obj1.printNode();
        System.out.println(token3.value);
        if (obj2!=null)
            obj2.printNode();
        if (obj3!=null)
            obj3.printNode();
    }


}
