package test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	
	
public boolean isSubSequence(String A, String B){
        
        int alen = A.length();
        int blen = B.length();
        int i = 0;
    
    for(int j = 0;i < alen && j < blen;j++)
    {
        if(A.charAt(i) == B.charAt(j))
        {
            i++;
        }
        
    }
    //System.out.println(i);
    if(i >= alen)
    {
        return true;
    }
    return false;
    }
	
public String removeChars(String string1, String string2){
    
    //String saved = "";
    int length1 = string1.length();
    int length2 = string2.length();
    int i = 0;
    
for(int j = 0; i < length2 && j < length1 ; j++)
{
    if(string1.charAt(j) == string2.charAt(i))
    {
        string1.replace(string1.charAt(j),' ');
        i++;
    }
}
return string1; 
}	

public boolean isValid(String s) {
    
    String ipv4[] = s.split("\\.");
    
    int length = ipv4.length;
    
    boolean ans[]=new boolean[4];

    if(length < 4 || length > 4 || s.charAt(s.length()-1) == '.')
    {
        return false;
    }
    
    for(int i = 0; i < length; i++)
    {
        if(ipv4[i] == "" || ipv4[i].length() > 1 && ipv4[i].charAt(0) == '0')
        {
            ans[i] = false;
        }
        else if(Integer.parseInt(ipv4[i]) <= 255 && Integer.parseInt(ipv4[i]) >= 0 && ipv4[i].length() <= 3)
        {
            ans[i] = true;
            
        }
       
    }
     for(boolean bool:ans)
        {
        if(!bool)
        {
            return false;
        }
        }
return true;    
}

String modify (String s)
{
    String saved = "";
   // StringBuilder ans = new StringBuilder();
    int j = 0;
    
    for(int i = 0; i < s.length(); i++)
    {
        if(s.charAt(i) == 'a' || s.charAt(i) == 'e' ||  s.charAt(i) == 'i' ||  s.charAt(i) == 'o' ||  s.charAt(i) == 'u')
        {
            saved = s.charAt(i) + saved;
        }
    }
    
    for(int i = 0; i < s.length(); i++)
    {
        if(s.charAt(i) == 'a' || s.charAt(i) == 'e' ||  s.charAt(i) == 'i' ||  s.charAt(i) == 'o' ||  s.charAt(i) == 'u')
        {
            s.replace(s.charAt(i),saved.charAt(j)); 
            j++;
        }
    }
return s;    
}

public int maxChars(String s)
{
int noRep=0;
for(int i= 0;i < s.length();i++)
{
    noRep=Math.max(noRep,s.lastIndexOf(s.charAt(i))-i);
}
return noRep-1;
}

static String crossPattern(String S){
    
    StringBuilder out = new StringBuilder();
    
    int len = S.length();
    int count = 0;
    
    for(int i = 0; i < len; i++)
    {
        out.append(S);
    }
    
    for(int i = 0; i < len; i++)
    {
        for(int j = i*len; j < (i*len)+len;j++)
        {
            if((j == i*len+count || j == (i*len)+len-1-count) == false)
            {
                out.setCharAt(j,' ');
            }
        }
        count++;
    }
return out.toString();    
}

public List<String> find_permutation(String S) {
    
    List<String> permu=new ArrayList<String>();
    
    permute(S,"",permu);
    Collections.sort(permu);
    return permu;
    }
    
    
   private void permute(String S,String out,List<String>  permu)
   {
       if(out != "" || S.length() == 0)
       {
           permu.add(out);
           return;
       }
       
       for(int i = 0; i < S.length();i++)
       {
           char ch = S.charAt(i);
           String ans = S.substring(0,i) + S.substring(i+1);
           permute(ans,out+ch,permu);
       }
   }
   
   
   static int x[] = {-1,-1,-1,0,0,1,1,1};
   static int y[] = {-1,0,1,-1,1,-1,0,1};
   
   public int[][] searchWord(char[][] grid, String word)
   {
        List<List<Integer>> output = new ArrayList<>();
        
        for(int row = 0; row < grid.length; row++)
        {
            for(int col = 0; col < grid[0].length; col++)
            {
                if(search(grid,row,col,word))
                {
                    List<Integer> list = new ArrayList<>();
                    list.add(row);
                    list.add(col);
                    output.add(list);
                }
            }
        }
        
       int [][]ans = new int [output.size()][2];
       
       for(int i = 0; i < ans.length; i++)
       {
           ans[i][0] = output.get(i).get(0);
           ans[i][1] = output.get(i).get(1);
       }
   return ans;    
   }
   
   
   private static boolean search(char[][] grid,int row,int col,String word)
   {
       if(grid[row][col] != word.charAt(0))
       {
           return false;
       }
       for(int i = 0; i < 8;i++)
       {
           int k;
           int rowd = row + x[i];
           int cold = col + y[i];
           
           int wordlen = word.length();
           
           
           for(k = 1; k < wordlen; k++)
           {
               if(rowd >= grid.length || rowd < 0 || cold >= grid[0].length || cold < 0)
               {
                   break;
               }
               
               if(grid[rowd][cold] != word.charAt(k))
               {
                   break;
               }
               
               rowd += x[i];
               cold += y[i];
           }
           if(k == wordlen)
           {
               return true;
           }
       }
   return false;
   }   

   
public boolean isValid1(String s) {
       
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		
       for(int i = 0; i < s.length(); i++)
       {
           if(s.charAt(i) == '(' || s.charAt(i) == ')')
           {
        	 count1++;  
           }
           if(s.charAt(i) == '[' || s.charAt(i) == ']')
           {
        	 count2++;  
           }
           if(s.charAt(i) == '{' || s.charAt(i) == '}')
           {
        	 count3++;  
           }
       }
       
       if(count1 % 2 != 0 || count2 % 2 != 0 || count3 % 2 != 0)
       {
    	   return false;
       }
   return true;     
}

public static boolean areIsomorphic(String str1,String str2)
{
    if(str1.length() != str2.length())
    {
        return false;
    }
    
    Map<Character,Character> mapCall = new HashMap<>();
    
    for(int i = 0; i < str2.length(); i++)
    {
        char ch1 = str1.charAt(i);
        char ch2 = str2.charAt(i);
        if(mapCall.containsKey(ch1))
        {
            if(mapCall.get(ch1) != ch2)
            {
                return false;
            }
        }
        else
        {
            if(mapCall.containsValue(ch2))
            {
                return false;
            }
            mapCall.put(ch1,ch2);
        }   
    }
return true;    
}

static String encryptString(String S){
    
    StringBuilder sb = new StringBuilder();
    int count = 1;
    int i = S.length()-1;
    
    while(i >= 0)
    {
        if(0 <= i - 1 && S.charAt(i) == S.charAt(i-1))
        {
            count++;
        }
        else
        {
            sb.append(Integer.toHexString(count)).append(S.charAt(i));
        }
        i--;
    }
return sb.toString();    
}


public String countAndSay(int n) {
    
    if(n == 1)
    {
        return "1";
    }
    
    StringBuilder ans = new StringBuilder();
    
    String str = countAndSay(n - 1);
    
    int count = 0;
    
    for(int i = 0; i < str.length();i++)
    {
        count++;
        if(i == str.length() - 1 ||str.charAt(i) != str.charAt(i+1))
        {
            ans.append(count).append(str.charAt(i));
            count = 0;
        }    
    }
return ans.toString();     
}

public List<String> compareString(String str1,String str2)
{
	
	char saved = 0;
	char dummy = 0;
	List<String> list = new ArrayList<>(); 
	String out="";
	for(int i = 0; i < str1.length(); i++)
	{
		if(str1.charAt(i) != str2.charAt(i))
		{
			saved = str1.charAt(i);
			dummy = str2.charAt(i);
			out=saved+""+dummy;
			list.add(out);
		}
		
	}
	
	return list;
}

public String removePalindrome(String str)
{
	char[] saved = str.toCharArray();
	String dummy = "";
	String output = "";
	
	
	for(int i = 0; i < str.length();i++)
	{
		dummy = saved[i] + dummy;
	}
	System.out.println(dummy);
	for(int i = 0; i < str.length();i++)
	{
		if(str.charAt(i) != dummy.charAt(i))
		{
			output += str.charAt(i);
		}
	}
return output;	
}

	public static void main(String[] args) {
			
			Solution solCall = new Solution();
			
			Scanner scan = new Scanner(System.in);
			
			int number = scan.nextInt();
			
	switch(number)
	{
		case 1:
			boolean check=solCall.isSubSequence("gksrek", "geeksforgeeks");
			System.out.println(check);
			break;
			
		case 2:
			String ans = solCall.removeChars("occurrance", "car");
			System.out.println(ans);
			break;
			
		case 3:
			boolean check1 = solCall.isValid("0.0.0.0."); 
			System.out.println(check1);
			break;
			
		case 4:
			String output = solCall.modify("practice"); 
			System.out.println(output);
			break;
		
		case 5:
			int out = solCall.maxChars("for");
			System.out.println(out);
			break;
	
		case 6:
			String str = Solution.crossPattern("hqghumeaylnlfdxfircvscxggbwkfnqduxwfnfozvs");
			System.out.println(str);
			break;
			
		case 7:
			List<String> output1 = solCall.find_permutation("abc");
			System.out.println(output1);
			break;
		
		case 8:
			char grid[][] = {{'a','b','c'},{'d','r','f'},{'g','h','i'}};
			int ans1[][] = solCall.searchWord(grid,"abc"); 
			System.out.println(ans1);
			break;
		
		case 9:
			boolean out1 = solCall.isValid1("(){}}{"); 
			System.out.println(out1);
			break;
			
		case 10:
			boolean out2 = Solution.areIsomorphic("aabc", "xxyy"); 
			System.out.println(out2);
			break;
		
		case 11:
			String str1 = Solution.encryptString("abbc");
			System.out.println(str1);
			break;
			
		case 12:
			String str2 = solCall.countAndSay(4);
			System.out.println(str2);
			break;
			
		case 13:
			System.out.println(solCall.compareString("abcddefgilom", "abdcdeffgklm"));
			break;
			
		case 14:
			System.out.println(solCall.removePalindrome("He did a good deed"));
			break;	
	}
	scan.close();
	}

}
