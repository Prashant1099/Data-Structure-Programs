import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class BottomViewOfBinaryTree {
        public static ArrayList<Integer> bottomView(Node root){
            ArrayList<Integer> ans = new ArrayList<>();
            if(root == null) return ans;

            Queue<Node> queue = new LinkedList<Node>();
            Map<Integer, Integer> map = new TreeMap<>();
            
            root.hd = 0;
            queue.add(root);

            while(!queue.isEmpty()){
                Node temp = queue.remove();
                int line = temp.hd;

                map.put(line, temp.data);

                if(temp.left != null){
                    temp.left.hd = hd-1;
                    queue.add(temp.left);
                }

                if(temp.right != null){
                    temp.right.hd = hd+1;
                    queue.add(temp.right);
                }
            }

            for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
                ans.add(entry.getValue()); 
            }
            return ans;
        }
}
