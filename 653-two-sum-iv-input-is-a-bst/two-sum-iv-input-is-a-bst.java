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
    Deque<TreeNode> asc = new ArrayDeque<>();
    Deque<TreeNode> dec = new ArrayDeque<>();

    public TreeNode getSmall() {
        if (asc.isEmpty()) {
            return null;
        }
        TreeNode small = asc.peek();
        asc.pop();
        TreeNode rightChild = small.right;
        while (rightChild != null) {
            asc.push(rightChild);
            rightChild = rightChild.left;
        }
        return small;
    }

    public TreeNode getBig() {
        if (dec.isEmpty()) {
            return null;
        }
        TreeNode big = dec.peek();
        dec.pop();
        TreeNode leftChild = big.left;
        while (leftChild != null) {
            dec.push(leftChild);
            leftChild = leftChild.right;
        }
        return big;
    }

    public boolean findTarget(TreeNode root, int k) {
        if (root == null)
            return false;

        TreeNode t = root;
        while (t != null) { // for small
            asc.push(t);
            t = t.left;
        }
        t = root; // reinitialize the t as root ---> cuz it will be null after the first while loop
        while (t != null) { // for big
            dec.push(t);
            t = t.right;
        }

        TreeNode i = getSmall();
        TreeNode j = getBig();

        while ((i != null && j != null) && (i != j) && (i.val < j.val)) {
            if (i.val + j.val == k)
                return true;

            if (i.val + j.val > k) {
                j = getBig(); // gets a bit smaller value
            } else {
                i = getSmall(); // gets a bit bigger value
            }
        }

        return false;
    }
}