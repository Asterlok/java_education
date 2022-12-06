import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    public Node root;

    public BinaryTree(int data) {
        root = new Node(data);
    }

    public void addValue(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
        } else {
            Node currentNode = root;
            while (true) {
                if (data < currentNode.value && currentNode.left == null) {
                    currentNode.left = newNode;
                    currentNode.left.level = currentNode.level + 1;
                    break;
                }
                if (data > currentNode.value && currentNode.right == null) {
                    currentNode.right = newNode;
                    currentNode.right.level = currentNode.level + 1;
                    break;
                }
                if (data == currentNode.value)
                    return;
                if (currentNode.left != null && data == currentNode.left.value)
                    return;
                if (currentNode.right != null && data == currentNode.right.value)
                    return;

                while ((data < currentNode.value && currentNode.left != null)) {
                    currentNode = currentNode.left;
                }
                while ((data > currentNode.value && currentNode.right != null)) {
                    currentNode = currentNode.right;
                }
            }
        }
    }

    private Node preDisNodeRemove(Node root, int data) {
        Node preDisNode = root;
        while (true) {
            if (data < preDisNode.value && preDisNode.left != null) {
                if (preDisNode.left.value == data) {
                    break;
                } else {
                    preDisNode = preDisNode.left;
                }
            }
            if (data > preDisNode.value && preDisNode.right != null) {
                if (preDisNode.right.value == data) {
                    break;
                } else {
                    preDisNode = preDisNode.right;
                }
            }
        }
        return preDisNode;
    }

    public void delete_value(int value) {
        if (root == null) {
            System.out.println("Tree is empty!");
        } else {
            if (root.left == null && root.right == null && root.value == value) {
                root = null;
                return;
            }

            Node preDisNode = preDisNodeRemove(root, value);
            if (preDisNode.left != null) {
                if (preDisNode.left.value == value) { // Левый потомок искомый
                    if (preDisNode.left.left == null && preDisNode.left.right == null) { // Искомый потомок - лист
                        preDisNode.left = null;
                    } else if (preDisNode.left.left == null && preDisNode.left.right != null) { // Искомый потомок имеет правого потомка
                        preDisNode.left = preDisNode.left.right;
                    } else if (preDisNode.left.left != null && preDisNode.left.right == null) { // Искомый потомок имеет левого потомка
                        preDisNode.left = preDisNode.left.left;
                    } else if (preDisNode.left.left != null && preDisNode.left.right != null) { // У искомого элемента два потомка
                        Node minLeaf = preDisNode.left.right;
                        while (true) {
                            if (minLeaf.left != null) {
                                minLeaf = minLeaf.left;
                            } else {
                                break;
                            }
                        }
                        Node preDisLeafNode = preDisNodeRemove(preDisNode.left, minLeaf.value);
                        if (preDisLeafNode.left.value == minLeaf.value) {
                            preDisLeafNode.left = null;
                        }
                        if (preDisLeafNode.right.value == minLeaf.value) {
                            preDisLeafNode.right = null;
                        }
                        preDisNode.left.value = minLeaf.value;
                    }
                }
            }
            if (preDisNode.right != null) {
                if (preDisNode.right.value == value) { // Правый потомок искомый
                    if (preDisNode.right.left == null && preDisNode.right.right == null) { // Искомый потомок - лист
                        preDisNode.right = null;
                    } else if (preDisNode.right.left == null && preDisNode.right.right != null) { // Искомый потомок имеет правого потомка
                        preDisNode.right = preDisNode.right.right;
                    } else if (preDisNode.right.left != null && preDisNode.right.right == null) { // Искомый потомок имеет левого потомка
                        preDisNode.right = preDisNode.right.left;
                    } else if (preDisNode.right.left != null && preDisNode.right.right != null) { // У искомого элемента два потомка
                        Node minLeaf = preDisNode.right.right;
                        while (true) {
                            if (minLeaf.left != null) {
                                minLeaf = minLeaf.left;
                            } else {
                                break;
                            }
                        }
                        delete_value(minLeaf.value);
                        preDisNode.right.value = minLeaf.value;
                    }
                }
            }
        }
    }

    public void breadth_first_search(int x, int y) {
        if (root == null) {
            return;
        }

        Queue<Node> queue_nodes = new LinkedList<>();
        queue_nodes.add(root);
        int count = 0;
        while (!queue_nodes.isEmpty()) {
            Node node = queue_nodes.remove();
            if (node.value >= x && node.value <= y) {
                count += 1;
                System.out.print(node.value);
                System.out.println("\t# " + count);
            }

            if (node.left != null) {
                queue_nodes.add(node.left);
            }

            if (node.right != null) {
                queue_nodes.add(node.right);
            }
        }
    }

    private static void showStvols(Stvol p) {
        if (p == null) {
            return;
        }
        showStvols(p.prev);
        System.out.print(p.str);
    }

    public static void printTree(Node root, Stvol prev, boolean isLeft) {
        if (root == null) {
            return;
        }

        String prev_str = "    ";
        Stvol stvol = new Stvol(prev, prev_str);

        printTree(root.right, stvol, true);

        if (prev == null) {
            stvol.str = "———";
        } else if (isLeft) {
            stvol.str = ".———";
            prev_str = "   |";
        } else {
            stvol.str = "`———";
            prev.str = prev_str;
        }

        showStvols(stvol);
        System.out.println(" " + root.value);

        if (prev != null) {
            prev.str = prev_str;
        }
        stvol.str = "   |";

        printTree(root.left, stvol, false);
    }
}