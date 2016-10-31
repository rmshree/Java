
// class Map [Ditto like Sequence]
class Map {

	private MapIterator mapIterator; 
	private Sequence head; 
	private MapIterator set;
	private int length; 
	private boolean flag = false; 
	Pair temp;  

	public Map(){
		head = new Sequence(null); 
		set = new MapIterator();
		temp = new Pair(null, null);
		temp = null; 
	}
	
	public MapIterator begin(){
		mapIterator = new MapIterator(); 
		mapIterator.set(this); 
		return this.mapIterator; 
		
	}
	
	public MapIterator end(){
		MapIterator s = new MapIterator(); 
		Map end = new Map();
		end = this; 
		end.set.set(this);
		
		s = set; 
		
		if(!flag){
			s.mapGet().add(temp);
			flag = true;
		}
	
		for (int pos  = 0; pos < this.length(); pos++){			
			if(pos > 0)
			s.advance();	
		}
		return s; 
	}

	
	public Pair first(){
		Sequence currentNode = head; 
		
		if(this.length() == 0){
			return null; 
		}
		
		 return (Pair) currentNode.getNext().getData();
	}
	
	public Map rest(){
		Map newSeq = new Map(); 
		newSeq.head = this.head.getNext(); 
		 
		newSeq.length = this.length - 1; 
	
		return newSeq; 
	}
	
	public void add(Pair val)
	{
		Sequence newNode = new Sequence(val); 
		Sequence currentNode = head;
		
		if(val == null)
			return; 
		
		for(int i = 0; currentNode.getNext() != null ; i++){	
			if((val.getKey().Get() > ((Pair)currentNode.getNext().getData()).getKey().Get() 
				|| val.getKey().Get() ==((Pair)currentNode.getNext().getData()).getKey().Get()) 
				&& currentNode.getNext() != null)
			{
				currentNode = currentNode.getNext(); 
			}
			
			else
				break; 
		}
		newNode.setNext(currentNode.getNext()); 
		currentNode.setNext(newNode); 
		length++; 
	}
	
	public int length()
	{
		int size = 0;
	 	Sequence currentNode = head.getNext();
	 	while (currentNode != null){
	 		currentNode = currentNode.getNext();
	 		size++;
	 	}
	 	 
	 	if(length == size)
	 		return length;
	 	
	 	else
	 		return size;
	}
	
	public MapIterator find(MyChar key)
	{
		MapIterator start = new MapIterator(); 
		Pair p = new Pair(null, null); 
		MyChar set = new MyChar(); 
	
		for(start = this.begin(); !start.equal(this.end()); start.advance()){
			p = start.get(); 
			set = p.getKey(); 
			
			if(key.Get() == set.Get())
			    break; 
		}
		return start; 
	}
	
	public void Print(){
		Pair data; 
		Sequence currentNode = head.getNext(); 
		System.out.print("[ "); 

		while (currentNode != null) {
	        	data = (Pair)currentNode.getData();
	        	data.Print();
	            currentNode = currentNode.getNext();
	            
	            if(currentNode != null){
	            	System.out.print(" ");
	            }
	    }    
		System.out.print(" ]"); 
	}
	
	public Sequence returnH(){
		return head; 
	}

}

