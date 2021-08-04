package august.week_1_1st_7th;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: the optimal code in leetCode
 * @Author: prashul
 * @Date: 2021/8/4 16:29
 * @Version: 1.0.0
 */
public class Subsets_II_for_LeetCode {
    List<List<Integer>> output;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); //To handle duplicate first we sort the array ( adjacent elements will be similar )
        output = new ArrayList();
        backTracking(0, nums, new ArrayList());
        return output;
    }

    public void backTracking(int index, int[] nums, List<Integer> list) {
        output.add(new ArrayList(list));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) { //skip the duplicates, except for the first time
                continue;
            }
            list.add(nums[i]); //include
            backTracking(i + 1, nums, list); //explore
            list.remove(list.size() - 1);//backtrack, remove the element
        }
    }

    public static void main(String[] args) {
        Subsets_II_for_LeetCode s=new Subsets_II_for_LeetCode();
        int[] cases={1,2,2};
        System.out.println(s.subsetsWithDup(cases));
    }
}
