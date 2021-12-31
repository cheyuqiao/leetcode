package com.leetcode.editor.cn;
//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1939 👎 0

public class P14LongestCommonPrefix{
//    public static void main(String[] args) {
//        String[] strs = new String[]{"c","acc","ccc"};
//        System.out.println(new Solution().longestCommonPrefix(strs));
//    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 标准纵向查找
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int length = strs[0].length();
        int count = strs.length;
        for (int i = 0; i < length; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

    /**
     * 自己第一遍写的
     */
    class Solution2 {
        public String longestCommonPrefix(String[] strs) {
            StringBuilder sb = new StringBuilder("");
            String[] firstString = strs[0].split("");
            for (int i = 0; i < firstString.length; i++) {
                String str = firstString[i];
                boolean allHave = true;
                for (String s : strs) {
                    if (s.isEmpty()) {
                        allHave = false;
                        continue;
                    }
                    if (s.length() <= i) {
                        allHave = false;
                        continue;
                    }
                    String temp = s.substring(i, i+1);
                    if (!temp.equals(str)) {
                        allHave = false;
                        continue;
                    }
                }
                if (allHave) {
                    sb.append(str);
                } else {
                    return sb.toString();
                }
            }
            return sb.toString();
        }
    }

    /**
     * 自己写的纵向查找
     */
    class Solution3 {
        public String longestCommonPrefix(String[] strs) {
            StringBuilder sb = new StringBuilder("");
            if (strs == null || strs.length == 0) {
                return sb.toString();
            }
            String[] base = strs[0].split("");
            int min = base.length;
            // 纵向遍历
            for (int i = 0; i < strs.length; i++) {
                String[] now = strs[i].split("");
                int nowMin = 0;
                int temp = base.length < now.length ? base.length : now.length;
                for (int j = 0; j < temp; j++) {
                    if (base[j].equals(now[j])) {
                        nowMin++;
                    } else {
                        break;
                    }
                }
                if (nowMin < min) {
                    min = nowMin;
                }
            }
            for (int i = 0; i < min; i++) {
                sb.append(base[i]);
            }
            return sb.toString();
        }
    }
}
