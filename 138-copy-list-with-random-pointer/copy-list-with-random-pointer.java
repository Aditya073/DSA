/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    HashMap<Node, Node> visitedNode = new HashMap<Node, Node>();

    public Node copyRandomList(Node head) {

        if(head == null){
            return null;
        }    
        // check if the node is visited or not
        if(this.visitedNode.containsKey(head)){
            return visitedNode.get(head);
        }
        // create the node then add it to the visited HashMap
        Node node = new Node(head.val, null, null);
        this.visitedNode.put(head, node);

        // recursion call for node.next & node.random
        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;
    }
}