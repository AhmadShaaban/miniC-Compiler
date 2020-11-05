public class stmt_list1 implements Node {
    //15 - stmt_list` → stmt stmt_list` | ε
    stmt obj1;
    stmt_list1 obj2;

    public stmt_list1(stmt obj1, stmt_list1 obj2){
        this.obj1 = obj1;
        this.obj2 = obj2;
    }
    public stmt_list1(){
        this.obj1 = null;
        this.obj2 = null;
    }

    @Override
    public void printNode() {
        System.out.println("Rule15");
        if (obj1!=null)
            obj1.printNode();
        if (obj2!=null){
            obj2.printNode();
        }
    }
}
