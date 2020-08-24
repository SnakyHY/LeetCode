package com.snakyhy.bytedance.stringchanllage;
/*
编写一个函数来查找字符串数组中的最长公共前缀。

        如果不存在公共前缀，返回空字符串 ""。

        示例 1:

        输入: ["flower","flow","flight"]
        输出: "fl"
        示例 2:

        输入: ["dog","racecar","car"]
        输出: ""
        解释: 输入不存在公共前缀。
        说明:

        所有输入只包含小写字母 a-z 。
        */

public class Solution2 {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) {
            return "";
        }
        String result = strs[0];
        for(int i=0; i<strs.length; i++) {
            while(strs[i].indexOf(result) != 0) {
                result = result.substring(0, result.length()-1);
                if(result.length() == 0) {
                    return "";
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution2 s=new Solution2();
        String[] strs={"flower","flow","flight"};
        System.out.println(s.longestCommonPrefix(strs));
    }
}
