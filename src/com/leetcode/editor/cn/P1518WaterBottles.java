package com.leetcode.editor.cn;
//小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。 
//
// 如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。 
//
// 请你计算 最多 能喝到多少瓶酒。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：numBottles = 9, numExchange = 3
//输出：13
//解释：你可以用 3 个空酒瓶兑换 1 瓶酒。
//所以最多能喝到 9 + 3 + 1 = 13 瓶酒。
// 
//
// 示例 2： 
//
// 
//
// 输入：numBottles = 15, numExchange = 4
//输出：19
//解释：你可以用 4 个空酒瓶兑换 1 瓶酒。
//所以最多能喝到 15 + 3 + 1 = 19 瓶酒。
// 
//
// 示例 3： 
//
// 输入：numBottles = 5, numExchange = 5
//输出：6
// 
//
// 示例 4： 
//
// 输入：numBottles = 2, numExchange = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= numBottles <= 100 
// 2 <= numExchange <= 100 
// 
// Related Topics 数学 模拟 
// 👍 79 👎 0

public class P1518WaterBottles{
//    public static void main(String[] args) {
//        int x = new Solution().numWaterBottles(15 ,4);
//        System.out.println(x);
//    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int totalNum;
        if (numExchange > numBottles) {
            return numBottles;
        }
        totalNum = numBottles + this.countNextNum(numBottles, numExchange);
        return totalNum;
    }
    public int countNextNum(int numBottles, int numExchange) {
        if (numExchange > numBottles) {
            return 0;
        }
        // 剩余瓶子
        int lastBottles = numBottles / numExchange;
        int nextBottles = lastBottles + (numBottles - numExchange * lastBottles);
        lastBottles += countNextNum(nextBottles, numExchange);
        return lastBottles;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
