package Trees.Tree;

public class BinaryTree<T> {
    protected Node<T> root;
    protected int size;

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return size;
    }
}