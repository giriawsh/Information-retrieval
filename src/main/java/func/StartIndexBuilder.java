package func;

import index.IndexBuilder;
import page.AnsjTest;
import page.PageBuilder;
import sun.awt.util.IdentityLinkedList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StartIndexBuilder {
    private PageBuilder page;

    public PageBuilder formatterData(){//进行格式化处理
        PageBuilder temp_page = new PageBuilder();
        try{
            String pathName = "C:\\Users\\giria\\Desktop\\index.txt";
            File f = new File(pathName);
            InputStreamReader read = new InputStreamReader(new FileInputStream(f), "gbk");
            BufferedReader in = new BufferedReader(read);
            String str;//save line data
            String title_str;//save the title
            String date_str;
            String url_str;
            String[] s = new String[0];
            Pattern pattern_id = Pattern.compile("-?[0-9]+\\.?[0-9]*");
            while((str=in.readLine())!=null){
                if(pattern_id.matcher(str).matches()){
                    //id
                    IndexBuilder index = new IndexBuilder();
                    index.setId(Integer.parseInt(str));
//                    System.out.println("index setid:"+index.getId());
                    //title
                    in.readLine();
                    title_str = in.readLine();
                    Pattern pattern_title = Pattern.compile(".*?\u3010(.*?)\u3011.*?");
                    Matcher matcher_title = pattern_title.matcher(title_str);
                    if(matcher_title.matches()){
                        index.setTitle(matcher_title.group(1));
//                        System.out.println("!!!"+matcher_title.group(1));
                        Pattern pattern_content = Pattern.compile(".*?\u3011(.*?)");
                        Matcher matcher_content = pattern_content.matcher(title_str);
                        if(matcher_content.matches()){
                            index.setContent(matcher_content.group(1));
                        }else{
                            index.setContent("");
                        }
                    }else{
                        index.setTitle("");
                        index.setContent(title_str);
                    }

                    //date
                    String temp = in.readLine();
//                    System.out.println("temp="+temp);
                    if(temp.equals(" 原图 "))
                    {
//                        System.out.println("No picture");
                        date_str = in.readLine();
                    }else{
                        date_str = temp;
                    }
//                    System.out.println("date_str="+date_str);
                    Pattern pattern_date = Pattern.compile(".*?藏 (.*?)");
                    String tail = " 来自微博 weibo.com";
                    Matcher matcher_date = pattern_date.matcher(date_str);
                    if(matcher_date.matches()){
                        if(matcher_date.group(1).contains(tail))
                        {
                            index.setDate(matcher_date.group(1).substring(0, matcher_date.group(1).length()-tail.length()));
                        }else {
                            index.setDate(matcher_date.group(1));
                        }
//                        System.out.println("date ="+index.getDate());
                    }else{
                        index.setDate("");
                    }

                    //url
                    in.readLine();
                    url_str = in.readLine();
                    Pattern pattern_url = Pattern.compile(".*?:(.*?)");
                    Matcher matcher_url = pattern_url.matcher(url_str);
                    if(matcher_url.matches()){
                        index.setUrl(matcher_url.group(1));
//                        System.out.println("url ="+matcher_url.group(1));
                    }else{
                        index.setUrl("");
                    }
                    AnsjTest t = new AnsjTest();
                    ArrayList<String> words = t.getWords(index.getSentence());
//                    System.out.println(words);
                    index.setWords(words);
                    temp_page.insertIndex(index);
                }
            }
//            page.printPage();
            temp_page.outputPage();
        }catch (IOException e){
        }
        return temp_page;
    }

    public PageBuilder getPage() {
        this.page = formatterData();
        return page;
    }

    public void setPage(PageBuilder page) {
        this.page = page;
    }
}
