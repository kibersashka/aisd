package org.example;

import java.util.ArrayList;
import java.util.List;

public class NodeNTree {
    int value;
    List<NodeNTree> children = new ArrayList<>();
    public NodeNTree(){

    }

    public NodeNTree(int value) {
        this.value = value;
    }
    public void addChild(NodeNTree node){
        children.add(node);
    }

    @Override
    public String toString(){
        return value + " ";
    }

}
