public class LnkedListQ2 {
    class node {
        int data;
        node next;

        node(int d) {
            data = d;
            next = null;
        }
    }

    node first;

    void insert(int data) {
        node temp = new node(data);
        if (first == null) {
            first = temp;
            return;
        }
        node temp2 = first;
        while (temp2.next != null) {
            temp2 = temp2.next;
        }
        temp2.next = temp;  
    }

    void deleteSamallest() {
        if (first == null) return; 

        node temp = first;
        node smallest = first;
        node pre = null;
        node presmall = null;

        while (temp != null) {
            if (temp.data < smallest.data) {
                smallest = temp;
                presmall = pre;
            }
            pre = temp;
            temp = temp.next;
        }

        if (presmall == null) {
            first = first.next;
        } else {
            presmall.next = smallest.next; 
        }
    }

    void deleteAll(int value) {
        while (first != null && first.data == value)
            first = first.next;

        node temp = first;
        while (temp != null && temp.next != null) {
            if (temp.next.data == value)
                temp.next = temp.next.next;
            else
                temp = temp.next;
        }
    }

    int getKth(int k) {
        node temp = first;
        int count = 1;
        while (temp != null) {
            if (count == k)
                return temp.data;
            count++;
            temp = temp.next;
        }
        System.out.println("No such element");
        System.exit(0);
        return -1;
    }

    void deleteKth(int k) {
        if (first == null) {
            System.out.println("List is empty");
            return;
        }
        if (k == 1) {
            first = first.next;
            return;
        }
        node temp = first;
        int count = 1;
        while (temp != null && count < k - 1) {
            temp = temp.next;
            count++;
        }
        if (temp == null || temp.next == null) {
            System.out.println("No such element exists");
            return;
        }
        temp.next = temp.next.next;
    }

    void divideList() {
        if (first == null)
            return;
        node slow = first;
        node fast = first;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        node head2 = slow.next;
        slow.next = null;

        System.out.print("First sublist: ");
        printList(first);
        System.out.print("Second sublist: ");
        printList(head2);
    }

    static LnkedListQ2 merge(LnkedListQ2 l1, LnkedListQ2 l2) {
        LnkedListQ2 result = new LnkedListQ2();
        node temp = l1.first;
        while (temp != null) {
            result.insert(temp.data);
            temp = temp.next;
        }
        temp = l2.first;
        while (temp != null) {
            result.insert(temp.data);
            temp = temp.next;
        }
        return result;
    }

    void insertUnique(int data) {
        node temp = first;
        while (temp != null) {
            if (temp.data == data) {
                System.out.println("Error: Item already exists");
                return;
            }
            temp = temp.next;
        }
        insert(data);
    }

    void printList() {
        printList(first);
    }

    void printList(node node) {
        node temp = node;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LnkedListQ2 list = new LnkedListQ2();

        list.insert(34);
        list.insert(65);
        list.insert(27);
        list.insert(89);
        list.insert(12);
        list.insert(99);

        System.out.println("Original List:");
        list.printList();

        list.deleteSamallest();
        System.out.println("After deleting smallest:");
        list.printList();

        list.deleteAll(65);
        System.out.println("After deleting all 65:");
        list.printList();

        System.out.println("3rd element: " + list.getKth(3));

        list.deleteKth(2);
        System.out.println("After deleting 2nd element:");
        list.printList();

        list.divideList();

        LnkedListQ2 l1 = new LnkedListQ2();
        l1.insert(11);
        l1.insert(22);
        l1.insert(33);
        LnkedListQ2 l2 = new LnkedListQ2();
        l2.insert(44);
        l2.insert(55);
        l2.insert(66);
        l2.insert(77);
        l2.insert(88);
        LnkedListQ2 merged = LnkedListQ2.merge(l1, l2);
        System.out.println("Merged List:");
        merged.printList();
        System.out.println();
        merged.insertUnique(22);
        merged.insertUnique(99);
        System.out.println("After unique insert:");
        merged.printList();
    }
}
