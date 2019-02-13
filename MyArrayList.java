// @author Kristen Lee
// @date 02-09-2019
class MyArrayList<E>{
  int DEFAULT_CAPACITY = 10;
  int size;
  int capacity;
  E array[];

/** Initializes the object, if given capacity, will get to parameter.
  * @param capacity
  */
  @SuppressWarnings("unchecked")
  MyArrayList(int capacity){
    this.capacity = capacity;
    this.size = 0;
    this.array = (E[]) new Object[capacity];
  }
/** Default constructor that makes an array of 10.
  */
  MyArrayList(){
    this.capacity = this.DEFAULT_CAPACITY;
    this.size = 0;
    this.array = (E[]) new Object[DEFAULT_CAPACITY];
  }
/** Adds the element to the end of the array list.
  * if there is not enough space, reallocate so capacity is doubled.
  * @param element to add
  */
  void add(E element){
    ensureCapacity(this.size);
    this.array[this.size] = element;
    this.size++;
  }
/** Adds the element to the specified position in the list.
  * @param integer index
  * @param element to add
  */
  void add(int index, E element){
    ensureCapacity(this.size);
    E spare[] = (E[]) new Object[this.size];
    int k = 0;
    for(int i = index; i < this.size + 1; i++){//copy the array over
      spare[k] = this.array[i];
      this.array[i] = null;
      k++;
    }//
    this.array[index] = element;
    this.size++;
    int j = 0;
    for(int i = index+1; i < this.size; i++){
      this.array[i] = spare[j];
      j++;
    }
  }
/** Removes every element of the array list setting them to null
  */
  void clear(){
    for(E element:this.array){element = null;}
    this.size = 0;
    this.capacity = DEFAULT_CAPACITY;
  }
/** Returns whether or not the element is present inside the arraylist.
  * @param e element to search for
  * @return boolean true if found
  */
  boolean contains(E element){
    for(E each:this.array){
      if(each == element) return true;
    }
    return false;
  }
/** Ensures the array list current capacity is at least the number specified/
  * @param integer capacity
  */
  void ensureCapacity(int capacity){
    if(capacity == this.capacity){
      this.capacity *= 2;//new capacity is current times 2
      MyArrayList<E> larger_array = new MyArrayList<E>(this.capacity);
      System.arraycopy(this.array, 0, larger_array, 0, this.capacity);
      this.array = (E[]) new Object[this.capacity];//store back to the global
      System.arraycopy(larger_array, 0, this.array, 0, this.capacity/2);
    }
  }
/** Find Index that returns index of first instance
  * @return int index or -1 if not found
  */
  int findIndex(E element){
    for(int i = 0; i < this.size; i++){
      if(this.array[i] == element) return i;
    }
    return -1;
  }
/** returns the element at given index
  * @param index
  * @return element
  */
  E get(int index) throws IndexOutOfBoundsException {
    if(index <= this.size) return this.array[index];
    else {throw new IndexOutOfBoundsException();}
  }
/** return the current capacity of the array list
  * @return int capacity
  */
  int getCapacity(){
    return this.capacity;
  }
/** Return the current amount of items in array list
  * @return int size
  */
  int getSize(){
    return this.size;
  }
/** return true if array list is empty, else return false
  * @return boolean true if empty
  */
  boolean isEmpty(){
    for(E element:this.array){
      if(element != null) return false;
    }
    return true;
  }
/** Removes the object from the specified index of array list. all subsequent elements are shifted.
  * @param int index to remove
  */
  void remove(int index)throws IndexOutOfBoundsException{
    if(index > this.size-1)throw new IndexOutOfBoundsException();
    else{
      this.array[index] = null;
      this.size--;
      int j = index;
      for(int i = index+1; i < this.size; i++){
        array[j] = array[i];
      }
    }
  }
/** overwrites the element at the given index.
  * @param int index
  * @param e element
  */
  void set(int index, E element)throws IndexOutOfBoundsException{
    if(index > this.size-1) throw new IndexOutOfBoundsException();
    else{
      array[index] = element;
    }
  }
/** returns string representation of array list
  * @return string
  */
  @Override
  public String toString(){
    StringBuilder builder = new StringBuilder("[");
    for(int i = 0; i < this.size; i++){
      if(i != 0) builder.append(", ");
      builder.append(array[i]);
    }
    builder.append("]");
    return builder.toString();
  }
  //main method
  public static void main(String[] args){
    // MyArrayList<Integer> array = new MyArrayList<Integer>();
    // array.add(42);
    // array.add(4);
    // array.add(12);
    // array.add(52);
    // array.add(6);
    // array.add(75);
    // array.add(13);
    // array.add(24);
    // array.add(3,23);
    // System.out.println(array.toString());
    // System.out.println("array is empty: " + array.isEmpty());
    // System.out.println("array capacity: " + array.getCapacity());
    // System.out.println("array size: " + array.getSize());
    // System.out.println("element at 4: " + array.get(4));
    // System.out.println("number 6 is in index: " + array.findIndex(6));
    // System.out.println("the list contains 45: " + array.contains(45));
  }
}
