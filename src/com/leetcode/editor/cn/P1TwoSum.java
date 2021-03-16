package com.leetcode.editor.cn;
//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 103 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 只会存在一个有效答案 
// 
// Related Topics 数组 哈希表 
// 👍 10501 👎 0

import java.util.Arrays;

public class P1TwoSum{
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2 || nums.length > 1000) {
            return null;
        }
        int index[] = new int[2];
        boolean finish = false;
        for (int i = 0; i < nums.length - 1; i++) {
            int number1 = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int number2 = nums[j];
                if( (number1 + number2) == target) {
                    index[0] = i;
                    index[1] = j;
                    finish = true;
                    break;
                }
            }
            if (finish) {
                break;
            }
            //Arrays.binarySearch需要排序后输出，否则可能会输出不正确
//            if (i < nums.length) {
//                int searchTarget = target - number;
//                int index2 = Arrays.binarySearch(nums, i + 1, nums.length, searchTarget);
//                if (index2 < 0) {
//                    continue;
//                }
//                index[0] = i;
//                index[1] = index2;
//                return index;
//            }
        }
        return index;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}