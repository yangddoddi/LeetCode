class Solution {
    public int reverse(int x) {
        
        int temp = 0;
        int n = 0;
        while (x != 0) {
            int tail = x % 10;
            x /= 10;
            
            temp *= 10;
            temp += tail;
            
            if (temp % 10 != tail) return 0;
        }
        
        return temp;
    }
}