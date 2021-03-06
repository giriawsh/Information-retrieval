package page;

import func.CosineSimilarity;
import func.MyComparator;
import index.IndexBuilder;
import index.InventedIndex;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class PageBuilder {
    private ArrayList<IndexBuilder> page;

    public PageBuilder() {
        page = new ArrayList<IndexBuilder>();
    }

    public void insertIndex(IndexBuilder index) {
        page.add(index);
    }

    public IndexBuilder[] findIndexById(int id)//后续可以添加by keyword方法
    {
        ArrayList<IndexBuilder> rtn = new ArrayList<IndexBuilder>();
        for (IndexBuilder index : page) {
            if (index.getId() == id) {
                rtn.add(index);
            }
        }
        IndexBuilder[] rtnPage = new IndexBuilder[page.size()];
        page.toArray(rtnPage);
        return rtnPage;
    }

    public IndexBuilder[] GetAllIndex() {
        IndexBuilder[] rtnPage = new IndexBuilder[page.size()];
        page.toArray(rtnPage);
        return rtnPage;
    }

    public void printPage() {
        for (IndexBuilder index : page) {
            System.out.println("------------------------------------------");
            System.out.println("index id=" + index.getId());
            System.out.println("title=" + index.getTitle());
            System.out.println("content =" + index.getContent());
            System.out.println("date =" + index.getDate());
            System.out.println("url =" + index.getUrl());
            System.out.println("Vector = " + index.getWordVector());
            System.out.println("Relativity = " + index.getRelativity());
        }
    }

    public void outputPage() throws IOException {
        for (IndexBuilder index : page) {
            BufferedWriter out = new BufferedWriter(new FileWriter("data/index" + index.getId() + ".txt"));
//            out.write("Index id = ");
            out.write(String.valueOf(index.getId()));
            out.newLine();
//            out.write("Title = ");
            out.write(index.getTitle());
            out.newLine();
//            out.write("Content = ");
            out.write(index.getContent());
            out.newLine();
//            out.write("Date = ");
            out.write(index.getDate());
            out.newLine();
//            out.write("Url = ");
            out.write(index.getUrl());
            out.newLine();
            out.close();
        }
    }

    public TreeMap<String, TreeMap<Integer,Integer>> getInvertedList(){
        TreeMap<String,TreeMap<Integer,Integer>> InvertedList = new TreeMap<String, TreeMap<Integer, Integer>>();
        for(IndexBuilder index : page){
            int id = index.getId();
            for(String word : index.getWords()){
                if(!InvertedList.containsKey(word))
                {
                    //单词在统计中首次出现
                    TreeMap<Integer, Integer> tmpST = new TreeMap<Integer, Integer>();
                    tmpST.put(id, 1);
                    InvertedList.put(word, tmpST);
                } else{
                    TreeMap<Integer ,Integer> tmpST = InvertedList.get(word);
                    Integer count = tmpST.get(id);//在一篇索引中同个词重复出现处理记录
                    if(count == null){
                        tmpST.put(id, 1);
                    }else{
                        count ++;
                        tmpST.put(id, count);
                    }
                    InvertedList.put(word, tmpST);
                }
            }
        }
        return InvertedList;
    }

    public void setVector(ArrayList<String> invertedList){
        for(IndexBuilder index : page){
            ArrayList<Integer> tempList = new ArrayList<Integer>();
            for(String str : invertedList){
                if(index.getWordsNotDuplicate().contains(str)){
                    tempList.add(1);
                }else{
                    tempList.add(0);
                }
            }
            index.setWordVector(tempList);
            CosineSimilarity c = new CosineSimilarity();
            index.setLength(c.getLength(index.getWordVector()));
        }
    }

    public ArrayList<IndexBuilder> getPage() {
        return page;
    }

    public void setPage(ArrayList<IndexBuilder> page) {
        this.page = page;
    }

    public void sortByRelativity(){
        Collections.sort(page, new Comparator<IndexBuilder>() {
            public int compare(IndexBuilder o1, IndexBuilder o2) {
                if(o1.getRelativity() < o2.getRelativity())
                {
                    return 1;
                }
                else if(o1.getRelativity() == o2.getRelativity())
                {
                    return 0;
                }
                else
                {
                    return -1;
                }
            }
        });
    }
}
