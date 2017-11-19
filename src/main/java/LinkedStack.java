import java.util.EmptyStackException;

public class LinkedStack<Type> implements Stack<Type> {
    private Node<Type> top;

    @Override
    public void push(Type a) {
        Node<Type> newNode = new Node<>(a);

        newNode.under = top;
        top = newNode;
    }

    @Override
    public Type pop() {
        if(top == null) {
            throw new EmptyStackException();
        }

        Type value = top.value;

        top = top.under;

        return value;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    private static class Node<Type> {
        private Type value;
        private Node<Type> under;

        private Node(Type value) {
            this.value = value;
        }
    }

    @Override
    public String toString() {
        if(top == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        Node current = top;
        do {
            result.append(current.value).append("\n");
        /*    current = current.under;
        } while(current != null);*/
        } while((current = current.under) != null);

        return result.toString();
    }
}













