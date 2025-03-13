package edu.cmu.cs.cs214.rec04;

import java.util.ArrayList;
import java.util.Collections;

/**
 * InheritanceSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */
public class InheritanceSortedIntList extends AbstractIntList {
    private final ArrayList<Integer> list;
    private int totalAdded;

    /**
     * Constructs an empty sorted integer list.
     */
    public InheritanceSortedIntList() {
        this.list = new ArrayList<>();
        this.totalAdded = 0;
    }

    /**
     * Adds the specified integer to the sorted list while maintaining order.
     *
     * @param num the integer to be added.
     * @return true if the list was modified as a result of this call.
     */
    @Override
    public boolean add(int num) {
        totalAdded++;
        int index = Collections.binarySearch(list, num);
        if (index < 0) {
            list.add(-index - 1, num);
            return true;
        }
        return false;
    }

    /**
     * Returns the integer at the specified index.
     *
     * @param index the index of the integer to retrieve.
     * @return the integer at the specified position.
     */
    @Override
    public int get(int index) {
        if (index < 0 || index >= list.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return list.get(index);
    }

    /**
     * Removes the first occurrence of the specified number from the list.
     *
     * @param num the integer to remove.
     * @return true if an element was removed, false otherwise.
     */
    @Override
    public boolean remove(int num) {
        return list.remove(Integer.valueOf(num));
    }

    /**
     * Removes all elements from this list that exist in the provided list.
     *
     * @param otherList the IntegerList containing elements to remove.
     * @return true if the list changed as a result of this call.
     */
    @Override
    public boolean removeAll(IntegerList otherList) {
        boolean changed = false;
        for (int i = 0; i < otherList.size(); i++) {
            changed |= remove(otherList.get(i));
        }
        return changed;
    }

    /**
     * Returns the number of elements in the list.
     *
     * @return the number of elements in the list.
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * Returns the total number of attempted additions, including duplicates.
     *
     * @return the total number of attempted insertions.
     */
    public int getTotalAdded() {
        return totalAdded;
    }
}
