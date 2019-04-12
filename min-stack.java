/***

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.

Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.

***/

class MinStack {
    private int[] data;
    private int size;
    private int min;

    /** initialize your data structure here. */
    public MinStack() {
        data = new int[1000];
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
        // 栈满扩容 
        if (size+1 >= data.length) {
            data = Arrays.copyOf(data, 2 * data.length);
        }
        
        if (x <= min) {
            // 原最小值入栈
            data[size] = min;
            // 更新最小值
            min = x;
            size++;
        }
        
        // PUSH
        data[size] = x;
        size++;
    }
    
    public void pop() {
        // 栈空特殊处理
        if (size == 0) {
            return;
        }
        
        if (data[size-1] <= min) {
            size--;
            // 更新最小值为原最小值
            min = data[size-1];
            // 原最小值出栈
            size--;
        } else {
            size--;
        }
    }
    
    public int top() {
        if (size == 0) {
            return 0;
        }
        return data[size-1];
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */