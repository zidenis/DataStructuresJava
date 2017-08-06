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
    ArrayList(int arraySize) {
        this.arraySize = arraySize;
        listLength = 0;
        currentPosition = 0;
        listArray = (E[])new Object[arraySize];
    }

    ArrayList() {
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
        System.arraycopy(listArray, currentPosition, listArray, currentPosition + 1, listLength - currentPosition);
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
        System.arraycopy(listArray, currentPosition + 1, listArray, currentPosition, listLength - currentPosition);
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
        return Arrays.asList(listArray).subList(0, listLength).toString();
    }

    @Override
    public int binarySearch(E element, Greater<E> greater) {
        int leftBound=-1;
        int rightBound=listLength;
        while (leftBound+1 != rightBound) {
            int index = (leftBound+rightBound)/2;
            if (listArray[index].equals(element)) return index;
            if (greater.compare(listArray[index], element)) rightBound = index;
            else leftBound = index;
        }
        return -1;
    }
}

