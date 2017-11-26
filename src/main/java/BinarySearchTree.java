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

    private static class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }
    }
}
