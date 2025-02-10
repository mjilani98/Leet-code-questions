/*
Q:1768. Merge Strings Alternately
 
You are given two strings word1 and word2.
Merge the strings by adding letters in alternating order, starting with word1.
If a string is longer than the other, append the additional letters onto the end of the merged string.

Return the merged string.

 

Example 1:

Input: word1 = "abc", word2 = "pqr"
Output: "apbqcr"
Explanation: The merged string will be merged as so:
word1:  a   b   c
word2:    p   q   r
merged: a p b q c r
Example 2:

Input: word1 = "ab", word2 = "pqrs"
Output: "apbqrs"
Explanation: Notice that as word2 is longer, "rs" is appended to the end.
word1:  a   b 
word2:    p   q   r   s
merged: a p b q   r   s
Example 3:

Input: word1 = "abcd", word2 = "pq"
Output: "apbqcd"
Explanation: Notice that as word1 is longer, "cd" is appended to the end.
word1:  a   b   c   d
word2:    p   q 
merged: a p b q c   d
*/

public class MergeString {

    public static void main(String[] args)
    {
        // Call the mergeAlternately function and display the result
        String str = mergeAlternately("abcd", "pq");
        System.out.println(str);
    }

    // Method to merge two strings alternately
    public static String mergeAlternately(String word1, String word2) {

        // Using StringBuilder to store and manipulate strings efficiently
        StringBuilder str1 = new StringBuilder(word1);
        StringBuilder str2 = new StringBuilder(word2);

        // StringBuilder to store the merged result
        StringBuilder merged = new StringBuilder();

        // Variable to store the remaining characters from the longer string
        String left = "";

        // Case 1: word1 is longer than word2
        if (str1.length() > str2.length()) {
            // Extract the remaining characters from word1 after merging
            left = str1.substring(word2.length());

            // Merge characters alternately up to the length of the shorter string
            for (int x = 0; x < str2.length(); x++) {
                merged.append(str1.charAt(x)); // Append character from word1
                merged.append(str2.charAt(x)); // Append character from word2
            }

            // Append the remaining characters from word1
            merged.append(left);

        // Case 2: word2 is longer than word1
        } else if (str1.length() < str2.length()) {
            // Extract the remaining characters from word2 after merging
            left = str2.substring(word1.length());

            // Merge characters alternately up to the length of the shorter string
            for (int x = 0; x < str1.length(); x++) {
                merged.append(str1.charAt(x)); // Append character from word1
                merged.append(str2.charAt(x)); // Append character from word2
            }

            // Append the remaining characters from word2
            merged.append(left);

        // Case 3: Both strings have equal lengths
        } else {
            for (int x = 0; x < str1.length(); x++) {
                merged.append(str1.charAt(x)); // Append character from word1
                merged.append(str2.charAt(x)); // Append character from word2
            }
        }

        // Convert StringBuilder to a String and return
        return merged.toString();
    }
}