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
        Double weight;
        Double deliveryfee;
        String location;
        int distance;

// Constructor for Courier class
        public Courier(String parcelId, String courier_id, int distance, double deliveryfee, String location, double weight) {
            this.parcelId = parcelId;
            this.courier_id = courier_id;
            this.distance = distance;
            this.deliveryfee = deliveryfee;
            this.location = location;
            this.weight = weight;
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
// Method to display Parcel details
            public void displayparseldetails() {
                Node current = head;
                while (current != null) {
                    System.out.println("Parcel ID: " + current.parcel.parcelId);
                    System.out.println("Sender's name: " + current.parcel.sender_name);
                    System.out.println("Recipient's name: " + current.parcel.recipient_name);
                    System.out.println("Weight: Kg." + current.parcel.weight);
                    System.out.println("Price: Rs."+ current.parcel.price);
                   // System.out.println("Delivery Status: Rs. " + current.parcel.deliveryStatus);

                    current = current.next;
                }
            }
//Method to display Courier details
            public void displaycourierdetails() {
                Node current = head;
                while (current != null) {
                    System.out.println("Parcel ID: " + current.courier.parcelId);
                    System.out.println("Courier ID: " + current.courier.courier_id);
                    System.out.println("Distance: " + current.courier.distance);
                    System.out.println("Weight: " + current.courier.weight);
                    System.out.println("Location: " + current.courier.location);
                    System.out.println("Delivery  Fee: " + current.courier.deliveryfee);

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
                 System.out.println("1.Add a parcel and courier");
                 System.out.println("2.Display parcel details");
                 System.out.println("3.Display courier details");
                 System.out.println("4.Exit");
                 scanner.nextLine();
                 System.out.println("Input your choice");

                    //Reading user choice
                 int choice = scanner.nextInt();
                 scanner.nextLine();
                    //Switch cases for user choices
                    switch (choice) {
                        //If the user choose the option 01) add a parcel and courier
                        case 1:
                            System.out.println("Enter parcel ID:");
                            String parcelId = scanner.nextLine();

                            System.out.println("Enter sender's name:");
                            String senderName = scanner.nextLine();
                            System.out.println("Enter recipient's name:");
                            String recipientName = scanner.nextLine();
                            System.out.println("Enter parcel price:Rs.");
                            double price = scanner.nextDouble();
                            System.out.println("Enter distance: Km");
                            int distance = scanner.nextInt();
                            System.out.println("Enter weight: Kg");
                            int weight = scanner.nextInt();
                            scanner.nextLine(); //Newline
                            System.out.println("Enter courier ID:");
                            String courierId = scanner.nextLine();
                            System.out.println("Enter courier location:");
                            String location = scanner.nextLine();
                            System.out.println("Enter courier delivery fee: Rs");
                            double deliveryFee = scanner.nextDouble();
                            System.out.println("Enter courier weight: Kg");
                            double courierWeight = scanner.nextDouble();
                            scanner.nextLine(); //Newline
                            //Creating Parcel and Courier objects
                            Parcel parcel = new Parcel(parcelId, senderName, recipientName, price,  weight);
                            Courier courier = new Courier(parcelId, courierId, distance, deliveryFee, location, courierWeight);
                           //Inserting into the doubly linked list
                            dll.insert(parcel, courier);

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
                            //If the user choose the option 04) Exit
                            System.out.println("Exiting...");
                            System.exit(0);

                        default:
                            //If the user choose invalid index
                            System.out.println("Invalid choice. Please select correct  numeric value.");
                }

            }

        }
    }

