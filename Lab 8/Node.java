public class Node implements BinaryTree {
    private static final int CAPACITY = 100;
    protected Integer[] data;
    protected int root;
    protected int size;

    public Node() {
        this.data = new Integer[CAPACITY];
        root = 0;
        size = 0;
    }

    protected int left(int t) {
        return 2*t+1;
    }

    protected int right(int t) {
        return 2*t+2;
    }

    public void insert(Integer value) {
        data[size++] = value;
    }

    /*
     * Purpose: prints each value in this BinaryTree
     *          following an in-order traversal
     * Parameters: none
     * Returns: Nothing
     */
    public void inOrder(){
        inOrder(root);
        System.out.println();
    }

    /*
     * Purpose: prints each value in the BinaryTree at index t
     *          following an in-order traversal
     * Parameters: int t - index of t's root
     * Returns: Nothing
     */
    private void inOrder(int t){
        if (data[t]==null)
            return;
        else {
            inOrder(left(t));
            System.out.print(data[t] + " ");
            inOrder(right(t));
        }
    }

    /*
     * Purpose: prints each value in this BinaryTree
     *          following a pre-order traversal
     * Parameters: none
     * Returns: Nothing
     */
    public void preOrder(){
        preOrder(root);
        System.out.println();
    }

    /*
     * Purpose: prints each value in the BinaryTree at index t
     *          following a pre-order traversal
     * Parameters: int t - index of t's root
     * Returns: Nothing
     */
    private void preOrder(int t){
        if (data[t]==null)
            return;
        else {
            System.out.print(data[t] + " ");
            preOrder(left(t));
            preOrder(right(t));
        }
    }


    /*
     * Purpose: prints each value in this BinaryTree
     *          following a post-order traversal
     * Parameters: none
     * Returns: Nothing
     */
    public void postOrder(){
        postOrder(root);
        System.out.println();
    }

    /*
     * Purpose: prints each value in the BinaryTree at index t
     *          following a post-order traversal
     * Parameters: int t - index of t's root
     * Returns: Nothing
     */
    private void postOrder(int t){
        if (data[t]==null)
            return;
        else {
            postOrder(left(t));
            postOrder(right(t));
            System.out.print(data[t] + " ");
        }
    }
}