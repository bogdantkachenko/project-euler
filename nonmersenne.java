import java.util.*;
import java.io.*;

public class nonmersenne{
    public static int[] longsum(int[] summand1, int[] summand2)
		{
			int[] sum = new int[]{0,0,0,0,0,0,0,0,0,0};
			for(int i=0;i<size;i++)
			{
				int j=1;
				int s1 = i<summand1.length ? summand1[i] : 0;
				int s2 = i<summand2.length ? summand2[i] : 0;
				sum[i]+=s1+s2;
				while(sum[i]>9)
				{
					if(i+j<size)
					sum[i+j]=sum[i+j]+1;
					sum[i]=sum[i]-10;
					j++;
				}				
			}
			return sum;
		}
		
	public static int[] lngprod(int[] mult1, int mult2)
		{
			int[] prod = new int[]{0,0,0,0,0,0,0,0,0,0};
			while(mult2-->0)
			{
				prod=longsum(prod, mult1);
			}
			return prod;
		}
		
	public static int[] lngpow(int base, long pow)
		{
			int[] res = new int[]{1,0,0,0,0,0,0,0,0,0};
			int[] base_ar = conv(base);
			while(pow-->0)
			{
				res=lngprod(res, base);
			}
			return res;
		}
	public static int[] conv(long num)
		{
			char[] num_text = String.valueOf(num).toCharArray();
			int ln = num_text.length;
			int num_sz = size>ln ? ln : size;
			int[] res = new int[num_sz];
			for (int j=0; j<num_sz; j++)
				res[j]=Integer.parseInt(Character.toString(num_text[ln-1-j]));
			return res;
		}
		
	public static void solve()
		{
			int[] res = new int[]{7,1,3,1,7,0,5,0,4,0};							  
		}
	public static void main(String[] args)
		{
			//test2();
			int[] res = new int[]{0,0,0,0,0,0,0,0,0,0};
			int a = 28433;
			res=lngprod(lngpow(2, 7830457L), a);
			for(int i=res.length-1; i>=0; i--)
			System.out.print(res[i]);
		    System.out.println();
			//test();
		}
	public static void test2()
		{
			int[] s = lngpow(9, 9);
			System.out.println("power test");
			for(int i=0; i<s.length; i++)
			System.out.println(s[i]);
		}
	public static void test()
		{
			int[] a = new int[]{1,1,1,1,1,1,1,1,1,1};
			int[] b = new int[]{8,8};//means 8888889999
			int[] s = lngprod(b, 3);
			System.out.println("product");
			for(int i=0; i<size; i++)
			System.out.println(s[i]);
			System.out.println("sum");
			s = longsum(b, b);
			for(int i=0; i<size; i++)
			System.out.println(s[i]);
			s = conv(1000);
			System.out.println("conv test");
			for(int i=0; i<s.length; i++)
			System.out.println(s[i]);
			s = lngpow(88, 2);
			System.out.println("power test");
			for(int i=0; i<s.length; i++)
			System.out.println(s[i]);
		}
	private static int size=10;
}
