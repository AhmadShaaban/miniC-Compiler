public class var_decl implements Node {
    //5 - var_decl → type_spec IDENT BB
    type_spec obj1;
    Token IDENT;
    BB obj2;
    public var_decl(type_spec obj1, Token IDENT , BB obj2){
        this.obj1 = obj1;
        this.IDENT = IDENT;
        this.obj2 = obj2;

    }

    @Override
    public void printNode() {
        System.out.println("rule 5");
        if (obj1!=null)
            obj1.printNode();
        System.out.println(IDENT.value);
        if (obj2!=null)
            obj2.printNode();
    }
}
