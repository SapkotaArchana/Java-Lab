

class DLLNode {
    public int info;
    public DLLNode prev;
    public DLLNode next;

    public DLLNode() {
        this.info = 0;
        this.prev = null;
        this.next = null;
    }

    public DLLNode(int info) {
        this.info = info;
        this.prev = null;
        this.next = null;
    }

    public DLLNode(int info, DLLNode prev, DLLNode next) {
        this.info = info;
        this.prev = prev;
        this.next = next;
    }
}

class DLList {
    public DLLNode head, tail;

    public DLList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null && tail == null);
    } // O(n)

    public void addToHead(int el) {
        if (isEmpty()) {
            head = tail = new DLLNode(el);
        } else {
            head = new DLLNode(el, null, head);
            head.next.prev = head;
        }
    }// O(1)

    public void addtoTail(int el) {
        if (!isEmpty()) {
            tail = new DLLNode(el, tail, null);
            tail.prev.next = tail;
        } else {
            head = tail = new DLLNode(el);
        }
    }// O(1)

    public int deleteFromHead() {
        int el = head.info;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        return el;

    }// O(1)

    public int deleteFromTail() {
        int el = tail.info;
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        return el;

    }// O(1)

    public void addtoanypos(int el, int position) {
        DLLNode NewNode = new DLLNode(el, null, null);
        // NewNode.next = null;
        // NewNode.prev = null;
        if (position < 1) {
            System.out.println("Position must be equal to 1 or greater than 1");
        } else if (position == 1) {
            NewNode.next = head;
            head.prev = NewNode;
            head = NewNode;
        } else {
            DLLNode tmp = new DLLNode();
            tmp = head;
            for (int i = 1; i < position - 1; i++) {
                if (tmp != null) {
                    tmp = tmp.next;
                }
            }
            if (tmp != null) {
                NewNode.next = tmp.next;
                NewNode.prev = tmp;
                tmp.next = NewNode;
                if (NewNode.next != null)
                    NewNode.next.prev = NewNode;
            } else {
                System.out.print("\nThe previous node is null.");
            }

        }
    }

    public void deletefromspecipos(int position) {
        if (position == 0) {
            deleteFromHead();
            return;
        }
        if (!isEmpty()) {
            DLLNode tmp = head;
            DLLNode deletenode;
            for (int i = 0; i < position; i++) {
                tmp = tmp.next;
                if (tmp == null) {
                    System.out.println("The position is less than the size of linkedlist");
                    return;
                }
            }
            deletenode = tmp;
            deletenode.prev.next = deletenode.next;
        }
    }// O(n)

    public void deletenodewithelement(int el) {
        try {
            if (!isEmpty()) {
                if (head == tail && el == head.info) {
                    head = tail = null;
                } else if (el == head.info) {
                    head = head.next;
                } else {
                    DLLNode tmp = head;
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
        } catch (NullPointerException e) {
            System.out.println("There is no element in the list");
        }

    }

    // public void printForward() {
    // DLLNode tmp = head;
    // if (isEmpty()) {
    // System.out.println("list is empty");
    // return;
    // }
    // while (tmp != null) {
    // System.out.print(tmp.info + "->");
    // tmp = tmp.next;
    // }
    // System.out.print("null");
    // System.out.println();
    // }// O(n)

    public void printReverse() {
        DLLNode tmp = tail;
        if (isEmpty()) {
            System.out.println("list is empty");
            return;
        }
        while (tmp != null) {
            System.out.print(tmp.info + "=>");
            tmp = tmp.prev;
        }
        System.out.print("null");
        System.out.println();
    }// O(n)

    public boolean isInList(int el) {
        boolean inList = false;
        DLLNode tmp = head;
        while (tmp != null) {
            if (tmp.info == el) {
                inList = true;
                break;
            }
            tmp = tmp.next;
        }
        return inList;
    }// O(n)

    public void printAll() {
        DLLNode tmp = new DLLNode();
        tmp = this.head;
        if (tmp != null) {
            while (tmp != null) {
                System.out.print(tmp.info + "=>");
                tmp = tmp.next;
            }
            System.out.print("null");
            System.out.println();
        } else {
            System.out.println("The list is empty.");
        }
    }// O(n)
}

public class doublylinkedlistDemo {
    public static void main(String[] args) {
        DLList list = new DLList();
        list.addToHead(3);
        list.addtoTail(5);
        list.addtoTail(10);
        list.addToHead(7);
        list.addToHead(1);
        list.addtoTail(15);
        list.addtoTail(20);
        System.out.print("The list are: ");
        list.printAll();
        System.out.print("The reverse of list:");
        list.printReverse();
        list.deleteFromHead();
        list.printAll();
        System.out.println("After deleting last node:" + list.deleteFromTail());
        list.printAll();
        list.deletefromspecipos(4);
        list.printAll();
        list.addtoanypos(6, 0);
        list.addtoanypos(12, 2);
        list.printAll();
        System.out.println("5 is in the list:" + list.isInList(5));
        list.deletenodewithelement(15);
        list.printAll();
        list.deletenodewithelement(5);
        list.printAll();

    }
}
// Perform search, deletespecific node, addtohead .