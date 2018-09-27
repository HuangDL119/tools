package com.hdl;

import org.junit.Test;

/**
 * Created by huangdongliang on 2018/7/19.
 */
public class Array {

    @Test
    public void removeDuplicates(){
        int nums[]={1,1,2};
        System.out.println(this.removeDuplicates1(nums));
        //打印
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }

    }
    //去掉数组内重复数据并排序
    public int removeDuplicates(int[] nums) {
        //排序
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length;j++){
                if(nums[i]<nums[j]){
                    int temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                }
            }
        }
        //获取不重复数组长度
        int reapeatNum=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]==nums[i]){
                reapeatNum++;
            }
        }
        //重建新数组
//        int[] newArray=new int[nums.length-reapeatNum];
        int newArrayIndex=0;
        //插入第一个元素
        int tempValue=nums[newArrayIndex];


//        newArray[newArrayIndex]=tempValue;
        //不用新数组
        nums[newArrayIndex]=tempValue;
        //比较后面的元素
        for(int i=1;i<nums.length;i++){
            if(tempValue!=nums[i]){
                newArrayIndex++;
                nums[newArrayIndex]=nums[i];
                tempValue=nums[i];
            }else {
                //和前面相等的跳过
            }
        }
        return nums.length-reapeatNum;
    }

    //给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
//    不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
    public int removeDuplicates1(int[] nums) {
        int reapeatNum=0;
        int newArrayIndex=0;
        //插入第一个元素
        int tempValue=nums[newArrayIndex];
        //不用新数组
        nums[newArrayIndex]=tempValue;
        //比较后面的元素
        for(int i=1;i<nums.length;i++){
            if(tempValue!=nums[i]){
                newArrayIndex++;
                nums[newArrayIndex]=nums[i];
                tempValue=nums[i];
            }else{
                reapeatNum++;
            }
        }
        return nums.length-reapeatNum;
    }
}
