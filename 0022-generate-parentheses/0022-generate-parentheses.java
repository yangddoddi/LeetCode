class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> ans = new ArrayList<String>();
        f (n, "", 0, 0, ans);
        
        return ans;
    }
    static void f (int n, String s, int start, int end, List<String> ans) {

        if (start + end == 2 * n) {
            ans.add(s);
            return;
        }

        
        if (start < n) {
            f (n, s + "(", start + 1, end, ans);
        }
        
        if (end < start) {
            f (n, s + ")", start, end + 1, ans);
        }
    }
}