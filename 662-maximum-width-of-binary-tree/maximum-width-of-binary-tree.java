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

class Pair {
    TreeNode node;
    int num; // num is just an index of a node in a particular level
    Pair(TreeNode _node, int _num) {
        num = _num;
        node = _node;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        int ans = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int size = queue.size();
            int min = queue.peek().num;
            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                int cur_id = queue.peek().num - min; // ***
                TreeNode node = queue.peek().node;
                queue.poll();

                if (i == 0)
                    first = cur_id; // get the first index of the level
                if (i == size - 1)
                    last = cur_id; // get the last index of the level

                if(node.left != null)  queue.offer(new Pair(node.left, cur_id*2+1));
                if(node.right != null)  queue.offer(new Pair(node.right, cur_id*2+2));
            
            }
            // width ---> last-first+1
            ans = Math.max(ans, last-first+1);
        }
        return ans;
    }
}