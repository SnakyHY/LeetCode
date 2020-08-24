package com.snakyhy.tencent.string;
/*给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？
    请你找出所有满足条件且不重复的三元组。

        注意：答案中不可以包含重复的三元组。

         

        示例：

        给定数组 nums = [-1, 0, 1, 2, -1, -4]，

        满足要求的三元组集合为：
        [
        [-1, 0, 1],
        [-1, -1, 2]
        ]*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution5 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums==null||nums.length<=2)return res;

        Arrays.sort(nums);//排序,O(logn)

        for(int i=0;i<nums.length-2;i++){
            if(nums[i]>0)break;
            if(i>0&&nums[i]==nums[i-1])continue;
            int target=-nums[i];
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                if(nums[left]+nums[right]==target){
                    res.add(new ArrayList<>(Arrays.asList(nums[i],nums[left],nums[right])));

                    left++;
                    right--;
                    while(left<right&&nums[left]==nums[left-1])left++;
                    while(left<right&&nums[right]==nums[right+1])right--;
                }else if(nums[left]+nums[right]<target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "";
        System.out.print(str.split(",").length);
    }
}
