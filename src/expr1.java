public class expr1 implements Node {
    //29 - expr` → B expr` | ε
    B obj1;
    expr1 obj2;
    public expr1(B obj1, expr1 obj2){
        this.obj1 = obj1;
        this.obj2 = obj2;
    }
    public expr1(){
        this.obj2 = null;
        this.obj1 = null;
    }

    @Override
    public void printNode() {
        System.out.println("Rule29");
        if (obj1!=null)
            obj1.printNode();
        if (obj2!=null)
            obj2.printNode();
    }
}
