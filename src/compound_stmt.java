public class compound_stmt implements Node {
    //19 - compound_stmt → { local_decls stmt_list }
    Token token1;
    local_decls obj1;
    stmt_list obj2;
    Token token2;
    public compound_stmt(Token token1,local_decls obj1, stmt_list obj2, Token token2){
        this.token1 = token1;
        this.obj1 = obj1;
        this.obj2 = obj2;
        this.token2 = token2;
    }

    @Override
    public void printNode() {
        System.out.println("Rule19");
        System.out.println(token1.value);
        if (obj1!=null)
             obj1.printNode();
        if(obj2!=null)
            obj2.printNode();
        System.out.println(token2.value);
    }
}
