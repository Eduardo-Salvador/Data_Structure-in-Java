package Trees.BinarySearchTree;
import Trees.BinaryTree.Node;

public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T> {

    public AVLTree() {
        super();
        height = 0;
    }

    private int balanceFactor(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return getNodeHeight(node.getLeft()) - getNodeHeight(node.getRight());
    }

    private void updateHeight(Node<T> node) {
        if (node != null) {
            int leftHeight = getNodeHeight(node.getLeft());
            int rightHeight = getNodeHeight(node.getRight());
            node.setHeight(1 + Math.max(leftHeight, rightHeight));
        }
    }

    public int getNodeHeight(Node<T> node) {
        if (node == null) return 0;
        return node.getHeight();
    }

    public int getBalanceValue(T value) {
        Node<T> node = containsNode(value);
        if (node != null) {
            return balanceFactor(node);
        } else {
            System.out.println("Node with value " + value + " not found.");
            return -1;
        }
    }

    private Node<T> rightRotation(Node<T> p) {
        Node<T> u = p.getLeft();
        Node<T> T2 = u.getRight();
        u.setRight(p);
        p.setLeft(T2);
        updateHeight(p);
        updateHeight(u);
        return u;
    }

    private Node<T> leftRotation(Node<T> p) {
        Node<T> u = p.getRight();
        Node<T> T2 = u.getLeft();
        u.setLeft(p);
        p.setRight(T2);
        updateHeight(p);
        updateHeight(u);
        return u;
    }

    private Node<T> balance(Node<T> node) {
        int bf = balanceFactor(node);
        if (bf > 1) {
            if (balanceFactor(node.getLeft()) < 0) {
                node.setLeft(leftRotation(node.getLeft()));
            }
            return rightRotation(node);
        }
        if (bf < -1) {
            if (balanceFactor(node.getRight()) > 0) {
                node.setRight(rightRotation(node.getRight()));
            }
            return leftRotation(node);
        }
        return node;
    }

    @Override
    public void insert(T value) {
        root = insert(root, value);
    }

    private Node<T> insert(Node<T> node, T value) {
        if (node == null) {
            size++;
            return new Node<>(value);
        }

        int compareValue = value.compareTo(node.getValue());

        if (compareValue < 0) {
            node.setLeft(insert(node.getLeft(), value));
        } else if (compareValue > 0) {
            node.setRight(insert(node.getRight(), value));
        } else {
            return node;
        }

        updateHeight(node);
        return balance(node);
    }

    @Override
    public void delete(T value) {
        root = delete(root, value);
    }

    private Node<T> delete(Node<T> node, T value) {
        if (node == null) return null;

        int compareValue = value.compareTo(node.getValue());

        if (compareValue < 0) {
            node.setLeft(delete(node.getLeft(), value));
        } else if (compareValue > 0) {
            node.setRight(delete(node.getRight(), value));
        } else {
            if (node.getLeft() == null || node.getRight() == null) {
                size--;
                return (node.getLeft() != null) ? node.getLeft() : node.getRight();
            }
            Node<T> successor = findMinNode(node.getRight());
            node.setValue(successor.getValue());
            node.setRight(delete(node.getRight(), successor.getValue()));
        }
        updateHeight(node);
        return balance(node);
    }

    public void printDetailed() {
        printDetailed(root, 0);
    }

    private void printDetailed(Node<T> node, int level) {
        if (node == null) return;

        printDetailed(node.getRight(), level + 1);

        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }

        int bf = balanceFactor(node);

        System.out.println(
                node.getValue() +
                        " (h=" + node.getHeight() +
                        ", bf=" + bf + ")"
        );

        printDetailed(node.getLeft(), level + 1);
    }
}