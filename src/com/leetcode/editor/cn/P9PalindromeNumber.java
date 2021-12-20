package com.leetcode.editor.cn;
//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。 
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 121
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：x = -121
//输出：false
//解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
// 
//
// 示例 3： 
//
// 
//输入：x = 10
//输出：false
//解释：从右向左读, 为 01 。因此它不是一个回文数。
// 
//
// 示例 4： 
//
// 
//输入：x = -101
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
//
// 
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？ 
// Related Topics 数学 
// 👍 1721 👎 0

public class P9PalindromeNumber{
//    public static void main(String[] args) {
//        System.out.println(new Solution().isPalindrome(121));
//    }
    //leetcode submit region begin(Prohibit modification and deletion)
 class Solution {
    // 1221
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        String xString = String.valueOf(Math.abs(x));
        String xSplit[] = xString.split("");
        int half = xSplit.length / 2; //5 : 2, 4:2
        if (xSplit.length % 2 == 1) {
            for (int i = 0; half - i >= 0 ; i++) {
                if (!xSplit[half - i].equals(xSplit[half + i]) ) {
                    return false;
                }
            }
        } else {
//            if (xSplit.length == 2) {
//                if (xSplit[0] != xSplit[1]) {
//                    return false;
//                }
//            } else {
                for (int i = 1; half - i >= 0 ; i++) {
                    if (!xSplit[half - i].equals(xSplit[half + i - 1])) {
                        return false;
                    }
                }
//            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    //例如，输入 1221，我们可以将数字 “1221” 的后半部分从 “21” 反转为 “12”，并将其与前半部分 “12” 进行比较，因为二者相同，我们得知数字 1221 是回文。
    //
//    int revertedNumber = 0;
//        while (x > revertedNumber) {
//        revertedNumber = revertedNumber * 10 + x % 10;
//        x /= 10;
//    }

    // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
    // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
    // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
//        return x == revertedNumber || x == revertedNumber / 10;
//
//    作者：LeetCode-Solution
//    链接：https://leetcode-cn.com/problems/palindrome-number/solution/hui-wen-shu-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
