import java.util.ArrayList;

public class Parser {
    public boolean ifEmpty(){
        return Tokens.myTokens.size() == 0;
    }
    public Token getPeek(){
        if (Tokens.myTokens.size() == 0){
            Token x = new Token();
            return x;
        }
        if (Tokens.myTokens.peek().type == "SINGLE_COMMENT" ||Tokens.myTokens.peek().type == "MULTI_COMMENT" ){
            Pop();
            if (Tokens.myTokens.size() == 0){
                Token x = new Token();
                return x;
            }
        }
        return Tokens.myTokens.peek();

    }
    public Token Pop(){
        Token y = Tokens.myTokens.peek();
        Tokens.temp.push(y);
        Tokens.myTokens.pop();
        return y;
    }
    public void StepBack(){
        Token xx = Tokens.temp.peek();
        Tokens.temp.pop();
        Tokens.myTokens.push(xx);
    }


    public program parse(){
        //1 -  program → decl_list
        decl_list x = decl_list_fn();
        return new program(x);

    }

    public decl_list decl_list_fn(){
        //2 - decl_list  → decl decl_list `
        decl x = decl_fn();
        if(x == null)
            return null;
        decl_list1 y = decl_list1_fn();
        if (y == null)
            return null;
        return new decl_list(x,y);
    }

    public decl_list1 decl_list1_fn(){
        //3 - decl_list `  → decl decl_list `  |  ε

        decl x = decl_fn();
        if (x == null)
            return new decl_list1();
        decl_list1 y = decl_list1_fn();
        return new decl_list1(x,y);
    }

    public  decl decl_fn(){
        //4 - decl → var_decl | fun_decl
        var_decl x = var_decl_fn();
        if (x != null)
            return new decl(x);

        fun_decl y = fun_decl_fn();
        if (y!=null)
            return new decl(y);
        return null;
    }

    var_decl var_decl_fn(){
        //5 - var_decl → type_spec IDENT BB
        Token y;
        type_spec x = type_spec_fn();
        if (x == null)
            return null;
        if (getPeek().type.equals("IDENT")){
            y = Pop();


        }
        else{
            StepBack();
            return null;
        }

        BB z = BB_fn();
        if (z == null){
            StepBack();
            StepBack();
            return null;
        }
        return new var_decl(x,y,z);
    }

    BB BB_fn (){
        //6 - BB  →  ; | [ ] ;
        if (getPeek().value.equals(";") ){

            return new BB(Pop());
        }
        if (getPeek().value.equals("[") ){
            Token x = Pop();
            Token y;
            Token z;
            if (!getPeek().equals("]")){
                StepBack();
                return null;
            }
            z = Pop();
            if (getPeek().value.equals(";") ){
                 y = Pop();
                 return new BB(x,y);}
            else{
                StepBack();
                StepBack();
                return null;

            }
        }
        else {
            return null;
        }
    }

    type_spec type_spec_fn(){
        //7 - type_spec → VOID | BOOL | INT | FLOAT
        if (ifEmpty()){
            return null;
        }

        if (getPeek().type.equals("VOID")  || getPeek().type.equals("BOOL")  || getPeek().type.equals("INT")  || getPeek().type.equals("FLOAT") ){
            Token y = Pop();

            return new type_spec(y);
        }
        return null;

    }

    fun_decl fun_decl_fn(){

        //8 - fun_decl → type_spec IDENT ( params ) compound_stmt
        type_spec x = type_spec_fn();
        if (x == null)
            return null;
        Token y,y2,y3;
        if(ifEmpty() || !getPeek().type.equals("IDENT")){
            StepBack();
            return null;
        }
        else{
            y = Pop();
        }


        if(ifEmpty() || !getPeek().value.equals("(")){
            StepBack();
            StepBack();
            return null;
        }
        else{
            y2 = Pop();
        }

        params z = params_fn();

        if(ifEmpty() || z == null || !getPeek().value.equals(")")){
            StepBack();
            StepBack();
            StepBack();
            return null;
        }


        y3 = Pop();

        compound_stmt h = compound_stmt_fn();
        //compd+stmt null
        if (h == null)
            return null;

        return new fun_decl(x,y,y2,z,y3,h);


    }

    params params_fn(){
        //9 - params → param_list | VOID
        param_list x = param_list_fn();
        if (x == null){

            if (getPeek().value.equals("VOID")) {
                Token y = Pop();
                return new params(y);
            }
            return null;
        }
        return new params(x);

    }
    param_list param_list_fn(){
        //10 - param_list → param param_list`
        param x = param_fn();
        if (x == null)
            return null;
        param_list1 y = param_list1_fn();
        if (y == null)
            return null;
        return new param_list(x,y);
    }
    param_list1 param_list1_fn(){
        //11 - param_list` → , param param_list` | ε
        if (!getPeek().value.equals(",")){
            return new param_list1();
        }
        Token y = Pop();
        param x = param_fn();
        if (x == null) {
            StepBack();
            return null;
        }
        param_list1 z = param_list1_fn();
        if (z == null){
            StepBack();
            return null;
        }
        return new param_list1(y,x,z);

    }

    param param_fn(){
        //12 - param → type_spec  IDENT param`
        type_spec x = type_spec_fn();
        if (x == null)
            return null;
        if (!getPeek().type.equals("IDENT")){
            StepBack();
            return null;
        }
        Token y = Pop();
        param1 z = param1_fn();
        if (z == null){
            StepBack();
            StepBack();
            return null;
        }
        return new param(x,y,z);
    }

    param1 param1_fn(){
        //13 - param` → ε |  [ ]
        Token x,y;
        if (!getPeek().value.equals('[')){
            return new param1();
        }
        x = Pop();
        if (!getPeek().value.equals(']')){
            StepBack();
            return null;
        }
        y = Pop();
        return new param1(x,y);
    }

    compound_stmt compound_stmt_fn(){
        //19 - compound_stmt → { local_decls stmt_list }

        if (!getPeek().value.equals("{")){
            return null;
        }

        Token x,w;
        x = Pop();

        local_decls y = local_decls_fn();

        if (y == null){
            StepBack();
            return null;
        }

        stmt_list z = stmt_list_fn();
        if (z == null){
            return null;
        }

        if (getPeek().value.equals("}")){
            w = Pop();
            return new compound_stmt(x,y,z,w);
        }
        return null;
    }

    local_decls local_decls_fn(){
        //20 - local_decls →  local_decls`
        local_decls1 x = local_decls1_fn();

        if (x==null)
            return null;
        return new local_decls(x);
    }

    local_decls1 local_decls1_fn(){
        //21 - local_decls` → local_decl local_decls` | ε
        local_decl x = local_decl_fn();

        if (x==null){
            return new local_decls1();
        }

        local_decls1 y = local_decls1_fn();
        if (y==null)
            return null;
        return new local_decls1(x,y);
    }

    local_decl local_decl_fn(){
        //22 - local_decl → type_spec IDENT  BB
        type_spec x = type_spec_fn();
        Token y;
        if (x == null)
            return  null;
        if (!getPeek().type.equals("IDENT")){
            StepBack();
            return null;

        }
        y = Pop();
        BB z = BB_fn();
        if (z == null){
            StepBack();
            StepBack();
            return null;
        }
        return new local_decl(x,y,z);
    }

    stmt_list stmt_list_fn(){
        //14 - stmt_list →  stmt_list`
        stmt_list1 x = stmt_list1_fn();
        return new stmt_list(x);
    }

    stmt_list1 stmt_list1_fn(){
        //15 - stmt_list` → stmt stmt_list` | ε
        stmt x = stmt_fn();
        if (x == null)
            return new stmt_list1();
        stmt_list1 y = stmt_list1_fn();
        if (y==null)
            return null;
        return new stmt_list1(x,y);
    }
    stmt stmt_fn(){
        //16 - stmt → expr_stmt | compound_stmt | if_stmt | while_stmt | return_stmt | break_stmt

        expr_stmt x = expr_stmt_fn();

        if (x!=null) {

            return new stmt(x);
        }
        compound_stmt y = compound_stmt_fn();
        if (y!=null)
            return new stmt(y);
        if_stmt z = if_stmt_fn();
        if (z!=null)
            return new stmt(z);
        while_stmt w = while_stmt_fn();
        if (w!=null)
            return new stmt(w);
        return_stmt a = return_stmt_fn();
        if (a!=null)
            return new stmt(a);
        if(getPeek().value.equals("break")){
            Token xx = Pop();
            return new stmt(xx);
        }
        return null;
    }



    expr_stmt expr_stmt_fn(){
        //17 - expr_stmt → expr ; | ;

        if (getPeek().value.equals(";")){
            return new expr_stmt (Pop());
        }

        expr x = expr_fn();
        Token y;
        if (x == null){
            return null;
        }

        if (!getPeek().value.equals(";")){
            return null;
        }
        y = Pop();

        return new expr_stmt(x,y);

    }

        while_stmt while_stmt_fn(){
            //18 - while_stmt → WHILE ( expr ) stmt
            if (!getPeek().value.equals("while")){
                return null;
            }
            Token x = Pop();
            if (!getPeek().value.equals("(")){
                StepBack();
                return null;
            }
            Token y = Pop();

            expr z = expr_fn();
            if (z == null)
                return null;
            if (!getPeek().value.equals(")")){
                StepBack();
                StepBack();
                return null;
            }
            Token w = Pop();
            stmt h = stmt_fn();
            if (h==null){
                StepBack();
                StepBack();
                StepBack();
                return null;
            }

            return new while_stmt(x,y,z,w,h);
        }

    if_stmt if_stmt_fn(){

        // //23 - if_stmt → IF  ( expr ) stmt if_stmt`
        if(!getPeek().value.equals("if")){
            return null;
        }
        Token x = Pop();

        if (!getPeek().value.equals("(")){
            StepBack();
            return null;
        }
        Token y = Pop();

        expr z = expr_fn();
        if (z== null){


            StepBack();
            StepBack();
            return null;
        }

        if (!getPeek().value.equals(")")){

            StepBack();
            StepBack();
            return null;
        }
        Token w = Pop();
        stmt xx = stmt_fn();
        if (xx == null){

            StepBack();
            StepBack();
            return null;
        }
        if_stmt1 xy = if_stmt1_fn();
        if (xy == null){

            StepBack();
            StepBack();
            return null;
        }

        return new if_stmt(x,y,z,w,xx,xy);
    }

    if_stmt1 if_stmt1_fn(){
        ////24 - if_stmt` →  ε  |  ELSE stmt
        if (!getPeek().value.equals("else")){
            return new if_stmt1();
        }
        Token x = Pop();
        stmt y = stmt_fn();
        if (y == null){
            StepBack();
            return null;
        }
        return new if_stmt1(x,y);
    }
    return_stmt return_stmt_fn(){
        //25 - return_stmt → RETURN  AB

        if(!getPeek().value.equals("return")){
            return null;
        }
        Token x = Pop();
        AB y = AB_fn();
        if (y == null){
            StepBack();
            return null;
        }
        return new return_stmt(x,y);

    }

    AB AB_fn(){
        //35 - AB → ; | expr ;
        if (!getPeek().value.equals(";")){

            expr x = expr_fn();
            if (x == null)
                return null;
            if (!getPeek().value.equals(";")){

                return null;
            }
           
            Token y = Pop();
            return new AB(x,y);
        }
        return new AB(Pop());
    }

    expr expr_fn(){
        //26 - expr → IDENT  A  DONE
        //28 - expr → expr`  DONE
        //31 - expr	 → ! expr | - expr | + expr DONE
        //→ ( expr )     DONE
        // → BOOL_LIT | INT_LIT | FLOAT_LIT | NEW type_spec [ expr ]

        if (getPeek().type.equals("IDENT")){
            Token x = Pop();

            A y = A_fn();

            if (y==null){
                StepBack();
                return  null;
            }

            return new expr(x,y);
        }



        if (getPeek().value.equals("!") || getPeek().value.equals("-") || getPeek().value.equals("+")){
            Token y = Pop();
            expr z = expr_fn();
            if (z == null){
                StepBack();
                return null;
            }
            return new expr(y,z);
        }
        if (getPeek().value.equals("(")){
            Token y = Pop();
            expr z = expr_fn();
            if (z == null){
                StepBack();
                return null;
            }
            if (!getPeek().value.equals(")")){
                StepBack();
                return null;
            }
            return new expr(y,z,Pop());
        }

        if (getPeek().type.equals("BOOL_LIT") || getPeek().type.equals("INT_LIT") || getPeek().type.equals("FLOAT_LIT")){

            return new expr(Pop());
        }
        if (getPeek().value.equals("new")){
            Token y = Pop();
            type_spec z = type_spec_fn();
            if (z==null){
                StepBack();
                return null;
            }
            if (!getPeek().value.equals("[")){
                StepBack();
                return null;
            }
            Token ab = Pop();
            expr w = expr_fn();
            if (w == null){
                return null;
            }
            if (!getPeek().value.equals("]")){
                StepBack();
                return null;
            }
            return new expr(y,z,ab,w,Pop());

        }
        expr1 x = expr1_fn();
        if(x != null)
            return new expr(x);
        return null;

    }


    A A_fn(){
        //27 - A  → = expr | [ expr ] Q | ε | ( args) | . size | expr
        if (getPeek().value.equals("=")){
            Token x = Pop();
            expr y = expr_fn();
            if (y == null){
                StepBack();
                return null;
            }
            return new A(x,y);
        }
        if (getPeek().value.equals("[")){
            Token x = Pop();
            expr y = expr_fn();
            if (y == null){
                StepBack();
                return null;
            }
            if(!getPeek().value.equals("]")){
                StepBack();
                return null;
            }
            Token z = Pop();
            Q q = Q_fn();
            if (q==null){
                StepBack();
                StepBack();
                return null;
            }
            return new A(x,y,z,q);
        }
        if (getPeek().value.equals("(")){
            Token x = Pop();
            args y = args_fn();
            if (y==null) {
                StepBack();
                return null;
            }
            if (!getPeek().value.equals(")")){
                StepBack();
                return null;
            }
            return new A(x,y,Pop());
        }
        if (getPeek().value.equals(".")){
            Token x = Pop();
            if(getPeek().value.equals("size")){
                return new A(x,Pop());
            }
            StepBack();
        }
        expr hh = expr_fn();
        if (hh!=null)
            return new A(hh);
        return new A();
    }

    Q Q_fn(){
        //36 - Q  → = expr | ε
        if (getPeek().value.equals("=")){
            Token x = Pop();
            expr y = expr_fn();
            if (y==null)
                return null;
            return new Q(x,y);
        }
        return new Q();
    }

    expr1 expr1_fn(){
        //29 - expr` → B expr` | ε
        B x = B_fn();
        if (x != null){
            expr1 y = expr1_fn();
            if (y!=null)
                return new expr1(x,y);
            return null;
        }
        return new expr1();
    }

    B B_fn(){
        //30 - B → OR expr | EQ expr |  NE expr | LE expr | < expr | GE expr | > expr | AND expr | + expr | - expr |  * expr | / expr | % expr
        if (getPeek().type.equals("OR") || getPeek().type.equals("EQ") || getPeek().type.equals("NE") || getPeek().type.equals("LE") || getPeek().value.equals("<") || getPeek().type.equals("GE") || getPeek().value.equals(">") || getPeek().type.equals("AND") || getPeek().value.equals("+")||getPeek().value.equals("-")||getPeek().value.equals("*") ||getPeek().value.equals("/")||getPeek().value.equals("%")){
            Token x= Pop();
            expr y = expr_fn();
            if (y==null){
                StepBack();
                return null;
            }
            return new B(x,y);
        }
        return null;
    }

    arg_list arg_list_fn(){
        //32 - arg_list → expr arg_list`

        expr x = expr_fn();

        if (x == null)
            return null;
        arg_list1 y = arg_list1_fn();
            if (y == null){

                return null;
            }


        return new arg_list(x,y);
    }

    arg_list1 arg_list1_fn(){
        //33 - arg_list` → , expr arg_list` | ε
        if (!getPeek().value.equals(",")){
            return new arg_list1();
        }
        Token x = Pop();
        expr y = expr_fn();
        if (y == null)
            return null;
        arg_list1 z = arg_list1_fn();
        if (z==null)
            return null;
        return new arg_list1(x,y,z);
    }

    args args_fn(){
        //34 - args → arg_list | ε

        arg_list x = arg_list_fn();
        if (x==null) {

            return new args();
        }

        return new args(x);
    }




}
