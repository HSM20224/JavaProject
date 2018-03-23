
public class Television58 {
	private String model;
	
	void setModel(String  b){
		model = b;
	}
	
	String getModel(){
		return model;
	}
	
	public static void main(String[] args){
		Television58 t = new Television58();
		t.setModel("STV-101");
		String b = t.getModel();
	}
}
