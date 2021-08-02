package com.leetcode.editor.cn;
//给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。 
//
// 请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。 
//
// 如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。 
//
// 军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。 
//
// 
//
// 示例 1： 
//
// 
//输入：mat = 
//[[1,1,0,0,0],
// [1,1,1,1,0],
// [1,0,0,0,0],
// [1,1,0,0,0],
// [1,1,1,1,1]], 
//k = 3
//输出：[2,0,3]
//解释：
//每行中的军人数目：
//行 0 -> 2 
//行 1 -> 4 
//行 2 -> 1 
//行 3 -> 2 
//行 4 -> 5 
//从最弱到最强对这些行排序后得到 [2,0,3,1,4]
// 
//
// 示例 2： 
//
// 
//输入：mat = 
//[[1,0,0,0],
// [1,1,1,1],
// [1,0,0,0],
// [1,0,0,0]], 
//k = 2
//输出：[0,2]
//解释： 
//每行中的军人数目：
//行 0 -> 1 
//行 1 -> 4 
//行 2 -> 1 
//行 3 -> 1 
//从最弱到最强对这些行排序后得到 [0,2,3,1]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 2 <= n, m <= 100 
// 1 <= k <= m 
// matrix[i][j] 不是 0 就是 1 
// 
// Related Topics 数组 二分查找 矩阵 排序 堆（优先队列） 
// 👍 97 👎 0

import java.util.Arrays;

public class P1337TheKWeakestRowsInAMatrix{
    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 1, 0, 0, 0},
                                  {1, 1, 1, 1, 0},
                                  {1, 0, 0, 0, 0},
                                  {1, 1, 0, 0, 0},
                                  {1, 1, 1, 1, 1}};
        int[] result = new Solution1337().kWeakestRows(mat, 3);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}

/**
 * 此题考的是二分查找
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] sort = new int[mat.length];
        int[] result = new int[k];
        int min = 2147483647;
        for (int i = 0; i < mat.length; i++) {
            sort[i] = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    sort[i]++;
                } else {
                    break;
                }
            }
            if (sort[i] < min) {
                min = sort[i];
            }
        }
        int i = 0;
        int[] result1 = getInts(k, sort, result, min, i);
        if (result1 != null) {
            return result1;
        }

        return null;
    }

    private int[] getInts(int k, int[] sort, int[] result, int min, int i) {
        for (int j = 0; j < sort.length; j++) {
            if (sort[j] == min) {
                result[i] = j;
                i++;
            }
            if (i == k){
                return result;
            }
            if ( j == sort.length -1){
                min++;
                result = getInts(k, sort, result, min, i);
                break;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/**
 * 网友的代码，思路一致。将每行数量也存为二维数组，使用Arrays函数进行排序、输出。
 */
class Solution1337Func2 {
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length,m=mat[0].length;
        int[][] count = new int[n][2];
        for(int i=0;i<n;i++){
            count[i][1] = i;
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0) {
                    break;
                }
                count[i][0]++;
            }
        }
        //下标0是军人数目，下标1是原下标。
        // 如果军人数目相等，则按照原下标从小到大排序，否则按照军人数目从小到大排序
        Arrays.sort(count,(a, b)->(a[0]==b[0]?a[1]-b[1]:a[0]-b[0]));
        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = count[i][1];
        }
        return ans;
    }
}
