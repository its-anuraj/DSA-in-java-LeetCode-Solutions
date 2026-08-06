class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int top = 0;
        int bottom = rows - 1;

        while (top <= bottom) {

            int midRow = top + (bottom - top) / 2;

            if(target < matrix[midRow][0]){
                bottom=midRow-1;

            }
            else if(target > matrix[midRow][cols-1]){
                top=midRow+1;
            }
            else{
                int start=0;
                int end=cols-1;

                while(start<=end){
                    int mid=start+(end-start)/2;
                     
                    if(target==matrix[midRow][mid]){
                        return true;
                    } 
                    else if(target < matrix[midRow][mid]){
                        end=mid-1;
                    }
                    else{
                        start=mid+1;
                    }
                }
                return false;
            }

        }
         return false;
    }
}