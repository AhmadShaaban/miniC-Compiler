public class stmt_list implements Node {
    //14 - stmt_list →  stmt_list`
    stmt_list1 obj;
    public stmt_list(stmt_list1 obj){
        this.obj = obj;
    }

    @Override
    public void printNode() {
        System.out.println("Rule14");
        if(obj!=null)
            obj.printNode();
    }
}
