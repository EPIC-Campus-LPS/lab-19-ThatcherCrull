
public class DoublyLinkedList<E> implements List {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    public DoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(Object element) {
       Node<E> newNode = new Node<>((E) element);
       if (tail == null) {
           tail = newNode;
           head = newNode;
       } else {
            tail.setNextNode(newNode);
            newNode.setPrevNode(tail);
            tail = newNode;
       }
       size++;
    }

    @Override
    public void add(int i, Object element) throws IndexOutOfBoundsException {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException("Out of Bounds");
        }
        Node<E> newNode = new Node<>((E) element);
        if (i == 0) {
            newNode.setNextNode(head);
            if (head != null) {
                head.setPrevNode(newNode);
            }
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
        } else if (i == size) {
            newNode.setPrevNode(tail);
            if (tail != null) {
                tail.setNextNode(newNode);
            }
            tail = newNode;
            if (head == null) {
                head = newNode;
            }
        } else {
            Node<E> current = head;
            for (int j = 0; j < i - 1; j++) {
                current = current.getNextNode();
            }
            newNode.setNextNode(current.getNextNode());
            newNode.setPrevNode(current);
            current.getNextNode().setPrevNode(newNode);
            current.setNextNode(newNode);
        }
        size++;
    }

    @Override
    public E remove() {
        if (tail == null) {
            throw new IndexOutOfBoundsException("List is Empty");
        }
        E removed = tail.data;
        if (tail.getPrevNode() != null) {
            tail = tail.getPrevNode();
            tail.setPrevNode(null);
        } else {
            head = null;
            tail = null;
        }
        size--;
        return removed;
    }

    @Override
    public Node remove(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Out of Bounds");
        }
        Node<E> removed;
        if (i == 0) {
            removed = head;
            head = head.getNextNode();
            if (head != null) {
                head.setNextNode(null);
            } else {
                tail = null;
            }
        } else if (i == size - 1) {
            removed = tail;
            tail = tail.getPrevNode();
            if (tail != null) {
                tail.setNextNode(null);
            }
        } else {
            Node<E> current = head;
            for (int j = 0; j < i; j++) {
                current = current.getNextNode();
            }
            removed = current;
            current.getPrevNode().setNextNode(current.getNextNode());
            current.getNextNode().setPrevNode(current.getPrevNode());
        }
        size--;
        return removed;
    }

    @Override
    public Node get(int i) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Out of Bounds");
        }
        Node<E> current = head;
        for (int j = 0; j < i; j++) {
            current = current.getNextNode();
        }
        return current;
    }

    @Override
    public void set(int i, Object element) throws IndexOutOfBoundsException {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("Out of Bounds");
        }
        Node<E> current = head;
        for (int j = 0; j < i; j++) {
            current = current.getNextNode();
        }
        current.data = (E) element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
