// class Pair
class Pair extends Element {

	private MyChar key; 
	private Element value; 
	
	public Pair(MyChar kEy, Element vAl){
		this.key = kEy; 
		this.value = vAl; 
	}
	
	public void Print(){
		System.out.print("(");
		key.Print(); 
		System.out.print(" ");
		value.Print(); 
		System.out.print(")");
	}
	
	//Helpers:
	
	String retrieve(){
		return null;
	}
	
	public MyChar getKey(){
		return key; 
	}
}
