import java.util.*;
import fibonacci.fibHeap;
public class client_cli
{
	public static void main(String[] args)
	{
		
		Map<String, fibHeap> heaps = new HashMap<String, fibHeap>();

		Scanner sc=new Scanner(System.in);
		System.out.println("1. Create Heap \n2. Insert \n3. Merge heaps \n4. Find minimum element \n5. Extract minimum element \n6. Decrease Key \n7. Free Heap \n8. Display heap \n9. Trace \n10. Exit");	
		int i=sc.nextInt();
		while(i>=1 && i<10)
		{	
			String n;
			if(i==3)
				System.out.println("Enter the name of the first heap");
			else
				System.out.println("Enter the name of the heap");
			n=sc.next();
			boolean b=heaps.containsKey(n);
			if((b==false && i==1) || (b==true && i!=1))
			{
				fibHeap h=heaps.get(n);
				switch(i)
				{
					case 1: heaps.put(n, fibHeap.create_heap());
							break;
					case 2: System.out.println("Enter the value to be inserted");
							int k=sc.nextInt();
							h.insert(k);
							if(h.get_trace()==true)
							{
								System.out.println("Heap: \n");
								h.display();
							}	
							break;
					case 3: System.out.println("Enter the name of the second heap");
							n=sc.next();
							if(!heaps.containsKey(n))
							{
								System.out.println("Heap not found");
								break;
							}	
							fibHeap h2=heaps.get(n);
							System.out.println("Enter the name of the third heap");
							n=sc.next();
							heaps.put(n,fibHeap.create_heap());
							fibHeap h3=heaps.get(n);
							fibHeap.merge_heap(h,h2,h3);
							if(h.get_trace())
							{
								System.out.println("Heap 1: \n");
								h.display();
							}	
							if(h2.get_trace())
							{
								System.out.println("Heap 2: \n");
								h2.display();
							}	
							if(h3.get_trace())
							{
								System.out.println("Heap 3: \n");
								h3.display();
							}	
							break;
					case 4: System.out.println("Minimum: "+h.find_min());
							break;
					case 5:	int p=h.extract_min();
							if(p==Integer.MAX_VALUE)
								System.out.println("Heap was empty. No element to extract");
							else
								System.out.println("Element extracted: "+p);
							if(h.get_trace())
							{
								System.out.println("Heap: \n");
								h.display();
							}
							break;
					case 6:	System.out.println("Enter key");
							int key=sc.nextInt();
							System.out.println("Enter new value");
							int nval=sc.nextInt();
							h.decrease_key(key,nval);
							if(h.get_trace())
							{
								System.out.println("Heap: \n");
								h.display();
							}
							break;

					case 7: p=h.extract_min();
							while(p!=Integer.MAX_VALUE)
							{	
								p=h.extract_min();
							}
							if(h.get_trace())
							{
								System.out.println("Heap: \n");
								h.display();
							}	
							break;
					case 8: h.display();
							break;
					case 9: System.out.println("Trace? true/false");
							n=sc.next();
							if(n.equals("true"))
								h.set_trace(true);
							else
								h.set_trace(false);
							break;
					default: System.exit(0);	
				}
			}
			else
			{
				if(i==1)
					System.out.println("Heap already exists");
				else
					System.out.println("Heap not found");
			}
			System.out.println("1. Create Heap \n2. Insert \n3. Merge heaps \n4. Find minimum element \n5. Extract minimum element \n6. Decrease Key \n7. Free Heap \n8. Display heap \n9. Trace \n10. Exit");	
			i=sc.nextInt();
		}	
	}
}
