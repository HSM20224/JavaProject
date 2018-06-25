import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class FrServer extends JFrame {
	JTextArea ta;
	JTextField tf;

	public FrServer() {
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("채팅방 서버");
		setLayout(new BorderLayout());

		JLabel label = new JLabel("This is a server ! ");
		ta = new JTextArea(25, 40);
		tf = new JTextField(25);

		add(label, BorderLayout.NORTH);
		add(ta, BorderLayout.CENTER);
		add(tf, BorderLayout.SOUTH);
		setVisible(true);

	}

}

public class TcpServer {
	HashMap clients;
	String name;
	String contents;
	String msgs = "aa";

	public String getMsgs() {
		return msgs;
	}

	public void setMsgs(String msgs) {
		this.msgs = msgs;
	}

	DAO dao = new DAO();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public TcpServer() {
		clients = new HashMap();
		Collections.synchronizedMap(clients);

	}

	public static void main(String args[]) {
		FrServer f = new FrServer();
		new TcpServer().start();
	}

	public void start() {
		ServerSocket ss = null;
		Socket s = null;
		try {
			ss = new ServerSocket(7777);
			System.out.println("서버가 시작됨");

			while (true) {
				s = ss.accept();
				System.out.println("[" + s.getInetAddress() + "에서 점속함" + "]");
				ServerReceiver thread = new ServerReceiver(s);
				thread.start();

				System.out.println("쓰레드 이름 :" + thread.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	void sendToAll(String msg) {
		Iterator it = clients.keySet().iterator();
		String[] arr = new String[2];
		
		while (it.hasNext()) {
			if (msg.contains(":")){
				System.out.println("검사완료");
				int idx = msg.indexOf(":");
				name = msg.substring(0, idx);
				contents = msg.substring(idx+2);
			}
			try {
				DataOutputStream out = (DataOutputStream) clients.get(it.next());
				out.writeUTF(msg);
				dao.insertChat(this);
			} catch (IOException e) {
				System.out.println("sendToall 입출력에러");
				System.out.println(e.getMessage());
			}
		}
			
	}

	class ServerReceiver extends Thread {
		Socket s;
		DataInputStream in;
		DataOutputStream out;

		ServerReceiver(Socket s) {
			this.s = s;
			try {
				in = new DataInputStream(s.getInputStream());
				out = new DataOutputStream(s.getOutputStream());

			} catch (IOException e) {
				System.out.println("서버 리시버 소켓 IO 에러");
			}
		}

		public void run() {
			String name = "";
			try {
				name = in.readUTF();
				sendToAll("#" + name + "님이 들어오셨습니다. ");
				clients.put(name, out);

				System.out.println("현재 접속자 수는" + clients.size() + "입니다.");
				System.out.println("현재 접속자 목록 : ");

				while (in != null) {
					sendToAll(in.readUTF());
				}
			} catch (IOException e) {
				System.out.println("리시버 도중 io에러");
			} finally {
				sendToAll("#" + name + "님이 나가셨습니다.");
				clients.remove(name);
				System.out.println("[" + s.getInetAddress() + ":" + s.getPort() + "] 에서 접속을 종료함");
				System.out.println("현재 접속자는 " + clients.size() + "입니다");
			}
		}

		
	}
}
