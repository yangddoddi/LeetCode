class Solution {
    private int maxLength = 0;
    private String answer = "";
    
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] checked = new boolean[n][n];
        
        for (int i=s.length()-1; i>=0; i--) {
            checked[i][i] = true;
            
            for (int j=i+1; j<n; j++) {
                if (searchPalindrom(checked, i, j, s)) {
                    if (maxLength < j-i) {
                        maxLength = j-i;
                        answer = s.substring(i, j+1);
                    }
                }
            }
        }
        
        return (answer.length() == 0) ? s.split("")[0] : answer;
    }
    
    private boolean searchPalindrom(boolean[][] checked, int left, int right, String s) {
        int l = left;
        int r = right;
        
        if (s.charAt(l) != s.charAt(r)) return false;
        // 두 문자열이 같지 않을 경우 비교할 필요가 없음.
        
        if (r-l < 3) {
            return checked[l][r] = true;
        }
        
        // if (r+1 > s.length()-1) return false;
        // 현재 포인터에서 좌우로 한 칸씩 이동했을 때 문자열의 범위를 넘어선다면
        // 4자리 이상 같은 비교를 할 필요가 없음.
        
        if (r-l >= 3) {
            if (checked[l+1][r-1]) return checked[l][r] = true;
        }
        // [2][4]가 팰린드롬일 때, [1] == [5]라면 [1][5]도 팰린드롬임.
        
        return false;
    }
}