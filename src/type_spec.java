public class type_spec implements  Node {
    //7 - type_spec → VOID | BOOL | INT | FLOAT
    Token token;
    public type_spec (Token token){
        this.token = token;
    }

    @Override
    public void printNode() {
        System.out.println("rule7");
        System.out.println(token.value);
    }
}
