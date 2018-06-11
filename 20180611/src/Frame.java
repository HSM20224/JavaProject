import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Frame extends JFrame {
	public Frame() {
		setLayout(new GridLayout(2,0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("구구단테스트");
		JPanel jp = new JPanel(); 
		jp.setLayout(new FlowLayout());
		JLabel jl1 = new JLabel("수를 입력 : ");
		JLabel result = new JLabel("결과창");
		result.setHorizontalAlignment((int) JComponent.CENTER_ALIGNMENT);
		result.setForeground(Color.blue);
		JTextField jt1 = new JTextField(10);
		JButton jb1 = new JButton("입력");
		
		jb1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				int j = Integer.parseInt(jt1.getText());		
				String[] gugudan = new String[9]; 
				
				for(int i = 1; i <= 9; i++){
					int sum = j*i;
					gugudan[i-1] = j+"*"+i+"="+sum+" \n";
					result.setText(Arrays.toString(gugudan));
				}
				
				
			}
		});
		
		add(jp);
		jp.add(jl1);
		jp.add(jt1);
		jp.add(jb1);
		add(result);
		setSize(600,100);
		setVisible(true);
	}
	
	public static void main(String[] args){
		Frame f = new Frame();
	}
}
