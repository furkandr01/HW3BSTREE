//Abdurrahman Furkan ADAR
//200316012
import java.util.ArrayList;
import java.util.List;

class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int data) {
        root = insertRecursive(root, data);
    }

    private Node insertRecursive(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data)
            root.left = insertRecursive(root.left, data);
        else if (data > root.data)
            root.right = insertRecursive(root.right, data);

        return root;
    }

    public List<Integer> preorderTraversal() {
        List<Integer> result = new ArrayList<>();
        preorderRecursive(root, result);
        return result;
    }

    private void preorderRecursive(Node root, List<Integer> result) {
        if (root != null) {
            result.add(root.data); // Gezinilen düğümü sonuç listesine ekle
            preorderRecursive(root.left, result); // Sol alt ağaca geç
            preorderRecursive(root.right, result); // Sağ alt ağaca geç
        }
    }

    public Node findLowestCommonAncestor(int value1, int value2) {
        return findLowestCommonAncestorRecursive(root, value1, value2);
    }

    private Node findLowestCommonAncestorRecursive(Node root, int value1, int value2) {
        if (root == null || root.data == value1 || root.data == value2) {
            return root;
        }

        Node left = findLowestCommonAncestorRecursive(root.left, value1, value2); // Sol alt ağaçta en küçük ortak atayı bul
        Node right = findLowestCommonAncestorRecursive(root.right, value1, value2); // Sağ alt ağaçta en küçük ortak atayı bul

        if (left != null && right != null) {
            return root; // Bulunan en küçük ortak atayı döndür
        }

        return (left != null) ? left : right; // En küçük ortak atayı döndür
    }

    public void deleteNode(int key) {
        root = deleteNodeRecursive(root, key);
    }

    private Node deleteNodeRecursive(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.data) {
            root.left = deleteNodeRecursive(root.left, key); // Sol alt ağaçta düğümü sil
        } else if (key > root.data) {
            root.right = deleteNodeRecursive(root.right, key); // Sağ alt ağaçta düğümü sil
        } else {
            if (root.left == null) {
                return root.right; // Sadece sağ alt ağacı varsa düğümü sil
            } else if (root.right == null) {
                return root.left; // Sadece sol alt ağacı varsa düğümü sil
            }

            root.data = minValue(root.right); // Silinecek düğümün yerine en küçük değeri koy

            root.right = deleteNodeRecursive(root.right, root.data); // Sağ alt ağaçta tekrar düğümü sil
        }

        return root;
    }

    private int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    public List<Integer> levelOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        int height = getHeight(root); // Ağacın yüksekliğini hesapla
        for (int i = 1; i <= height; i++) {
            levelOrderRecursive(root, i, result); // Her seviye için levelOrderRecursive metodunu çağır
        }
        return result;
    }

    private int getHeight(Node root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = getHeight(root.left); // Sol alt ağacın yüksekliğini hesapla
            int rightHeight = getHeight(root.right); // Sağ alt ağacın yüksekliğini hesapla

            if (leftHeight > rightHeight) {
                return leftHeight + 1; // Daha yüksek olan yüksekliği 1 arttır
            } else {
                return rightHeight + 1; // Daha yüksek olan yüksekliği 1 arttır
            }
        }
    }

    private void levelOrderRecursive(Node root, int level, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (level == 1) {
            result.add(root.data); // Gezinilen düğümü sonuç listesine ekle
        } else if (level > 1) {
            levelOrderRecursive(root.left, level - 1, result); // Sol alt ağaca geç ve seviyeyi azalt
            levelOrderRecursive(root.right, level - 1, result); // Sağ alt ağaca geç ve seviyeyi azalt
        }
        }
    }


