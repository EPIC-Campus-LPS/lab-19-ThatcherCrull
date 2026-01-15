public interface List<E> {

    /**
     * Add an element to the end of the list
     * @param element element to add to the list
     */
    public void add(E element);

    /**
     * Add an element to the list at index i
     * If index is invalid, throws IndexOutOfBoundsException
     * @param i index of the element
     * @param element element to add to the list
     */
    public void add(int i, E element) throws IndexOutOfBoundsException;

    /**
     * Removes all elements from the list
     */
    public E remove();

    /**
     * Remove element at index i
     * If index is invalid, throws IndexOutOfBoundsException
     * @param i index of the element to remove
     * @return the element that was removed
     */
    public Node<E> remove(int i) throws IndexOutOfBoundsException;

    /**
     * Gets the element at index i
     * If index is invalid, throws IndexOutOfBoundsException
     * @param i index of the element
     * @return the element
     */
    public Node<E>  get(int i) throws IndexOutOfBoundsException;

    /**
     * Sets the element at i to a new value
     * If index is invalid, throws IndexOutOfBoundsException
     * @param i index of the element to set
     * @param element new value of the element
     */
    public void set(int i, E element) throws IndexOutOfBoundsException;

    /**
     * Returns the size of the list
     * @return the size of the list
     */
    public int size();

    /**
     * Returns true if the list is empty and false if there are elements
     * @return
     */
    public boolean isEmpty();

    /**
     * Prints out the list in the format [value1, value2, value3, …]
     * @return a String of the list
     */
    @Override
    public String toString();


}
