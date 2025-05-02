package CS113;

import CS113.interfaces.BinarySearchTree;

public class BinarySearchTreeES <T extends Comparable<T>> implements BinarySearchTree<T> {

     class Node<T> {
        T data;
        Node<T> left;
        Node<T> right;

        public Node(T data) {
            this.data = data;
            this.left = this.right = null;
        }
//          delete interface and make custom one
//        public int compareTo(Node<T> other) {
//            return this.data.compareTo(other.data);
//        }
    }


     Node<T> root;

     //helper method to loop through to find the right spot to insert the node
     Node<T> insertRecursive(Node<T> node, T data) {
         if(node == null) {
             return new Node<T>(data);
         }
         if(node.data.compareTo(data) > 0) {
             node.left = insertRecursive(node.left, data);
         }
         if(node.data.compareTo(data) < 0) {
             node.right = insertRecursive(node.right, data);
         }

         return node;
     }


    @Override
    public void insert(T value) {
        root = insertRecursive(root, value);
    }

    public Node<T> deleteRecursive(Node<T> node, T data) {
        if(node == null) return null;

        if(node.data == data) {
            Node<T> replace = null;
            if(heightRecursive(node) == 1) {
                return null;
            }
            if(heightRecursive(node.right) > heightRecursive(node.left)) {
                replace = findMinRecursive(node.right);
            }
            else {
                replace = findMaxRecursive(node.left);
            }
            deleteRecursive(node, replace.data);
            replace.left = node.left;
            replace.right = node.right;
            return replace;
        }

        if(node.data.compareTo(data) > 0) {
            node.left = deleteRecursive(node.left, data);
        }
        if(node.data.compareTo(data) < 0) {
            node.right = deleteRecursive(node.right, data);
        }
        return node;
    }

    @Override
    public boolean delete(T value) {
        root = deleteRecursive(root, value);
        return false;
    }

    @Override
    public boolean contains(T value) {
        if(root == null) {
            return false;
        }

        return false;
    }

    Node<T> findMinRecursive(Node<T> node) {
         if(node.left == null) return node;
         return findMinRecursive(node.left);
    }
    @Override
    public T findMin() {
        return findMinRecursive(root).data;
    }

    Node<T> findMaxRecursive(Node<T> node) {
         if(node.right == null) return node;
         return findMaxRecursive(node.right);
    }

    @Override
    public T findMax() {
        return findMaxRecursive(root).data;
    }

    int heightRecursive(Node<T> node) {
         if(node == null) return 0;
         return 1 + Integer.max(heightRecursive(node.left), heightRecursive(node.right));
    }

    @Override
    public int height() {
        return heightRecursive(root);
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void clear() {

    }

    String recurseToString(Node<T> node) {
        if(node == null)
            return "";

        String left = recurseToString(node.left);
        String center = node.data.toString();
        String right = recurseToString(node.right);

        return left + center + right;
    }

    public String toString() {
         return recurseToString(root);
    }


}
