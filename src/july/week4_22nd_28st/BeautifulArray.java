package july.week4_22nd_28st;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: Everglow
 * @Date: 2021/7/29 14:50
 * @Version: 1.0.0
 */
public class BeautifulArray {
    //1 2 3 4 5 as example
    Map<Integer, int[]> dp = new HashMap<>();

    public int[] beautifulArray(int N) {
        if (dp.containsKey(N)) {
            return dp.get(N);
        }
        int[] res = new int[N];
        if (N == 1) {
            res[0] = 1;
            return res;
        }
        int index = 0;
        //dealing 1 2 3=>convert to 1 3 5
        int[] left = beautifulArray((N + 1) / 2);
        int[] right = beautifulArray(N / 2);
        for (int i : left) {
            res[index++] = i * 2 - 1;
        }
        for (int i : right) {
            res[index++] = i * 2;
        }
        dp.put(N, res);
        return res;
    }

}

