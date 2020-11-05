public class decl implements Node {
    //4 - decl → var_decl | fun_decl
    var_decl obj1;
    fun_decl obj2;

    public decl(var_decl obj1){
        this.obj1 = obj1;

    }
    public decl(fun_decl obj2){
        this.obj2 = obj2;
    }

    @Override
    public void printNode() {
        System.out.println("rule4");
        if(obj1!=null)
            obj1.printNode();
        if (obj2!=null)
            obj2.printNode();
    }
}
