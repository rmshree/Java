public abstract class Element 
{
    protected Element value;
    
    private void set(Element val){
        value = val;
    }
    
	public Element get(){
	    return value;
	}
	
    abstract void Print();
	
	//To retrieve values
	abstract String retrieve();
}
