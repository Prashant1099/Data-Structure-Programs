// Question Link: https://leetcode.com/problems/valid-anagram/

/* Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
*/

class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        
        if(len1 != len2) return false;
        
        
        int hashMap[] = new int[26];
        
        for(int i=0; i<len1; i++){
            int index = (int)s.charAt(i)-97;
            hashMap[index] += 1;
        }
        
        for(int i=0; i<len2; i++){
            int index = (int)t.charAt(i)-97;
            hashMap[index] -= 1;
        }
        
        for(int i : hashMap){
            if(i != 0) return false;
        }
        
        return true;
    }
}