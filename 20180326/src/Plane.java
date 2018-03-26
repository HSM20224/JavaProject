
public class Plane {
	private String model;
	private String company;
	private int p_num;
	public static int planes;
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getP_num() {
		return p_num;
	}

	public void setP_num(int p_num) {
		this.p_num = p_num;
	}
	
	public static int getPlanes() {
		return planes;
	}
	
	public Plane(){}
	
	public Plane(String company){
		this.company = company; 
	}
	
	public Plane(String company, String model){
		this.company = company; 
		this.model = model;
	}
	
	public Plane(String company, String model, int p_num){
		this.company = company; 
		this.model = model;
		this.p_num = p_num;
	}
}
class PlaneTest{
	public static void main(String[] args){
		System.out.println(Plane.getPlanes());
	}
}
