public class LinkedList<Type> implements List<Type> {
    private Node<Type> first;

    @Override
    public void add(Type a) {
        Node<Type> newNode = new Node<>(a);

        if(first == null) {
            first = newNode;
        } else {
            Node<Type> current = first;

            while(current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }
    }

    private Node<Type> getNode(int pos) {
        if(pos < 0 || first == null) {
            throw new IndexOutOfBoundsException("can't find index " + pos);
        }
        Node<Type> current = first;

        for(int i = 0;i < pos;++i) {
            if(current == null) {
                throw new IndexOutOfBoundsException("can't find index " + pos);
            }
            current = current.next;
        }
        return current;
    }

    @Override
    public Type get(int pos) {
        return getNode(pos).value;
    }

    @Override
    public void remove(int pos) {
        if(first == null) {
            throw new IndexOutOfBoundsException("can't find index " + pos);
        }

        if(pos == 0) {
            first = first.next;
            return;
        }

        Node<Type> beforeRemoved;
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
            Node<Type> current = first;

            int size = 0;
            while(current.next != null) {
                current = current.next;
                ++size;
            }

            return size;
        }
    }

    private static class Node<Type> {
        private Type value;
        private Node<Type> next;

        private Node(Type value) {
            this.value = value;
        }
    }
}
