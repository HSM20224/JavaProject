
public class TelevisionTest15 {
	public static void main(String[] args) {
		Television15 myTv = new Television15();
		myTv.channel = 7;
		myTv.volume = 9;
		myTv.onOff = true;
		int ch = myTv.getChannel();
		System.out.println("현재 채널은 "+ ch + "입니다.");
	}
}
