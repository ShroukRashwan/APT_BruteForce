import java.util.*;

public class oldMain {
//	public static String DictionarySet[] = 
//		{
//			"0",
//			"1",
//			"2",
//
//		};
//	public static char DictionarySet2[] = 
//		{
//			'0',
//			'1',
//			'2'
//		};
//	private static StringBuilder string = new StringBuilder("   ");
//	private static String password = "~~~~";
//
//	public static void loop(int index, int MaxLength) 
//	{
//		for(int i = 0; i < DictionarySet2.length; i++) 
//		{
//			if (index > string.length() - 1)
//			{
//				string.append(DictionarySet2[i]);
//			}
//			else
//			{
//				string.setCharAt(index, DictionarySet2[i]);				
//			}
//			
//			if(index < MaxLength)
//			{
//				loop(index + 1, MaxLength);
//			}
//			
//			if (i < DictionarySet2.length - 1)
//				System.out.println(string);
//			
//		}
//	}
//	
//	public static class Call
//	{
//		public int i;
//		public int index;
//		public int callNumber;
//		public Call next;
//		
//		public Call()
//		{
//			i = 0;
//			index = 0;
//			callNumber = 0;
//			next = null;
//		}
//		
//	}
//	
//	static boolean FirstTime = true;
//	public static void loop3(int index, int MaxLength, Call C) 
//	{
//		if (FirstTime)
//		{
//			C.next = new Call();
//			C.index = index;
//			C.callNumber = C.callNumber + 1;
//			C.i=0;
//			System.out.println(" ######### ");
//			System.out.println(C.callNumber);
//			System.out.println(C.index);
//			System.out.println(C.i);
//			
//			if (C.i < DictionarySet2.length) 
//			{
//				index = C.index;
//				if (index > string.length() - 1)
//				{
//					string.append(DictionarySet2[C.i]);
//				}
//				else
//				{
//					string.setCharAt(index, DictionarySet2[C.i]);				
//				}
//				
//				if(index < MaxLength)
//				{
//					loop2(index + 1, MaxLength, C.next);
//				}
//				
//				if (C.i < DictionarySet2.length - 1)	
//				{
//					System.out.println(string);	
//				}
//				C.i++;
//			}
//			
////			for(int i = 0; i < DictionarySet2.length; i++) 
////			{
////				if (index > string.length() - 1)
////				{
////					string.append(DictionarySet2[i]);
////				}
////				else
////				{
////					string.setCharAt(index, DictionarySet2[i]);				
////				}
////				
////				if(index < MaxLength)
////				{
////					loop2(index + 1, MaxLength, C.next);
////				}
////				
////				if (i < DictionarySet2.length - 1)	
////				{
////					System.out.println(string);	
////				}
////			}
//		}
//		else
//		{
//			System.out.println(" ******* ");
//			System.out.println(C.callNumber);
//			System.out.println(C.index);
//			if (C.i < DictionarySet2.length) 
//			{
//				index = C.index;
//				if (index > string.length() - 1)
//				{
//					string.append(DictionarySet2[C.i]);
//				}
//				else
//				{
//					string.setCharAt(index, DictionarySet2[C.i]);				
//				}
//				
//				if(index < MaxLength)
//				{
//					loop2(index + 1, MaxLength, C.next);
//				}
//				
//				if (C.i < DictionarySet2.length - 1)	
//				{
//					System.out.println(string);	
//				}
//				C.i++;
//			}
////			if (C.next.i < DictionarySet2.length) 
////			{
////				index = C.next.index;
////				if (index > string.length() - 1)
////				{
////					string.append(DictionarySet2[C.next.i]);
////				}
////				else
////				{
////					string.setCharAt(index, DictionarySet2[C.next.i]);				
////				}
////				
////				if(index < MaxLength)
////				{
////					loop2(index + 1, MaxLength, C.next);
////				}
////				
////				if (C.next.i < DictionarySet2.length - 1)	
////				{
////					System.out.println(string);	
////				}
////				C.next.i++;
////			}
//		}
//		
//		
//	}
//	public static void loop2(int index, int MaxLength, Function<int, int> someFunction) 
//	{
//		
//		for(int i = 0; i < DictionarySet2.length; i++) 
//		{
//			if (index > string.length() - 1)
//			{
//				string.append(DictionarySet2[i]);
//			}
//			else
//			{
//				string.setCharAt(index, DictionarySet2[i]);				
//			}
//			
//			if(index < MaxLength)
//			{
//				loop2(index + 1, MaxLength, C.next);
//			}
//			
//			if (i < DictionarySet2.length - 1)	
//			{
//				System.out.println(string);	
//			}
//		}
//	}
	
	
	public oldMain(String[] args) 
	{
		int index = 0;
		char x[] = new char[4];
		int externalIndex = 1;
//		for (int i=0; i<6; i++)
//		{
//			if (i < 3)
//			{
//				x[index] = DictionarySet2[externalIndex];
//				System.out.println(new String(x));
//			}
//			else if (i == 3)
//			{
//				externalIndex++;
//			}
//		}
//		Call inputC = new Call();
//		loop2(0, 3, inputC);
//		FirstTime = false;
//		Call c = inputC;
//		while(c.next != null)
//		{
//			System.out.println(" ---- ");
//			System.out.println(c.callNumber);
//			System.out.println(c.index);
//			c = c.next;
//		}
//		loop2(0, 3, inputC);
		//loop2(0, 3, inputC);
		//X = func2(0, 1, X);
		TestClass test = new TestClass();
		BruteForceGenerator myGenerator = new BruteForceGenerator();
		
		myGenerator.setCallBack(test);
		//myGenerator.loop2(0,  3);
		//System.out.println(X);
	}

}
