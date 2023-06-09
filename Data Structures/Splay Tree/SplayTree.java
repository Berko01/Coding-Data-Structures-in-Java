public class SplayTree {
    Node root;

    public SplayTree() {
        root = null;
    }

    public void insert(int data) {
        Node parent = null;
        Node node2 = this.root;

        while (node2 != null) {
            parent = node2;
            if (data > node2.data && node2 != null) {

                node2 = node2.right;
            } else if (node2 != null) {

                node2 = node2.left;
            }
        }
        node2 = new Node(data);
        node2.data = data;
        node2.parent = parent;
        if (parent == null) {
            root = node2;
        } else if (data > parent.data) {
            parent.right = node2;
        } else {
            parent.left = node2;
        }

        Splay(node2);

    }

    public Node SplaySearch(Node node, int data) {
        if (node == null) {
            return null;
        }

        if (node.data == data) {
            Splay(node);
            return node;
        } else if (node.data < data) {
            return SplaySearch(node.right, data);
        } else {
            return SplaySearch(node.left, data);
        }

    }

    public Node SplaySearch(int data) {
        return SplaySearch(root, data);

    }

    public boolean isEmpty() {
        return root == null;
    }

    public Node Search(int data) {
        return SplaySearch(root, data);
    }

    public Node Search(int data, Node node) {
        if (node == null) {
            return null;
        }

        while (node != null && node.data != data) {
            if (data < node.data) {
                node = node.left;
            } else if (data > node.data) {
                node = node.right;

            }
        }
        return node;

    }

    public void MakeLeftChildParent(Node child, Node parent) {
        if ((child == null) || (parent == null)) {
            System.out.println("Cocuk yok");
            return;
        }

        Node grand = parent.parent;
        if (grand != null) {
            if (parent == grand.left) {
                grand.left = child;
            } else {
                grand.right = child;
            }
        }
        if (child.right != null) {
            child.right.parent = parent;
        }

        child.parent = grand;
        parent.parent = child;
        parent.left = child.right;
        child.right = parent;

    }

    public void MakeRightChildParent(Node child, Node parent) {
        if ((child == null) || (parent == null)) {
            System.out.println("Hatalı!!");
            return;
        }

        Node grand = parent.parent;

        if (grand != null) {
            if (parent == grand.left)
                grand.left = child;
            else
                grand.right = child;
        }
        if (child.left != null)
            child.left.parent = parent;

        child.parent = grand;
        parent.parent = child;
        parent.right = child.left;
        child.left = parent;
    }

    public void Splay(Node node) {

        while (node.parent != null) {
            Node parent = node.parent;
            Node grand = parent.parent;

            if (grand == null) {
                if (node == parent.left) {// left case
                    MakeLeftChildParent(node, parent);
                } else {// right case
                    MakeRightChildParent(node, parent);
                }
            } else {
                if (node == parent.left) {
                    if (parent == grand.left)// left-left case
                    {
                        MakeLeftChildParent(parent, grand);
                        MakeLeftChildParent(node, parent);
                    } else {// left right chase
                        MakeLeftChildParent(node, node.parent);
                        MakeRightChildParent(node, node.parent);
                    }
                } else {
                    if (parent == grand.left) {// right-left
                        MakeRightChildParent(node, node.parent);
                        MakeLeftChildParent(node, node.parent);
                    } else {// right right
                        MakeRightChildParent(parent, grand);
                        MakeRightChildParent(node, parent);
                    }
                }
            }

        }
        root = node;

    }

    public int IsHaveChild(Node node) {
        if (node.left != null && node.right != null) {
            return 2;// 2 cocuk var
        } else if (node.left != null && node.right == null || node.left == null && node.right != null) {
            if (node.left != null && node.right == null)
                return 11; // 1 çocuk solda
            else if (node.left == null && node.right != null)
                return 12;// 1 çocuk sağda
        } else {
            return 0;// cocuk yok
        }
        return 0;
    }

    public Node deleteEngine(Node node, int data) {
        if (node.left != null && node.left.data == data) {

            if (IsHaveChild(node.left) == 0)
                return node.left = null;
            else if (IsHaveChild(node.left) == 11) {
                node.left.left.parent = node;
                return node.left = node.left.left;
            } else if (IsHaveChild(node.left) == 12) {
                node.left.right.parent = node;
                return node.left = node.left.right;
            } else if (IsHaveChild(node.left) == 2) {
                Node node2;
                node2 = Min(node.left.right);
                if (IsHaveChild(node2) == 12) {
                    node2.parent.left = node2.right;
                    node2.right.parent = node2.parent;
                }
                Delete(node2.data);
                node.left.data = node2.data;
                return node;
            }
        } else if (node.right != null && node.right.data == data) {
            if (IsHaveChild(node.right) == 0)
                return node.right = null;
            else if (IsHaveChild(node.right) == 11) {
                node.right.left.parent = node;
                return node.right = node.right.left;
            } else if (IsHaveChild(node.right) == 12) {
                node.right.right.parent = node;
                return node.right = node.right.right;
            } else if (IsHaveChild(node.right) == 2) {
                Node node2;
                node2 = Max(node.right.left);
                if (IsHaveChild(node2) == 11) {
                    node2.parent.right = node2.left;
                    node2.left.parent = node2.parent;
                }
                Delete(node2.data);
                node.right.data = node2.data;
                return node;
            }

        }
        return node;
    }

    public Node Delete(Node node, int data) {

        if (this.root.data == data) {
            Node node2;
            if (root.left != null) {
                node2 = Max(root.left);
                Delete(node2.data);
                root.data = node2.data;
                return root;
            } else if (root.right != null) {
                node2 = Min(root.right);
                Delete(node2.data);
                root.data = node2.data;
                return root;
            }

        }

        if (node.left != null && data < node.data && data != node.left.data) {
            node = Delete(node.left, data);

        } else if (node.right != null && data > node.data && data != node.right.data) {
            node = Delete(node.right, data);
        }

        deleteEngine(node, data);
        return node;
    }

    public void Delete(int data) {
        Delete(root, data);
    }

    public Node Min(Node node) {
        if (node == null)
            return null;
        while (node.left != null) {
            node = node.left;

        }
        return node;
    }

    public Node Max(Node node) {
        if (this.root == null)
            return null;

        while (node.right != null) {
            node=node.right;

        }
        return node;
    }

    public void preorder() {
        preorder(root);
    }

    private void preorder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void InfixPrint(Node node) {
        if (node != null) {
            InfixPrint(node.left);
            node.Display();
            InfixPrint(node.right);
        }

    }

    public void InfixPrint() {
        InfixPrint(root);
    }

    public void PostfixPrint(Node node) {
        if (node != null) {
            PostfixPrint(node.left);
            PostfixPrint(node.right);
            node.Display();
        }
    }

    public void PostfixPrint() {
        PostfixPrint(root);
    }

}