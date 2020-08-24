package com.snakyhy.tencent.string;
/*
给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。

        请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

        你可以假设 nums1 和 nums2 不会同时为空。

         

        示例 1:

        nums1 = [1, 3]
        nums2 = [2]

        则中位数是 2.0
        示例 2:

        nums1 = [1, 2]
        nums2 = [3, 4]

        则中位数是 (2 + 3)/2 = 2.5
        */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    //字符串拼接排序，找中位数，速度慢（自创）
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1=nums1.length;
        int length2=nums2.length;
        double midNum=0.0;
        nums1=Arrays.copyOf(nums1, length1+length2);
        System.arraycopy(nums2, 0, nums1,length1,length2);
        Arrays.sort(nums1);
        System.out.println(Arrays.toString(nums1));//输出数组
        if(nums1.length%2==0){
            //偶数
            midNum=(nums1[nums1.length/2]+nums1[(nums1.length/2)-1])/2.0;
        }else{
            midNum=nums1[(nums1.length-1)/2];
        }
        return midNum;
    }
    //直接找中位数，速度快
    public double findMedianSortedArrays2(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        int len = m + n;
        int left = -1, right = -1;
        int aStart = 0, bStart = 0;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
                right = A[aStart++];
            } else {
                right = B[bStart++];
            }
        }
        if ((len & 1) == 0)
            return (left + right) / 2.0;
        else
            return right;
    }

    public static void main(String[] args) {
        Solution2 s=new Solution2();
        int[] nums1={1,3};
        int[] nums2={2};
        System.out.println(s.findMedianSortedArrays(nums1,nums2));
    }
}
