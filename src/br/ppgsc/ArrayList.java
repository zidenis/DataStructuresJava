package br.ppgsc;

import java.util.Arrays;

/**
 * Created by zidenis on 03/08/2017.
 */
public class ArrayList<E> implements List<E> {

    private static final int DEFAULT_SIZE = 1024;
    private int arraySize; // fixed size of the array
    private int listLength;
    private int currentPosition;
    private E[] listArray; // the array that holds the lists elements

    /** @param arraySize the maximum number of elements of the list
     */
    public ArrayList(int arraySize) {
        this.arraySize = arraySize;
        listLength = 0;
        currentPosition = 0;
        listArray = (E[])new Object[arraySize];
    }

    public ArrayList() {
        this(DEFAULT_SIZE);
    }

    @Override
    public void clear() {
        listLength = 0;
        currentPosition = 0;
        listArray = (E[])new Object[arraySize];
    }

    @Override
    public void insert(E element) throws Exception {
        assert listLength <= arraySize : "The length of the list should never be greater than the size of the array";
        if (listLength == arraySize) throw new Exception("Array size limit exceeded. Could not insert a new element");
        // Shift up the elements after the current position
        for (int i = listLength; i>currentPosition; i--) {
            listArray[i] = listArray[i-1];
        }
        listArray[currentPosition] = element;
        listLength++;
    }

    @Override
    public void append(E element) throws Exception {
        assert listLength <= arraySize : "The length of the list should never be greater than the size of the array";
        if (listLength == arraySize) throw new Exception("Array size limit exceeded. Could not append a new element");
        listArray[listLength] = element;
        listLength++;
    }

    @Override
    public E remove() {
        E element = listArray[currentPosition];
        for (int i=currentPosition; i<listLength; i++) {
            listArray[i]=listArray[i+1];
        }
        listLength--;
        return element;
    }

    @Override
    public void moveToStart() {
        currentPosition = 0;
    }

    @Override
    public void moveToEnd() {
        currentPosition = listLength;
    }

    @Override
    public void prev() {
        if (currentPosition != 0) currentPosition--;
    }

    @Override
    public void next() {
        if (currentPosition < listLength) currentPosition++;
    }

    @Override
    public int length() {
        return listLength;
    }

    @Override
    public int currentPosition() {
        return currentPosition;
    }

    @Override
    public void moveToPosition(int position) throws Exception {
        if (position > listLength) throw new Exception("Invalid position");
        currentPosition = position;
    }

    @Override
    public E getElement() {
        return listArray[currentPosition];
    }

    @Override
    public String toString() {
        return Arrays.asList(listArray).toString();
    }
}
