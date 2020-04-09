package com.sarues.array.leetcodetest;

import javax.swing.plaf.metal.MetalIconFactory;
import java.util.concurrent.ForkJoinPool;

/**
 *27. 移除元素
 *
 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。

 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。

 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

 示例 1:

 给定 nums = [3,2,2,3], val = 3,

 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。

 你不需要考虑数组中超出新长度后面的元素。
 示例 2:

 给定 nums = [0,1,2,2,3,0,4,2], val = 2,

 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。

 注意这五个元素可为任意顺序。
 */
public class id27 {

    public static void main(String[] args) {
        int[] nums = new int[]{2};
        int val = 3;
        System.out.println(removeElement(nums,val));
    }
    public static int removeElement(int[] nums, int val) {
         int i = 0;   //i为慢指针（用来指定不等于val值元素的插入位置）
        for (int j = 0; j < nums.length ; j++) {  //j为快指针，遍历数组，查找不等于val的元素
            if(nums[j] != val){   //若快指针指定的元素不等于val
                nums[i] = nums[j];  //将不等于val的值赋给慢指针指的位置
                i++;   //维护慢指针加一
            }
        }
        return i;  //最后返回慢指针
    }
}
