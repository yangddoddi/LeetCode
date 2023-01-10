/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int maximum = 0;
    public int maxDepth(TreeNode root) {
        bfs(root);
        
        return maximum;
    }
    
    private void bfs(TreeNode root) {
        Queue<List<TreeNode>> queue = new LinkedList<>();
        if (root == null) return;
        queue.add(List.of(root));
        
        while (!queue.isEmpty()) {
            List<TreeNode> curr = queue.poll();
            
            List<TreeNode> nextList = new ArrayList<>();
            for (int i=0; i<curr.size(); i++) {
                if (curr.get(i).left != null) nextList.add(curr.get(i).left);
                if (curr.get(i).right != null) nextList.add(curr.get(i).right);
            }
            
            if (nextList.size() != 0) {
                queue.add(nextList);
            }
            
            maximum++;
        }
    }
}