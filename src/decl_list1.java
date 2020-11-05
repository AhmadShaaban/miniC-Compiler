public class decl_list1 implements Node {
    //3 - decl_list`  → decl decl_list `  |  ε
    decl obj1;
    decl_list1 obj2;

    public decl_list1(decl obj1, decl_list1 obj2){
        this.obj1 = obj1;
        this.obj2 = obj2;
    }
    public decl_list1(){
        //
    }

    @Override
    public void printNode() {
        System.out.println("rule 3");
        if (obj1!=null)
            obj1.printNode();
        if (obj2!=null)
            obj2.printNode();
    }
}
