package br.ppgsc;

/**
 * Created by zidenis on 03/08/2017.
 */

/** List Abstract Data Type*/
public interface List<E> {

    /** Remove all contents of the list
     */
    public void clear();

    /** Insert an element at the current position
     * @param element is the element to be inserted
     * @throws Exception when its not possible to insert the element in the list
     */
    public void insert(E element) throws Exception;

    /** Appends an element at the end of the list
     * @param element is the element to be appended
     * @throws Exception when its not possible to append the element in the list
     */
    public void append(E element) throws Exception;

    /** Removes the element at the current position
     * @return the removed element
     */
    public E remove();

    /** Set the current position to the start of the list
     */
    public void moveToStart();

    /** Set the current position to the end of the list
     */
    public void moveToEnd();

    /** Set the current position one step left. No change if already at beginning
     */
    public void prev();

    /** Set the current position one step right. No change if already at the end
     */
    public void next();

    /**
     * @return the number of elements in the list
     */
    public int length();

    /**
     * @return the position of the current element
     */
    public int currentPosition();

    /** Set the current position
     * @param position the number of the position
     * @throws Exception when the position is not valid
     */
    public void moveToPosition(int position) throws Exception;

    /**
     * @return the element at current position
     */
    public E getElement();

}
