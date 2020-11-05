public class local_decls1 implements Node {
    //21 - local_decls` → local_decl local_decls` | ε
    local_decl obj1;
    local_decls1 obj2;

    public local_decls1(local_decl obj1, local_decls1 obj2){
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    public local_decls1(){
        this.obj1 = null;
        this.obj2 = null;
    }
    @Override
    public void printNode() {
        System.out.println("Rule21");
        if(obj1!=null)
            obj1.printNode();
        if(obj2!=null)
            obj2.printNode();
    }
}
