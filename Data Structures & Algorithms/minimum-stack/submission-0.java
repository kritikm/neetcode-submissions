class MinStack {

    Deque<int[]> q;

    public MinStack() {
        q = new LinkedList<>();
    }
    
    public void push(int val) {
        int nextMin = val;
        if (!q.isEmpty()) {
            int lastMin = q.getLast()[1];
            nextMin = Math.min(lastMin, val);
        }
        q.addLast(new int[] {val, nextMin});
    }
    
    public void pop() {
        if (!q.isEmpty()) {
            q.removeLast();
        }
    }
    
    public int top() {
        return q.getLast()[0];        
    }
    
    public int getMin() {
        return q.getLast()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */