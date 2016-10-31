
class MapIterator {

	protected Map head; 
	
	public MapIterator(){
		this.head = null; 
	}
	
	public void advance(){
		this.head = head.rest(); 
	}
	
	public Pair get(){
		return head.first(); 
	}
	
	public void set(Map first){
		this.head = first; 
	}
	
	public Map mapGet(){
		return this.head; 
	}
	
	public boolean equal(MapIterator inp){
		Sequence n = inp.mapGet().returnH().getNext(); 
		if(this.get() == null)
			return true;
	
		if(this.mapGet().returnH() == n)
			return true;
		
		return false; 
	}
}