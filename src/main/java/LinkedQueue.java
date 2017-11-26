public class LinkedQueue<Type> implements Queue<Type> {
    private Node<Type> head = null;
    private Node<Type> tail = null;

    @Override
    public void add(Type a) {
        Node<Type> node = new Node<>(a);
        if(isEmpty()) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }

    @Override
    public Type poll() {
        Type value = head.value;

        head = head.next;

        return value;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public String toString() {
        if(head == null) {
            return "[]";
        }

        StringBuilder textBuilder = new StringBuilder("[");

        Node actual = head;

        while(actual.next != null) {
            textBuilder.append(actual.value).append(", ");
            actual = actual.next;
        }

        textBuilder.append(actual.value).append("]");

        return textBuilder.toString();
    }
}
