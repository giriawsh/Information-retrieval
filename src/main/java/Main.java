import func.StartIndexBuilder;
import page.AnsjTest;
import page.PageBuilder;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        StartIndexBuilder func = new StartIndexBuilder();
        PageBuilder page = func.getPage();
        AnsjTest t = new AnsjTest();
        TreeMap<String, TreeMap<Integer, Integer>> invertedMap;
        invertedMap = page.getInvertedList();
        ArrayList<String> invertedList = new ArrayList<String>();
        Iterator iter = invertedMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            String key = (String) entry.getKey();
            invertedList.add(key);
        }
        System.out.println("!!!");
//        System.out.println("invertedMap = "+invertedMap);
        System.out.println("invertedList = " + invertedList);
        page.setVector(invertedList);
        page.printPage();
        System.out.println("请输入要查询的语句：");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str;
            str = sc.next();
//            System.out.println("你输入的是:"+str);
            ArrayList<String> inputWords = t.getWords(str);
            System.out.println("你输入的词是:" + inputWords);
            
        }

    }
}
