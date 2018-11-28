import java.util.*;
import fibonacci.fibHeap;

public class readFromFile
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		String file=new String(sc.nextLine());
		String[] commands=file.split("\\), ");
		/*for(String s:commands)
			System.out.println(s);*/
		String[] options={"Create","Insert","Merge","Findmin","Extractmin","Decreasekey","Free","Display","Trace"};
		int i;
		Map<String, fibHeap> heaps = new HashMap<String, fibHeap>();
		for(i=0;i<commands.length;++i)
		{
			String[] parts=commands[i].split(",");
			//remove the bracket from part 0
			parts[0]=parts[0].substring(1);
			if(i==commands.length-1)
			{
				String s=parts[parts.length-1];
				s=s.substring(0,s.length()-1);
				parts[parts.length-1]=s;
			}
			int j,op=10;
			for(j=0;j<9;++j)
			{
				if(parts[0].equals(options[j]))
				{
					op=j+1;
					break;
				}
			}
			String n=parts[1];
			boolean b=heaps.containsKey(n);
			if((b==false && op==1) || (b==true && op!=1))
			{
				fibHeap h=heaps.get(n);
				switch(op)
				{
					case 1: heaps.put(n, fibHeap.create_heap());
							System.out.println("Created heap: "+n);
							break;
					case 2: int k=Integer.parseInt(parts[2]);
							h.insert(k);
							if(h.get_trace()==true)
							{
								System.out.println("Inserted "+k+" into heap "+n);
								h.display();
							}	
							break;
					case 3: n=parts[2];
							if(!heaps.containsKey(n))
							{
								System.out.println("Heap "+n+" not found");
								break;
							}	
							fibHeap h2=heaps.get(n);
							n=parts[3];
							heaps.put(n,fibHeap.create_heap());
							fibHeap h3=heaps.get(n);
							fibHeap.merge_heap(h,h2,h3);
							if(h.get_trace())
							{
								System.out.println("Heap "+parts[1]);
								h.display();
							}	
							if(h2.get_trace())
							{
								System.out.println("Heap "+parts[2]);
								h2.display();
							}	
							if(h3.get_trace())
							{
								System.out.println("Heap "+parts[3]);
								h3.display();
							}	
							break;
					case 4: System.out.println("Minimum: "+h.find_min());
							break;
					case 5:	int p=h.extract_min();
							if(p==Integer.MAX_VALUE)
								System.out.println("Heap "+n+" was empty. No element to extract");
							else
							{	System.out.println("Element extracted from heap "+n+": "+p);
								if(h.get_trace())
								{
									System.out.println("Heap "+n+" after extraction ");
									h.display();
								}
							}
							break;
					case 6:	int key=Integer.parseInt(parts[2]);
							int nval=Integer.parseInt(parts[3]);
							h.decrease_key(key,nval);
							if(h.get_trace())
							{
								System.out.println("Heap "+n+" after decreasing key "+key+" to "+nval);
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
								System.out.println("Heap "+n);
								h.display();
							}	
							break;
					case 8: System.out.println("Heap "+n);
							h.display();
							break;
					case 9: n=parts[2];
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
					System.out.println("Heap "+n+" already exists");
				else
					System.out.println("Heap "+n+" not found");
			}
		}
	}
}
/*
Create_Heap(Heap_Name)
Insert (Heap_Name, Key)
Merge_Heap(H1,H2,H3)     // Merge Heaps H1  and H2 into H3)
Find_Min(Heap_Name)
Extract_Min(Heap_Name)
Decrease_Key(Heap_Name, Key, Delta)
Free_Heap(Heap_Name)
Display_Heap(HeapName)
Trace(Heap_Name ,  TRUE/FLASE ) 
*/
