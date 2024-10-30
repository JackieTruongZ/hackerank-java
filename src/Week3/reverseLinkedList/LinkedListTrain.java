package Week3.reverseLinkedList;


class Node {
    public int data;
    public Node next;

    public Node(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }

}

class LinkedList {
    public Node head;
    public Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addNode(int nodeData) {
        Node newNode = new Node(nodeData);
        if (this.head == null) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
        }

        this.tail = newNode;
    }

}


public class LinkedListTrain {

    public static void main(String[] args) {

    }

}
