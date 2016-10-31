public class MyInteger extends Element{
    private int value;
    
    public MyInteger(){
        this.value = 0;
    }
    
    public MyInteger(int newValue) { 
		this.value = newValue;
	}
	
	public MyInteger(MyInteger newValue){
		this.value = newValue.Get();
	}
    
    public int Get(){
		return value;
	}
	
	public void Set(int val){
		this.value = val; 
	}
	
	public void Print(){
	    System.out.print(value);
	}
	
	String retrieve(){
		return String.valueOf(value);
	} // helper  
}