package com.snakyhy.tencent.string;

/*给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

        示例 1：

        输入: "babad"
        输出: "bab"
        注意: "aba" 也是一个有效答案。
        示例 2：

        输入: "cbbd"
        输出: "bb"
        java.lang.UnsupportedOperationException: Not a string: null
        at line 389, com.eclipsesource.json.JsonValue.asString
	    at __Deserializer__.toString(Unknown Source)
        at line 82, __Driver__.main
        */

public class Solution3 {
    //暴力破解（自创）时间超出限制
    public String longestPalindrome(String s) {

        if(s==null){return "";}

        int strLen=s.length();
        String invStr=null;
        String convStr=null;
        String maxStr="";
        int maxLen=0;

        if(strLen==1){return s;}

        for(int index=0;index<strLen-1;index++){
            for(int len=1;len<=strLen-index;len++){
                invStr=s.substring(index, index+len);//ab
                convStr=converseStr(invStr);//ba
                if(s.indexOf(convStr, index+len)==index+len && maxLen<len){
                    maxLen=len;
                    maxStr=invStr+convStr;
                }else if(s.indexOf(convStr, index+len-1)==index+len-1 && maxLen<len){
                    if(len==1){
                        maxStr=invStr;
                        continue;
                    }
                    maxLen=len;
                    if(maxLen>1) {
                        String newConvStr = convStr.substring(1);
                        maxStr=invStr+newConvStr;
                    }
                }
            }
        }
        return s==""?"":maxStr;
    }
    public static String converseStr(String s){
        StringBuffer str=new StringBuffer();
        int strLen=s.length();
        for(int index=strLen-1;index>=0;index--){
            str.append(s.charAt(index));
        }
        return str.toString();
    }

    public static void main(String[] args) {
        Solution3 s=new Solution3();
        System.out.println(s.longestPalindrome(""));
    }
    //优化后的暴力解法
    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // s.charAt(i) 每次都会检查数组下标越界，因此先转换成字符数组
        char[] charArray = s.toCharArray();

        // 枚举所有长度大于 1 的子串 charArray[i..j]
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (j - i + 1 > maxLen && validPalindromic(charArray, i, j)) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    /**
     * 验证子串 s[left..right] 是否为回文串
     */
    private boolean validPalindromic(char[] charArray, int left, int right) {
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

   /* _______________________________________________________________*/

}
