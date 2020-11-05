public class decl_list implements Node {
    //2 - decl_list  → decl decl_list `

    decl_list1 obj1;
    decl obj2;

    public decl_list(decl obj2, decl_list1 obj1){
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public void printNode() {
        System.out.println("rule2");
        if (obj1 != null) {
            obj1.printNode();

        }
        if (obj2 != null)
            obj2.printNode();
    }
}
