/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        HashMap<Integer, Node> map = new HashMap<>();
        return dfs(node, map);
    }
    public Node dfs(Node node, HashMap<Integer, Node> map){
        if(node == null) return null;
        Node newNode = new Node(node.val);
        map.put(newNode.val, newNode);
        //System.out.println(newNode.val);
        for(Node nn : node.neighbors){
            if(map.containsKey(nn.val)){
                newNode.neighbors.add(map.get(nn.val));
            }else{
                dfs(nn, map);
                newNode.neighbors.add(map.get(nn.val));
            }
        }
        return newNode;
    }
}