import func.StartIndexBuilder;
import page.AnsjTest;
import page.PageBuilder;

import java.util.TreeMap;

public class Main {
    public static void main(String[] args){
        StartIndexBuilder func = new StartIndexBuilder();
        PageBuilder page = func.getPage();
        AnsjTest t = new AnsjTest();
        TreeMap<String, TreeMap<Integer,Integer>> invertedList = new TreeMap<String, TreeMap<Integer, Integer>>();
        invertedList = page.getInvertedList();
        System.out.println("!!!");
        System.out.println(invertedList);
    }
}
