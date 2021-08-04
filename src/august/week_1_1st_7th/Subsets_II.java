package august.week_1_1st_7th;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * @Author: Everglow
 * @Date: 2021/8/4 14:16
 * @Version: 1.0.0
 */
public class Subsets_II {
    public int partition(int A[], int low, int high) {

        int pivot = A[high];
        int i = low - 1;

        for (int j = low; j < high; j++) { // 保证所有比pivot小的元素都放在A[low]...A[i]中
            if (A[j] <= pivot) {
                i++;
                int temp = A[j];
                A[j] = A[i];
                A[i] = temp;
            }
        }

        int temp2 = A[high];
        A[high] = A[i + 1];
        A[i + 1] = temp2;

        return i + 1;
    }

    public void quick_sort(int A[], int low, int high) {
        if (low < high) {
            int mid = partition(A, low, high);
            quick_sort(A, low, mid - 1);
            quick_sort(A, mid + 1, high);
        }
    }

    /**@author
     * @date 20151015
     * 感觉是动态规划的思想
     * 求集合的子集只需要先求前面的子集，比如{1,2,3}，在知道{1,2}的子集为空集，{1}，{2}再求{1,2,3}的子集只需要在前面四个子集的基础上再让这四个子集分别加上3，即得到最后的8个子集。
     * 	只有当前子集不在结果中才加入到最后的结果中
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        quick_sort(nums, 0, nums.length-1);//第一步对元素进行排序，原因是后面需要判断当前子集是否在结果中
        Arrays.sort(nums);
        List<List<Integer>> resultList = new LinkedList<List<Integer>>();
        List<Integer> list = new LinkedList<Integer>();
        resultList.add(list);
        int length = nums.length;

        for(int index=0;index<length;index++){
            int resultSize = resultList.size();//先获取得到之前的子集个数
            for(int re=0;re<resultSize;re++){//在目前子集的基础上加分别由各个子集加上新增的元素
                list = resultList.get(re);
                /*必须要加后面下面的两行，因为如果不加的话在resultList.get(re)得到的一个链表的引用，那样的list的内容会被覆盖*/
                List<Integer> newlist = new LinkedList<Integer>();
                newlist.addAll(list);//把从现有结果中得到的list的值全部赋给新的list

                newlist.add(nums[index]);//newlist再加上当前的数组元素
                /*只有当前子集不在结果中才加入到最后的结果中*/
                if(!resultList.contains(newlist)){
                    resultList.add(newlist);
                }

            }
        }

        return resultList;
    }

    public static void main(String[] args) {
        Subsets_II s=new Subsets_II();
        int[] nums={1,2,2};
        System.out.println(s.subsetsWithDup(nums));
    }
}
