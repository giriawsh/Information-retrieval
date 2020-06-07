package index;
//针对单篇内容的建模

import java.util.ArrayList;

public class IndexBuilder {
    private int id;//索引序列号
    private String url;//url地址
    private String title;//取中括号为标题
    private String date;//发表日期
    private String content;//内容
    private ArrayList<String> words;//分词
    private String sentence;//拼接地址、内容做分词用
    private ArrayList<String> wordsNotDuplicate;//01向量空间构建时使用
    private ArrayList<Integer> wordVector;//向量空间
    private double length;//向量长度
    private double relativity;//针对特定语句的相关度

    public void setLength(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setRelativity(double relativity) {
        this.relativity = relativity;
    }

    public double getRelativity() {
        return relativity;
    }

    public void setWordsNotDuplicate(ArrayList<String> wordsNotDuplicate) {
        this.wordsNotDuplicate = wordsNotDuplicate;
    }

    public ArrayList<String> getWordsNotDuplicate() {
        return wordsNotDuplicate;
    }

    public ArrayList<Integer> getWordVector() {
        return wordVector;
    }

    public void setWordVector(ArrayList<Integer> wordVector) {
        this.wordVector = wordVector;
    }

    public String getSentence() {
        sentence = this.title + this.content;
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public void setWords(ArrayList<String> words) {
        this.words = words;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public String getUrl() {
        return url;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void printIndex(){
        System.out.println("index id=" + this.id);
        System.out.println("title=" + this.title);
        System.out.println("content =" + this.content);
        System.out.println("date =" + this.date);
        System.out.println("url =" + this.url);
        System.out.println("relativity = " + this.relativity);
    }
}
