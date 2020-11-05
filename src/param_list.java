public class param_list implements Node {
    ////10 - param_list → param param_list`
    param obj1;
    param_list1 obj2;
    public param_list(param obj1 , param_list1 obj2){
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public void printNode() {
        System.out.println("Rule10");
        if (obj1!=null)
            obj1.printNode();
        if(obj2!=null)
            obj2.printNode();
    }
}
