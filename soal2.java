import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
 
class ConvertWordUsingDictionary 
{
    static String dictionary [] = {
        "hot", "dot", "dog", "lot", "log"
    };
    
    
    static HashMap <String, ArrayList<String>> smallerWordsMap = new HashMap <String, ArrayList<String>> ();
    static HashMap<String, ArrayList<String>> wordToPathMap = new HashMap<String, ArrayList<String>> ();
    static HashSet<String> visitedWords = new HashSet<String> ();
    
    public static void main(String[] args) 
    {
        String a = "hot";
        String b = "dog";
        
        System.out.print ("Sample Input  : ");
        System.out.print(a);
        System.out.print(" ");
        System.out.print(b);
        System.out.println();
        System.out.println();
        createSmallerWordMap ();
        ArrayList<String> path = convertWord (a,b);
        printPath (a,path);
        
    }
 
    static void createSmallerWordMap() 
    {
        for (String word : dictionary)
        {
            for (int i=0; i<word.length(); i++)
            {
               
                String smallerWord = 
                        word.substring(0, i) + 
                        word.substring(i+1, word.length()) +
                        i;
           
            ArrayList<String> list = smallerWordsMap.get(smallerWord);
                if (list == null)
                {
                    list = new ArrayList<String> ();
                    smallerWordsMap.put(smallerWord, list);
                }
                list.add(word);
            }
        }
    }

    static ArrayList <String> convertWord (String a, String b) 
    {
        ArrayList<String> existingPath = wordToPathMap.get(a);
        if (existingPath != null && existingPath.size() > 0)
            return existingPath;
        
       
        if (visitedWords.contains(a))
            return null;
        visitedWords.add(a);
        
        ArrayList <String> minPath  = new ArrayList<String>();
        
        for (int i=0; i<a.length(); i++)
        {
            String smallerWord = 
                    a.substring(0, i) + 
                    a.substring(i+1, a.length()) +
                    i;
            
            ArrayList<String> list = smallerWordsMap.get(smallerWord);
            for (String word: list)
            {
                if (word.equals(a))
                    continue;
                
                if (word.equals(b)) // match found
                {
                    ArrayList <String> currPath = new ArrayList<String>();
                    currPath.add(word);
                    wordToPathMap.put(word, currPath);
                    return currPath;
                }
                
                ArrayList <String> fwdPath = convertWord(word, b); 
                
                if (fwdPath != null && fwdPath.size() > 0)
                {
                    if (minPath.size()==0 || minPath.size() > 1 + fwdPath.size())
                    {
                        minPath.clear();
                        minPath.add(word);
                        minPath.addAll(fwdPath);
                    }
                }
            }
        }
        
        wordToPathMap.put(a, minPath);
        return minPath;
    }
 
    
   
    static void printPath(String a, ArrayList<String> path) 
    {
        System.out.println ();
        System.out.print("Sample Output : ");
        if (path == null || path.size() == 0)
        {
            System.out.println ("No path exists");
            return;
        }
        System.out.print(a);
        
        for (String w : path)
            
            System.out.print("  " + w);
    }
    
 
}