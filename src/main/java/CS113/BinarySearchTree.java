package CS113;

public interface BinarySearchTree<T extends Comparable<T>> {

    // Insert a value into the BST
    void insert(T value);

    // Delete a value from the BST
    boolean delete(T value);

    // Search for a value in the BST
    boolean contains(T value);

    // Find the minimum value in the BST
    T findMin();

    // Find the maximum value in the BST
    T findMax();

    // Get the height of the BST
    int height();

    // Check if the BST is empty
    boolean isEmpty();

    // Clear the BST
    void clear();

}
