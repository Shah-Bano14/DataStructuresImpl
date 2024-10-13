package src.main.java.basics;

import java.util.ArrayList;
import java.util.Collections;

public class test {

    public static void main(String[] args) {
        ArrayList<String> li = new ArrayList<>();
        li.add("der");
        li.add("des");
        li.add("dfr");
        li.add("dgt");
        li.add("dfs");
        Collections.sort(li);

        System.out.println(li);
    }
    
}
