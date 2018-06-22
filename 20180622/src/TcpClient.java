import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TcpClient {
	Socket s = null;
	OutputStream out;
	InputStream in;
	BufferedReader br;
	BufferedWriter bw;
	private int serverPort = 7;
	private String ipAddress = "localhost";
	
	
	public TcpClient(){
		FrClient fc = new FrClient();
		try{
			s = new Socket(ipAddress, serverPort);
			in = s.getInputStream();
			out = s.getOutputStream();
			br = new BufferedReader(new InputStreamReader(in));
			bw = new BufferedWriter(new OutputStreamWriter(out));
		} catch(Exception i) {
			i.printStackTrace();
		}
		
	}
	class FrClient extends JFrame{
		JTextArea ta;
		JTextField tf;
		
		public FrClient(){
			setSize(600,400);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle("채팅방 서버");
			setLayout(new BorderLayout());
			
			JLabel label = new JLabel("클라이언트");
			ta = new JTextArea(25, 40);
			tf = new JTextField(25);
			
			add(label, BorderLayout.NORTH);
			add(ta, BorderLayout.CENTER);
			add(tf, BorderLayout.SOUTH);
			setVisible(true);
			
			tf.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					try {
						String str = tf.getText();
						System.out.println(str);
						bw.write(str);
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
			});
		}
		
		
	}
	
	public static void main(String args[]){
		TcpClient tc = new TcpClient();
	}
}

