public class args implements Node {
    //args → arg_list | ε
    arg_list obj;
    public args(arg_list obj){
        this.obj = obj;
    }
    public args(){
        this.obj = null;
    }
    @Override
    public void printNode() {
        System.out.println("Rule34");
        if (obj!=null)
            obj.printNode();
    }
}
