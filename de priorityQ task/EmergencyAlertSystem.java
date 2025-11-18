public class EmergencyAlertSystem {
    String[] messages;
    int[] priorities;
    int size;

    public EmergencyAlertSystem(int capacity) {
        messages = new String[capacity];
        priorities = new int[capacity];
        size = 0;
    }

    public void insert(String message, int priority) {
        if (size == messages.length) {
            System.out.println("Alert Queue is full!");
            return;
        }

        int i;
        for (i = size - 1; i >= 0; i--) {
            if (priorities[i] > priority) {
                messages[i + 1] = messages[i];
                priorities[i + 1] = priorities[i];
            } else {
                break;
            }
        }
        messages[i + 1] = message;
        priorities[i + 1] = priority;
        size++;
    }

    public void processAlert() {
        if (size == 0) {
            System.out.println("No alerts to process!");
            return;
        }
        System.out.println("Processing Alert ==> " + messages[0] + " | Priority: " + priorities[0]);

        for (int i = 1; i < size; i++) {
            messages[i - 1] = messages[i];
            priorities[i - 1] = priorities[i];
        }
        size--;
    }

    public void display() {
        if (size == 0) {
            System.out.println("No alerts in queue.");
            return;
        }
        System.out.println("Alerts in Queue:");
        for (int i = 0; i < size; i++) {
            System.out.println("Message: " + messages[i] + " | Priority: " + priorities[i]);
        }
    }

    public static void main(String[] args) {
        EmergencyAlertSystem alertSystem = new EmergencyAlertSystem(10);

        alertSystem.insert("Fire in Building A", 1);
        alertSystem.insert("Network outage", 3);
        alertSystem.insert("Medical emergency", 2);
        alertSystem.insert("Routine maintenance", 5);

        alertSystem.display();

        System.out.println("\nProcessing highest priority alert...");
        alertSystem.processAlert();

        System.out.println("\nAfter processing:");
        alertSystem.display();
    }
}
