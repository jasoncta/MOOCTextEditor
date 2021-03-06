package spelling;

import java.util.Objects;
import java.util.TreeSet;

/**
 * @author UC San Diego Intermediate MOOC team
 *
 */
public class DictionaryBST implements Dictionary 
{
   private TreeSet<String> dict;
   
   public DictionaryBST() {
	   dict = new TreeSet<String>();
   }
	
    // TODO: Implement the dictionary interface using a TreeSet.  
 	// You'll need a constructor here
	
    
    /** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     * (it wasn't already there). */
    public boolean addWord(String word) {
    	// TODO: Implement this method
    	Objects.requireNonNull(word);
    	String wordToLowerCase = word.toLowerCase();
    	if (!dict.contains(wordToLowerCase)) {
    		dict.add(wordToLowerCase);
    		return true;
    	}
        return false;
    }


    /** Return the number of words in the dictionary */
    public int size()
    {
    	// TODO: Implement this method
        return dict.size();
    }

    /** Is this a word according to this dictionary? */
    public boolean isWord(String s) {
    	//TODO: Implement this method
    	String sToLowerCase = s.toLowerCase();
    	if (dict.contains(sToLowerCase)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }

}
