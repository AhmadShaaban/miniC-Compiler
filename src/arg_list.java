public class arg_list implements Node {
    //32 - arg_list → expr arg_list`
    expr obj1;
    arg_list1 obj2;
    public arg_list(expr obj1, arg_list1 obj2){
        this.obj1 = obj1;
        this.obj2 = obj2;
    }
    @Override
    public void printNode() {
        System.out.println("Rule32");
        if (obj1!=null)
            obj1.printNode();
        if (obj2!=null)
            obj2.printNode();
    }
}
