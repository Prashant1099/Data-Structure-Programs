// Question Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

/* You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
*/ 

class BestTimetoBuyAndSellStock1{
    public int maxProfit(int[] prices) {
        int minVal = Integer.MAX_VALUE;
        int profit = Integer.MIN_VALUE;

        for(int i=0; i<prices.length; i++){
            if(prices[i] < minVal) minVal = prices[i];
            
            profit = prices[i]-minVal > profit ? prices[i]-minVal : profit;
        }

        return profit;
    }
}