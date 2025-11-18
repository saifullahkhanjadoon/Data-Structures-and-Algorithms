public class PriorityQ {
    String[] taskNames;
    int[] priorities;
    int size;

    public PriorityQ(int capacity) {
        taskNames = new String[capacity];
        priorities = new int[capacity];
        size = 0;
    }

    public void insert(String taskName, int priority) {
        if (size == taskNames.length) {
            System.out.println("Priority Queue is full!");
            return;
        }

        int i;
        for (i = size - 1; i >= 0; i--) {
            if (priorities[i] > priority) {
                taskNames[i + 1] = taskNames[i];
                priorities[i + 1] = priorities[i];
            } else {
                break;
            }
        }
        taskNames[i + 1] = taskName;
        priorities[i + 1] = priority;
        size++;
    }

    public void remove() {
        if (size == 0) {
            System.out.println("Priority Queue is empty!");
            return;
        }
        System.out.println("Removed: " + taskNames[0] + " | Priority: " + priorities[0]);
        for (int i = 1; i < size; i++) {
            taskNames[i - 1] = taskNames[i];
            priorities[i - 1] = priorities[i];
        }
        size--;
    }

    public void display() {
        if (size == 0) {
            System.out.println("Priority Queue is empty!");
            return;
        }
        System.out.println("Tasks in Priority Queue:");
        for (int i = 0; i < size; i++) {
            System.out.println("Task: " + taskNames[i] + " | Priority: " + priorities[i]);
        }
    }

    public static void main(String[] args) {
        PriorityQ pq = new PriorityQ(10);

        pq.insert("Task A", 3);
        pq.insert("Task B", 1);
        pq.insert("Task C", 2);
        pq.insert("Task D", 5);
        pq.insert("Task E", 4);

        pq.display();

        System.out.println("\nRemoving highest priority task...");
        pq.remove();

        System.out.println("\nAfter removal:");
        pq.display();
    }
}
