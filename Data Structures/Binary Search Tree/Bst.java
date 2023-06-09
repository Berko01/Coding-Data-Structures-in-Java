import java.lang.System.Logger.Level;
import java.util.LinkedList;
import java.util.Queue;

import javax.security.auth.kerberos.DelegationPermission;
import javax.swing.event.AncestorEvent;

import org.w3c.dom.css.Counter;

public class Bst {
    Node root;

    public Bst() {
        this.root = null;
    }

    public void Insert(int data, Node node) {
        Node newNode = new Node(data);

        if (this.root == null) {
            root = newNode ;

            root.level = Math.max(getLevel(root.right), getLevel(root.left)) + 1;
            return;
        }

        if (data < node.data) {
            if (node.left == null) {
                node.left = newNode ;
                return;
            }
            node = node.left;

            Insert(data, node);

            node.level = Math.max(getLevel(node.right), getLevel(node.left)) + 1;
            root.level = Math.max(getLevel(root.right), getLevel(root.left)) + 1;

        } else if (data > node.data) {
            if (node.right == null) {
                node.right = newNode ;
                return;
            }
            node = node.right;

            Insert(data, node);

            node.level = Math.max(getLevel(node.right), getLevel(node.left)) + 1;
            root.level = Math.max(getLevel(root.right), getLevel(root.left)) + 1;

        } else if (data == node.data) {
            node.counter++;
        }

    }

    public void Insert(int data) {
        Insert(data, root);
    }

    public int getLevel(Node node) {
        if (node == null) {
            return 0;
        }
        return node.level;
    }

    public Node Search(int data, Node node) {
        if (node == null) {
            return null;
        }

        if (data < node.data) {
            return Search(data, node.left);
        } else if (data > node.data) {
            return Search(data, node.right);

        } else {
            return node;
        }

    }

    public Node Search(int data) {
        return Search(data, root);
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

    public void PrefixPrint(Node node) {
        if (node != null) {
            node.Display();
            PrefixPrint(node.left);
            PrefixPrint(node.right);

        }
    }

    public void PrefixPrint() {
        PrefixPrint(root);
    }

    public void LevelOrderTraverse(Node node) {
        Queue queue = new LinkedList();
        queue.add(node);
        Node temp = node;
        while (!queue.isEmpty()) {
            temp = (Node) queue.poll();
            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);
            temp.Display();
        }

    }

    public void LevelOrder() {
        LevelOrderTraverse(root);
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
            node = node.right;

        }
        return node;
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
        // node'un solu mu data sağımı data
        if (node.left != null && node.left.data == data) {
            // konuma göre silme işlemi
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
                return node;
            }
        } else if (node.right != null && node.right.data == data) {
            // konuma göre silme işlemi
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
                return node;
            }

        }
        return node;
    }

    public Node Delete(Node node, int data) {
        if (this.root.data == data) {
            Node node2;
            node2 = Max(root.left);
            Delete(node2.data);
            root.data = node2.data;

        }

        deleteEngine(node, data);

        if (node.left != null && data < node.data && data != node.left.data) {
            node = Delete(node.left, data);

        } else if (node.right != null && data > node.data && data != node.right.data) {
            node = Delete(node.right, data);
        }
        return node;
    }

    public void Delete(int data) {
        Delete(root, data);
    }

    public void AncestorsofMin() {
        Node temp = root;
        int k = -1;
        while (temp.left.left != Min(root)) {
            k++;
            System.out.println("Ancestors of Min: " + temp.data);
            temp = temp.left;
        }
        if (k == -1) {
            System.out.println("There is no ancestor of min!!!");
        }

    }

    public void AncestorsofMax() {
        Node temp = root;
        int k = -1;
        while (temp.right != null && temp.right.right != Max(root)) {
            k++;
            System.out.println("Ancestors of Max: " + temp.data);
            temp = temp.right;
        }
        if (k == -1) {
            System.out.println("There is no ancestor of max!!!");
        }

    }

    public void SiblingsofMin(Node node) {
        if (node != null) {
            SiblingsofMin(node.right);
            SiblingsofMin(node.left);
            if (Min(root).level == node.level) {
                System.out.println("Sibling od Min: " + node.data);
            }
        }

    }

    public void SiblingsofMin() {
        SiblingsofMin(root);
    }

    public void SiblingsofMax(Node node) {
        if (node != null) {
            SiblingsofMin(node.right);
            SiblingsofMin(node.left);
            if (Max(root).level == node.level) {
                System.out.println("Sibling of Max: " + node.data);
            }
        }

    }

    public void SiblingsofMax() {
        SiblingsofMax(root);
    }

    public void SiblingsofNode(Node root, int value) {

        Node tempnode = Search(value);
        if (root != null) {
            SiblingsofNode(root.left, value);
            SiblingsofNode(root.right, value);
            if (tempnode.level == root.level) {
                System.out.println("Siblings of " + value + ":" + root.data);
            }
        }

    }

    public void SiblingsofNode(int value) {
        SiblingsofNode(root, value);
    }

    public int level() {

        return Math.max(root.right.level, root.left.level);

    }

    public int BalanceDifference() {
        return root.left.level - root.right.level;
    }

}