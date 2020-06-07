package index;

import java.util.ArrayList;

public class InventedIndex {
    private String keyword;
    private ArrayList<Integer> value;

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setValue(ArrayList<Integer> value) {
        this.value = value;
    }

    public ArrayList<Integer> getValue() {
        return value;
    }

    public String getKeyword() {
        return keyword;
    }
}
