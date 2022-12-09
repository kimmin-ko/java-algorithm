package data_structure.linked_list.v2;

public class Main {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.retrieve();

        list.delete(2);
        list.delete(4);
        list.retrieve();
    }
}
