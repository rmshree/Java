
// Iterate through Sequence
class SequenceIterator {
	
	private Sequence curr;
		
	public SequenceIterator() {
		this.curr = null;
	} // constructor
		
	public void advance()
	{	
		this.curr = curr.rest();				
	} // To the next Sequence pointer
	
	public Element get(){
		return curr.first();
	} 

	public Sequence getSeq(){
		return this.curr;
	} 
	
	public boolean equal(SequenceIterator other){
		Sequence n = other.getSeq().returnH().getNext();
		
		if(this.get() == null)
			return true;
		
		if(this.getSeq().returnH() == n)
			return true;
		
		return false;
	}
	
	public void set(Sequence first){
		this.curr = first;
	}
} // Compares two Sequences and returns true/false