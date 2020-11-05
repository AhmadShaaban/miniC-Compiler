public class Token {
    public String type;
    public String value;
    public  String tokenName;

    public Token(){
        type="";
        value="";
    }
    public Token(String type, String value){
        this.type = type;
        this.value = value;
    }
}
