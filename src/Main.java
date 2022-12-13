public class Main {
    public static void main(String[] arg){
        MyNode[] nodes1 = new MyNode[3];
        MyNode[] nodes2 = new MyNode[4];
        MyNode[] nodes3 = new MyNode[5];
        MyNode s = new MyNode();
        for (int i = 0; i < nodes1.length; i++){
            nodes1[i] = new MyNode(s,(char)(i+65));
        }
        for (int i = 0; i < nodes2.length; i++){
            nodes2[i] = new MyNode(nodes1[0],(char)(i+68));
        }
        for (int i = 0; i < nodes3.length; i++){
            nodes3[i] = new MyNode(nodes1[1],(char)(i+72));
        }
        System.out.println(s);
        System.out.println(nodes1[0]);

    }
}
