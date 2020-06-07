import func.CosineSimilarity;
import func.MyComparator;
import func.StartIndexBuilder;
import index.IndexBuilder;
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
        Iterator<Map.Entry<String, TreeMap<Integer, Integer>>> iter = invertedMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, TreeMap<Integer, Integer>> entry = iter.next();
            String key = entry.getKey();
            invertedList.add(key);
        }
//        System.out.println("!!!");
//        System.out.println("invertedList = " + invertedList);
        page.setVector(invertedList);
        System.out.println("请输入要查询的语句：");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str;
            str = sc.nextLine();
            ArrayList<String> inputWords = t.getWords(str);
            ArrayList<Integer> inputVector = new ArrayList<Integer>();
            for (String word : invertedList) {
                if (inputWords.contains(word)) {
                    inputVector.add(1);
                } else {
                    inputVector.add(0);
                }
            }
            CosineSimilarity c = new CosineSimilarity();
            double inputLength = c.getLength(inputVector);
            for (IndexBuilder index :
                    page.getPage()) {
                double relativity = c.getSimilarity(inputVector, index.getWordVector(), inputLength, index.getLength());
                index.setRelativity(relativity);
            }
            page.sortByRelativity();
            page.printPage();
            System.out.println("请输入要查询的语句：");
        }
    }
}
