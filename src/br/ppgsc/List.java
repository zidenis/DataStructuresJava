package br.ppgsc;

/** List Abstract Data Type
 * Created by zidenis on 03/08/2017
 */
public interface List<E> {

    /** Remove all contents of the list
     */
    void clear();

    /** Insert an element at the current position
     * @param element is the element to be inserted
     * @throws Exception when its not possible to insert the element in the list
     */
    void insert(E element) throws Exception;

    /** Appends an element at the end of the list
     * @param element is the element to be appended
     * @throws Exception when its not possible to append the element in the list
     */
    void append(E element) throws Exception;

    /** Removes the element at the current position
     * @return the removed element
     */
    E remove();

    /** Set the current position to the start of the list
     */
    void moveToStart();

    /** Set the current position to the end of the list
     */
    void moveToEnd();

    /** Set the current position one step left. No change if already at beginning
     */
    void prev();

    /** Set the current position one step right. No change if already at the end
     */
    void next();

    /**
     * @return the number of elements in the list
     */
    int length();

    /**
     * @return the position of the current element
     */
    int currentPosition();

    /** Set the current position
     * @param position the number of the position
     * @throws Exception when the position is not valid
     */
    void moveToPosition(int position) throws Exception;

    /**
     * @return the element at current position
     */
    E getElement();

    /** Apply binary search to find and element in the list. The List must be sorted from lowest to highest
     * @return the position of an element in the and sorted list using binary search algorithm. Returns -1 if the
     * element was not found
     * @param element the element to be searched
     * @param greater the function(first, second) used to compare if the fist element is greater than the second
     */
    int binarySearch(E element, Greater<E> greater);

}

interface Greater<E> {
    /**
     * Compare two elements to determine if the first is greater than the second
     * @param first the first element
     * @param second the second element
     * @return true if the first element is greater than the second
     */
    boolean compare(E first, E second);
}
