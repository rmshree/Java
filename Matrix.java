// Creating a matrix of specific rows and columns
class Matrix extends Sequence{
	
	private Sequence row;
	private Sequence matrix;
	private MyInteger initial;
	private int rows;
	private int cols;
	
	void Set(int rowsize, int colsize, int value){
		Sequence seq;
	
		MyInteger newInt = new MyInteger(); 
		newInt.Set(value); 
		int limit = rowsize - 1;
		
		for (int j = 0; j <= rowsize; j++){
			 if(j == rowsize){
				seq = (Sequence)matrix.index(j); 
				seq.node_index(colsize, newInt); 
			 }
		}
	}
	
	int Get(int rowsize, int colsize){
		int getValue = 0;
		Sequence seq;
		
		seq = (Sequence)this.matrix.index(rowsize); 
		getValue = ((MyInteger)seq.index(colsize)).Get();
				
		return getValue;
	}
	
	Matrix(int rowsize, int colsize){
		matrix = new Sequence();
		initial = new MyInteger();
		initial.Set(0);
		rows = rowsize;
		cols = colsize;
		
		for (int i = 0; i < rowsize; i++) {
			row = new Sequence();
			for (int j = 0; j < colsize; j++){
				row.add(initial,j);
			}
			matrix.add(row, i);
		}
	} 
	
	void Print(){
		if(!(rows == 0 || cols == 0)){
			Sequence new_row = new Sequence(); 
			for (int i = 0; i < rows; i++){
				new_row = (Sequence)matrix.index(i); 
				new_row.Print();
				System.out.println("");
			}
		}
	}

	Matrix Sum(Matrix mat) {	
		int totrows;
		int totcols;
		
		if(this.rows < mat.rows){
			totrows = mat.rows;
		}
		else{
			totrows = this.rows;
		}
		
		if(this.cols < mat.cols){
			totcols = mat.cols;
		}
		else{
			totcols = this.cols;
		}
		
		Matrix total = new Matrix(totrows, totcols);
		Sequence seq1;
		Sequence seq2;
		
		int value1;
		int value2;
		
		for (int i = 0; i< rows; i++) {
			seq1 = (Sequence)this.matrix.index(i);
            seq2 = (Sequence)mat.matrix.index(i);
            	
            for (int j = 0; j < cols; j++){
            	value1 = ((MyInteger)seq1.index(j)).Get();
            	value2 = ((MyInteger)seq2.index(j)).Get();
            		
            	total.Set(i, j, value1 + value2);
			}
		}	
		return total;
	}
	
	Matrix Product(Matrix mat){	
		Matrix total = new Matrix(this.rows, mat.cols);
		if(!(this.cols == mat.rows)){
			System.out.println("Matrix dimensions incompatible for Product");
			Matrix x = new Matrix(0,0);
			return x;
		}
		
		Sequence seq1, seq2, seq3;
		int value1, value2, value3;
		int p = 0;
		for (int i = 0; i < this.rows; i++) {
				seq1 = (Sequence)this.matrix.index(i);
	            seq2 = (Sequence)mat.matrix.index(i);
	           
	            for (int j = 0; j < mat.cols; j++){
	               	for (int k = 0; k < this.cols; k++){  
	            	   seq3 = (Sequence)mat.matrix.index(k);
	            	   value1 = ((MyInteger)seq1.index(k)).Get();
	            	   value2 = ((MyInteger)seq2.index(j)).Get();
	            	   value3 = ((MyInteger)seq3.index(j)).Get();
	            	 
	            	   p = p + (value1*value3);
	            	}
	               	total.Set(i, j, p);
	               	p = 0;
	            }
	    }
		return total;
	}
}