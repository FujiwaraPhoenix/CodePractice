public class ArrayListAlt<E> {
	E[] objList;
	int INITIAL_ARRAY_LENGTH = 10;
	int lastIndex = 0;
	
	private void IncreaseSize() {
		int newSize = (int)(objList.length * 1.5f) + 2;
		System.out.println("New size: " + newSize);
		E[] newArray = (E[])new Object[newSize];
		for(int i = 0; i < objList.length; i++) {
			newArray[i] = (E)objList[i];
		}
		objList = newArray;
	}
	
	public void Add(E newObj) {
		//Adds a new object of type E to the end of the ArrayList's current value set.
		//lastIndex points to the next open point in the array.
		if (objList.length - 1 < lastIndex) {
			IncreaseSize();
		}
		objList[lastIndex] = newObj;
		lastIndex++;
	}
	
	public void RemoveAt(int index) {
		//Removes the object at the given index.
		//Confirm that the index is less than the current size to proceed, else fizzle.
		ValidityCheck(index);
		System.arraycopy(objList, index + 1, objList, index, lastIndex - index - 1);
		if (lastIndex > 0)
		lastIndex--;	
	}
	
	public void ReplaceAt(int index, E newItem) {
		ValidityCheck(index);
		objList[index] = newItem;
	}
	
	public E Get(int index) {
		ValidityCheck(index);
		return objList[index];
	}
	
	private void ValidityCheck(int input) {
		if (input > lastIndex || input < 0) {
			throw new IllegalArgumentException();
		}
	}
	
	public ArrayListAlt(){
		//The default initialization size is 10 for an ArrayList.
		objList = (E[])new Object[INITIAL_ARRAY_LENGTH];
	}

	public ArrayListAlt(int initSize) {
		//Initializes an ArrayList of size initSize.
		if (initSize < 1) {
			throw new IllegalArgumentException();
		}
		objList = (E[])new Object[initSize];
	}
	
	public ArrayListAlt(E[] inputArray) {
		//Initializes an ArrayList of size initSize.
		objList = inputArray;
	}
}
