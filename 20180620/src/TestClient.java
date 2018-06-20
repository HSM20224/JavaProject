import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TestClient {
	protected JTextField tf;     
	protected JTextArea ta; 
	DatagramSocket s;
	DatagramPacket p;
	InetAddress address = null;
	final int myPort = 1000;
	final int otherPort = 2000;
	public TestClient() throws IOException {
		 MyFrame mf = new  MyFrame();
		 address = InetAddress.getByName("127.0.0.1");
		 s = new DatagramSocket(myPort);
		 
	}
	
	public void process() {
		while(true) {
			try{
				byte[] buf = new byte[256];
				p = new DatagramPacket(buf,buf.length);
				s.receive(p);
				ta.append("RECIVED : "+ new String(buf) + "\n");
			} catch (IOException ioException){
				ioException.printStackTrace();
			}
			
			
		}
	}
	
	class MyFrame extends JFrame {
		 
	public MyFrame() {
			setTitle("example");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setLayout(null);
			setSize(320,500);
			setVisible(true);
			ta = new JTextArea(10,30);
			tf = new JTextField(30);
			ta.setEditable(false);
			JButton btn = new JButton("º¸³»±â");
			
			btn.setBounds(208, 400, 90, 50);
			tf.setBounds(8, 400, 190, 50);
			ta.setBounds(0, 0, 300, 400);
			
			btn.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					String str = tf.getText();
					byte[] buffer = str.getBytes();
					DatagramPacket packet;
					
					packet = new DatagramPacket(buffer,buffer.length, address, otherPort);
					try{
						s.send(packet);
					} catch(IOException io) {
						io.printStackTrace();
					}
					ta.append("SENT : "+str+"\n" );
					tf.setText("");
				}
				
			});
			
			add(ta);
			add(tf);
			add(btn);
			
			}
	}
	public static void main(String[] args) throws IOException{
		TestClient tc = new TestClient();
		tc.process();
	}
}
