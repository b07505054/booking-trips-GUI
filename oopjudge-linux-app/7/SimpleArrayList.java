import java.util.Arrays;

public class SimpleArrayList {
    Integer[] arrayList;

    /**
     * Default constructor that sets the array size to zero.
     */
    public SimpleArrayList() {
        this.arrayList = new Integer[0];
    }

    /**
     * Constructor that can set initial array size, and set all Integer to zero in
     * the array.
     *
     * @param initialSize the initial size of arrayList.
     */
    public SimpleArrayList(int initialSize) {
        this.arrayList = new Integer[initialSize];

        for (int i = 0; i < this.arrayList.length; i++) {
            this.arrayList[i] = 0;
        }
    }

    /**
     * Appends the specified element to the end of this array.
     *
     * @param i
     */
    public void add(Integer i) {
        this.arrayList = Arrays.copyOf(this.arrayList, this.arrayList.length + 1);
        this.arrayList[this.arrayList.length - 1] = i;
    }

    /**
     * Returns the element at the specified position in this array. If the specified
     * position is out of range of the array, returns null.
     *
     * @param index the index of arrayList
     * @return arrayList[index], if out of range, null.
     */
    public Integer get(int index) {
        if (index < this.arrayList.length && index >= 0) {
            return this.arrayList[index];
        } else {
            return null;
        }
    }

    /**
     * Replaces the element at the specified position in this array with the
     * specified element, and returns the original element at that specified
     * position. If the specified position is out of range of the array, returns
     * null.
     *
     * @param index   the index of arrayList.
     * @param element the new element of arrayList[index].
     * @return the original element of arrayList, if out of range, null.
     */
    public Integer set(int index, Integer element) {
        if (index < this.arrayList.length && index >= 0) {
            Integer originalElement = this.arrayList[index];
            this.arrayList[index] = element;

            return originalElement;
        } else {
            return null;
        }
    }

    /**
     * Removes arrayList[index] and shifts every element after it to the left.
     *
     * @param index the index of arrayList.
     * @return false if arrayList[index] is null, otherwise true is returned.
     */
    public boolean remove(int index) {
        if (get(index) == null) {
            return false;
        } else {

            for (int i = index; i < this.arrayList.length - 1; i++) {
                this.arrayList[i] = this.arrayList[i + 1];
            }

            this.arrayList = Arrays.copyOf(this.arrayList, this.arrayList.length - 1);

            return true;
        }
    }

    /**
     * Removes all of the elements from this array.
     */
    public void clear() {
        this.arrayList = new Integer[0];
    }

    /**
     * Returns the number of elements in this array.
     *
     * @return the number of elements in this array.
     */
    public int size() {
        return this.arrayList.length;
    }

    /**
     * Retains only the elements in this array that are contained in the specified
     * SimpleArrayList. In other words, removes from this array all of its elements
     * that are not contained in the specified SimpleArrayList. Returns true if this
     * array changed as a result.
     *
     * @param l a SimpleArrayList object.
     * @return true if list is changed, returns false otherwise.
     */
    public boolean retainAll(SimpleArrayList l) {
        boolean shouldBeRetained;
        Integer[] originalArrayList = Arrays.copyOf(this.arrayList, this.arrayList.length);

        for (int i = 0; i < this.arrayList.length; i++) {

            shouldBeRetained = false;

            for (int j = 0; j < l.size(); j++) {
                if (this.arrayList[i] == l.get(j)) {
                    shouldBeRetained = true;
                }
            }

            if (!shouldBeRetained) {
                remove(i);
            }
        }
        return !Arrays.equals(this.arrayList, originalArrayList);
    }

    /**
     * Prints the content of arrayList
     */
    public void showContent() {
        System.out.println(Arrays.toString(this.arrayList));
    }

}
