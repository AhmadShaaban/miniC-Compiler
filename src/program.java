public class program implements Node {
    //1 -  program → decl_list
    decl_list obj;

    public program(decl_list obj){
        this.obj = obj;
    }

    @Override
    public void printNode() {
        System.out.println("rule1");
        if (obj!=null)
            obj.printNode();
    }
}
