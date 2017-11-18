public class LinkedList implements List {
    private Node first;

    @Override
    public void add(double a) {
        Node newNode = new Node(a);

        if(first == null) {
            first = newNode;
        } else {
            Node current = first;

            while(current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }
    }

    private Node getNode(int pos) {
        if(pos < 0 || first == null) {
            throw new IndexOutOfBoundsException("can't find index " + pos);
        }
        Node current = first;

        for(int i = 0;i < pos;++i) {
            if(current == null) {
                throw new IndexOutOfBoundsException("can't find index " + pos);
            }
            current = current.next;
        }
        return current;
    }

    @Override
    public double get(int pos) {
        return getNode(pos).value;
    }

    @Override
    public void remove(int pos) {
        if(first == null) {
            throw new IndexOutOfBoundsException("can't find index " + pos);
        }

        if(pos == 0) {
            first = first.next;
        }

        Node beforeRemoved;
        try {
            beforeRemoved = getNode(pos - 1);
        } catch(IndexOutOfBoundsException e) {
            throw new IndexOutOfBoundsException("can't find index " + pos);
        }

        if(beforeRemoved.next == null) {
            throw new IndexOutOfBoundsException("can't find index " + pos);
        }

        beforeRemoved.next = beforeRemoved.next.next;
    }

    @Override
    public int size() {
        if(first == null) {
            return 0;
        } else {
            Node current = first;

            int size = 0;
            while(current.next != null) {
                current = current.next;
                ++size;
            }

            return size;
        }
    }

    private static class Node {
        private double value;
        private Node next;

        private Node(double value) {
            this.value = value;
        }
    }
}
