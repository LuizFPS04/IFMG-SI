public class BinaryTree {
    Node root;

    BinaryTree() {
        root = null;
    }

    private Node insertNewNode(Node newNode, Node actualNode) {
        if (actualNode == null) return newNode;

        if (actualNode.value > newNode.value) {
            actualNode.left = insertNewNode(newNode, actualNode.left);
        } else {
            actualNode.right = insertNewNode(newNode, actualNode.right);
        }

        return actualNode;
    }

    public void insert(Node newNode) {
        root = insertNewNode(newNode, null);
    }

    private void preOrder(Node element) {
        if (element != null) {
            System.out.println(element.value);
            preOrder(element.left);
            preOrder(element.right);
        }
    }

    public void showPreOrder() {
        preOrder(root);
    }

    private Node foundElement(Node actualNode, int valueInformed) {
        if (actualNode == null) return null;

        if (actualNode.right != null) {
            if (actualNode.right.value == valueInformed) {
                return actualNode;
            }
        }
        if (actualNode.left != null) {
            if (actualNode.left.value == valueInformed) {
                return actualNode;
            }
        }

        if (actualNode.value > valueInformed) {
            return foundElement(actualNode.right, valueInformed);
        }
        if (valueInformed > actualNode.value) {
            return foundElement(actualNode.left, valueInformed)
        }
    }

    public boolean remove(int valueInformed) {
        if (root == null) {
            return false;
        } else {
            Node father;
            Node auxNode;

            if (root.value != valueInformed) {
                father = foundElement(root, valueInformed);

                if (father.value > valueInformed) {
                    auxNode = father.left;
                } else {
                    auxNode = father.right;
                }

                if (auxNode.right == null) {
                    if (father.value > valueInformed) {
                        father.right = auxNode.left;
                    } else {
                        father.left = auxNode.right;
                    }
                }
                    
                if (auxNode.left == null) {
                    if (father.value > valueInformed) {
                        father.right = auxNode.left;
                    } else {
                        father.left = auxNode.right;
                    }
                }
            } else {
                if (root.left == null && root.right == null) {
                    root = null;
                    return true;
                } else {
                    father = foundElement(root, valueInformed);
                    
                    if (father.value > valueInformed) {
                        auxNode = father.left;
                    } else {
                        auxNode = father.right;
                    }
    
                    if (auxNode.right == null) {
                        if (father.value > valueInformed) {
                            father.right = auxNode.left;
                        } else {
                            father.left = auxNode.right;
                        }
                    }
                }
            }
        }
    }
}