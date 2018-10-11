package crypt;
import java.util.*;
 class SimpleEncrypt {

 public static void encryeasy(String s)
{
	 
		int n;
		n=s.length();
		int x;
		if(n%2==1)
			 x=n-1;
		else
			 x=n;
		char []ch=s.toCharArray() ;
		for(int j=0;j<x;j=j+2)
		{
			char temp;
			temp=ch[j];
			ch[j]=ch[j+1];
			ch[j+1]=temp;
		}
		for(int j=0;j<ch.length;++j)
		{
	ch[j]=alphaMirror(ch[j]);
		}
		String b=new String(ch);
		System.out.println(b);
	}


static char alphaMirror(char c) {
 int maxAdvance = 25;

 int diff = c - ((c > 'Z') ? 'a' : 'A');

 int advance = maxAdvance - 2 * diff;

 return (char) (c + advance);
}
}