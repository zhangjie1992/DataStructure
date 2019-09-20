package lanchong.iloveu.algorithm;


import java.util.HashMap;

/**
 * 字符串匹配
 */
public class StringMatching {

    /**
     * BF算法
     */
    public boolean bf(String src, String target) {
        if (src == null || target == null || src.length() < target.length())
            return false;

        char[] srcChars = src.toCharArray();
        char[] targetChars = target.toCharArray();

        for (int i = 0, j; i <= src.length() - target.length(); i++) {
            for (j = 0; j < target.length(); j++) {
                if (srcChars[i + j] != targetChars[j]) break;
            }
            if (j == target.length()) return true;
        }
        return false;
    }


    /**
     * RK算法
     * 借助hash算法,这里的hash很简单 a=0 b=1 c=2....
     * 当前写法允许小写字母
     */
    public boolean rk(String src, String target) {
        if (src == null || target == null || src.length() < target.length())
            return false;
        initMap();

        int n = src.length();
        int m = target.length();

        char[] srcChars = src.toCharArray();
        char[] targetChars = target.toCharArray();
        int targetHash = 0;
        int srcRangeHash = 0;
        int i = 0;
        for (; i < m; i++) {
            srcRangeHash = srcRangeHash * 26 + map.get(srcChars[i]);
            targetHash = targetHash * 26 + map.get(targetChars[i]);
        }

        if (targetHash==srcRangeHash){
            return true;
        }

        for (; i < n; i++) {
            int prev = map.get(srcChars[i-m])*(int)Math.pow(26,m-1);

            srcRangeHash = (srcRangeHash - prev)*26+map.get(srcChars[i]);
            if (targetHash==srcRangeHash){
                return true;
            }
        }

        return false;
    }

    private HashMap<Character, Integer> map = new HashMap<>();

    private void initMap() {
        char c = 'a';
        for (int i = 0; i < 26; i++, c += 1) {
            //hash关系
            map.put(c, i);
        }
    }


}
