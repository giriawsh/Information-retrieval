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
}
