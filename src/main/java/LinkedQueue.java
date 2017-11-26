public class LinkedQueue<Type> implements Queue<Type> {
    private Node<Type> first;
    private Node<Type> last;


    @Override
    public void add(Type a) {
        Node<Type> newNode = new Node<>(a);

        if(first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            newNode.previous = last;

            last = newNode;
        }
    }

    @Override
    public Type poll() {
        if(first == null) {
            throw new EmptyQueueException();
        }

        Type value = first.value;

        first = first.next;

        return value;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    private static class Node<Type> {
        private Type value;
        private Node<Type> next;
        private Node<Type> previous;

        private Node(Type value) {
            this.value = value;
        }
    }
}
