import java.util.*;
import java.lang.*;
import java.io.*;


/*AAA*/
/* Name of the class has to be "Main" only if the class is public. */
class longestPalindrome
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    int left = 0, right = 0, mid = 0, max=0; // index values
	    String palindrum = ""; // storing longest palindrome
	    String str = ""; // input Stirng
	    
	    
	    // Storing user input
		str = args[0].replaceAll("\\s","");
		
		// Handling null input string
		if(str.length() == 0){
		    System.err.println("Null String");
		}
		
		// Handling string with 1 char
		if(str.length() == 1){
		    palindrum = str;
		    System.out.println(palindrum + " max size: " + palindrum.length());
		}
		
		// Handling string with 2 char that are palindomes
        if(str.length() == 2){
          if(str.charAt(1)==str.charAt(2)){
		    palindrum = str;
		    System.out.println(palindrum + " max size: " + palindrum.length());
          }
          
          else{
              System.err.println("String is not a palindrome");
          }
        }
        
        // Handling string with more than 3 chars
        // For each character in string
        for(mid = 0; mid < str.length()-1; mid++){
            System.out.println("Center at: " + str.charAt(mid));
                // Initialize left, right, middle point of palindrome
                left = mid;
                right = mid + 1;
                
                // If first two letters in even sequence did not match
                
                System.out.println("Comparing " + str.charAt(left)+str.charAt(right)+
                    ": "+ (str.charAt(left) == str.charAt(right)));   
                    
                if(str.charAt(left) != str.charAt(right)){
                    //Check for odd sequence by reversing left pointer back
                    left--;
                    System.out.println("Updating left index to " + left);
                    if(left < 0)
                        System.out.println();
                }
                
                // Found palindrome
                else{
                    // If longer than last palindrome, update max value and palindrome
                    if(str.substring(left, right+1).length() > max){
                        palindrum = str.substring(left, right+1);
                        max = palindrum.length();
                        System.out.println("FOUND longest Palindrome: " + palindrum);   
                    }
                    
                    // Check chars next to sequence for more matches
                    right++;
                    left--;
                }
                
                // While not out of bound
                while(left >= 0 && right < str.length()){
                    
                    System.out.println("Comparing " + str.charAt(left)+str.charAt(right)+
                    ": "+ (str.charAt(left) == str.charAt(right)));    
                    
                    // Found palindrome
                    if(str.charAt(left) == str.charAt(right)){
                        // Record sequence and update Max if is new max
                        if(str.substring(left, right+1).length() > max){
                            palindrum = str.substring(left, right+1);
                            max = palindrum.length();
                            System.out.println("FOUND longest Palindrome: " + palindrum);  
                        }
                    }
                    
                    // No Palindrome found. Move to next character in string
                    else{
                        System.out.println("not a palindrome");
                        System.out.println();
                        break;
                    }
                    
                    // If found palindrome. Update left and right pointers.
                    left--;
                    right++;
                }
        
        }
        // If palindrome is found... print length and sequence of max palindrome
        if(max != 0){
            System.out.println("Given the string " + str);    
            System.out.println("Palindrome: " + palindrum + " Max size: " + max);
        }        
        // Else, delcare no palindrome found
        else
            System.err.println("String is not a palindrome");
            System.out.println();
	}
}
