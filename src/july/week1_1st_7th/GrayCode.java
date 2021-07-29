package july.week1_1st_7th;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: Everglow
 * @Date: 2021/7/29 14:34
 * @Version: 1.0.0
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<String> ans1 = grayCodeHelper(n);
        List<Integer> ans2 = new ArrayList<>();
        for (int i = 0; i < ans1.size(); i++) {
            ans2.add(Integer.parseInt(ans1.get(i), 2));
        }
        return ans2;
    }

    public List<String> grayCodeHelper(int n) {

        if (n == 0) {
            List<String> ans = new ArrayList<>();
            ans.add("0");
            return ans;
        }

        if (n == 1) {
            List<String> ans = new ArrayList<>();
            ans.add("0");
            ans.add("1");
            return ans;
        }

        List<String> rres = grayCodeHelper(n - 1);
        List<String> mres = new ArrayList<>();

        for (int i = 0; i < rres.size(); i++) {
            mres.add("0" + rres.get(i));
        }

        for (int i = rres.size() - 1; i >= 0; i--) {
            mres.add("1" + rres.get(i));
        }

        return mres;
    }

    public static void main(String[] args) {
        GrayCode s=new GrayCode();
        s.grayCode(2).forEach(System.out::println);
    }
}
