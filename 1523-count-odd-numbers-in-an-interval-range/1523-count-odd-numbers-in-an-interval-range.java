class Solution {
    public int countOdds(int low, int high) {
        int count=high-low+1;

        if((low & 1)==1 || (high & 1)==1){
            return (count+1)/2;
        }
        return count/2;
    }
}