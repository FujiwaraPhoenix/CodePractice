import java.util.HashMap;

public class Solution03 {

	public int lengthOfLongestSubstring(String s) {
        int output = 0;
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
        	if (hm.containsKey(s.charAt(i))) {
        		//Repeat character found.
        		//Check the amount of characters between i and last repeat.
        		//If it's bigger, update output.
        		if (i - hm.get(s.charAt(i)) > output) {
        			output = i - hm.get(s.charAt(i));
        		}
        	}
			hm.put(s.charAt(i), i);
        }
		return output;
    }
	
	public static void main(String[] args){
		Solution03 sol03 = new Solution03();
		String test1 = "abcabcbb";
		String test2 = "bbbbb";
		String test3 = "pwwkew";
		System.out.println(sol03.lengthOfLongestSubstring(test1));
		System.out.println(sol03.lengthOfLongestSubstring(test2));
		System.out.println(sol03.lengthOfLongestSubstring(test3));
	}
}
