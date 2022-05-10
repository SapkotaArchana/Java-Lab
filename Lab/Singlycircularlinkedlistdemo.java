package Lab;

class SCLLNode {
    public int info;
    public SCLLNode next;

    public SCLLNode() {
        this.info = 0;
        this.next = null;
    }

    public SCLLNode(int info) {
        this.info = info;
        this.next = null;
    }

    // public SCLLNode(int info, SCLLNode next) {
    // this.info = info;
    // this.next = next;
    // }
}

class SCLList {
    SCLLNode head;
    SCLLNode tail;

    public SCLList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null && tail == null);
    }

    public void addToHead(int el)// 4
    {
        // head = new SCLLNode(el, head);

        // if (tail == null)
        // tail = head;

        // tail.next = head

        SCLLNode tmp = new SCLLNode(el);
        tmp.next = head;
        if (head == null) {
            head = tmp;
            tail = head;
        } else {
            tail.next = tmp;
            head = tmp;
        }
    }// O(1)

    public void addToTail(int el) {
        SCLLNode tmp = new SCLLNode(el);
        tmp.next = head;
        if (head == null) {
            head = tmp;
            tmp.next = head;
            tail = tmp;
        } else {
            tail.next = tmp;
            tail = tmp;
        }
    }

    public void deletefromhead() {
        // SCLLNode tmp;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            tail.next = head;
        }
    }

    public void deletefromtail() {
        SCLLNode tmp;
        if (head == tail) {
            head = tail = null;
        } else {
            for (tmp = head; tmp.next != tail; tmp = tmp.next)
                ;
            tail = tmp;
            tail.next = head;
        }
    }

    public void addtoanypos(int el, int position) {
        SCLLNode newNode = new SCLLNode();
        newNode.info = el;
        newNode.next = null;
        SCLLNode tmp = head;
        int NoOfEl = 0;

        if (tmp != null) {
            NoOfEl++;
            tmp = tmp.next;
        }
        while (tmp != head) {
            NoOfEl++;
            tmp = tmp.next;
        }

        if (position < 1) {
            System.out.print("\nInvalid position.");
        } else if (position == 1) {

            if (head == null) {
                head = newNode;
                head.next = head;
            } else {
                while (tmp.next != head) {
                    tmp = tmp.next;
                }
                newNode.next = head;
                head = newNode;
                tmp.next = head;
            }
        } else {
            tmp = head;
            for (int i = 1; i < position - 1; i++)
                tmp = tmp.next;
            newNode.next = tmp.next;
            tmp.next = newNode;
        }
    }

    public void deletefromspecipos(int position) {
        SCLLNode nodeToDelete = head;
        SCLLNode temp = head;
        int NoOfElements = 0;

        if (temp != null) {
            NoOfElements++;
            temp = temp.next;
        }
        while (temp != head) {
            NoOfElements++;
            temp = temp.next;
        }

        if (position < 1 ) {
            System.out.println("Position should be equal to or greater than 1.");
        } else if (position == 1) {

            if (head.next == head) {
                head = null;
            } else {
                while (temp.next != head){
                    temp = temp.next;
                }
                head = head.next;
                temp.next = head;
                nodeToDelete = null;
            }
        } else {
            temp = head;
            for (int i = 1; i < position - 1; i++)
                temp = temp.next;
            nodeToDelete = temp.next;
            temp.next = temp.next.next;
            nodeToDelete = null;
        }
    }
    // Delete all nodes by key
    public void deletenodeWithElement(int el) {
        SCLLNode nodeToDelete = new SCLLNode();
        SCLLNode tmp = new SCLLNode();

        while (head != null && head.info == el) {
            if (head.next == head) {
                head = null;
            } else {
                nodeToDelete = head;
                tmp = head;
                while (tmp.next != head) {
                    tmp = tmp.next;
                }
                head = head.next;
                tmp.next = head;
                nodeToDelete = null;
            }
        }

        tmp = head;
        if (tmp != null) {
            while (tmp.next != head) {
                if (tmp.next.info == el) {
                    nodeToDelete = tmp.next;
                    tmp.next = tmp.next.next;
                    nodeToDelete = null;
                } else {
                    tmp = tmp.next;
                }
            }
        }
    }

    // Search an element in the list
    public void isInList(int el) {
        SCLLNode temp = new SCLLNode();
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
                if (temp == head) {
                    break;
                }
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
        SCLLNode tmp = head;
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

public class Singlycircularlinkedlistdemo {
    public static void main(String[] args) {
        SCLList list = new SCLList();
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
        list.printAll();
        list.isInList(4);
        list.isInList(10);
        list.addtoanypos(12, 3);
        list.printAll();
        list.deletenodeWithElement(4);
        list.printAll();
    }
}
