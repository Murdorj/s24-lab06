package edu.cmu.cs.cs214.rec04;

/**
 * AbstractIntList -- a list of integers.
 * Provides a skeletal implementation of the IntegerList interface.
 * This class allows subclasses to implement the core functionalities
 * while reusing common logic for handling list operations.
 *
 * @author Nora Shoemaker
 */
public abstract class AbstractIntList implements IntegerList {

    /**
     * Adds the specified integer to the list.
     *
     * @param num the integer to be added
     * @return true if the list is modified
     */
    public abstract boolean add(int num);

    /**
     * Adds all elements from the provided IntegerList to this list.
     * Iterates over the list and calls add() on each element.
     * Can be overridden by subclasses for optimized behavior.
     *
     * @param list IntegerList containing elements to be added
     * @return true if the list changed as a result
     */
    public boolean addAll(IntegerList list) {
        boolean success = false;
        for (int i = 0; i < list.size(); i++) {
            success |= this.add(list.get(i));
        }
        return success;
    }

    /**
     * Retrieves the integer at the specified index.
     *
     * @param index the position of the element
     * @return the integer at the specified position
     */
    public abstract int get(int index);

    /**
     * Removes the first occurrence of the specified integer.
     *
     * @param num the integer to remove
     * @return true if the element was successfully removed
     */
    public abstract boolean remove(int num);

    /**
     * Removes all elements present in the provided IntegerList from this list.
     *
     * @param list IntegerList containing elements to be removed
     * @return true if the list changed as a result
     */
    public abstract boolean removeAll(IntegerList list);

    /**
     * Returns the number of elements in the list.
     * If the list contains more than Integer.MAX_VALUE elements,
     * it should return Integer.MAX_VALUE.
     *
     * @return the size of the list
     */
    public abstract int size();
}
