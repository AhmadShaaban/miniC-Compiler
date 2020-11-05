public class params implements Node {
    //9 - params → param_list | VOID
    param_list obj1;
    Token token;
    public params (param_list obj1){
        this.obj1 = obj1;
    }
    public params(Token token){
        this.token = token;
    }

    @Override
    public void printNode() {
        System.out.println("Rule9");
        if(obj1!=null)
            obj1.printNode();
        if(token!=null)
            System.out.println(token.value);
    }
}
