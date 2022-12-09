package data_structure.linked_list.v1;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        Node head = new Node(1);
        head.append(2);
        head.append(3);
        head.append(4);
        head.retrieve();

        head.delete(2);
        head.delete(4);
        head.retrieve();

        LinkedList<Integer> list = new LinkedList<>();
        list.get(3);
        list.remove(1);
        list.remove(new Integer(1));
    }
}