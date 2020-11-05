public class local_decls implements Node {
    //20 - local_decls →  local_decls`
    local_decls1 obj1;
    public local_decls(local_decls1 obj1){
        this.obj1 = obj1;
    }



    @Override
    public void printNode() {
        System.out.println("Rule20");
        if(obj1!=null)
             obj1.printNode();
    }
}
