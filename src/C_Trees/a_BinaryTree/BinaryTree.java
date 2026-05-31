package C_Trees.a_BinaryTree;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {
    protected Node<T> root;
    protected int size;
    protected int height;

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

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node<T> current) {
        if (current == null) {
            return;
        }
        inOrder(current.getLeft());
        System.out.print(current.getValue() + " ");
        inOrder(current.getRight());
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node<T> current) {
        if (current == null) {
            return;
        }
        System.out.print(current.getValue() + " ");
        preOrder(current.getLeft());
        preOrder(current.getRight());
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node<T> current) {
        if (current == null) {
            return;
        }
        postOrder(current.getLeft());
        postOrder(current.getRight());
        System.out.print(current.getValue() + " ");
    }

    public int height() {
        return height(root);
    }

    private int height(Node<T> node) {
        if (node == null) return -1;

        int left = height(node.getLeft());
        int right = height(node.getRight());

        return 1 + Math.max(left, right);
    }

    public boolean isBalanced() {
        return checkBalance(root) != -2;
    }

    private int checkBalance(Node<T> node) {
        if (node == null) return -1;
        int left = checkBalance(node.getLeft());

        if (left == -2) return -2;
        int right = checkBalance(node.getRight());

        if (right == -2) return -2;
        if (Math.abs(left - right) > 1) return -2;
        
        return 1 + Math.max(left, right);
    }
}