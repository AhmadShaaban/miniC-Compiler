public class param_list1 implements Node {
    //11 - param_list` → , param param_list` | ε
    Token token;
    param obj1;
    param_list1 obj2;

    public param_list1(Token token, param obj1, param_list1 obj2){
        this.token = token;
        this.obj1 = obj1;
        this.obj2 = obj2;
    }
    public  param_list1(){
        //
    }

    @Override
    public void printNode() {
        System.out.println("Rule11");
        if(token!=null){
            System.out.println(token.value);
            if(obj1!=null)
                obj1.printNode();
            if(obj2!=null)
                obj2.printNode();
        }
    }
}
