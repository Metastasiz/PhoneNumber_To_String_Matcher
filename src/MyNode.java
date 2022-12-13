import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyNode implements Comparable<MyNode> {
    List<MyNode> nextNodes = new ArrayList<>();
    MyNode superNode;
    MyNode failure;
    char c;
    MyNode(){
        c=0;
        failure=this;
    }
    MyNode(MyNode s, char c){
        this.c=c;
        superNode=s;
        s.addNode(this);
    }
    public void addNode(MyNode n){
        nextNodes.add(n);
        Collections.sort(nextNodes);
    }
    public void addFail(MyNode n){failure=n;}
    public MyNode findNode(char find){
        for (MyNode e : nextNodes){
            if (e.c==find)return e;
        }
        return failure.findNode(find);
    }
    public MyNode getNext(int n){return nextNodes.get(n);}
    public MyNode getFail(){return failure;}

    @Override
    public int compareTo(MyNode o) {
        return this.c-o.c;
    }
    public String getLayer(){
        return getLayer(0);
    }
    public String getLayer(int layer){
        String out = "";
        if (layer == 0){
            out+="===\n";
            out+=c+"\n";
        }
        for (MyNode e : nextNodes){
            for (int i = 0; i < layer; i++)out+="--";
            out+="> ";
            out += e.c + "\n";
            out += e.getLayer(layer+1);
        }
        if (layer == 0){
            out+="===";
        }
        return out;
    }
    @Override
    public String toString(){
        return getLayer();
    }
}
