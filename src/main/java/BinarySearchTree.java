public class BinarySearchTree {

    private Node root;

    private void add (int a){

        Node newNode = new Node(a);


        if (root == null) {
            root = newNode;
        }else  {
            if (newNode.value > root.value) {
                root.rightChild = newNode;
            }else if (newNode.value <root.value){
                root.leftChild = newNode;
            }
        }
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
