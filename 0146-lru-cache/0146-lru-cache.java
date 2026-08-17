class LRUCache {
    class Node{
        Node prev;
        Node next;
        int key;
        int value;
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            prev = next = null;
        }
    }
    int limit;
    HashMap<Integer, Node> map = new HashMap<>();
    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);

    public LRUCache(int capacity) {
        limit = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        int value = map.get(key).value;
        put(key,value);
        return value;
    }

    public void addNode(Node newNode){
        Node oldNode = head.next;
        head.next = newNode;
        newNode.prev = head;
        oldNode.prev = newNode;
        newNode.next = oldNode;
    }

    public void deleteNode(Node oldNode){
        Node prev = oldNode.prev;
        Node next = oldNode.next;
        prev.next = next;
        next.prev = prev;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            deleteNode(map.get(key));
            map.remove(key);
        }
        if(map.size() == limit) {
            map.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        Node newNode = new Node(key, value);
        addNode(newNode);
        map.put(key, newNode);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */