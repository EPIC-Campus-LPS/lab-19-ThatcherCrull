import java.util.Objects;

public class Node<E> {
    E data;
    Node<E> prev;
    Node<E> next;

    public Node(E d) {
        data = d;
    }

    public void setNextNode(Node<E> next) {
        this.next = next;
    }

    public void setPrevNode(Node<E> prev) {
        this.prev = prev;
    }

    public Node<E> getNextNode() {
        return next;
    }

    public Node<E> getPrevNode() {
        return prev;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Node<?> other = (Node<?>) obj;
        return Objects.equals(data, other.data);
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
