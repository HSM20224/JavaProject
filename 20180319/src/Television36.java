
	public class Television36 {
		private int channel;
		private int volume;
		private boolean onOff;
		
		Television36(int c, int v, boolean o) {
			channel = c;
			volume = v;
			onOff = o;
		}
		
		void print() { 
			System.out.println("ä���� "+channel+"�̰� ������"+volume+"�Դϴ�.");
		}	
	
		public static void main(String[] args){
			Television36 myTv = new Television36(7,10,true);
			myTv.print();
			Television36 yourTv = new Television36(11,20,true);
			yourTv.print();
			
		}
}
