package B_Trees.e_RedBlackTree;
import B_Trees.a_BinaryTree.Color;
import B_Trees.a_BinaryTree.Node;
import B_Trees.b_BinarySearchTree.BinarySearchTree;

public class RedBlackTree<T extends Comparable<T>> extends BinarySearchTree<T> {
    private Node<T> nullNode = new Node<>(null);

    public RedBlackTree() {
        super();
        height = 0;
        nullNode.setColor(Color.BLACK);
    }

    @Override
    public void insert(T value) {
        root = insert(root, value);
        root.setColor(Color.BLACK);
    }

    private Node<T> insert(Node<T> node, T value) {
        if (node == null) {
            Node<T> newNode = new Node<>(value);
            newNode.setColor(Color.RED);
            size++;
            return newNode;
        }

        if (value.compareTo(node.getValue()) < 0) {
            node.setLeft(insert(node.getLeft(), value));
        } else if (value.compareTo(node.getValue()) > 0) {
            node.setRight(insert(node.getRight(), value));
        }
        node = fixInsert(node);
        return node;
    }

    private Node<T> fixInsert(Node<T> node) {
        if (isRed(node.getLeft()) && isRed(node.getLeft().getRight())) {
            node.setLeft(rotateLeft(node.getLeft()));
        }

        if (isRed(node.getLeft()) && isRed(node.getLeft().getLeft())) {
            node = rotateRight(node);
            node.setColor(Color.BLACK);
            node.getRight().setColor(Color.RED);
        }

        if (isRed(node.getLeft()) && isRed(node.getRight())) {
            node.setColor(Color.RED);
            node.getLeft().setColor(Color.BLACK);
            node.getRight().setColor(Color.BLACK);
        }

        return node;
    }

    private boolean isRed(Node<T> node) {
        if (node == null) return false;
        return node.getColor() == Color.RED;
    }

    private Node<T> rotateRight(Node<T> node) {
        Node<T> temp = node.getLeft();
        node.setLeft(temp.getRight());
        temp.setRight(node);
        return temp;
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> temp = node.getRight();
        node.setRight(temp.getLeft());
        temp.setLeft(node);
        return temp;
    }

    @Override
    public void delete(T value) {
        root = delete(root, value);
        if (root != null) root.setColor(Color.BLACK);
    }

    private Node<T> delete(Node<T> node, T value) {
        if (node == null) return null;

        if (value.compareTo(node.getValue()) < 0) {
            node.setLeft(delete(node.getLeft(), value));
        } else if (value.compareTo(node.getValue()) > 0) {
            node.setRight(delete(node.getRight(), value));
        } else {
            if (node.getLeft() == null && node.getRight() == null) {
                return null;
            }
            if (node.getLeft() == null) return node.getRight();
            if (node.getRight() == null) return node.getLeft();

            Node<T> successor = getMin(node.getRight());
            node.setValue(successor.getValue());
            node.setRight(delete(node.getRight(), successor.getValue()));
        }

        node = fixDelete(node);
        return node;
    }

    private Node<T> getMin(Node<T> node) {
        while (node.getLeft() != null) node = node.getLeft();
        return node;
    }

    private Node<T> fixDelete(Node<T> node) {
        if (isRed(node.getRight()) && !isRed(node.getLeft())) {
            node = rotateLeft(node);
            node.setColor(node.getRight().getColor());
            node.getLeft().setColor(Color.BLACK);
            node.getRight().setColor(Color.BLACK);
            return node;
        }

        if (!isRed(node.getRight()) && isRed(node.getRight().getLeft())) {
            node.setRight(rotateRight(node.getRight()));
            node.getRight().setColor(Color.BLACK);
            node.getRight().getRight().setColor(Color.RED);
            return fixDelete(node);
        }

        if (isRed(node.getLeft()) && !isRed(node.getRight())) {
            node = rotateRight(node);
            node.setColor(node.getLeft().getColor());
            node.getRight().setColor(Color.BLACK);
            node.getLeft().setColor(Color.BLACK);
            return node;
        }


        if (!isRed(node.getLeft()) && !isRed(node.getRight())) {
            if (isRed(node)) {
                node.setColor(Color.BLACK);
            } else {
                node.setColor(Color.RED);
            }
        }

        return node;
    }
}