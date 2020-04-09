package com.sarues.array.leetcodetest;

public class id35 {

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 5;
        System.out.println(searchInsert1(nums,target));
    }

    /**
     *
     * @param nums
     * @param target
     * @return
     * 解法一：暴力破解法
     * 时间复杂度：O（N）
     * 循环遍历数组
     * 三种情况：
     *      1.数组中存在和目标值大小一样的数，便利到该数则直接返回索引
     *      2.数组中不存在和目标值相同的元素，则插入大于目标值和小于目标值的元素中间
     *      3.遍历完所有数组元素都没找到符合1，2条件的元素位置，则证明目标值大于数组中所有元素，则把目标值插入数组末尾。
     */
    public static int searchInsert1(int[] nums, int target) {

        for (int i = 0; i < nums.length ; i++) {
            if(target == nums[i])
               return i ;
            if(  nums[i] >= target)
                return i;
        }
        return nums.length;
    }

    /**
     *
     * @param nums
     * @param target
     * @return
     * 解法二：二分查找法
     *
     */
    public static int searchInsert2(int[] nums, int target) {
            int left = 0;                       //指定数组低位
            int right = nums.length -1;         //指定数组高位
            while (left <= right){              //循环条件是低位小于等于高位
                int mid = (left + right) / 2;   //计算中间位置
                if(nums[mid] == target)         //情况一：中间位置指定的值刚好等于目标值，则直接返回索引
                    return mid;
                if(nums[mid] < target)          //情况二：中间的值小于目标值，说明插入位置在中间位置的右边
                    left = mid + 1;             //于是修改低位
                if(nums[mid] > target)          //情况三：中间的值大于目标值，说明插入位置在中间位置的左边
                    right = mid - 1;            //于是修改高位
            }

            return left;                        //最后返回要插入的位置值


    }
}
