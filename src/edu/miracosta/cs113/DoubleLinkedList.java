/**
 * @author Carlos Sanchez
 * @version 1.01
 * @since 2-23-2015
 * <p>
 * DoubleLinkedList.java : This doubled linked list that holds generic data along with methods for adding, removing
 * and finding elements in list. This DoubleLinkedList implements the List<E> interface and also hold two inner
 * classes DoubleListIterator and Node which are used by DoubleLinkedList.
 */

 /*
 - head : Node
 - tail : Node
 - size : int

 - setAll
 + iterator() : Iterator<E>
 + listIterator() : ListIterator<E>
 + listIterator(index : int) : ListIterator<E>
 + add(e : E) : boolean
 + add(index : int, element : E) : void
 + clear() : void
 + equals(o : Object) : boolean
 + contains ( o : Object) : boolean
 + get(index : int) : E
 + indexOf(Object o) : int
 + lastIndexOf(o : Object) : int
 + isEmpty() : boolean
 + remove ( index : int) : E
 + remove(o : Object) : boolean
 + set ( index : int, element : E) : E
 + size() : int
 + toString() : String
*/

package edu.miracosta.cs113;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * DoubleLinkedList class implements most List<E> Interface.
 *
 * @param <E> Generic data type that will be stored by inner Node class.
 */
public class DoubleLinkedList<E> implements List<E>
{
    // Local variables
    private Node head;
    private Node tail;
    private int size;

    /**
     * Default constructor sets head and tail to null while size gets set to 0.
     */
    public DoubleLinkedList()
    {
        this.setAll(null, null, 0);
    }

    /**
     * Convenient set all helper method.
     *
     * @param head the head reference.
     * @param tail the tail reference.
     * @param size the size to set list to.
     */
    private void setAll(Node head, Node tail, int size)
    {
        this.head = head;
        this.tail = tail;
        this.size = size;
    }

    @Override
    public Iterator<E> iterator()
    {
        return new DoubleListIterator();
    }

    @Override
    public ListIterator<E> listIterator()
    {
        return new DoubleListIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index)
    {
        return new DoubleListIterator(index);
    }

    @Override
    public boolean add(E e)
    {

        listIterator(this.size).add(e);
        return true;
    }

    @Override
    public void add(int index, E element)
    {
        listIterator(index).add(element);
    }

    @Override
    public void clear()
    {
        this.head = null;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == null || this.getClass() != o.getClass())
        {
            return false;
        }
        else
        {
            DoubleLinkedList other = (DoubleLinkedList) o;
            return this.toString() == other.toString();
        }
    }

    @Override
    public boolean contains(Object o)
    {
        // special case list is empty
        if (this.size() == 0)
        {
            return false;
        }

        ListIterator iterator = this.listIterator();

        while (iterator.hasNext())
        {
            Object local = iterator.next();
            if (local.equals(o))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int index)
    {
        checkOutOfBounds(index);
        return listIterator(index).next();
    }

    @Override
    public int indexOf(Object o)
    {
        int location;

        if (size != 0)
        {
            location = 0;

            ListIterator iterator = this.listIterator();

            while (iterator.hasNext())
            {
                Object local = iterator.next();
                if (local.equals(o))
                {
                    return location;
                }

                location++;
            }
        }

        return -1;
    }


    @Override
    public int lastIndexOf(Object o)
    {
        int location;

        if (size != 0)
        {
            location = this.size() - 1;

            ListIterator iterator = this.listIterator(this.size());

            while (iterator.hasPrevious())
            {
                Object local = iterator.previous();
                if (local.equals(o))
                {
                    return location;
                }
                location--;
            }
        }

        return -1;

    }

    @Override
    public boolean isEmpty()
    {
        return (head == null);
    }

    @Override
    public E remove(int index)
    {
        E elementToReturn;

        checkOutOfBounds(index);
        ListIterator iterator = listIterator(index);
        elementToReturn = (E) iterator.next();
        iterator.remove();

        return elementToReturn;
    }

    @Override
    public boolean remove(Object other)
    {
        // local variables
        Object local;
        ListIterator iterator;

        if (this.size() == 0)
        {
            return false;
        }
        else
        {
            iterator = listIterator();

            while (iterator.hasNext())
            {
                local = iterator.next();

                if (local.equals(other))
                {
                    iterator.remove();
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public E set(int index, E element)
    {
        // local variables
        E elementToReturn;
        ListIterator iterator;

        // checking out of bounds
        checkOutOfBounds(index);

        // set iterator at desired index
        iterator = listIterator(index);

        // store element to return before replacing it
        elementToReturn = (E) iterator.next();

        // replace the element at index given
        iterator.set(element);

        // return the element we replaced
        return elementToReturn;
    }

    @Override
    public int size()
    {
        return this.size;
    }


    @Override
    public String toString()
    {
        // local variables
        DoubleListIterator iterator;
        String listContent;

        // initialize
        iterator = new DoubleListIterator();
        listContent = "[";

        // add list contents to string
        while (iterator.hasNext())
        {
            listContent += iterator.next().toString();
            if (iterator.hasNext())
            {
                listContent += ", ";
            }
        }

        return listContent + "]";
    }

    /**
     * adds index location for each item in list.
     *
     * @return String with indexed list content.
     */
    public String indexedToString()
    {
        String listContent, index;
        Node currentPosition;

        listContent = "Size: " + this.size + "\n";

        currentPosition = this.head;

        for (int i = 0; i < this.size; i++)
        {

            index = String.format("[%d]", i);
            listContent += String.format("%s %s", index, currentPosition.data);

            // Add comma
            if (i != this.size - 1)
            {
                listContent += ", ";
            }
            currentPosition = currentPosition.next;
        }

        return listContent;
    }


    /**
     * Helper Method: checks index is within bounds of list.
     * index must be equal to or higher then zero and lower list size.
     *
     * @param index the index to check is withing bounds.
     */
    private void checkOutOfBounds(int index)
    {
        if (index < 0 || index >= this.size)
        {
            throw new IndexOutOfBoundsException("Invalid index " + index);
        }
    }


    //------------------- STUBS-----------------------//

    @Override
    public Object[] toArray()
    {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a)
    {
        return null;
    }

    @Override
    public boolean containsAll(Collection<?> c)
    {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c)
    {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c)
    {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c)
    {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        return false;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex)
    {
        return null;
    }


    /**
     * **********************************************************************************
     * CustomListIterator : implements ListIterator<E>
     * Used to traverse double linked list and add, remove, check for data.
     * **********************************************************************************
     */
    private class DoubleListIterator implements ListIterator<E>
    {
        // Local variables
        private Node<E> nextItem;
        private Node<E> lastItemReturned;
        private int index;

        /**
         * Default constructor, sets next Item and lastItem Returned to null. sets index to 0.
         */
        public DoubleListIterator()
        {
            this.nextItem = head;
            this.lastItemReturned = null;
            index = 0;
        }

        /**
         * Index Constructor, instantiates iterator with index set at required location.
         * index must be bigger then 0 and lower then list size.
         *
         * @param i the index to set iterator at.
         */
        public DoubleListIterator(int i)
        {
            // out of bounds check
            if (i < 0 || i > size)
            {
                throw new IndexOutOfBoundsException("Invalid index " + i);
            }

            lastItemReturned = null;  // No item returned yet.

            // special case, last item
            if (i == size)
            {
                index = size;
                nextItem = null;
            }
            else // start at beginning
            {
                nextItem = head;
                for (index = 0; index < i; index++)
                {
                    nextItem = nextItem.next;
                }
            }
        }

        @Override
        public void add(E e)
        {
            Node<E> newNode;


            // if list is empty
            if (head == null)
            {
                head = new Node<E>(e);
                tail = head;
            }
            // if the next item is the head
            else if (nextItem == head)
            {
                newNode = new Node<E>(e);
                newNode.next = nextItem;    // link new node with next Item
                nextItem.previous = newNode;  // link nextItems's previous reference with new node
                head = newNode;     // assign new node as head
            }
            else if (nextItem == null)
            {
                newNode = new Node<E>(e);
                tail.next = newNode;
                newNode.previous = tail;
                tail = newNode;
            }
            else
            {
                newNode = new Node<E>(e);
                newNode.previous = nextItem.previous;
                nextItem.previous.next = newNode;
                newNode.next = nextItem;
                nextItem.previous = newNode;
            }

            size++;
            index++;
            lastItemReturned = null;
        }

        @Override
        public boolean hasNext()
        {
            // if nextItem == null returns false
            // else nextItem != null returns true
            return nextItem != null;
        }

        @Override
        public boolean hasPrevious()
        {
            // return true if nextItem is null and list is not empty
            // or nextItem's previous is not null
            return (nextItem == null && size != 0)
                    || nextItem.previous != null;
        }

        @Override
        public E next()
        {
            if (!hasNext())
            {
                throw new NoSuchElementException();
            }
            lastItemReturned = nextItem;
            nextItem = nextItem.next;
            index++;
            return lastItemReturned.data;
        }

        @Override
        public int nextIndex()
        {
            return index;
        }

        @Override
        public E previous()
        {
            if (!hasPrevious())
            {
                throw new NoSuchElementException();
            }
            if (nextItem == null)
            {
                nextItem = tail;
            }
            else
            {
                nextItem = nextItem.previous;
            }
            lastItemReturned = nextItem;
            index--;
            return lastItemReturned.data;
        }


        @Override
        public int previousIndex()
        {
            return index - 1;
        }

        @Override
        public void remove()
        {
            // if list is empty or no item was returned
            if (isEmpty() || lastItemReturned == null)
            {
                throw new NoSuchElementException();
            }
            else
            {
                // only one node in list
                if (size() == 1)
                {
                    head = null;
                }

                // first node in list
                else if (lastItemReturned.previous == null)
                {
                    head = nextItem;
                    lastItemReturned.next.previous = null;
                }
                // last node in list
                else if (lastItemReturned.next == null)
                {
                    lastItemReturned.previous.next = null;
                }
                else // everything else in between
                {
                    lastItemReturned.previous.next = lastItemReturned.next;
                    lastItemReturned.next.previous = lastItemReturned.previous;
                }
                size--;
                lastItemReturned = null;
            }
        }

        @Override
        public void set(E e)
        {
            if (lastItemReturned == null)
            {
                throw new IllegalStateException();
            }
            else
            {
                lastItemReturned.data = e;
                lastItemReturned = null;
            }
        }
    }


    /**
     * **************************************************************************************
     * This is the inner Node class to be used by DoubleLinkedList class.  It stores a
     * Generic E data type along with a reference to it's next and previous node.
     *
     * @param <E> The data type to assign to this node.
     ****************************************************************************************/
    private static class Node<E>
    {
        // class variables
        private E data;
        private Node<E> next;
        private Node<E> previous;

        /**
         * Default constructor for node class, all local variables are set to null.
         */
        public Node()
        {
            this.setAll(null, null, null);
        }

        /**
         * Partial constructors sets local Generic E data to value given.
         *
         * @param dataItem the Generic E data to set this node to.
         */
        public Node(E dataItem)
        {
            this.setAll(dataItem, null, null);
        }

        /**
         * Full constructor for Inner node class
         *
         * @param newData      that data to copy over;
         * @param nextNode     the reference to the next node.
         * @param previousNode the reference to the previous node.
         */
        public Node(E newData, Node<E> nextNode, Node<E> previousNode)
        {
            this.setAll(newData, nextNode, previousNode);
        }

        /**
         * Sets all local variables to given paramaters.
         *
         * @param dataItem     the Generic E data to set this node to.
         * @param nextNode     the reference to the next Node.
         * @param previousNode the reference to the previous Node.
         */
        public void setAll(E dataItem, Node nextNode, Node previousNode)
        {
            this.data = dataItem;
            this.next = nextNode;
            this.previous = previousNode;
        }
    }
}
