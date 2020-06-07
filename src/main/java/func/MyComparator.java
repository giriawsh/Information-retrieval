package func;

import index.IndexBuilder;

import java.util.Comparator;

public class MyComparator implements Comparator {

    public int compare(Object o1, Object o2) {
        IndexBuilder p1 = (IndexBuilder) o1;
        IndexBuilder p2 = (IndexBuilder) o2;
        if ((double)p1.getRelativity() < (double)p2.getRelativity()) return 1;
        else return 0;
    }
}
