package august.week_1_1st_7th;

import java.util.*;

/**
 * @Description:
 * @Author: Everglow
 * @Date: 2021/8/4 20:08
 * @Version: 1.0
 **/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class PathSum_II {
    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, 0, sum);
        return res;
    }

    public void dfs(TreeNode root, int num, int sum) {
        if (root == null) return;
        num += root.val;
        list.add(root.val);
        if (num == sum && root.left == null && root.right == null) res.add(new ArrayList<>(list));
        dfs(root.left, num, sum);
        dfs(root.right, num, sum);
        list.remove(list.size() - 1);
    }

}
