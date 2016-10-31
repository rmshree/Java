public class MyChar extends Element{
    
    public char value;
    
    public MyChar(){
		this.value = '0';
	}
    
   /* public MyChar(char value){
        this.value = value;
    }
    
    public MyChar(MyChar value){
        this.value = value.Get();
    }
    */
    
    public char Get(){
		return value;
	}
	
	public void Set(char val){
		this.value = val;
	}
	
	String retrieve(){
		return "'" + value + "'";
	} // helper
	
	public void Print(){
	    System.out.print("'" + this.value + "'");
	}
}