package com.snakyhy.swordToOffer.stringAndArrays;
/*找出数组中重复的数字。


        在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。

        示例 1：

        输入：
        [2, 3, 1, 0, 2, 5, 3]
        输出：2 或 3
         

        限制：

        2 <= n <= 100000*/


import java.util.*;



class Solution1{

    //map遍历
    /*
    执行用时：16 ms, 在所有 Java 提交中击败了5.94%的用户
    内存消耗：47.7 MB, 在所有 Java 提交中击败了59.04%的用户
    */
    public int findRepeatNumber1(int[] nums) {

        //创建map，存放数据
        Map<String,Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){

            //不在map中，不重复
            if(map.get(Integer.toString(nums[i]))==null){

                //放入map中
                map.put(Integer.toString(nums[i]),i);

            }else{

                //在map中
                return nums[i];
            }
        }

        //没有重复数字
        return -1;

    }

    //数组遍历(未完成)
    public int findRepeatNumber2(int[] nums) {

        int index=nums[0];

        List list =new ArrayList<>(nums.length);

        Collections.addAll(list,nums);

        for(int i=1;i<nums.length;i++){

            //判断是否存在index
            if(list.contains(index)){

                //存在
                return index;

            }else{

                //不存在
                index=nums[i];
            }

        }

        //无重复
        return -1;

    }






    public static void main(String[] args) {

        Solution1 s=new Solution1();

        int[] a={1,2,3,4,11,5,6,11};

        System.out.println(s.findRepeatNumber2(a));
    }

}