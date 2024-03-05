package coding_practice.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
public class InorderTraversal {
    public static void main(String[] args) {
          TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        List<Integer> result = inOreder(root);
        System.out.println(result);
    }

    private static List<Integer> inOreder(TreeNode root) {
     List<Integer> result = new ArrayList<>();
     if(root == null){
        return result;
     }

     Stack<TreeNode> stack = new Stack<>();
     TreeNode curr = root;

     while(curr != null || !stack.isEmpty()){
        while(curr != null){
            stack.push(curr);
            curr = curr.left;
        }

        curr = stack.pop();
        result.add(curr.val);
        curr = curr.right;
     }
     return result;
    }

}
