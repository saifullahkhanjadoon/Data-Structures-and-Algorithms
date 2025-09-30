class NTS {
    int std_id;
    String std_name;
    int marks_obt;
    String address;
    NTS next, prev;

    NTS(int id, String name, int marks, String addr) {
        std_id = id;
        std_name = name;
        marks_obt = marks;
        address = addr;
        next = prev = null;
    }
}

class DoublyLinkedListQ1 {
    NTS first;

    void insert(int id, String name, int marks, String addr) {
        NTS newNode = new NTS(id, name, marks, addr);

        if (first == null) {
            first = newNode;
            return;
        }

        NTS temp = first;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    int size() {
        int count = 0;
        NTS temp = first;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    void count_pass_fail() {
        int pass = 0, fail = 0;
        NTS temp = first;

        while (temp != null) {
            if (temp.marks_obt >= 50) {
                pass++;
                System.out.println("PASS -> " + temp.std_id + " " + temp.std_name + " " + temp.marks_obt + " " + temp.address);
            } else {
                fail++;
                System.out.println("FAIL -> " + temp.std_id + " " + temp.std_name + " " + temp.marks_obt + " " + temp.address);
            }
            temp = temp.next;
        }

        System.out.println("Total Pass: " + pass);
        System.out.println("Total Fail: " + fail);
    }

    void deleteFailStudents() {
        NTS temp = first;

        while (temp != null) {
            if (temp.marks_obt < 50) {
                // If node is head
                if (temp == first) {
                    first = first.next;
                    if (first != null) {
                        first.prev = null;
                    }
                } else {
                    temp.prev.next = temp.next;
                    if (temp.next != null) {
                        temp.next.prev = temp.prev;
                    }
                }
            }
            temp = temp.next;
        }
    }

    void printList() {
        NTS temp = first;
        while (temp != null) {
            System.out.println("id--> "+temp.std_id + " | name--> " + temp.std_name + " | marks--> " + temp.marks_obt + " | address--> " + temp.address);
            temp = temp.next;
        }
    }


    public static void main(String[] args) {
        DoublyLinkedListQ1 list = new DoublyLinkedListQ1();

        list.insert(1, "saifullah", 67, "havelian");
        list.insert(2, "siyaf", 45, "Islamabad");
        list.insert(3, "sikandar", 89, "Lahore");
        list.insert(4, "ahmed", 30, "Karachi");

        System.out.println("All Students:");
        list.printList();

        System.out.println("\nTotal Students = " + list.size());

        System.out.println("\nPass and Fail Students:");
        list.count_pass_fail();

        System.out.println("\nAfter Deleting Fail Students (<50):");
        list.deleteFailStudents();
        list.printList();
    }
}
