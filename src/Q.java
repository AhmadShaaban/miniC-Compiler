public class Q implements Node{
    //36 - Q  → = expr | ε
    Token token1;
    expr obj;
    public Q(Token token1,expr obj){
        this.token1 = token1;
        this.obj = obj;
    }
    public Q(){
        //
    }

    @Override
    public void printNode() {
        System.out.println("Rule36");
        if (token1!=null){
            System.out.println(token1.value);
        }
        if (obj!=null)
            obj.printNode();
    }
}
