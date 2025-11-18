public class HospitalPriorityQ {
    int[] patientIDs;
    String[] names;
    int[] severityLevels;
    int size;

    public HospitalPriorityQ(int capacity) {
        patientIDs = new int[capacity];
        names = new String[capacity];
        severityLevels = new int[capacity];
        size = 0;
    }

    // Enqueue: Insert patient based on severity (higher severity → higher priority)
    public void enqueue(int id, String name, int severity) {
        if (size == patientIDs.length) {
            System.out.println("Queue is full!");
            return;
        }

        int i;
        // Shift patients with lower severity to the right
        for (i = size - 1; i >= 0; i--) {
            if (severityLevels[i] < severity) {
                patientIDs[i + 1] = patientIDs[i];
                names[i + 1] = names[i];
                severityLevels[i + 1] = severityLevels[i];
            } else {
                break;
            }
        }
        patientIDs[i + 1] = id;
        names[i + 1] = name;
        severityLevels[i + 1] = severity;
        size++;
    }

    public void dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.println("Dequeued Patient ==> ID: " + patientIDs[0] +
                           ", Name: " + names[0] +
                           ", Severity: " + severityLevels[0]);

        for (int i = 1; i < size; i++) {
            patientIDs[i - 1] = patientIDs[i];
            names[i - 1] = names[i];
            severityLevels[i - 1] = severityLevels[i];
        }
        size--;
    }

    public void display() {
        if (size == 0) {
            System.out.println("No patients in queue.");
            return;
        }
        System.out.println("Patients in Priority Queue:");
        for (int i = 0; i < size; i++) {
            System.out.println("ID: " + patientIDs[i] +
                               ", Name: " + names[i] +
                               ", Severity: " + severityLevels[i]);
        }
    }

   public void countPatients() {
        System.out.println("Total Patients: " + size);
    }

    public static void main(String[] args) {
        HospitalPriorityQ pq = new HospitalPriorityQ(10);

        pq.enqueue(1, "saifullah", 2);
        pq.enqueue(2, "sikandar", 5);
        pq.enqueue(3, "mohiz", 3);
        pq.enqueue(4, "siyaf", 4);

        pq.display();
        pq.countPatients();

        System.out.println("\nDequeue operation:");
        pq.dequeue();

        System.out.println("\nAfter Dequeue:");
        pq.display();
        pq.countPatients();
    }
}
