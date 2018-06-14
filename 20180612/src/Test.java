//http://nakzzi.xyz/java/Java-mysql%EC%97%B0%EB%8F%99.html 자바 데이터베이스 연동


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class Test extends JFrame {
	public Test (){
		
		int key = 0;
	
		String columnNames[] = {"이름","국어점수","영어점수","수학점수","총점","평균"};

		Object rowData[][] = {{"양정현",11,11,11,33,11}};
		
		DefaultTableModel defaultTableModel = new DefaultTableModel(rowData, columnNames);
		JTable jTable = new JTable(rowData, columnNames);
		JScrollPane jsp = new JScrollPane(jTable);
		
		jsp.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("성적 관리 프로그램");
		setBounds(450,250,950,300);
		setLayout(new GridLayout(0,2));
		
		JPanel panel1 = new JPanel(); 
		panel1.setLayout(new GridLayout(4,3,10,10));
		
		JLabel nameLabel = new JLabel("이름");
		nameLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JTextField nameField = new JTextField(10);
		
		JButton addButton = new JButton("추가");
		
		JLabel korLabel = new JLabel("국어점수");
		korLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
		korLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JTextField korField = new JTextField(10);
		
		JButton removeButton = new JButton("제거");	
		
		JLabel engLabel = new JLabel("영어점수");
		engLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
		engLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JTextField engField = new JTextField(10);
		
		JButton modifyButton = new JButton("수정");
		
		JLabel mathLabel = new JLabel("수학점수");
		mathLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
		mathLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JTextField mathField = new JTextField(10);
		
		
		addButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				int kor = Integer.parseInt(korField.getText());
				int eng = Integer.parseInt(engField.getText());
				int math = Integer.parseInt(mathField.getText());
				int sum = kor+eng+math;
				int Average = (int)sum/3;
				
				Object [] temporaryObject = {name, kor, eng, math, sum, Average};
				defaultTableModel.addRow(temporaryObject);
				defaultTableModel.fireTableDataChanged();
			}
			
		});
		
		
		panel1.add(nameLabel);
		panel1.add(nameField);
		panel1.add(addButton);
		panel1.add(korLabel);
		panel1.add(korField);
		panel1.add(removeButton);
		panel1.add(engLabel);
		panel1.add(engField);
		panel1.add(modifyButton);
		panel1.add(mathLabel);
		panel1.add(mathField);
		
		add(panel1);
		add(jsp);
		
		setVisible(true);
	}
	
	public static void main(String[] args){
		Test t = new Test();
	}
}
