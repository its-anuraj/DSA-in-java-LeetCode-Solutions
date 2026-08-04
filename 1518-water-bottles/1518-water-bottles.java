class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        if (numBottles < numExchange)
            return numBottles;

        int total = numBottles;

        while (numBottles >= numExchange) {

            int n1 = numBottles / numExchange;
            int n2 = numBottles % numExchange;

            total += n1;

            numBottles = n1 + n2;

        }
        return total;

    }
}