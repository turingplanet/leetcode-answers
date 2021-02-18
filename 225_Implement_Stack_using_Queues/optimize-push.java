class MyStack {
    Queue<Integer> q1, q2;
    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if (!q2.isEmpty()) {
            q1.add(q2.poll());
        }
        q1.add(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (!q2.isEmpty()) {
            return q2.poll();
        }
        
        top();
        return q2.poll();
    }
    
    /** Get the top element. */
    public int top() {
        if (!q2.isEmpty()) {
            return q2.peek();
        }
        
        while (q1.size() > 1) {
            q2.add(q1.poll());
        }
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
        return q2.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}