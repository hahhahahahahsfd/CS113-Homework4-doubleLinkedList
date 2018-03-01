/**
 * @author Carlos Sanchez
 * @version 1.01
 * @Since 2-24-1983
 * <p>
 * DoubleListIteratorTest.java : Used for testing inner class DoubleListIterator inside DoubleLinkedList.java.
 */

package edu.miracosta.cs113;

import org.junit.Before;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class DoubleListIteratorTest
{

    private static final String[] STRING_VALUES = {"first", "second", "third", "fourth", "fifth"};
    private static final int[] INT_VALUES = {100, 200, 300, 400, 500};
    private static final char[] CHAR_VALUES = {'A', 'B', 'C', 'D', 'E'};
    private static final double[] DOUBLE_VALUES = {1.1, 2.2, 3.3, 4.4, 5.5};

    private static final String[] STRING_INSERT_VALUES = {"cow", "monkey", "pig", "gorilla", "zebra"};
    private static final int[] INT_INSERT_VALUES = {-25, -250, -350, -450, -550};
    private static final char[] CHAR_INSERT_VALUES = {'L', 'M', 'N', 'O', 'P'};
    private static final double[] DOUBLE_INSERT_VALUES = {-.1, -.2, -.3, -.4, -.5};


    // List for testing
    private List<String> stringList;
    private List<Integer> intList;
    private List<Character> charList;
    private List<Double> doubleList;

    // Iterator for testing
    private ListIterator stringIterator;
    private ListIterator intIterator;
    private ListIterator charIterator;
    private ListIterator doubleIterator;

    private ListIterator[] iteratorArray;


    @Before
    public void setUp()
    {
        // Instatiate list
        stringList = new DoubleLinkedList<String>();
        intList = new DoubleLinkedList<Integer>();
        charList = new DoubleLinkedList<Character>();
        doubleList = new DoubleLinkedList<Double>();


    }

    // Helper method
    public void buildList(int num)
    {
        for (int i = 0; i < num; i++)
        {
            stringList.add(STRING_VALUES[i]);
            intList.add(INT_VALUES[i]);
            charList.add(CHAR_VALUES[i]);
            doubleList.add(DOUBLE_VALUES[i]);
        }
    }

    public void addElementsWithIterator(int num)
    {
        for (int i = 0; i < num; i++)
        {
            stringIterator.add(STRING_VALUES[i]);
            intIterator.add(INT_VALUES[i]);
            charIterator.add(CHAR_VALUES[i]);
            doubleIterator.add(DOUBLE_VALUES[i]);
        }
    }

    // Helper method
    public void instantiateIterators()
    {
        // Instatite iterators
        stringIterator = stringList.listIterator();
        intIterator = intList.listIterator();
        charIterator = charList.listIterator();
        doubleIterator = doubleList.listIterator();
    }

    // Helper method
    public void instantiateIterators(int index)
    {
        // Instatite iterators
        stringIterator = stringList.listIterator(index);
        intIterator = intList.listIterator(index);
        charIterator = charList.listIterator(index);
        doubleIterator = doubleList.listIterator(index);
    }


    // test Default Constructor public DoubleListIterator()


    // test public void add(E e)
    @Test
    public void testAddingOneBySize()
    {
        instantiateIterators();
        addElementsWithIterator(1);

        assertEquals("String list should have size of 1", 1, stringList.size());
        assertEquals("Integer list should have size of 1", 1, intList.size());
        assertEquals("Character list should have size of 1", 1, charList.size());
        assertEquals("Double list should have size of 1", 1, doubleList.size());
    }

    @Test
    public void testAddingThreeBySize()
    {
        instantiateIterators();
        addElementsWithIterator(3);

        assertEquals("String list should have size of 3", 3, stringList.size());
        assertEquals("Integer list should have size of 3", 3, intList.size());
        assertEquals("Character list should have size of 3", 3, charList.size());
        assertEquals("Double list should have size of 3", 3, doubleList.size());
    }

    // test public E next()
    @Test
    public void testNextOnEmptyList()
    {
        instantiateIterators();
        try
        {
            stringIterator.next();
            fail("String iterator testNextOnEmptyList() test should have thrown NoSuchElementException");

        } catch (NoSuchElementException e)
        { /* Test passed */}

        try
        {
            intIterator.next();
            fail("Integer iterator testNextOnEmptyList() test should have thrown NoSuchElementException");

        } catch (NoSuchElementException e)
        { /* Test passed */}

        try
        {
            charIterator.next();
            fail("Character iterator testNextOnEmptyList() test should have thrown NoSuchElementException");

        } catch (NoSuchElementException e)
        { /* Test passed */}

        try
        {
            doubleIterator.next();
            fail("Double iterator testNextOnEmptyList() test should have thrown NoSuchElementException");

        } catch (NoSuchElementException e)
        { /* Test passed */}
    }

    @Test
    public void testNextOnFullList()
    {
        int num = 5;
        buildList(num);
        instantiateIterators();

        for (int i = 0; i < num; i++)
        {
            assertEquals("String Iterator next element should be " + STRING_VALUES[i], STRING_VALUES[i], stringIterator.next());
            assertEquals("Integer Iterator next element should be " + INT_VALUES[i], INT_VALUES[i], intIterator.next());
            assertEquals("Character Iterator next element should be " + CHAR_VALUES[i], CHAR_VALUES[i], charIterator.next());
            assertEquals("Double Iterator next element should be " + DOUBLE_VALUES[i], DOUBLE_VALUES[i], doubleIterator.next());
        }
        try
        {
            stringIterator.next();
            fail("String iterator testNextOnEmptyList() test should have thrown NoSuchElementException");

        } catch (NoSuchElementException e)
        { /* Test passed */}

        try
        {
            intIterator.next();
            fail("Integer iterator testNextOnEmptyList() test should have thrown NoSuchElementException");

        } catch (NoSuchElementException e)
        { /* Test passed */}

        try
        {
            charIterator.next();
            fail("Character iterator testNextOnEmptyList() test should have thrown NoSuchElementException");

        } catch (NoSuchElementException e)
        { /* Test passed */}

        try
        {
            doubleIterator.next();
            fail("Double iterator testNextOnEmptyList() test should have thrown NoSuchElementException");

        } catch (NoSuchElementException e)
        { /* Test passed */}
    }

    // test public boolean hasNext()
    @Test
    public void testIteratorWithEmptyListHasNoNext()
    {
        instantiateIterators();
        // verify nextItem == head, lastItem returned == null, index == 0
        assertFalse("String list Iterator nextItem should be null", stringIterator.hasNext());
        assertFalse("Integer list Iterator nextItem should be null", intIterator.hasNext());
        assertFalse("Char list Iterator nextItem should be null", charIterator.hasNext());
        assertFalse("Double list Iterator nextItem should be null", doubleIterator.hasNext());
    }


    // test public E previous()
    @Test
    public void testIteratorWithElementsHasNext()
    {
        buildList(1);
        instantiateIterators();

        assertTrue("String list Iterator has nextItem ", stringIterator.hasNext());
        assertTrue("Integer list Iterator has nextItem ", intIterator.hasNext());
        assertTrue("Char list Iterator has nextItem ", charIterator.hasNext());
        assertTrue("Double list Iterator has nextItem ", doubleIterator.hasNext());
    }

    @Test
    public void testIteratorWithElementsDoesNotHavePrevious()
    {
        buildList(1);
        instantiateIterators();

        assertFalse("String list Iterator does not have Previous", stringIterator.hasPrevious());
        assertFalse("Integer list Iterator does not have Previous ", intIterator.hasPrevious());
        assertFalse("Char list Iterator does not have Previous ", charIterator.hasPrevious());
        assertFalse("Double list Iterator does not have Previous", doubleIterator.hasPrevious());
    }

    // test Constructor public DoubleListIterator(int i)
    @Test
    public void testIteratorIndexOutOfBoundsOnEmptyList()
    {
        int[] outOfBounds = {-1, 1};


        for (int i = 0; i < outOfBounds.length; i++)
        {
            try
            {
                stringIterator = stringList.listIterator(outOfBounds[i]);
                fail("String iterator listIterator() test should have thrown exception IndexOutOfBounds for " +
                        "index[" + outOfBounds[i] + "]");
            } catch (IndexOutOfBoundsException ioobe)
            { /* Test passed */}

            try
            {
                intIterator = stringList.listIterator(outOfBounds[i]);
                fail("String iterator listIterator() test should have thrown exception IndexOutOfBounds for " +
                        "index[" + outOfBounds[i] + "]");
            } catch (IndexOutOfBoundsException ioobe)
            { /* Test passed */}

            try
            {
                charIterator = stringList.listIterator(outOfBounds[i]);
                fail("String iterator listIterator() test should have thrown exception IndexOutOfBounds for " +
                        "index[" + outOfBounds[i] + "]");
            } catch (IndexOutOfBoundsException ioobe)
            { /* Test passed */}

            try
            {
                doubleIterator = stringList.listIterator(outOfBounds[i]);
                fail("String iterator listIterator() test should have thrown exception IndexOutOfBounds for " +
                        "index[" + outOfBounds[i] + "]");
            } catch (IndexOutOfBoundsException ioobe)
            { /* Test passed */}
        }


    }

    // test public int nextIndex()

    @Test
    public void testNextIndexOnEmptyList()
    {
        instantiateIterators();
        assertEquals("Expected 0 as next index for String Iterator", 0, stringIterator.nextIndex());
        assertEquals("Expected 0 as next index for Integer Iterator", 0, intIterator.nextIndex());
        assertEquals("Expected  0 as next index for Char Iterator", 0, charIterator.nextIndex());
        assertEquals("Expected 0 as next index for Double Iterator", 0, doubleIterator.nextIndex());
    }


    @Test
    public void testNextIndexOnFullList()
    {
        int num = 5;

        buildList(num);
        instantiateIterators();

        assertEquals("Expected 0 as next index for String Iterator", 0, stringIterator.nextIndex());
        assertEquals("Expected 0 as next index for Integer Iterator", 0, intIterator.nextIndex());
        assertEquals("Expected 0 as next index for Char Iterator", 0, charIterator.nextIndex());
        assertEquals("Expected 0 as next index for Double Iterator", 0, doubleIterator.nextIndex());

        for (int i = 0; i < num; i++)
        {
            stringIterator.next();
            intIterator.next();
            charIterator.next();
            doubleIterator.next();

            assertEquals("Expected " + (i + 1) + " as next index for String Iterator", i + 1, stringIterator.nextIndex());
            assertEquals("Expected  " + (i + 1) + "as next index for Integer Iterator", i + 1, intIterator.nextIndex());
            assertEquals("Expected " + (i + 1) + " as next index for Char Iterator", i + 1, charIterator.nextIndex());
            assertEquals("Expected " + (i + 1) + " as next index for Double Iterator", i + 1, doubleIterator.nextIndex());
        }
    }


    // test public int previousIndex()

    @Test
    public void testPreviousIndexOnEmtpyList()
    {
        instantiateIterators();
        assertEquals("Expected 0 as next index for String Iterator", -1, stringIterator.previousIndex());
        assertEquals("Expected 0 as next index for Integer Iterator", -1, intIterator.previousIndex());
        assertEquals("Expected  0 as next index for Char Iterator", -1, charIterator.previousIndex());
        assertEquals("Expected 0 as next index for Double Iterator", -1, doubleIterator.previousIndex());
    }

    @Test
    public void testPreviousIndexOnFullList()
    {
        int num = 5;

        buildList(num);
        instantiateIterators(num);

        for (int i = num; i > 0; i--)
        {
            assertEquals("Expected " + (i - 1) + " as next index for String Iterator", i - 1, stringIterator.previousIndex());
            assertEquals("Expected  " + (i - 1) + "as next index for Integer Iterator", i - 1, intIterator.previousIndex());
            assertEquals("Expected " + (i - 1) + " as next index for Char Iterator", i - 1, charIterator.previousIndex());
            assertEquals("Expected " + (i - 1) + " as next index for Double Iterator", i - 1, doubleIterator.previousIndex());

            stringIterator.previous();
            intIterator.previous();
            charIterator.previous();
            doubleIterator.previous();
        }

        assertEquals("Expected 4 as next index for String Iterator", -1, stringIterator.previousIndex());
        assertEquals("Expected 4 as next index for Integer Iterator", -1, intIterator.previousIndex());
        assertEquals("Expected 4 as next index for Char Iterator", -1, charIterator.previousIndex());
        assertEquals("Expected 4 as next index for Double Iterator", -1, doubleIterator.previousIndex());
    }


    // test public void remove()
    @Test
    public void testRemoveFromEmptyListThrowsException()
    {
        instantiateIterators();
        try
        {
            stringIterator.remove();
            fail("String iterator remove() test should have thrown exception NoSuchElementException");
        } catch (NoSuchElementException e)
        { /* Test passed */}

        try
        {
            intIterator.remove();
            fail("Integer iterator remove() test should have thrown exception NoSuchElementException");
        } catch (NoSuchElementException e)
        { /* Test passed */}

        try
        {
            charIterator.remove();
            fail("Character iterator remove() test should have thrown exception NoSuchElementException");
        } catch (NoSuchElementException e)
        { /* Test passed */}

        try
        {
            doubleIterator.remove();
            fail("Double iterator remove() test should have thrown exception NoSuchElementException");
        } catch (NoSuchElementException e)
        { /* Test passed */}
    }


    @Test
    public void testRemoveThrowsExceptionAfterAddingElements()
    {
        instantiateIterators();
        addElementsWithIterator(1);
        try
        {
            stringIterator.remove();
            fail("String iterator remove() test should have thrown exception NoSuchElementException");
        } catch (NoSuchElementException e)
        { /* Test passed */}

        try
        {
            intIterator.remove();
            fail("Integer iterator remove() test should have thrown exception NoSuchElementException");
        } catch (NoSuchElementException e)
        { /* Test passed */}

        try
        {
            charIterator.remove();
            fail("Character iterator remove() test should have thrown exception NoSuchElementException");
        } catch (NoSuchElementException e)
        { /* Test passed */}

        try
        {
            doubleIterator.remove();
            fail("Double iterator remove() test should have thrown exception NoSuchElementException");
        } catch (NoSuchElementException e)
        { /* Test passed */}
    }

    @Test
    public void testRemoveAfterUsingNext()
    {
        int num, expected;
        num = 5;
        buildList(5);
        instantiateIterators();

        for (int i = 0; i < num; i++)
        {
            // Invoke next()
            stringIterator.next();
            intIterator.next();
            charIterator.next();
            doubleIterator.next();

            // Invoke remove()
            stringIterator.remove();
            intIterator.remove();
            charIterator.remove();
            doubleIterator.remove();

            expected = num - i - 1;

            assertEquals("String list should now be of size " + expected + " after removing element", expected, stringList.size());
            assertEquals("Integer list should now be of size " + expected + " after removing element", expected, intList.size());
            assertEquals("Character list should now be of size " + expected + " after removing element", expected, charList.size());
            assertEquals("Double list should now be of size " + expected + " after removing element", expected, doubleList.size());
        }
    }

    @Test
    public void testRemoveAfterUsingPrevious()
    {
        int num = 5;
        buildList(num);
        instantiateIterators(num);

        for (int i = num; i > 0; i--)
        {
            // Invoke previous()
            stringIterator.previous();
            intIterator.previous();
            charIterator.previous();
            doubleIterator.previous();

            // Invoke remove()
            stringIterator.remove();
            intIterator.remove();
            charIterator.remove();
            doubleIterator.remove();

            assertEquals("String list should now be of size " + (i - 1) + "after removing element", i - 1, stringList.size());
            assertEquals("Integer list should now be of size " + (i - 1) + " after removing element", i - 1, intList.size());
            assertEquals("Character list should now be of size " + (i - 1) + " after removing element", i - 1, charList.size());
            assertEquals("Double list should now be of size " + (i - 1) + " after removing element", i - 1, doubleList.size());
        }

    }

    // test public void set(E e)
    @Test
    public void testSetOnEmptyListThrowsException()
    {
        instantiateIterators();

        try
        {
            stringIterator.set(STRING_VALUES[0]);
            fail("String iterator set() test should have thrown exception IllegalStateException");
        } catch (IllegalStateException e)
        { /* Test passed */}

        try
        {
            intIterator.set(INT_VALUES[0]);
            fail("Integer iterator set() test should have thrown exception IllegalStateException");
        } catch (IllegalStateException e)
        { /* Test passed */}

        try
        {
            charIterator.set(CHAR_VALUES[0]);
            fail("Character iterator set() test should have thrown exception IllegalStateException");
        } catch (IllegalStateException e)
        { /* Test passed */}

        try
        {
            doubleIterator.set(DOUBLE_VALUES[0]);
            fail("Double iterator set() test should have thrown exception IllegalStateException");
        } catch (IllegalStateException e)
        { /* Test passed */}
    }

    @Test
    public void testSetWithoutCallingNextPreviousThrowsException()
    {
        instantiateIterators();

        stringIterator.add(STRING_VALUES[0]);
        intIterator.add(INT_VALUES[0]);
        charIterator.add(CHAR_VALUES[0]);
        doubleIterator.add(DOUBLE_VALUES[0]);

        try
        {
            stringIterator.set(STRING_VALUES[1]);
            fail("String iterator set() test should have thrown exception IllegalStateException");
        } catch (IllegalStateException e)
        { /* Test passed */}

        try
        {
            intIterator.set(INT_VALUES[1]);
            fail("Integer iterator set() test should have thrown exception IllegalStateException");
        } catch (IllegalStateException e)
        { /* Test passed */}

        try
        {
            charIterator.set(CHAR_VALUES[1]);
            fail("Character iterator set() test should have thrown exception IllegalStateException");
        } catch (IllegalStateException e)
        { /* Test passed */}

        try
        {
            doubleIterator.set(DOUBLE_VALUES[1]);
            fail("Double iterator set() test should have thrown exception IllegalStateException");
        } catch (IllegalStateException e)
        { /* Test passed */}
    }

    @Test
    public void testSetReplacesElements()
    {
        int num = 5;
        buildList(num);
        instantiateIterators();

        for (int i = 0; i < num; i++)
        {
            stringIterator.next();
            intIterator.next();
            charIterator.next();
            doubleIterator.next();

            stringIterator.set(STRING_INSERT_VALUES[i]);
            intIterator.set(INT_INSERT_VALUES[i]);
            charIterator.set(CHAR_INSERT_VALUES[i]);
            doubleIterator.set(DOUBLE_INSERT_VALUES[i]);
        }

        for (int i = 0; i < num; i++)
        {
            assertEquals("String iterator should have replaced " + STRING_VALUES[i] + " with " + STRING_INSERT_VALUES[i],
                    STRING_INSERT_VALUES[i], stringList.get(i));

            assertEquals("Integer iterator should have replaced " + INT_VALUES[i] + " with " + INT_INSERT_VALUES[i],
                    STRING_INSERT_VALUES[i], stringList.get(i));

            assertEquals("Character iterator should have replaced " + CHAR_VALUES[i] + " with " + CHAR_INSERT_VALUES[i],
                    STRING_INSERT_VALUES[i], stringList.get(i));

            assertEquals("Double iterator should have replaced " + DOUBLE_VALUES[i] + " with " + DOUBLE_INSERT_VALUES[i],
                    STRING_INSERT_VALUES[i], stringList.get(i));
        }
    }

}
