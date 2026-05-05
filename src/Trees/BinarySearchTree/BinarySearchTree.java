package Trees.BinarySearchTree;
import Trees.BinaryTree.BinaryTree;
import Trees.BinaryTree.Node;

public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {

    public BinarySearchTree() {
        super();
    }

    public BinarySearchTree(T value) {
        root = new Node<>(value);
        size = 1;
    }

    public void insert(T value) {
        root = insert(root, value);
    }

    private Node<T> insert(Node<T> current, T value) {
        if (current == null) {
            size++;
            return new Node<>(value);
        }

        int compareResult = value.compareTo(current.getValue());

        if (compareResult < 0) {
            current.setLeft(insert(current.getLeft(), value));
        } else if (compareResult > 0) {
            current.setRight(insert(current.getRight(), value));
        }
        return current;
    }

    public boolean contains(T value) {
        return search(root, value);
    }

    public Node<T> containsNode(T value) {
        return returnNode(root, value);
    }

    private Node<T> returnNode(Node<T> current, T value) {
        if (current == null) return null;

        int compareResult = value.compareTo(current.getValue());

        if (compareResult == 0) return current;
        if (compareResult < 0) return returnNode(current.getLeft(), value);

        return returnNode(current.getRight(), value);
    }

    private boolean search(Node<T> current, T value) {
        if (current == null) return false;

        int compareResult = value.compareTo(current.getValue());

        if (compareResult == 0) return true;
        if (compareResult < 0) return search(current.getLeft(), value);

        return search(current.getRight(), value);
    }

    public T findMin() {
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }

        Node<T> current = root;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current.getValue();
    }

    public T findMax() {
        if (root == null) {
            throw new IllegalStateException("Tree is empty");
        }

        Node<T> current = root;
        while (current.getRight() != null) {
            current = current.getRight();
        }
        return current.getValue();
    }

    public void delete(T value) {
        root = delete(root, value);
    }

    private Node<T> delete(Node<T> current, T value) {
        if (current == null) return null;

        int compareResult = value.compareTo(current.getValue());

        if (compareResult < 0) {
            current.setLeft(delete(current.getLeft(), value));
        } else if (compareResult > 0) {
            current.setRight(delete(current.getRight(), value));
        } else {
            if (current.getLeft() == null && current.getRight() == null) {
                size--;
                return null;
            }

            if (current.getLeft() == null) {
                size--;
                return current.getRight();
            }

            if (current.getRight() == null) {
                size--;
                return current.getLeft();
            }

            Node<T> successor = findMinNode(current.getRight());
            current.setValue(successor.getValue());
            current.setRight(delete(current.getRight(), successor.getValue()));
        }
        return current;
    }

    protected Node<T> findMinNode(Node<T> node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
    }

    public void printTree() {
        printTree(root, 0);
    }

    private void printTree(Node<T> node, int level) {
        if (node == null) return;

        printTree(node.getRight(), level + 1);

        for (int i = 0; i < level; i++) {
            System.out.print("    ");
        }

        System.out.println(node.getValue());

        printTree(node.getLeft(), level + 1);
    }

    public T successor(T value) {
        Node<T> node = containsNode(value);
        if (node == null) return null;

        if (node.getRight() != null) {
            return findMinNode(node.getRight()).getValue();
        }

        Node<T> successor = null;
        Node<T> current = root;

        while (current != null) {
            int compareValue = value.compareTo(current.getValue());

            if (compareValue < 0) {
                successor = current;
                current = current.getLeft();
            } else if (compareValue > 0) {
                current = current.getRight();
            } else {
                break;
            }
        }

        return (successor != null) ? successor.getValue() : null;
    }

    public T predecessor(T value) {
        Node<T> node = containsNode(value);
        if (node == null) return null;

        if (node.getLeft() != null) {
            Node<T> current = node.getLeft();
            while (current.getRight() != null) {
                current = current.getRight();
            }
            return current.getValue();
        }

        Node<T> predecessor = null;
        Node<T> current = root;

        while (current != null) {
            int cmp = value.compareTo(current.getValue());

            if (cmp > 0) {
                predecessor = current;
                current = current.getRight();
            } else if (cmp < 0) {
                current = current.getLeft();
            } else {
                break;
            }
        }

        return (predecessor != null) ? predecessor.getValue() : null;
    }
}