package Lab;

class LLStack {
//    java.util.LinkedList<Object> list = new java.util.LinkedList<Object>();
IntSLList<Object> list = new IntSLList<Object>();

    public void clear() {
        mylist.clear();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public Object topEl() {
        if (isEmpty())
            throw new java.util.EmptyStackException();
        return list.getLast();
    }

    public Object pop() {
        if (isEmpty())
            throw new java.util.EmptyStackException();
        return list.removeLast();
    }

    public void push(Object el) {
        list.addLast(el);
    }

    public String toString() {
        return list.toString();
    }
    public void display() {
        for (int i = 0; i <= tos; i++) {
            System.out.println(stkarray[i]);
        }
    }
}

public class StackLinkedList{
    public static void main(String[] args) {
        LLStack obj=new LLStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.display();
        System.out.println( obj.topEl());
        obj.pop();
        System.out.println("after popping out the element from the stack");
        System.out.println( obj.topEl());
    }

}