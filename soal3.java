import java.util.*;
import java.lang.*;
import java.io.*;

class soal3
{

	public static HashMap<String,String> getDictionary()
{
    HashMap<String,String> hm=new HashMap<String,String>();
    hm.put("pro","pro");
    hm.put("gram","gram");
    hm.put("merit","merit");
    hm.put("program","program");
    hm.put("it","it");
    hm.put("programmer","programmer");
    return hm;
}
  
public static void findWords(String s, int length, String out)
{
    HashMap<String,String>hm = getDictionary();
    for (int i=1; i <= length; i++)
    {
        String subwords = s.substring(0, i);
        if (hm.containsKey(subwords))
        {
            if (i == length)
            {
                out = out + subwords;
                System.out.println(out);
                return;
            }
            findWords(s.substring(i,length), length-i, out+subwords+" ");
        }
    }
}
  
public static void main (String[] args) throws java.lang.Exception
{
    String s = "programmerit";
    findWords(s,s.length(),"");
}

	
}
