package Lab;

class Queue {

    public int front, rear;
    public int maxsize;
    public int[] queuearr;

    public Queue(int maxsize) {
        this.maxsize = maxsize;
        front = rear = -1;
        queuearr = new int[maxsize];
    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    public boolean isFull() {
        return (front == 0 && rear == maxsize - 1) || (front == rear + 1);
    }

    public void enqueue(int el) {
        if (isEmpty()) {
            front++;
            rear++;
            queuearr[rear] = el;
        } else if (isFull()) {
            System.out.println("Queue is full");
        } else {
            rear = (rear + 1) % maxsize;
            queuearr[rear] = el;
        }
    }

    public Integer dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        } else if (front == rear) {
            Integer deletedno = queuearr[front];
            front = rear = -1;
            return deletedno;
        } else {
            Integer deletedno = queuearr[front];
            front = (front + 1) % maxsize;
            return deletedno;
        }
    }

    public void printAll() {
        int tmp = front;
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println(queuearr[tmp]);
        while (tmp != rear) {
            tmp = (tmp + 1) % maxsize;
            System.out.println(queuearr[tmp]);
        }
    }
}

public class Queuedemo {
    public static void main(String[] args) {
        Queue q = new Queue(4);
        System.out.println("The queue is empty:" + q.isEmpty());
        System.out.println("The queue is full:" + q.isFull());
        System.out.println("After enqueing elements:");
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(9);
        q.enqueue(7);
        q.printAll();
        System.out.println("The queue is empty:" + q.isEmpty());
        System.out.println("The queue is full:" + q.isFull());
        System.out.println("After dequeing elements:");
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.printAll();
    }
}
