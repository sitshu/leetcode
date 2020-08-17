package com.company.design;

class MyCircularQueue {
    int[] arr;
    int head;
    int capacity;
    int count = 0;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        arr = new int[k];
        head = 0;
        capacity = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(count == arr.length){
            return false;
        } else {
            arr[(this.head+this.count)%capacity] = value ;
            count++;
            return true;
        }
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(count==0)
            return false;
        this.head = (this.head+1) %capacity;
        count-=1;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(this.count == 0)
            return -1;
        return this.arr[this.head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(this.count == 0)
            return -1;
        return this.arr[(this.head+count-1) % capacity];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if(count == 0)
            return true;
        return false;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if(count == arr.length)
            return true;
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */