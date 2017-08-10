package br.ppgsc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by zidenis on 08/08/2017.
 */

class ArrayListTest {
    private List<String> list;

    @BeforeEach
    void setUp() {
        list = new ArrayList<>(15);
        try {
            list.append("Alice");
            list.append("Bob");
            list.append("Cloud");
            list.append("Denis");
            list.append("Eric");
            list.append("Fran");
            list.append("Gaia");
            list.append("Goia");
            list.append("Gulliver");
            list.append("Hugo");
        } catch (Exception e) {
            fail("cannot append to the list");
        }
    }

    @Test
    @DisplayName("Length of an empty list is 0")
    void lengthOfEmptyList() {
        List<Object> emptyList = new ArrayList<>();
        assertEquals(0, emptyList.length());
    }

    @Test
    @DisplayName("Length of a list")
    void lengthOfList() {
        assertEquals(10, list.length());
        try {
            list.append("New Name");
        } catch (Exception e) {
            fail("Uname to append element");
        }
        assertEquals(11, list.length());
    }

    @Test
    @DisplayName("Element at the end of the list")
    void elementAtEnd() {
        list.moveToEnd();
        assertEquals("Hugo", list.getElement());
        try {
            list.append("New");
        } catch (Exception e) {
            fail("Unable to append element");
        }
        list.moveToEnd();
        assertEquals("New", list.getElement());
    }

    @Test
    @DisplayName("Element at the begin of the list")
    void elementAtBegin() {
        list.moveToStart();
        assertEquals("Alice", list.getElement());
    }

    @Test
    @DisplayName("Cleared list is a new empty list")
    void clear() {
        assertEquals(10, list.length());
        list.clear();
        assertEquals(0, list.length());
    }

    @Test
    @DisplayName("Binary Search")
    void binarySearch() {
        assertEquals(0, list.binarySearch("Alice", (f, s) -> f.compareTo(s) > 0));
        assertEquals(9, list.binarySearch("Hugo", (f, s) -> f.compareTo(s) > 0));
        assertEquals(5, list.binarySearch("Fran", (f, s) -> f.compareTo(s) > 0));
        assertEquals(-1, list.binarySearch("ALICE", (f, s) -> f.compareTo(s) > 0));
        List<String> newList = new ArrayList<>(15, true);

    }
}