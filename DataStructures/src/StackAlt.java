public class StackAlt<E> {
	E[] objList;
	int INITIAL_ARRAY_LENGTH = 10;
	int lastIndex = 0;
	
	//A stack is FILO.
	
	private void IncreaseSize() {
		int newSize = (int)(objList.length * 1.5f) + 2;
		System.out.println("New size: " + newSize);
		E[] newArray = (E[])new Object[newSize];
		for(int i = 0; i < objList.length; i++) {
			newArray[i] = (E)objList[i];
		}
		objList = newArray;
	}
	
	public void Push(E newItem) {
		if (objList.length - 1 < lastIndex) {
			IncreaseSize();
		}
		objList[lastIndex] = newItem;
		lastIndex++;
	}
	
	public E Pop() {
		E toBeRemoved = Peek();
		objList[lastIndex] = null;
		lastIndex--;
		return toBeRemoved;
	}
	
	public E Peek() {
		return objList[lastIndex-1];
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
	
	public StackAlt(){
		//The default initialization size is 10 for an ArrayList.
		objList = (E[])new Object[INITIAL_ARRAY_LENGTH];
	}

}
