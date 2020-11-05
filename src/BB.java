public class BB implements Node{
    //6 - BB  →  ; | [ ] ;
    Token token1,token2,token3;
    public  BB(Token token1){
        this.token1 = token1;
    }
    public BB(Token token2, Token token3){
        this.token2 = token2;
        this.token3 = token3;
    }

    @Override
    public void printNode() {
        System.out.println("rule 6");
        if (token1 != null){
            System.out.println(token1.value);
            return;
        }
        System.out.println(token2.value);
        System.out.println(token3.value);
    }
}
