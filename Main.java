import java.util.Scanner;
//Parcel class
class Parcel {
    String parcelId;
    String sender_name;
    String recipient_name;

    Double price;
    int weight;

    //Constructor for parcel
    public Parcel(String parcelId, String sender_name, String recipient_name, double price, int weight) {
        this.parcelId = parcelId;
        this.sender_name = sender_name;
        this.recipient_name = recipient_name;
        this.price = price;
        this.weight = weight;

    }
} // Courier class

class Courier {
    String parcelId;
    String courier_id;
    Double deliveryfee;
    String location;
    int distance;
    int priority;

    // Constructor for Courier class
    public Courier(String parcelId, String courier_id, int distance, double deliveryfee, String location, int priority) {
        this.parcelId = parcelId;
        this.courier_id = courier_id;
        this.distance = distance;
        this.deliveryfee = deliveryfee;
        this.location = location;
        this.priority = priority;
    }
}
class Node {
    Parcel parcel;
    Courier courier;
    Node prev;
    Node next;
    // Constructor for node
    public Node(Parcel parcel, Courier courier) {
        this.parcel = parcel;
        this.courier = courier;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList1 {
    Node head;

    //Method to insert Parcel and Courier into Doubly Linked List
    public void insert(Parcel parcel, Courier courier) {
        Node newNode = new Node(parcel, courier);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    public void sort() {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            Node current = head;
            Node previous = null;
            while (current != null && current.next != null) {
                if (current.courier.priority > current.next.courier.priority) {
                    if (previous == null) {
                        head = current.next;
                    } else {
                        previous.next = current.next;
                    }
                    Node temp = current.next;
                    current.next = temp.next;
                    temp.next = current;
                    previous = temp;
                    sorted = false;
                } else {
                    previous = current;
                    current = current.next;
                }
            }
        }
    }



    // Method to display Parcel details
    public void displayparseldetails() {
        Node current = head;
        while (current != null) {
            System.out.println("-------------");
            System.out.println("Parcel ID: " + current.parcel.parcelId);
            System.out.println("Sender's name: " + current.parcel.sender_name);
            System.out.println("Recipient's name: " + current.parcel.recipient_name);
            System.out.println("Weight: Kg." + current.parcel.weight);
            System.out.println("Price: Rs." + current.parcel.price);



            current = current.next;
        }
    }

    //Method to display Courier details
    public void displaycourierdetails() {
        Node current = head;
        while (current != null) {
            System.out.println("-------------");
            System.out.println("Parcel ID: " + current.courier.parcelId);
            System.out.println("Courier ID: " + current.courier.courier_id);
            System.out.println("Distance: " + current.courier.distance);
            System.out.println("Location: " + current.courier.location);
            System.out.println("Priority" + current.courier.priority);
            System.out.println("Delivery  Fee: " + current.courier.deliveryfee);


            current = current.next;
        }
    }

    public void displaySorted() {
        Node current = head;
        System.out.println("Sorted List based on Priority:");
        while (current != null) {
            System.out.println("-------------");
            System.out.println("Parcel ID: " + current.parcel.parcelId);
            System.out.println("Destination: " + current.courier.location);
            System.out.println("Priority: " + current.courier.priority);
            current = current.next;
        }
    }
}



public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList1 dll = new DoublyLinkedList1();

        while (true)
        {
            //Displaying menu options
            System.out.println("Choose an option ( select number)");
            System.out.println("1. Add a parcel and courier");
            System.out.println("2. Display parcel details");
            System.out.println("3. Display courier details");
            System.out.println("4. Display the priorities of the parcels");
            System.out.println("5. Exit");
            System.out.println();


            System.out.print("Input your choice: ");

            //Reading user choice
            int choice = scanner.nextInt();
            scanner.nextLine();
            //Switch cases for user choices
            switch (choice) {
                //If the user choose the option 01) add a parcel and courier
                case 1:
                    // Prompt the user to enter the number of parcels
                    System.out.println("Enter the number of parcels to add:");
                    int numParcels = scanner.nextInt();
                    scanner.nextLine();

                    for (int i = 0; i < numParcels; i++) {
                        System.out.println("Enter details for parcel " + (i + 1) + ":");

                        System.out.print("Enter parcel ID: ");
                        String parcelId = scanner.nextLine();

                        System.out.print("Enter sender's name: ");
                        String senderName = scanner.nextLine();

                        System.out.print("Enter recipient's name: ");
                        String recipientName = scanner.nextLine();

                        System.out.print("Enter parcel price: ");
                        double price = scanner.nextDouble();

                        System.out.print("Enter distance: ");
                        int distance = scanner.nextInt();

                        System.out.print("Enter weight: ");
                        int weight = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter courier ID: ");
                        String courierId = scanner.nextLine();

                        System.out.print("Enter courier location: ");
                        String location = scanner.nextLine();

                        System.out.print("Enter courier delivery fee: ");
                        double deliveryFee = scanner.nextDouble();

                        System.out.print("Enter courier priority: ");
                        int priority = scanner.nextInt();
                        scanner.nextLine();

                        Parcel parcel = new Parcel(parcelId, senderName, recipientName, price, weight);
                        Courier courier = new Courier(parcelId, courierId, distance, deliveryFee, location, priority);

                        dll.insert(parcel, courier);
                    }
                    break;


                case 2:
                    //If the user choose the option 02) Display parcel details
                    System.out.println("Parcel Details:");
                    dll.displayparseldetails();

                    break;

                case 3:
                    //If the user choose the option 03) Display courier details
                    System.out.println("Courier Details:");
                    dll.displaycourierdetails();

                    break;
                case 4:
                    //If the user choose the option 04) Display the listing according to the priority
                    System.out.println("Priority listing");
                    dll.sort();
                    dll.displaySorted();

                    break;
                case 5:
                    //If the user choose the option 05 Exit
                    System.exit(0);


                default:
                    //If the user choose invalid index
                    System.out.println("Invalid choice. Please select correct  numeric value.");
            }

  }

}
}
