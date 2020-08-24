package com.snakyhy.tencent.string;

/*给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

        你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

         

        示例:

        给定 nums = [2, 7, 11, 15], target = 9

        因为 nums[0] + nums[1] = 2 + 7 = 9
        所以返回 [0, 1]*/

import java.util.HashMap;

public class Solution1 {

    //暴力算法（自创），慢
    public int[] twoSum(int[] nums, int target) {
        if(nums.length<2){
            return null;
        }
        int left=0;
        int right=0;
        int[] res=new int[2];
        for(;left<nums.length;left++){
            for(right=left+1;right< nums.length;right++){
                if(nums[left]+nums[right]==target){
                    res[0]=left;
                    res[1]=right;
                    return res;
                }
            }
        }
        return null;
    }
    //HashMap反向搜索，快
    public int[] twoSum2(int[] nums, int target) {
        int[] indexs = new int[2];

        // 建立k-v ，一一对应的哈希表
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(hash.containsKey(nums[i])){
                indexs[0] = i;
                indexs[1] = hash.get(nums[i]);
                return indexs;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target-nums[i],i);
        }
        return indexs;
    }

    public static void main(String[] args) {
        Solution1 s=new Solution1();
        int []nums={1,2,3};
        System.out.println(s.twoSum(nums,3));
    }
}
