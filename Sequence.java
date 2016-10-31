public class Sequence extends Element{
    
    Element curr_val;
    Sequence next_val;
    private Sequence head;
    private Sequence head1;
    private int list_ct;
    private int size;
    boolean flag;
    private SequenceIterator sI;
	private SequenceIterator sE;
	
	Element testInt;
    
    public Sequence(){
        head = new Sequence(null);
		head1 = new Sequence(null);
		list_ct = 0;
		sE = new SequenceIterator();
		flag = false;
    }
    
    // enter data
	public Sequence(Element _data){
		next_val = null;
		curr_val= _data;
	}
	
	// enter data w/ pointer
	public Sequence(Element _data, Sequence _next){
		next_val = _next;
		curr_val = _data;
	}
    
    public SequenceIterator begin(){
		sI = new SequenceIterator();
		sI.set(this);
		return this.sI;
	} 

    
    public Element first(){
       Sequence current = head.getNext();
		
		if(this.list_ct == 0){
			return null;
		}	
		return current.getData();
    }
    
    public Sequence rest(){
        Sequence s = new Sequence();
        s.head = this.head.getNext();
        s.list_ct = this.size()-1;
        return s;
    }
    
    public void restCount(Sequence s){
	    s.list_ct = this.size()-1;
	}
    
    public int length(){
        	int size = 0;
		Sequence current = head.getNext();
		while (current != null){
			current = current.getNext();
			size++;
		}
		
		if(list_ct == size){
			return list_ct;
		}
		else{
			return size;
		}
    }
    
    public void add(Element elm){
        Sequence temp = new Sequence(elm);
		Sequence current = head;
		
		 	while(current.getNext() != null){
			current = current.getNext();
		}
		current.setNext(temp);
		list_ct ++;
    }
   
    public void add(Element elm, int pos){
        Sequence temp = new Sequence(elm);
		Sequence current = head;
		
		for(int i = 0; i < pos && current.getNext() != null; i++){
			current = current.getNext();
		}
		temp.setNext(current.getNext());
		current.setNext(temp);
		list_ct ++;
    }
    
    public boolean delete(int index){
        if(index < 0 || index > size()){
            return false; 
        }
		Sequence current = head;
		for(int i = 0; i < index; i++){
			if(current.getNext() == null){
	            return false; 
			}
			current = current.getNext();
		}
		list_ct--;
		current.setNext(current.getNext().getNext());
		return true;
    }
    
    void Print(){
        Element temp;
		System.out.print("[ ");
		Sequence current = head.getNext();
		while(current != null){
			temp = current.getData();
			temp.Print();
			System.out.print(" ");
			current = current.getNext();
		}
		System.out.print("]");
    }
    
    public Element index(int pos){
		Sequence current = head.getNext();
		for(int i = 0; i < pos; i++){
			if(current.getNext() == null)
				return null;
			current = current.getNext();
		}
		if(pos < 0 || pos > size()){
			return null;
		}
		return current.getData();
    }
    
    // Modifies value and position
	public void node_index(int pos, MyInteger e){
		Sequence current = head.getNext();
		for(int i = 0; i < pos; i++){
			if(current.getNext() == null)
				return;
			current = current.getNext();
		}
		if(pos < 0 || pos > size()){
			return ;
		}
		current.setData(e);
	}

	public Sequence flatten(){
		Sequence current = head.getNext();
		Sequence s = new Sequence();
		Sequence temp;
		
		int pos = 0;
		int j = 0;
		int elements;
		
		for(int i = 0; i < list_ct; i++){
			
			if(current.getData() instanceof Sequence){
				temp = ((Sequence) current.getData()).flatten();
				elements = pos + temp.list_ct;
			
				for(;pos < elements;pos++){
					s.add(temp.index(j), pos);
					j++;
				}
			}
			else
				s.add(current.getData(), pos);
			
			current = current.getNext();
			pos++;
			j = 0;
		}
		return s;
	}
	
	// deep copy
	public Sequence copy(){
		Element e;
		Sequence s = new Sequence();
		Sequence latestSequence = this;
    	int pos = 0;
		int size = this.length();
		
		for(e = latestSequence.first(); pos < size; ){
			if(e instanceof Sequence){
				s.add(((Sequence)e).copy(),pos);
			}
			else{ 	
				if(e instanceof MyChar){
					MyChar mc = new MyChar();
					mc.Set(((MyChar)e).Get());
					s.add(mc,pos);
				}
				else if(e instanceof MyInteger){
					MyInteger mi = new MyInteger();
					mi.Set(((MyInteger)e).Get());
					s.add(mi,pos);
				}
			}
			
			latestSequence = latestSequence.rest();
			e = latestSequence.first();
			pos ++;
		}
		return s;
	}
	
	
	public SequenceIterator end(){
		int i = 0;
		SequenceIterator s = new SequenceIterator();
		Sequence latestSequence = new Sequence();
		latestSequence = this;
		latestSequence.sE.set(this);
		s = sE;
		int limit = (this.length()-1);
		for(int pos = 0; pos < this.length(); pos ++){
			if(pos > 0){	
				s.advance();
			}
		}
		if(!flag){
			s.getSeq().add(testInt,list_ct);
			flag = true;
		}
		s.advance();
		return s;
	} 
	
	// Helpers:
    
    String retrieve(){
		Sequence current = head.getNext();
		String output = "";
		System.out.print("[");
		while(current != null){
			output += current.getData().retrieve();
			current = current.getNext();
		}
		return output;
	}
    
    public Element getData(){
		return curr_val;
	} 
		
	public void setData(Element _data){
		curr_val = _data;
	} 
		
	public Sequence getNext(){
		return next_val;
	} 
		
	public void setNext(Sequence _next){
		next_val = _next;
	} 
	
	public int size(){
		int size = 0;
		Sequence current = head.getNext();
		while (current != null){
			current = current.getNext();
			size++;
		}
		return size; 
	}
	
	public Sequence returnH(){
		return this.head;
	} // returns head
}