package page;

import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.IndexAnalysis;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.util.*;

public class AnsjTest {
    public ArrayList<String> getWords(String str) {
//        System.out.println("goodnight");
//        String str = "“鸦片流毒于天下，则为害甚巨，法当从严！”一百多年前林则徐的这句话，现在看来，依旧毫不过时。1839年6月3日，林则徐虎门销烟。" ;
//        System.out.println(ToAnalysis.parse(str));
        Set<String> expectedNature = new HashSet<String>() {{
            add("n");add("v");add("vd");add("vn");add("vf");
            add("vx");add("vi");add("vl");add("vg");
            add("nt");add("nz");add("nw");add("nl");
            add("ng");add("userDefine");add("wh");
        }};
        ArrayList<String> words = new ArrayList<String>();
//        String str = "欢迎使用ansj_seg,(ansj中文分词)在这里如果你遇到什么问题都可以联系我.我一定尽我所能.帮助大家.ansj_seg更快,更准,更自由!" ;
        Result result = ToAnalysis.parse(str); //分词结果的一个封装，主要是一个List<Term>的terms
//        System.out.println(result.getTerms());

        List<Term> terms = result.getTerms(); //拿到terms
//        System.out.println(terms.size());

        for(int i=0; i<terms.size(); i++) {
            String word = terms.get(i).getName(); //拿到词
            String natureStr = terms.get(i).getNatureStr(); //拿到词性
            if(expectedNature.contains(natureStr)) {
//                System.out.println(word + ":" + natureStr);
                words.add(word);
            }
        }
//        for(int i = 0; i < words.size(); i++){
//            System.out.println(words.get(i));
//        }
        return words;
    }
}
