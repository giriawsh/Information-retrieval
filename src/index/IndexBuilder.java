package index;
//针对单篇内容的建模

public class IndexBuilder {
    private int id;//索引序列号
    private String url;//url地址
    private String title;//取中括号为标题
    private String date;//发表日期
    private String content;//内容

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
