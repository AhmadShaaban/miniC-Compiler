public class fun_decl implements Node {
    //fun_decl → type_spec IDENT ( params ) compound_stmt
    type_spec obj1;
    Token IDENT;
    Token open;
    params obj;
    Token closed;
    compound_stmt obj2;

    public fun_decl(type_spec obj1, Token IDENT , Token open , params obj, Token closed, compound_stmt obj2){
        this.obj = obj;
        this.closed = closed;
        this.IDENT = IDENT;
        this.obj1 = obj1;
        this.obj2 = obj2;
        this.open = open;
    }

    @Override
    public void printNode() {
        System.out.println("Rule8");
        if(obj1!=null)
            obj1.printNode();
        System.out.println(IDENT.value);
        System.out.println(open.value);
        if(obj!=null)
            obj.printNode();
        System.out.println(closed.value);
        if(obj2!=null)
            obj2.printNode();

    }
}
