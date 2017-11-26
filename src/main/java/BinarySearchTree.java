public class BinarySearchTree {
    private Node root;

    public void add(int a) {
        Node newNode = new Node(a);

        if(root == null) {
            root = newNode;
        } else {
            add(root, newNode);
        }
    }

    private void add(Node parent, Node newNode) {
        if(newNode.value > parent.value) {
            if(parent.rightChild == null) {
                parent.rightChild = newNode;
            } else {
                add(parent.rightChild, newNode);
            }
        } else if(newNode.value < parent.value) {
            if(parent.leftChild == null) {
                parent.leftChild = newNode;
            } else {
                add(parent.leftChild, newNode);
            }
        }
    }

    public boolean contain(int i) {
        return contain(root, i);
    }

    private boolean contain(Node parent, int i) {
        if(parent == null) {
            return false;
        }

        if(i > parent.value) {
            return contain(parent.rightChild, i);
        } else if(i < parent.value) {
            return contain(parent.leftChild, i);
        } else {
            return true;
        }
    }

    public int depth() {
        return depth(root);
    }

    private int depth(Node node) {
        if(node == null) {
            return 0;
        }

        if(node.leftChild == null && node.rightChild == null) {
            return 1;
        }

        int leftDepth = depth(node.leftChild);
        int rightDepth = depth(node.rightChild);

        return 1 + Math.max(leftDepth, rightDepth);
    }

    public int minDepth() {
        return minDepth(root);
    }

    private int minDepth(Node node) {
        if(node == null) {
            return 0;
        }

        if(node.leftChild == null && node.rightChild == null) {
            return 1;
        }

        int leftDepth = depth(node.leftChild);
        int rightDepth = depth(node.rightChild);

        return 1 + Math.min(leftDepth, rightDepth);
    }

    public void normalise() {
        if(root == null) {
            return;
        }

        int leftDepth = depth(root.leftChild);
        int rightDepth = depth(root.rightChild);

        if(leftDepth - 1 > rightDepth) {
            Node oldRoot = root;
            root = root.leftChild;
            oldRoot.leftChild = null;
            addAll(oldRoot);
            normalise();
        } else if(rightDepth - 1 > leftDepth){
            Node oldRoot = root;
            root = root.rightChild;
            oldRoot.rightChild = null;
            addAll(oldRoot);
            normalise();
        }
    }

    private void addAll(Node node) {
        if(node == null) {
            return;
        }

        add(node.value);

        addAll(node.leftChild);
        addAll(node.rightChild);
    }

    private static class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }
    }
}
