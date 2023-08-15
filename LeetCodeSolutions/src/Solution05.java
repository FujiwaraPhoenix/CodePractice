
public class Solution05 {
	//Maybe TODO: Understand how that one algorithm thing works that does this in O(n) space and time.
	public String longestPalindrome(String s) {
	        String output = "";
	        if (s.length() <= 1) {
	        	return s;
	        }
	        else if (s.length() == 2){
	        	if (AreCharsSame(s.charAt(0), s.charAt(1))) {
	        		return s;
	        	}
	        	else {
	        		return String.valueOf(s.charAt(0));
	        	}
	        }
	        else {
		        String odd = CheckPalindromeOdd(s);
		        String even = CheckPalindromeEven(s);
		        if (odd.length() > output.length()) {
		        	output = odd;
		        }
		        if (even.length() > output.length()) {
		        	output = even;
		        }
	        }
	        return output;
	}
	
	public boolean AreCharsSame(char a, char b) {
		if (a == b)
			return true;
		return false;
	}
	
	public String CheckPalindromeEven(String s) {
		String output = "";
		for (int i = 1; i < s.length() - 1; i++) {
			if (AreCharsSame(s.charAt(i), s.charAt(i+1))) {
	        //We never check the first or last index.
		        int leftBound = i - 1;
		        int rightBound = i + 2; 
		        String substring = s.substring(i, i+2);
		        //If we're within the left and right bounds, proceed.
		        //Else, stop process.
		        boolean endLoop = false;
		        while (!endLoop) {
		        	if (leftBound < 0 || rightBound > s.length() - 1) {
			       		endLoop = !endLoop;
			       	}
			       	else {
			       		if (AreCharsSame(s.charAt(leftBound), s.charAt(rightBound))) {
				       		substring = s.substring(leftBound, rightBound + 1);
			       			leftBound--;
			       			rightBound++;
			       		}
			       		else {
			       			endLoop = !endLoop;
			       		}
			       	}
		        }
		        if (substring.length() > output.length()) {
		        	output = substring;
		        	i = rightBound-2;
		        }
			}
		}
		return output;
	}
	
	public String CheckPalindromeOdd(String s) {
		String output = "";
		for (int i = 1; i < s.length() - 1; i++) {
        	//We never check the first or last index.
        	int leftBound = i - 1;
        	int rightBound = i + 1; 
        	String substring = String.valueOf(s.charAt(i));
        	//If we're within the left and right bounds, proceed.
        	//Else, stop process.
        	boolean endLoop = false;
        	while (!endLoop) {
        		if (leftBound < 0 || rightBound > s.length() - 1) {
	        		endLoop = !endLoop;
	        	}
	        	else {
	        		if (AreCharsSame(s.charAt(leftBound), s.charAt(rightBound))) {
		        		substring = s.substring(leftBound, rightBound + 1);
	        			leftBound--;
	        			rightBound++;
	        		}
	        		else {
	        			endLoop = !endLoop;
	        		}
	        	}
        	}
        	if (substring.length() > output.length()) {
        		output = substring;
        		i = rightBound-2;
        	}
        }
		return output;
	}
	
	public static void main(String[] args) {
		Solution05 sol05 = new Solution05();
		System.out.println(sol05.longestPalindrome("cabbbbage"));
	}
}
