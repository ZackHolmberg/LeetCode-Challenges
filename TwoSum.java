/*

Problem - https://leetcode.com/problems/two-sum/

My solution - Runtime: 0 ms, faster than 100.00% of Java online submissions for Two Sum.
              Memory Usage: 39 MB, less than 87.92% of Java online submissions for Two Sum.


*/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
           for(int j = 0; j < nums.length; j++){
                int num1 = nums[i];
                int num2 = nums[j];
                int guess = num1 + num2;
                if(guess == target && i != j){
                    return new int[]{i,j};
                }
            } 
        }
        
        return null;
    }
}
