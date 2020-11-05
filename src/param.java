public class param implements Node{
    //12 - param → type_spec  IDENT param`
    type_spec obj1;
    Token IDENT;
    param1  obj2;
    public param(type_spec obj1, Token IDENT, param1 obj2){
        this.obj1 = obj1;
        this.IDENT = IDENT;
        this.obj2 = obj2;
    }

    @Override
    public void printNode() {
        System.out.println("Rule12");
        if(obj1!=null)
            obj1.printNode();
        System.out.println(IDENT.value);
        if(obj2!=null)
            obj2.printNode();
    }
}
