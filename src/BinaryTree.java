public class BinaryTree {
    Node root;
    int amountNode = 0;

    BinaryTree() {
        root = null;
    }

    private Node insertNewNode(Node newNode, Node actualNode) {
        if (actualNode == null) {
            return newNode;
        }

        if (actualNode.value > newNode.value) {
            actualNode.left = insertNewNode(newNode, actualNode.left);
        } else {
            actualNode.right = insertNewNode(newNode, actualNode.right);
        }

        return actualNode;
    }

    public void insert(Node newNode) {
        this.amountNode += 1;
        root = insertNewNode(newNode, root);
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

    private void posOrder(Node element) {
        if (element != null) {
            posOrder(element.left);
            posOrder(element.right);
            System.out.println(element.value);
        }
    }

    public void showPosOrder() {
        posOrder(root);
    }

    private void onOrder(Node element) {
        if (element != null) {
            onOrder(element.left);
            System.out.println(element.value);
            onOrder(element.right);
        }
    }

    public void showOnOrder() {
        onOrder(root);
    }  

    public void preOrderStack() {
        if (root != null) {
            Stack stackOrder = new Stack();

            stackOrder.stackUp(root);

            while (!stackOrder.empty()) {
                Node currentNode = stackOrder.unstack();

                System.out.println(currentNode.value);

                if (currentNode.right != null) {
                    stackOrder.stackUp(currentNode.right);
                }

                if (currentNode.left != null) {
                    stackOrder.stackUp(currentNode.left);
                }
            }
        }
    }

    public void posOrderStack() {
        if (root != null) {
            Stack stackOrder = new Stack();
            Stack stackOrderOut = new Stack();

            stackOrder.stackUp(root);

            while (!stackOrder.empty()) {
                Node currentNode = stackOrder.unstack();
                stackOrderOut.stackUp(currentNode);

                if (currentNode.left != null) {
                    stackOrder.stackUp(currentNode.left);
                }

                if (currentNode.right != null) {
                    stackOrder.stackUp(currentNode.right);
                }
            }

            while (!stackOrderOut.empty()) {
                System.out.println(stackOrderOut.unstack().value);
            }
            
        }
    }
    
    public void onOrderStack() {
        if (root != null) {
            Stack stackOrder = new Stack();
            Node currentNode = root;

            while (currentNode != null || !stackOrder.empty()) {
                while (currentNode != null) {
                    stackOrder.stackUp(currentNode);
                    currentNode = currentNode.left;
                }

                currentNode = stackOrder.unstack();
                System.out.println(currentNode.value);

                currentNode = currentNode.right;
            }
        }
    }

    private Node foundElement(Node actualNode, int valueInformed) {
        if (actualNode == null) return null;

        if (valueInformed > actualNode.value) {
            if (actualNode.right != null) {
                if (actualNode.right.value == valueInformed) {
                    return actualNode;
                }
            }
        } else {
            if (actualNode.left != null) {
                if (actualNode.left.value == valueInformed) {
                    return actualNode;
                }
            }
        }

        if (actualNode.value > valueInformed) {
            return foundElement(actualNode.right, valueInformed);
        }
        if (valueInformed > actualNode.value) {
            return foundElement(actualNode.left, valueInformed);
        }

        return null;
    }

    private Node nodeFarLeft(Node father, Node son) {
        if (son.left == null) {
            return father;
        }

        return nodeFarLeft(son, son.left);
    }

    private Node nodeFarRight(Node father, Node son) {
        if (son.right == null) {
            return father;
        }

        return nodeFarRight(father, son.right);
    }
    
    public boolean remove(int valueInformed) {
        if (root != null) {
            Node father;
            Node auxNode;

            if (root.value == valueInformed) {
                if (root.left == null && root.left == null) {
                    root = null;
                } else if (root.left == null) {
                    root = root.right;
                } else if (root.right == null) {
                    root = root.left;
                } else {
                    Node nodeRL = nodeFarLeft(root, root.right);
                    Node substituteNode = nodeRL.left;
                
                    if (substituteNode != null) {
                        nodeRL.left = substituteNode.right;
                        substituteNode.right = root.right;
                        substituteNode.left = root.left;
                    } else {
                        substituteNode = root.right;
                        substituteNode.left = root.left;
                    }

                
                    root = substituteNode;
                }
                this.amountNode -= 1;                
                return true;
            } else {
                father = foundElement(root, valueInformed);
                auxNode = root;

                if (valueInformed > father.value) {
                    auxNode = father.right;
                }
                else {
                    auxNode = father.left;
                }

                if (auxNode.right == null && auxNode.left == null) {
                    if (valueInformed > father.value) {
                        father.right = null;
                    }
                    else {
                        father.left = null;
                    }
                    this.amountNode -= 1;
                    return true;
                } else {
                    if (auxNode.right == null) {
                        if (valueInformed > father.value) {
                            father.right = auxNode.left;
                        } else {
                            father.left = auxNode.left;
                        }
                    } else if (auxNode.left == null) {
                        if (valueInformed > father.value) {
                            father.right = auxNode.right;
                        } else {
                            father.left = auxNode.right;
                        }
                        this.amountNode -= 1;
                        return true;
                    }
                }

                if (auxNode.left != null && auxNode.right != null) {
                    Node fatherRL = nodeFarLeft(auxNode, auxNode.right);
                    Node substituteNode = fatherRL.right;
    
                    substituteNode.right = auxNode.right;
                    substituteNode.left = auxNode.left;
    
                    auxNode.left = null;
                    auxNode.right = null;
    
                    if (valueInformed > father.value) {
                        father.right = substituteNode;
                    } else if (valueInformed < father.value) {
                        father.left = substituteNode;
                    } else {
                        father = substituteNode;
                    }
                    this.amountNode -= 1;
                    return true;
                }
            }
        }
        return false;
    }

    public int amountNode() {
        return this.amountNode;
    }

    public int amountNodeNoSheet() {
        return nodeNoSheet(root);
    }
    
    private int nodeNoSheet(Node actualNode) {
        if (actualNode == null) {
            return 0;
        }

        if (actualNode.left == null && actualNode.right == null) {
            return 0;
        }

        return 1 + nodeNoSheet(actualNode.left) + nodeNoSheet(actualNode.right);
    }

    public int amountNodeSheet() {
        return nodeSheet(root);
    }
    
    private int nodeSheet(Node actualNode) {
        if (actualNode == null) {
            return 0;
        }

        if (actualNode.left == null && actualNode.right == null) {
            return 1;
        }

        return nodeSheet(actualNode.left) + nodeSheet(actualNode.right);
    }
    
    public int heightTree() {
        return calculeHeightTree(root);
    }

    private int calculeHeightTree(Node actualNode) {
        if (actualNode == null) {
            return -1;
        }

        int heightTreeLeft = calculeHeightTree(actualNode.left);
        int heightTreeRight = calculeHeightTree(actualNode.right);

        return Math.max(heightTreeLeft, heightTreeRight) + 1;
    }

    public void removePair() {
        removePairNodes(root);
    }

    private void removePairNodes(Node actualNode) {
        if (actualNode != null) {

            if (actualNode.value % 2 == 0) {
                remove(actualNode.value);
            }

            if (actualNode.left != null && actualNode.right != null) {
                removePairNodes(actualNode.left);
                removePairNodes(actualNode.right);
            }
        }
    }

    public void subtreeSwap() {
        if (root != null) {
            Node rootLeft = root.left;
            Node rootRight = root.right;

            root.left = rootRight;
            root.right = rootLeft;
        }    
    }
}