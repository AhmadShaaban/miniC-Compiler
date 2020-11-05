public class if_stmt1 implements Node {
    //24 - if_stmt` →  ε  |  ELSE stmt
    Token token;
    stmt obj;
    public if_stmt1(Token token,stmt obj){
        this.token = token;
        this.obj = obj;
    }
    public if_stmt1(){
        this.token = null;
        this.obj = null;
    }
    @Override
    public void printNode() {
        System.out.println("Rule24" );
        if (token!=null)
            System.out.println(token.value);
        if(obj!=null)
            obj.printNode();
    }
}
