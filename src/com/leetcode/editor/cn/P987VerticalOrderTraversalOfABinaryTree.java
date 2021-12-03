package com.leetcode.editor.cn;
//给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。 
//
// 对位于 (row, col) 的每个结点而言，其左右子结点分别位于 (row + 1, col - 1) 和 (row + 1, col + 1) 。树的
//根结点位于 (0, 0) 。 
//
// 二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则
//按结点的值从小到大进行排序。 
//
// 返回二叉树的 垂序遍历 序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[9],[3,15],[20],[7]]
//解释：
//列 -1 ：只有结点 9 在此列中。
//列  0 ：只有结点 3 和 15 在此列中，按从上到下顺序。
//列  1 ：只有结点 20 在此列中。
//列  2 ：只有结点 7 在此列中。 
//
// 示例 2： 
//
// 
//输入：root = [1,2,3,4,5,6,7]
//输出：[[4],[2],[1,5,6],[3],[7]]
//解释：
//列 -2 ：只有结点 4 在此列中。
//列 -1 ：只有结点 2 在此列中。
//列  0 ：结点 1 、5 和 6 都在此列中。
//          1 在上面，所以它出现在前面。
//          5 和 6 位置都是 (2, 0) ，所以按值从小到大排序，5 在 6 的前面。
//列  1 ：只有结点 3 在此列中。
//列  2 ：只有结点 7 在此列中。
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2,3,4,6,5,7]
//输出：[[4],[2],[1,5,6],[3],[7]]
//解释：
//这个示例实际上与示例 2 完全相同，只是结点 5 和 6 在树中的位置发生了交换。
//因为 5 和 6 的位置仍然相同，所以答案保持不变，仍然按值从小到大排序。 
//
// 
//
// 提示： 
//
// 
// 树中结点数目总数在范围 [1, 1000] 内 
// 0 <= Node.val <= 1000 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 哈希表 二叉树 
// 👍 150 👎 0

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P987VerticalOrderTraversalOfABinaryTree {

    public static TreeNode arrayToBTree(Integer[] arrs) {
        if (arrs == null || arrs.length == 0) {
            return new TreeNode();
        }

        List<TreeNode> nodes = new ArrayList<>(arrs.length);
        for (Integer obj : arrs) {
            TreeNode treeNode = new TreeNode();
            if (obj != null) {
                treeNode.val = obj;
                nodes.add(treeNode);
            } else {
                nodes.add(null);
            }

        }

        for (int i = 0; i < arrs.length/2 - 1; i++) {
            TreeNode node = nodes.get(i);
            if (node == null) {
                continue;
            }
            if (nodes.get(i*2 + 1) != null) {
                node.left = nodes.get(i*2 + 1);
            } else {
                node.left = null;
            }
            if (nodes.get(i*2 + 2) != null) {
                node.right = nodes.get(i*2 + 2);
            } else {
                node.right = null;
            }
        }
        // 只有当总节点数是奇数时，最后一个父节点才有右子节点
        int lastPNodeIndex = arrs.length/2 - 1;
        if (nodes.get(lastPNodeIndex) != null) {
            TreeNode lastPNode = nodes.get(lastPNodeIndex);
            lastPNode.left = nodes.get(lastPNodeIndex*2 + 1);
            if (arrs.length % 2 != 0) {
                lastPNode.right = nodes.get(lastPNodeIndex*2 + 2);
            }
        }
        return nodes.get(0);
    }

    public static void main(String[] args) {
        Integer[] root = new Integer[]{0,5,1,9,null,2,null,null,null,null,3,4,8,6,null,null,null,7};
        TreeNode tree = arrayToBTree(root);
        List<List<Integer>> result = new Solution987().verticalTraversal(tree);
        System.out.println(result);
    }
}

//leetcode submit region begin(Prohibit modification and deletion)

class Solution987 {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        root.setXY(-1, 0, 0);
        int[] start = {0,0};
        // 查找root中y最小和y最大
        int[] minMax = root.findMinMax(start);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = minMax[0]; i <= minMax[1]; i++) {
            List<Integer> resultList = new ArrayList<>();
            result.add(root.findValueByY(i, resultList));
        }
        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    int x;
    int y;

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

    /**
     * 设置二叉树节点xy值
     * @param x
     * @param y
     * @param flag
     */
    void setXY(int x, int y, int flag) {
        this.x = x + 1;
        this.y = y + flag;
        if (this.left != null) {
            this.left.setXY(this.x, this.y, -1);
        }
        if (this.right != null) {
            this.right.setXY(this.x, this.y, 1);
        }
    }

    /**
     * 查找二叉树中节点y值最大和最小
     * @param minMax
     * @return
     */
    int[] findMinMax(int[] minMax) {
        if (this.y < minMax[0]) {
            minMax[0] = this.y;
        }
        if (y > minMax[1]) {
            minMax[1] = this.y;
        }
        if (this.left != null) {
            minMax = this.left.findMinMax(minMax);
        }
        if (this.right != null) {
            minMax = this.right.findMinMax(minMax);
        }
        return minMax;
    }

    /**
     * 查找y值匹配的value值，并排序
     * @param y
     * @return
     */
    List<Integer> findValueByY (int y, List<Integer> resultList) {
        if (this.y == y) {
            resultList.add(this.val);
        }
        List<Integer> resultTemp = new ArrayList<>();
        if (this.left != null) {
            resultTemp = this.left.findValueByY(y, resultTemp);
        }
        if (this.right != null) {
            resultTemp = this.right.findValueByY(y, resultTemp);
        }
        Collections.sort(resultTemp);
        resultList.addAll(resultTemp);
        return resultList;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
