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
    static String deliveryStatus = "Pending"; // Adding static delivery status field

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

    public void displaySorted()
    {
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

    // Method to display Parcel details
    public void displayparseldetails() {
        Node current = head;
        while (current != null) {
            System.out.println("-------------");
            System.out.println("Parcel ID: " + current.parcel.parcelId);
            System.out.println("Sender's name: " + current.parcel.sender_name);
            System.out.println("Recipient's name: " + current.parcel.recipient_name);
            System.out.println("Weight: Kg." + current.parcel.weight);
            System.out.println("Price: Rs."+ current.parcel.price);



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
            System.out.println("Priority"+ current.courier.priority);
            System.out.println("Delivery  Fee: " + current.courier.deliveryfee);
            System.out.println("Delivery Status: " + Courier.deliveryStatus); // Include delivery status


            current = current.next;
        }
    }

    public void deleteByParcelId(String parcelId) {
        Node current = head;

        // Traverse the list to find the node with the specified Parcel ID
        while (current != null) {
            if (current.parcel.parcelId.equals(parcelId)) {
                if (current == head) {
                    head = current.next;
                    if (head != null)
                        head.prev = null;
                } else {
                    current.prev.next = current.next;
                    if (current.next != null)
                        current.next.prev = current.prev;
                }
                System.out.println("");
                System.out.println("Parcel with ID " + parcelId + " deleted.");

                break; // Exit loop once the parcel is found and deleted
            }
            current = current.next;
        }

        // If the parcel ID is not found, display a message
        System.out.println("");
        System.out.println("Parcel with ID " + parcelId + " not found.");

    }

    public void searchByParcelId(String parcelId) {
        Node current = head;
        boolean found = false;

        while (current != null) {
            if (current.parcel.parcelId.equals(parcelId)) {
                found = true;
                System.out.println("-------------");
                System.out.println("Parcel ID: " + current.parcel.parcelId);
                System.out.println("Sender's name: " + current.parcel.sender_name);
                System.out.println("Recipient's name: " + current.parcel.recipient_name);
                System.out.println("Weight: Kg." + current.parcel.weight);
                System.out.println("Price: Rs."+ current.parcel.price);
                System.out.println("Courier ID: " + current.courier.courier_id);
                System.out.println("Distance: " + current.courier.distance);
                System.out.println("Location: " + current.courier.location);
                System.out.println("Priority: " + current.courier.priority);
                System.out.println("Delivery Fee: " + current.courier.deliveryfee);
                break; // Exit the loop once the parcel with the given ID is found
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("-------------");
            System.out.println("Parcel with ID " + parcelId + " not found.");
            System.out.println("-------------");
        }
    }

    public void displayDeliveryStatusById(String parcelId) {
        Node current = head;
        boolean found = false;

        while (current != null) {
            if (current.parcel.parcelId.equals(parcelId)) {
                found = true;
                System.out.println("-------------");
                System.out.println("Parcel ID: " + current.parcel.parcelId);
                System.out.println("Courier ID: " + current.courier.courier_id);
                System.out.println("Delivery Status: " + Courier.deliveryStatus); // Use static field for delivery status

                break; // Exit the loop once the parcel with the given ID is found
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("-------------");
            System.out.println("Parcel with ID " + parcelId + " not found.");
            System.out.println("-------------");
        }
    }

    public void updateDeliveryStatus(String parcelId, String newStatus) {
        Node current = head;
        boolean found = false;

        while (current != null) {
            if (current.parcel.parcelId.equals(parcelId)) {
                found = true;
                // Update the delivery status
                Courier.deliveryStatus = newStatus;
                System.out.println("Delivery status updated!");
                break; // Exit the loop once the parcel with the given ID is found
            }

            current = current.next;
        }

        if (!found) {
            System.out.println("Parcel with ID " + parcelId + " not found.");
        }
    }



}

class Edge {
    String source, destination;
    int distance;

    public Edge(String source, String destination, int distance) {
        this.source = source;
        this.destination = destination;
        this.distance = distance;
    }
}

class Subset {
    int parent, rank;

    public Subset(int parent, int rank) {
        this.parent = parent;
        this.rank = rank;
    }
}

class Kruskal {
    public static void sortEdges(Edge[] edges) {
        for (int i = 1; i < edges.length; i++) {
            for (int j = i; j > 0 && edges[j - 1].distance > edges[j].distance; j--) {
                Edge temp = edges[j];
                edges[j] = edges[j - 1];
                edges[j - 1] = temp;
            }
        }
    }

    public static void kruskals(int V, Edge[] edges) {
        int j = 0;
        int noOfEdges = 0;

        Object[] indexMap = new Object[V];
        int index = 0;
        for (Edge edge : edges) {
            int srcIndex = indexOf(indexMap, edge.source);
            int destIndex = indexOf(indexMap, edge.destination);
            if (srcIndex == -1) {
                indexMap[index++] = edge.source;
            }
            if (destIndex == -1) {
                indexMap[index++] = edge.destination;
            }
        }

        Subset[] subsets = new Subset[V];
        Edge[] results = new Edge[20]; // Fix size to 20

        for (int i = 0; i < V; i++) {
            subsets[i] = new Subset(i, 0);
        }

        while (noOfEdges < V - 1 && j < edges.length) {
            Edge nextEdge = edges[j];
            int x = findRoot(subsets, indexOf(indexMap, nextEdge.source));
            int y = findRoot(subsets, indexOf(indexMap, nextEdge.destination));

            if (x != y) {
                results[noOfEdges] = nextEdge;
                union(subsets, x, y);
                noOfEdges++;
            }

            j++;
        }

        System.out.println("");
        System.out.println("shortest paths to distribute the all parcels:");
        int minCost = 0;
        for (int i = 0; i < noOfEdges; i++) {
            System.out.println(results[i].source + " - " + results[i].destination + " = "
                    + results[i].distance +" km");
            minCost += results[i].distance;
        }
        System.out.println("");
        System.out.println("Total distance of shortest delivery route: " + minCost +" km");
        System.out.println("");
    }

    private static void union(Subset[] subsets, int x, int y) {
        int rootX = findRoot(subsets, x);
        int rootY = findRoot(subsets, y);

        if (subsets[rootY].rank < subsets[rootX].rank) {
            subsets[rootY].parent = rootX;
        } else if (subsets[rootX].rank < subsets[rootY].rank) {
            subsets[rootX].parent = rootY;
        } else {
            subsets[rootY].parent = rootX;
            subsets[rootX].rank++;
        }
    }

    private static int findRoot(Subset[] subsets, int i) {
        if (subsets[i].parent == i)
            return subsets[i].parent;

        subsets[i].parent = findRoot(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

    private static int indexOf(Object[] array, Object element) {
        for (int i = 0; i < array.length; i++) {
            if (element.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }
}
public class Main01{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList1 dll = new DoublyLinkedList1();

        while (true)
        {
            //Displaying menu options
            System.out.println("");
            System.out.println("Choose an option ( select number)");
            System.out.println("1. Add a parcel and courier");
            System.out.println("2. Display parcel details");
            System.out.println("3. Display courier details");
            System.out.println("4. Display the priorities of the parcels");
            System.out.println("5. Calculate the shortest distance to distribute the all parcels");
            System.out.println("6. Delete the courier data");
            System.out.println("7. Search courier data");
            System.out.println("8. Display delivery status");
            System.out.println("9. Update delivery status");
            System.out.println("10. Exit");

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
                    //If the user choose the option 05) Display the minimum location by using kruskal
                    System.out.print("Enter the number of locations: ");
                    int V = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter the number of routes: ");
                    int E = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Edge[] graphEdges = new Edge[E];
                    for (int i = 0; i < E; i++) {
                        System.out.println("");
                        System.out.println("Enter details for route " + (i + 1) + ":");
                        System.out.print("Start location: ");
                        String source = scanner.nextLine();
                        System.out.print("Destination: ");
                        String destination = scanner.nextLine();
                        System.out.print("Distance: ");
                        int distance = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        graphEdges[i] = new Edge(source, destination, distance);
                    }

                    Kruskal.sortEdges(graphEdges);

                    Kruskal.kruskals(V, graphEdges);
                    break;

                case 6:
                    //If the user choose the option 06) Delete parcel by ID
                    System.out.println("Enter parcel ID to delete:");
                    String parcelIdToDelete = scanner.nextLine();
                    dll.deleteByParcelId(parcelIdToDelete);
                    break;

                case 7:
                    //If the user choose the option 07) Searxh parcel by ID
                    System.out.println("Enter parcel ID to search:");
                    String parcelIdToSearch = scanner.nextLine();
                    dll.searchByParcelId(parcelIdToSearch);
                    break;


                case 8:
                    // If the user chooses the option 08) Display delivery status by parcel ID
                    System.out.println("Enter parcel ID to display delivery status:");
                    String parcelIdToDisplayStatus = scanner.nextLine();
                    dll.displayDeliveryStatusById(parcelIdToDisplayStatus);
                    break;

                case 9:
                    // If the user chooses the option 09) Update delivery status by parcel ID
                    System.out.println("Enter parcel ID to update delivery status:");
                    String parcelIdToUpdateStatus = scanner.nextLine();
                    System.out.println("Enter new delivery status:");
                    String newStatus = scanner.nextLine();
                    dll.updateDeliveryStatus(parcelIdToUpdateStatus, newStatus);
                    break;

                case 10:
                    //If the user choose the option 10 Exit
                    System.exit(0);


                default:
                    //If the user choose invalid index
                    System.out.println("Invalid choice. Please select correct  numeric value.");
            }

        }

    }
}