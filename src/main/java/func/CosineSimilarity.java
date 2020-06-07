package func;

import java.util.ArrayList;

public class CosineSimilarity {
    public double getSimilarity(ArrayList<Integer> words1, ArrayList<Integer> words2, double length1, double length2) {//传入两组向量与各自的长度

        double score = getSimilarityImpl(words1, words2, length1, length2);

        //(int) (score * 1000000 + 0.5)其实代表保留小数点后六位 ,因为1034234.213强制转换不就是1034234。对于强制转换添加0.5就等于四舍五入
        score = (int) (score * 1000000 + 0.5) / (double) 1000000;

        return score;
    }

    public double getSimilarityImpl(ArrayList<Integer> words1, ArrayList<Integer> words2, double length1, double length2){
        double num = 0;//点乘法结果
        for(int i = 0; i < words1.size(); i++)
        {
            num +=(words1.get(i) * words2.get(i));
        }
        return (double)num/(length1 * length2);
    }

    public double getLength(ArrayList<Integer> words)
    {
        double sum = 0;
        for(int i : words){
            sum += i*i;
        }
        return (double)Math.sqrt((double)sum);
    }

}
