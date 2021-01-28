package tran.leetcode.BTRightSideView;

import java.util.*;

public class Solution {

    // 199. Binary Tree Right Side View
    public List<Integer> rightSideView(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();

        if(root == null) return result;

        // Use ArrayDeque as we need access to both ends of the list.
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        TreeNode current = root;
        queue.add(current);

        while(!queue.isEmpty()) {
            /*
             * We use size to ensure we stop before the next level nodes.
             * We add the last node of the current level to the output list (result). Then we add nodes at the next level and repeat this process.
             */
            int size = queue.size();
            result.add(queue.peekLast().val); // add the last node of the current level to our output list.
            for(int i = 0; i < size; i++) {
                current = queue.poll(); // grab first node.
                if(current.left != null) queue.add(current.left);
                if(current.right != null) queue.add(current.right);
            }
        }

        return result;
    }
}
