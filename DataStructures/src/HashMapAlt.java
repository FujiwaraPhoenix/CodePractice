
public class HashMapAlt {
	public HashPair[] map;
	public final static int INITIAL_MAP_SIZE = 10;
	public int keyCount;

	public int GenerateHashCode(String key) {
		int output =  key.hashCode() % INITIAL_MAP_SIZE;
		if (output < 0) {
			output *= -1;
		}
		return output;
	}
	
	
	public int FindData(String keyCheck) {
		return FindMatchInList(keyCheck, map[GenerateHashCode(keyCheck)]).value;
	}
	
	//This function returns a HashPair from a given starting point of a single linked list.
	public HashPair FindMatchInList(String keyCheck, HashPair start) {
		if (start.key.equals(keyCheck)) {
			return start;
		}
		else if (start.nextPair != null) {
			return FindMatchInList(keyCheck, start.nextPair);
		}
		return null;
	}
	
	public void AddPair(String newKey, int newValue) {
		int position = GenerateHashCode(newKey);
		HashPair newPair = new HashPair(newKey, newValue);
		//Find an empty slot.
		if (map[position] == null) {
			map[position] = newPair;
			keyCount++;
		}
		else {
			if (!(CheckListForKey(map[position], newKey))) {
				FindNextOpen(map[position]).nextPair = newPair;
				keyCount++;
			}
			else {
				System.out.println("A key/value pair already exists for the given key. Updating pair.");
				ReplaceValue(newKey, newValue);
			}
		}
	}
	
	public HashPair FindNextOpen(HashPair start) {
		if (start.nextPair == null) {
			return start;
		}
		else {
			return FindNextOpen(start.nextPair);
		}
	}
	
	public boolean ContainsKey(String keyCheck) {
		HashPair startPoint = map[GenerateHashCode(keyCheck)];
		if (startPoint != null) {
			return CheckListForKey(startPoint, keyCheck);
		}
		return false;
	}
	
	public boolean CheckListForKey(HashPair start, String keyCheck) {
		if (start != null) {
			if (start.key.equals(keyCheck)) {
				return true;
			}
			else {
				return CheckListForKey(start.nextPair, keyCheck);
			}
		}
		return false;
	}
	
	public void ReplaceValue(String key, int newValue) {
		if (ContainsKey(key)) {
			HashPair toEdit = FindPair(key);
			toEdit.value = newValue;
		}
		else {
			System.out.println("A key/value pair does not exist for the given key.");
		}
	}
	
	public HashPair FindPair(String key) {
		int position = GenerateHashCode(key);
		return FindPairInList(map[position], key);
	}
	
	
	public HashPair FindPairInList(HashPair start, String keyCheck) {
		if (start != null) {
			if (start.key.equals(keyCheck)) {
				return start;
			}
			else {
				return null;
			}
		}
		return null;
	}
	
	public void RemovePair(String key) {
		if (ContainsKey(key)) {
			HashPair startPoint = map[GenerateHashCode(key)];
			if (startPoint.key.equals(key)){
				if (startPoint.nextPair != null) {
					map[GenerateHashCode(key)] = startPoint.nextPair;
				}
				else {
					map[GenerateHashCode(key)] = null;
				}
				keyCount--;
			}
			else {
				RemoveNextKey(map[GenerateHashCode(key)], key);
			}
		}
	}
	
	private void RemoveNextKey(HashPair startPoint, String key) {
		if (startPoint.nextPair != null) {
			if (startPoint.nextPair.key.equals(key)) {
				RemoveNext(startPoint);
				keyCount--;
			}
			else {
				RemoveNextKey(startPoint.nextPair, key);
			}
		}
	}
	
	private void RemoveNext(HashPair previous) {
		HashPair nextnext = previous.nextPair.nextPair;
		if (nextnext != null) {
			previous.nextPair = nextnext;
		}
		else {
			previous.nextPair = null;
		}
	}
	
	public HashMapAlt() {
		map = new HashPair[INITIAL_MAP_SIZE];
	}
	
	public class HashPair{
		public String key;
		public int value;
		public HashPair nextPair;
		
		public HashPair(String newKey, int newValue) {
			key = newKey;
			value = newValue;	
		}
		
		public void SetNext(HashPair newNext) {
			nextPair = newNext;
		}
	}
}
