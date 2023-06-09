import javax.swing.text.AbstractDocument.LeafElement;
import javax.swing.text.html.HTMLDocument.RunElement;

public class Avltree {
    Node root;

    public Avltree() {
        this.root = null;
    }

    public void TreeBalanceState() {
        System.out.println("Tree Balance State: " + BalanceDifference(root));
    }

    public int NodeLevel(Node node) {
        if (node == null) {
            return 0;
        }
        return node.level;
    }

    public int BalanceDifference(Node node) {
        if (node != null)
            return NodeLevel(node.left) - NodeLevel(node.right);
        else
            return 0;
    }

    public Node LeftRotate(Node pivot) {
        Node pr = pivot.right;
        Node prl = pr.left;

        if (pivot == root) {
            root = pivot.right;

        }
        pivot.right = prl;
        pr.left = pivot;
        

        pivot.level = Math.max(NodeLevel(pivot.right), NodeLevel(pivot.left)) + 1;
        pr.level = Math.max(NodeLevel(pr.right), NodeLevel(pr.left)) + 1;
        this.root.level = Math.max(NodeLevel(root.left), NodeLevel(root.right));

        return pr;
    }

    public Node RightRotate(Node pivot) {
        Node pl = pivot.left;
        Node plr = pl.right;
        

        if (pivot == root) {
            root = pivot.left;
        }

        pivot.left = plr;
        pl.right = pivot;
       

        pivot.level = Math.max(NodeLevel(pivot.right), NodeLevel(pivot.left)) + 1;
        pl.level = Math.max(NodeLevel(pl.right), NodeLevel(pl.left)) + 1;
        this.root.level = Math.max(NodeLevel(root.left), NodeLevel(root.right));

        return pl;
    }

    public Node Insert(Node node, int data) {
        if (node == null) {
            if (root == null) {
                root = new Node(data);
                return root;
            }
            return new Node(data);
        }

        if (data < node.data) {
            node.left = Insert(node.left, data);

        } else if (data > node.data) {
            node.right = Insert(node.right, data);
        }

        node.level = Math.max(NodeLevel(node.left), NodeLevel(node.right)) + 1;

        int Bd = BalanceDifference(node);

        if (Bd > 1 && data < node.data) {
            return RightRotate(node);
        }
        if (Bd > 1 && data > node.data) {
            node.left = LeftRotate(node.left);
            return RightRotate(node);
        }

        if (Bd < -1 && data > node.data) {
            return LeftRotate(node);

        }

        if (Bd < -1 && data < node.data) {
            node.right = RightRotate(node.right);
            return LeftRotate(node);
        }
        return node;

    }

    public void Insert(int data) {
        Insert(root, data);
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

    public Node Min(Node node) {
        if (node == null)
            return null;
        while (node.left != null) {
            node = node.left;

        }
        return node;
    }

    public Node Max(Node node) {
        if (node == null)
            return null;
        Node temp = root;
        while (node.right != null) {
            node = node.right;

        }
        return node;
    }

    public Node DeleteEngine(Node node, int data) {
        if (root.data == data) {
            if (root.left != null)
            {
                root.data = Max(root.left).data;
                Delete(Max(root.left).data);
            }
            else {
                root.data = Min(root.right).data;
                Delete(Min(root.right).data);
            }
            return root;
        }
        if (node.left != null && node.left.data == data) {

            if (IsHaveChild(node.left) == 0)
                return node.left = null;
            else if (IsHaveChild(node.left) == 11) {
                return node.left = node.left.left;
            } else if (IsHaveChild(node.left) == 12) {
                return node.left = node.left.right;
            } else if (IsHaveChild(node.left) == 2) {
                Node node2;
                node2 = Min(node.left.right);
                Delete(node2.data);
                node.left.data = node2.data;
                return node.left;
            }
        } else if (node.right != null && node.right.data == data) {
            if (IsHaveChild(node.right) == 0)
                return node.right = null;
            else if (IsHaveChild(node.right) == 11) {
                return node.right = node.right.left;
            } else if (IsHaveChild(node.right) == 12) {
                return node.right = node.right.right;
            } else if (IsHaveChild(node.right) == 2) {
                Node node2;
                node2 = Max(node.right.left);
                Delete(node2.data);
                node.right.data = node2.data;
                return node.right;
            }

        }
        return node;

    }

    public Node Delete(Node node, int data) {
        if (this.root.data == data) {
            Node node2;
            node2 = Max(root.right);
            Delete(node2.data);
            root.data = node2.data;

        }

        if (data < node.data && data != node.left.data) {
            node = Delete(node.left, data);

        } else if (node.right != null && data > node.data && data != node.right.data) {
            node = Delete(node.right, data);
        }

        DeleteEngine(node, data);

        if (root == null)
            return root;

        node.level = Math.max(NodeLevel(node.right), NodeLevel(node.left));

        int Bd = BalanceDifference(node);
        if (Bd > 1 && BalanceDifference(node.left) >= 0)
            return RightRotate(node);

        // Left Right Case
        if (Bd > 1 && BalanceDifference(node.left) < 0) {
            node.left = LeftRotate(node.left);
            return RightRotate(node);
        }

        // Right Right Case
        if (Bd < -1 && BalanceDifference(node.right) <= 0)
            return LeftRotate(node);

        // Right Left Case
        if (Bd < -1 && BalanceDifference(node.right) > 0) {
            node.right = RightRotate(node.right);
            return LeftRotate(node);
        }
        return node;

    }

    public void Delete(int data) {
        Delete(root, data);
    }

    public void InfixPrint(Node node) {
        if (node != null) {
            InfixPrint(node.left);
            node.Display();
            InfixPrint(node.right);
        }

    }

    public void InfixPrint() {
        System.out.print("Infix: ");
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
        System.out.print("Postfix: ");
        PostfixPrint(root);
    }

    public void PrefixPrint(Node node) {
        if (node != null) {
            node.Display();
            PrefixPrint(node.left);
            PrefixPrint(node.right);

        }

    }

    public void PrefixPrint() {
        System.out.print("Prefix: ");
        PrefixPrint(root);
    }

}