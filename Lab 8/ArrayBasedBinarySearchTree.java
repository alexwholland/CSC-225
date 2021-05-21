public class ArrayBasedBinarySearchTree extends Node{
    public ArrayBasedBinarySearchTree(){
        super();
    }

    public void insert(Integer value) {
        if (data[0] == null) {
            data[0] = value;
        }
        else {
            insertIterative(value);
        }
    }

    private void insertIterative(Integer value) {
        int current = 0;

        while (data[current] != null) {
            if (value <= data[current]) {
                current = left(current);
            }
            else if (value > data[current]) {
                current = right(current);
            }
        }
        data[current] = value;
    }

    private void insertRecur(Integer value, int current) {
        if (value <= data[current]) {
            int left = left(current);
            if (data[left] != null) {
                insertRecur(value, left);
            }
            else {
                data[left] = value;
            }
        }
        else if (value > data[current]) {
            int right = right(current);
            if (data[right] != null) {
                insertRecur(value, right);
            }
            else {
                data[right] = value;
            }
        }
    }


    public static void main(String[] args) {
        ArrayBasedBinarySearchTree emptyTree = new ArrayBasedBinarySearchTree();

        ArrayBasedBinarySearchTree myTree = new ArrayBasedBinarySearchTree();
        myTree.insert(4);
        myTree.insert(5);
        myTree.insert(8);
        myTree.insert(9);
        myTree.insert(2);
        myTree.insert(1);
        myTree.insert(10);
        myTree.insert(3);
        myTree.insert(6);
        myTree.insert(7);

        System.out.println("inOrder");
        myTree.inOrder();
        System.out.println("preOrder");
        myTree.preOrder();
        System.out.println("postOrder");
        myTree.postOrder();
    }

}