public class B implements Node{
    //30 - B → OR expr | EQ expr |  NE expr | LE expr | < expr | GE expr | > expr | AND expr | + expr | - expr |  * expr | / expr | % expr
    Token token;
    expr obj;
    public B (Token token , expr obj){
        this.token = token;
        this.obj = obj;
    }

    @Override
    public void printNode() {
        System.out.println("Rule30");
        if (token!=null)
            System.out.println(token.value);
        if (obj!=null)
            obj.printNode();
    }
}
