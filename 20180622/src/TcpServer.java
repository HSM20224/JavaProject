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
		setTitle("ä�ù� ����");
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
			ss = new ServerSocket(7);
			System.out.println("������ ���۵�");

			while (true) {
				s = ss.accept();
				System.out.println("[" + s.getInetAddress() + "���� ������" + "]");
				ServerReceiver thread = new ServerReceiver(s);
				thread.start();

				System.out.println("������ �̸� :" + thread.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	void sendToAll(String msg) {
		Iterator it = clients.keySet().iterator();

		while (it.hasNext()) {
			try {
				DataOutputStream out = (DataOutputStream) clients.get(it.next());
				out.writeUTF(msg);

			} catch (IOException e) {
				System.out.println("sendToall ����¿���");
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
				System.out.println("���� ���ù� ���� IO ����");
			}
		}

		public void run() {
			String name = "";
			try {
				name = in.readUTF();
				sendToAll("#" + name + "���� �����̽��ϴ�. ");

				clients.put(name, out);
				System.out.println("���� ������ ����" + clients.size() + "�Դϴ�.");
				System.out.println("���� ������ ��� : ");

				while (in != null) {
					sendToAll(in.readUTF());
				}
			} catch (IOException e) {
				System.out.println("���ù� ���� io����");
			} finally {
				sendToAll("#" + name + "���� �����̽��ϴ�.");
				clients.remove(name);
				System.out.println("[" + s.getInetAddress() + ":" + s.getPort() + "] ���� ������ ������");
				System.out.println("���� �����ڴ� " + clients.size() + "�Դϴ�");
			}
		}

	}
}
