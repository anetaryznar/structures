public class OptimizedLinkedList implements List {
    private Node first;
    private Node last;
    private int length = 0;

    @Override
    public void add(double a) {
        Node newNode = new Node(a);

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

    private Node getNode(int pos) {
        if(pos < 0 || pos >= length) {
            throw new IndexOutOfBoundsException("can't find index " + pos);
        }
        if(pos <= length / 2) {
            Node current = first;

            for (int i = 0; i < pos; ++i) {
                current = current.next;
            }
            return current;
        } else {
            Node current = last;

            for (int i = length; i >= pos; --i) {
                current = current.previous;
            }
            return current;
        }
    }

    @Override
    public double get(int pos) {
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
            Node toRemove = getNode(pos);

            Node beforeRemoved = toRemove.previous;
            Node afterRemoved = toRemove.next;

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

    private static class Node {
        private double value;
        private Node next;
        private Node previous;

        private Node(double value) {
            this.value = value;
        }
    }
}
