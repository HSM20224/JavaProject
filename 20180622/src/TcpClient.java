import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.DefaultCaret;

public class TcpClient {
	JTextArea ta;
	JTextField tf;
	String msg;
	Socket s = null;
	OutputStream out;
	DataOutputStream dos;
	InputStream in;
	DataInputStream dis;
	private int serverPort = 7777;
	private String ipAddress = "localhost";
	String name;

	public TcpClient() {
		Scanner sc = new Scanner(System.in);
		name = sc.nextLine();
		FrClient fc = new FrClient();
		try {
			s = new Socket(ipAddress, serverPort);
			in = s.getInputStream();
			out = s.getOutputStream();
			dos = new DataOutputStream(out);
			dos.writeUTF(name);
			ClientReceiver thread = new ClientReceiver(s);
			thread.start();
		} catch (Exception i) {
			i.printStackTrace();
		}

	}

	public void start() {
		while (true) {

		}

	}

	public static void main(String args[]) {
		TcpClient tc = new TcpClient();
	}

	class FrClient extends JFrame {

		public FrClient() {
			setSize(600, 400);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setTitle("채팅방 클라");
			setLayout(new BorderLayout());

			JLabel label = new JLabel("클라이언트");
			ta = new JTextArea(25, 40);
			ta.setAutoscrolls(true);
			ta.setEditable(false);
			JButton btn = new JButton("대화내용 불러오기");
			JScrollPane scroll = new JScrollPane(ta);
			scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			tf = new JTextField(25);
			DefaultCaret caret = (DefaultCaret) ta.getCaret();
			caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

			add(btn, BorderLayout.NORTH);
			add(scroll, BorderLayout.CENTER);
			add(tf, BorderLayout.SOUTH);

			setVisible(true);

			tf.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					try {
						String str = tf.getText();
						dos.writeUTF(name + " : " + str + "\n");
						tf.setText("");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

			});

			btn.addActionListener(new ActionListener() {
				DAO dao = new DAO();

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					ta.append(dao.getChat());
				}

			});
		}

	}

	class ClientReceiver extends Thread {
		Socket s;
		DataInputStream in;

		ClientReceiver(Socket s) {
			this.s = s;
			try {
				in = new DataInputStream(s.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		public void run() {
			while (in != null) {
				try {
					String s = in.readUTF();
					// System.out.println(s);
					ta.append(s + "\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
