class MyHashMap {
    
    private Node[] buckets;
    private int size;
    private static final double LOAD_FACTOR = 0.75;
    
    /** Initialize your data structure here. */
    public MyHashMap() {
        size = 0;
        buckets = new Node[16];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = key % buckets.length;
        Node head = buckets[index];
        
        while (head != null && head.key != key) {
            head = head.next;
        }
        
        if (head != null) {
            head.value = value;
        } else {
            Node newNode = new Node(key, value);
            newNode.next = buckets[index];
            buckets[index] = newNode;
            size++;
        }
        
        if (size >= buckets.length * LOAD_FACTOR) {
            expand();
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = key % buckets.length;
        Node head = buckets[index];
        
        while (head != null && head.key != key) {
            head = head.next;
        }
        
        return head == null ? -1 : head.value;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = key % buckets.length;
        Node head = buckets[index];
        
        Node dummy = new Node(0, 0), cur = dummy;
        dummy.next = head;
        while (cur.next != null && cur.next.key != key) {
            cur = cur.next;
        }
        
        if (cur.next != null && cur.next.key == key) {
            cur.next = cur.next.next;
            size--;
        }
        
        buckets[index] = dummy.next;
    }
    
    private void expand() {
        Node[] oldBuckets = buckets;
        Node[] newBuckets = new Node[buckets.length * 2];
        buckets = newBuckets;
        
        for (Node head : oldBuckets) {
            while (head != null) {
                put(head.key, head.value);
                head = head.next;
            }
        }
    }
    
    class Node {
        int key, value;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            next = null;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */