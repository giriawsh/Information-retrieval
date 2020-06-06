package page;

import index.IndexBuilder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PageBuilder {
    private List<IndexBuilder> page;

    public PageBuilder() {
        page = new ArrayList<>();
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
            System.out.println("index id=" + index.getId());
            System.out.println("title=" + index.getTitle());
            System.out.println("content =" + index.getContent());
            System.out.println("date =" + index.getDate());
            System.out.println("url =" + index.getUrl());
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
}
