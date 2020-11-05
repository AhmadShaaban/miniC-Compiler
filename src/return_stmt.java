public class return_stmt implements Node {
    //25 - return_stmt → RETURN  AB
    Token token1;
    AB obj;

    public return_stmt(Token token1, AB obj){
        this.token1 = token1;
        this.obj = obj;
    }



    @Override
    public void printNode() {
        System.out.println("Rule25");
        if (token1!=null)
            System.out.println(token1.value);
        if (obj!=null)
            obj.printNode();


    }
}
