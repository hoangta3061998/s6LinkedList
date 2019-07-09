import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private Node head = null;
    private Node tail = null;

    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    public void add(int index, E e) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index:" + index + ", Size: " + size);
        } else if (index == 0 || size == 0) {
            addFirst(e);
        } else if (index == size) {
            addLast(e);
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            Node temp = current.next;
            current.next = new Node(e);
            current.next.next = temp;
            size++;
        }
    }

    public void addFirst(E e) {
        Node newNode = new Node(e);
        newNode.next = head;
        head = newNode;
        size++;
        if (tail == null) {
            tail = head;
        }
    }

    public void addLast(E e) {
        if (tail == null) {
            addFirst(e);
        } else {
            Node newNode = new Node(e);
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    public Object remove(int index) {
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        Node temp;
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        } else if (index == size - 1) {
            temp = current.next;
            tail = current;
            tail.next = null;
        } else if (index == 0) {
            temp = current;
            head = current.next;
        } else {
            temp = current.next;
            current.next = current.next.next;
        }
        size--;
        return temp.getData();
    }

    public boolean remove(Object o) {
        boolean remove = false;
        Node current = head;
        if (current.getData().equals(o)) {
            remove = true;
            head = current.next;
            size--;
        } else {
            for (int i = 1; i < size; i++) {
                if (current.next.getData().equals(o)) {
                    remove = true;
                    current.next = current.next.next;
                    size--;
                    break;
                }
                current = current.next;
            }
        }
        return remove;
    }

    public int size() {
        return size;
    }

    public boolean contains(E e) {
        boolean contains = false;
        Node current = head;
        for (int i = 0; i < size; i++) {
            if (current.getData().equals(e)) {
                contains = true;
                break;
            }
            current = current.next;
        }
        return contains;
    }

    public int indexOf(E e) {
        int index = -1;
        Node current = head;
        for (int i = 0; i < size; i++) {
            if (current.getData().equals(e)) {
                index = i;
                break;
            }
            current = current.next;
        }
        return index;
    }

    public boolean add(E e) {
        Node newNode = new Node(e);
        tail.next = newNode;
        tail = newNode;
        size++;
        return true;
    }

    public Object get(int index) {
        Node current = head;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        return current.next.getData();
    }

    public Object getFirst() {
        return head.getData();
    }

    public Object getLast() {
        return tail.getData();
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
    public void print(){
        Node current = head;
        System.out.print("[");
        for ( int i = 0 ; i < size ; i++){
            if ( i == size-1){
                System.out.print(current.getData()+"]");
                break;
            }
            System.out.print(current.getData() + ",");
            current=current.next;
        }
    }
    public Object clone(){
        Object elementArray[] = new Object[size];
        Node current = head;
        for ( int i = 0 ; i < elementArray.length ; i++){
            elementArray[i] = current.getData();
            current=current.next;
        }
        return Arrays.toString(elementArray);
    }
}
