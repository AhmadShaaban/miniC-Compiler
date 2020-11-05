public class arg_list1 implements Node {
    //33 - arg_list` → , expr arg_list` | ε
    expr obj1;
    arg_list1 obj2;
    Token token;
    public arg_list1(Token token, expr obj1, arg_list1 obj2){
        this.obj1 = obj1;
        this.obj2 = obj2;
        this.token = token;
    }
    public arg_list1(){
        this.obj2 = null;
        this.obj1 = null;
        this.token = null;
    }
    @Override
    public void printNode() {
        System.out.println("Rule33");
        if (token!=null)
            System.out.println(token.value);
        if (obj1!=null)
            obj1.printNode();
        if (obj2!=null)
            obj2.printNode();
    }
}
