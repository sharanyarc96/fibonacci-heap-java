class node
{
	node parent;
	node left;
	node right;
	node child;
	int degree;
	boolean mark;
	int key;
	
	public node()
	{
		this.degree=0;
		this.mark=false;
		this.parent=null;
		this.left=this;
		this.right=this;
		this.child=null;
		this.key=0;
	}
	node(int x)
	{
		this();
		this.key=x;
	}
	
	void set_parent(node x)
	{
		this.parent=x;
	}
	
	node get_parent()
	{
		return this.parent;
	}
	
	void set_left(node x)
	{
		this.left=x;
	}
	
	node get_left()
	{
		return this.left;
	}
	
	void set_right(node x)
	{
		this.right=x;
	}
	
	node get_right()
	{
		return this.right;
	}
	
	void set_child(node x)
	{
		this.child=x;
	}
	
	node get_child()
	{
		return this.child;
	}
	
	void set_degree(int x)
	{
		this.degree=x;
	}
	
	int get_degree()
	{
		return this.degree;
	}
	
	void set_mark(boolean m)
	{
		this.mark=m;
	}
	
	boolean get_mark()
	{
		return this.mark;
	}
	
	void set_key(int x)
	{
		this.key=x;
	}
	
	int get_key()
	{
		return this.key;
	}
}

class fibHeap
{
	node min;
	int n;
	
	public static fibHeap create_heap()
	{
		return new fibHeap();
	}
	
	fibHeap()
	{
		min=null;
		n=0;
	}
	
	public void insert(int key)
	{
		node x=new node(key);
		if(min==null)
		{
			min=x;
			x.set_left(min);
			x.set_right(min);
		}
		else
		{
			x.set_right(min);
			x.set_left(min.get_left());
			min.get_left().set_right(x);
			min.set_left(x);
			if(x.get_key() < min.get_key())
				min=x;
		}
		n+=1;
	}
	
	public void display()
	{
		node temp=min;
		if(min==null)
			System.out.println("-1");
		else
		{
			do
			{
				System.out.println(temp.get_key()+"->");
				temp=temp.get_right();
			}
			while(temp!=min);
			System.out.println();
		}
	}
	
	public static void main(String[] args)
	{
		fibHeap obj=create_heap();
		obj.display();
		obj.insert(4);
		obj.display();
		obj.insert(8);
		obj.display();
		obj.insert(12);
		obj.display();
		obj.insert(6);
		obj.display();
		obj.insert(2);
		obj.display();
	}
}

