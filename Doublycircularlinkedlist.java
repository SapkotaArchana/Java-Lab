package Lab;

class DCLLNode {
    public int info;
    public DCLLNode next;
    public DCLLNode prev;

    public DCLLNode() {
        this.info = 0;
        this.next = null;
        this.prev = null;
    }

    public DCLLNode(int info) {
        this.info = info;
        this.next = null;
        this.prev = null;

    }

    // public DCLLNode(int info, DCLLNode next) {
    // this.info = info;
    // this.next = next;
    // }
}

class DCLList {
    DCLLNode head;
    DCLLNode tail;

    public DCLList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null && tail == null);
    }

    public void addToHead(int el)// 4
    {
        // head = new DCLLNode(el, head);

        // if (tail == null)
        // tail = head;

        // tail.next = head

        DCLLNode tmp = new DCLLNode(el);
        tmp.next = head;
        if (head == null) {
            head = tmp;
            head.prev = tmp;
            tail = tmp;
            tail.next = tmp;
        } else {
            tail.next = tmp;
            head = tmp;
        }
    }// O(1)

    public void addToTail(int el) {
        DCLLNode tmp = new DCLLNode(el);
        tmp.next = head;
        if (head == null) {
            head = tmp;
            head.prev = tmp;
            tail = tmp;
            tmp.next = tmp;
        } else {
            head.prev = tmp;
            tail.next = tmp;
            tmp.prev = tail;
            tail = tmp;
        }
    }

    public void deletefromhead() {
        // SCLLNode tmp;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
    }

    public void deletefromtail() {
        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            head.prev = tail;
            tail.next = head;
        }
    }

    public void addtoanypos(int el, int position) {
        DCLLNode newNode = new DCLLNode();
        newNode.info = el;
        newNode.next = null;
        DCLLNode temp = head;
        int NoOfElements = 0;
        if (temp != null) {
            NoOfElements++;
            temp = temp.next;
        }
        while (temp != head) {
            NoOfElements++;
            temp = temp.next;
        }

        if (position < 1) {
            System.out.print("\nInvalid position.");
        } else if (position == 1) {
            if (head == null) {
                head = newNode;
                head.next = head;
                head.prev = head;
            } else {
                while (temp.next != head) {
                    temp = temp.next;
                }
                temp.next = newNode;
                newNode.prev = temp;
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
        } else {

            temp = head;
            for (int i = 1; i < position - 1; i++)
                temp = temp.next;
            newNode.next = temp.next;
            newNode.next.prev = newNode;
            newNode.prev = temp;
            temp.next = newNode;
        }
    }

    public void deletefromspecipos(int position) {
        DCLLNode nodeToDelete = head;
        DCLLNode temp = head;
        int NoOfElements = 0;

        if (temp != null) {
            NoOfElements++;
            temp = temp.next;
        }
        while (temp != head) {
            NoOfElements++;
            temp = temp.next;
        }

        if (position < 1) {
            System.out.print("\nInvalid position.");
        } else if (position == 1) {
            if (head.next == head) {
                head = null;
            } else {
                while (temp.next != head){
                    temp = temp.next;
                }
                head = head.next;
                temp.next = head;
                head.prev = temp;
                nodeToDelete = null;
            }
        } else {
            temp = head;
            for (int i = 1; i < position - 1; i++)
                temp = temp.next;
            nodeToDelete = temp.next;
            temp.next = temp.next.next;
            temp.next.prev = temp;
            nodeToDelete = null;
        }
    }

    // Delete all nodes by key
    public void deletenodeWithElement(int el) {
        DCLLNode nodeToDelete = new DCLLNode();
        DCLLNode temp = new DCLLNode();

        while (head != null && head.info == el) {

            if (head.next == head) {
                head = null;
            } else {
                nodeToDelete = head;
                temp = head;
                while (temp.next != head) {
                    temp = temp.next;
                }
                head = head.next;
                temp.next = head;
                head.prev = temp;
                nodeToDelete = null;
            }
        }

        temp = head;
        if (temp != null) {
            while (temp.next != head) {
                if (temp.next.info == el) {
                    nodeToDelete = temp.next;
                    temp.next = temp.next.next;
                    temp.next.prev = temp;
                    nodeToDelete = null;
                } else {
                    temp = temp.next;
                }
            }
        }
    }

    // Search an element in the list
    public void isInList(int el) {
        DCLLNode temp = new DCLLNode();
        temp = head;
        int found = 0;
        int i = 0;

        if (temp != null) {
            while (true) {
                i++;
                if (temp.info == el) {
                    found++;
                    break;
                }
                temp = temp.next;
                if (temp == head)
                    break;
            }
            if (found == 1) {
                System.out.println(el + " is found in the list.");
            } else {
                System.out.println(el + " is not found in the list.");
            }
        } else {
            System.out.println("The list is empty.");
        }
    }

    public void printAll() {
        DCLLNode tmp = head;
        if (isEmpty()) {
            System.out.println("list is empty");
            return;
        }
        do {
            System.out.print(tmp.info + "=>");
            tmp = tmp.next;
        } while (tmp != head);
        System.out.print("null");
        System.out.println();
    }
}

public class Doublycircularlinkedlist {
    public static void main(String[] args) {
        DCLList list = new DCLList();
        System.out.println("The list is empty: "+list.isEmpty());
        list.addToHead(4);
        list.addToHead(6);
        list.addToTail(3);
        list.addToHead(14);
        list.addToTail(10);
        list.addToHead(2);
        list.printAll();       
        list.deletefromtail();
        list.printAll();
        list.deletefromhead();
        list.printAll();
        list.deletefromspecipos(0);
        list.printAll();
        list.deletefromspecipos(2);
        System.out.print("After deleting:");
        list.printAll();
        System.out.println("The list is empty: "+list.isEmpty());
        list.isInList(4);
        list.isInList(10);
        list.addtoanypos(12, 3);
        System.out.println("After adding element in position 3 :");
        list.printAll();
        list.addtoanypos(12, 0);
        list.printAll();
        list.addToTail(14);
        list.printAll();
        list.deletenodeWithElement(14);
        System.out.println("After deleting the node:");
        list.printAll();
    }
}
