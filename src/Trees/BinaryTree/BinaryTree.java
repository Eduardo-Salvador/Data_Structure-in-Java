package Trees.BinaryTree;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {
    protected Node<T> root;
    protected int size;

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return size;
    }

    public void insert(T value) {
        Node<T> newNode = new Node<>(value);

        if (root == null) {
            root = newNode;
            size++;
            return;
        }

        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node<T> current = queue.poll();

            if (current.getLeft() == null) {
                current.setLeft(newNode);
                size++;
                return;
            } else {
                queue.add(current.getLeft());
            }

            if (current.getRight() == null) {
                current.setRight(newNode);
                size++;
                return;
            } else {
                queue.add(current.getRight());
            }
        }
    }
}