class Solution {
    public int trap(int[] height) {
        int sum = 0;
        int left = 0;
        int right = height.length - 1;

        int leftMax = height[0];
        int rightMax = height[right];

        while(left < right){

            if(height[left] < height[right]){
                // if height of left side is small, then update it 
                leftMax = Math.max(leftMax, height[left]);

                if((leftMax - height[left]) > 0){ // check id we can store water
                    sum = sum + (leftMax - height[left]);
                }
                left++;
            }
            else{
                // if height of right side is small, then update it 
                rightMax = Math.max(rightMax, height[right]);

                if((rightMax - height[right]) > 0){ // check id we can store water
                    sum = sum + (rightMax - height[right]);
                }
                right--;
            }
        }
        return sum;
    }
}