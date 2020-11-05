public class stmt implements Node {
    //16 - stmt → expr_stmt | compound_stmt | if_stmt | while_stmt | return_stmt | break_stmt
    expr_stmt obj1;
    compound_stmt obj2;
    if_stmt obj3;
    while_stmt obj4;
    return_stmt obj5;
    Token break_stmt;
    public stmt(expr_stmt obj1){
        this.obj1 = obj1;

    }
    public stmt(compound_stmt obj2){
        this.obj2 = obj2;
    }
    public stmt(if_stmt obj3){
        this.obj3 = obj3;
    }
    public stmt(while_stmt obj4){
        this.obj4 = obj4;
    }
    public stmt(return_stmt obj5){
        this.obj5 = obj5;
    }
    public stmt(Token break_stmt){
        this.break_stmt = break_stmt;
    }

    @Override
    public void printNode() {
        System.out.println("Rule16");
        if (obj1!=null)
            obj1.printNode();
        if (obj2!=null)
            obj2.printNode();
        if (obj3!=null)
            obj3.printNode();
        if (obj4!=null)
            obj4.printNode();
        if (obj5!=null)
            obj5.printNode();
        if(break_stmt!=null){
            System.out.println(break_stmt.value);
        }
    }
}
