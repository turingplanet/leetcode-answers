class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int l = 1, r = 0;
        for (int p : piles) {
            r = Math.max(p, r);
        }
        
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (canEatAll(piles, mid, H)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
    
    private boolean canEatAll(int[] piles, int k, int H) {
        int h = 0;
        for (int p : piles) {
            h += (int)Math.ceil(p * 1.0 / k);
        }
        return h <= H;
    }
}