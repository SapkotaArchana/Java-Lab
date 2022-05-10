package Lab;

class IntSLLNode {
    public int info;
    public IntSLLNode next;

    public IntSLLNode() {
        this.info = 0;
        this.next = null;

    }

    public IntSLLNode(int info) {
        this.info = info;
        this.next = null;
    }

    public IntSLLNode(int info, IntSLLNode next) {
        this.info = info;
        this.next = next;
    }
}

class IntSLList {
    public IntSLLNode head, tail;

    public IntSLList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null && tail == null);
    }

    public void addToHead(int el)// 4
    {
        head = new IntSLLNode(el, head);
        if (tail == null)
            tail = head;
    }// time complexity:O(1)

    public void addToTail(int el) {
        if (!isEmpty()) {
            tail.next = new IntSLLNode(el);
            tail = tail.next;
        } else {
            head = tail = new IntSLLNode(el);
        }
    }// O(1)

    public int deleteFromHead() {
        int deletedinfo = head.info;
        if (head == tail)// when there is only one node or there is no node.
        {
            head = tail = null;
        } else {
            head = head.next;
        }
        return deletedinfo;
    }// O(1)

    public int deleteFromTail() {
        int deletedinfo = tail.info;
        IntSLLNode tmp = head;
        if (head == tail) {
            head = tail = null;
        } else {
            while (tmp.next != tail) {
                tmp = tmp.next;
            }
            tail = tmp;
            tail.next = null;
        }

        return deletedinfo;
    }//O(1)


    public void addtoanypos(int el, int position) {
        IntSLLNode NewNode = new IntSLLNode(el, null);
        if (position < 1) {
            System.out.println("Position must be equal to or greater than 1");
        } else if (position == 1) {
            NewNode.next = head;
            head = NewNode;
        } else {
            IntSLLNode tmp = new IntSLLNode();
            tmp = head;
            for (int i = 1; i < position - 1; i++) {
                if (tmp != null) {
                    tmp = tmp.next;
                }
            }
            if (tmp != null) {
                NewNode.next = tmp.next;
                tmp.next = NewNode;
            }
        }
    }//O(n)

    public void deletefromspecificpos(int position) {
        if (head == null) {
            return;
        }
        IntSLLNode tmp = head;

        if (position == 0) {
            head = tmp.next;
            return;
        }
        for (int i = 0; tmp != null && i < position - 1; i++) {
            tmp = tmp.next;
        }
        if (tmp == null || tmp.next == null)
            return;

        IntSLLNode next = tmp.next.next;
        tmp.next = next;
    }//O(n)


    public void deletenodeWithElement(int el) {
        if (!isEmpty()) {
            if (head == tail && el == head.info) {// if there is only one node
                head = tail = null;
            } else if (el == head.info) {// if the node to delete is matched with head
                head = head.next;
            } else {// if there are more than one node and the node to delete is in the position
                    // later than head.
                IntSLLNode tmp = head;
                while (tmp != null) {
                    if (tmp.next.info == el) {
                        break;
                    }
                    tmp = tmp.next;
                }
                if (tmp != null) {
                    tmp.next = tmp.next.next;
                }
            }

        }

    }// O(n)
    // Search
    public boolean isInList(int key) {
        // Node tmp = head;
        // while (tmp != null && tmp.info != key) {
        // tmp = tmp.next;
        // }
        // return tmp != null;
        IntSLLNode tmp = head;
        boolean inList = false;
        while (tmp != null) {
            if (tmp.info == key) {
                inList = true;
                break;
            }
            tmp = tmp.next;
        }
        return inList;
    }// O(n)

    public void printAll() {
        IntSLLNode tmp = head;
        if (isEmpty()) {
            System.out.println("list is empty");
            return;
        }
        while (tmp != null) {
            System.out.print(tmp.info + "->");
            tmp = tmp.next;
        }
        System.out.print("null");
        System.out.println();
    }
}//O(n)

public class SinglylinkedListDemo {
    public static void main(String[] args) {
        IntSLList mylist = new IntSLList();
        // IntSLList mylist1 = new IntSLList();
        // mylist1.printAll();
        System.out.println("The list is empty:" + mylist.isEmpty());
        mylist.addToHead(3);
        mylist.addToHead(4);

        mylist.addToTail(5);
        mylist.addToTail(6);
        mylist.addToHead(9);
        mylist.addToTail(1);
        mylist.addToTail(7);
        mylist.printAll();
        System.out.println("The list is empty:" + mylist.isEmpty());
        System.out.println("After deleting: " + mylist.deleteFromHead());
        mylist.printAll();
        System.out.println("After deleting: " + mylist.deleteFromTail());
        mylist.printAll();
        mylist.deletenodeWithElement(5);
        mylist.printAll();
        System.out.println("6 is in the list:" + mylist.isInList(6));
        mylist.addtoanypos(7, 0);
        mylist.printAll();
        mylist.addtoanypos(7, 3);
        mylist.printAll();
        mylist.deletefromspecificpos(1);
        mylist.printAll();

    }
}

// Insertion: addtohead, addtotail, addtoanyposition.
// addtohead:
/*
 * .1.Create an empty node
 * 2. The node's info field is initialized to some value
 * 3. Since the node is being included at front of the list, the next field of
 * node refers to first node(head).
 * 4. refer the node as head.
 */
