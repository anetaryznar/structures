public class OptimizedLinkedList<Type> implements List<Type> {
    private Node<Type> first;
    private Node<Type> last;
    private int length = 0;

    @Override
    public void add(Type a) {
        Node<Type> newNode = new Node(a);

        if(first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            newNode.previous = last;

            last = newNode;
        }
        ++length;
    }

    private Node<Type> getNode(int pos) {
        if(pos < 0 || pos >= length) {
            throw new IndexOutOfBoundsException("can't find index " + pos);
        }
        if(pos <= length / 2) {
            Node<Type> current = first;

            for (int i = 0; i < pos; ++i) {
                current = current.next;
            }
            return current;
        } else {
            Node<Type> current = last;

            for (int i = length; i >= pos; --i) {
                current = current.previous;
            }
            return current;
        }
    }

    @Override
    public Type get(int pos) {
        return getNode(pos).value;
    }

    @Override
    public void remove(int pos) {
        if(length == 0 || pos < 0 || pos >= length) {
            throw new IndexOutOfBoundsException("can't find index " + pos);
        }

        if(pos == 0) {
            first = first.next;
        } else {
            Node<Type> toRemove = getNode(pos);

            Node<Type> beforeRemoved = toRemove.previous;
            Node<Type> afterRemoved = toRemove.next;

            beforeRemoved.next = afterRemoved;
            if(afterRemoved != null) {
                afterRemoved.previous = beforeRemoved;
            }
        }
        --length;
    }

    @Override
    public int size() {
        return length;
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
