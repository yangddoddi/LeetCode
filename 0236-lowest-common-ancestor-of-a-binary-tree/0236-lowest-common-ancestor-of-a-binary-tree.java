class Solution {
    TreeNode answer;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        search(root, p, q);
        
        return answer;
    }
    
    public boolean search(TreeNode node, TreeNode p, TreeNode q) {
        int count = 0;
        
        if (node.val == p.val || node.val == q.val) count++;
        
        if (node.left != null) {
            if (search(node.left, p, q)) count ++;
        }
        
        if (node.right != null) {
            if (search(node.right, p, q)) count ++;
        }
        
        if (count == 2) answer = node; 
        
        if (node.val == p.val || node.val == q.val || count > 0) return true;
        
        return false;
    }
}