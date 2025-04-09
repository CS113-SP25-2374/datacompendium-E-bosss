package CS113;

public class AVLTreeES  <T extends Comparable<T>> extends BinarySearchTreeES<T>  {

    //left heavy, rotate right
     Node<T> rotateRight(Node<T> node) {
        if(root == null || root.left == null) {
            return node;
        }

        //need temp variable and set to each other
        Node<T> childLeft = node.left;
        node.left = childLeft.right;
        childLeft.right = node;

        node = childLeft;
        return node;
    }

    //Right heavy, rotate left
    Node<T> rotateLeft(Node<T> node) {
        if(root == null || root.right == null) {
            return node;
        }

        //need temp variable and set to each other
        Node<T> childRight = root.right;
        node.right = childRight.left;
        childRight.left = node;

        node = childRight;
        return node;
    }

    int balanceFactor (Node<T> node) {
         if(node == null) { return 0; }
         //difference of heights of each side
         return heightRecursive(node.right) - heightRecursive(node.left);
    }

    Node<T> rebalance(Node<T> node) {
        int balanceFactor = balanceFactor(node);

        // Left-heavy
        if (balanceFactor < -1) {
            if (balanceFactor(node.left) <= 0) {
                // Rotate right
                node = rotateRight(node);
            } else {
                // Rotate left-right
                node.left = rotateLeft(node.left);
                node = rotateRight(node);
            }
        }

        // Right-heavy
        if (balanceFactor > 1) {
            if (balanceFactor(node.right) >= 0) {
                // Rotate left
                node = rotateLeft(node);
            } else {
                // Rotate right-left
                node.right = rotateRight(node.right);
                node = rotateLeft(node);
            }
        }

        return node;
    }

    @Override
    Node<T> insertRecursive(Node<T> node, T data) {
         //call super from BST class, apply to node and balance if needed
         node = super.insertRecursive(node, data);
         node = rebalance(node);
         return node;
    }
}
