public class Solution06 {
	public String convert(String s, int numRows) {
		String[] bucketList = new String[numRows];
		String output = "";
		int addedCounter = 0;
		int increment = 1;
		if (numRows == 1) {
			return s;
		}
		for (int i = 0; i < s.length(); i++) {
			if (bucketList[addedCounter] == null) {
				bucketList[addedCounter] = "";
			}
			bucketList[addedCounter] += String.valueOf(s.charAt(i));
			addedCounter += increment;
			if (addedCounter == numRows || addedCounter < 0) {
				increment *= -1;
				addedCounter = addedCounter + (increment * 2);
			}
		}
		for (int i = 0; i < numRows; i++) {
			output += bucketList[i];
		}
		return output;
    }
	
	public static void main(String[] args) {
		Solution06 sol06 = new Solution06();
		System.out.println(sol06.convert("PAYPALISHIRING", 4));
	}
}
