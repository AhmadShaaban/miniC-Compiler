public class param1 implements Node {
    //13 - param` → ε |  [ ]
    Token token1,token2;
    public param1(Token token1,Token token2){
        this.token1 = token1;
        this.token2 = token2;
    }
    public param1(){
        this.token2 = null;
        this.token1 = null;
    }

    @Override
    public void printNode() {
        System.out.println("Rule13");
        if(token1!=null){
            System.out.println(token1.value);
            System.out.println(token2.value);
        }
    }
}
