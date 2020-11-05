public class AB implements Node {
    //35 - AB → ; | expr ;
    Token token;
    expr obj;
    public AB (Token token){
        this.token = token;
    }
    public AB (expr obj, Token token){
        this.obj = obj;
        this.token = token;
    }
    @Override
    public void printNode() {
        System.out.println("Rule35");
        if (obj!=null)
            obj.printNode();
        if(token!=null)
            System.out.println(token.value);
    }
}
