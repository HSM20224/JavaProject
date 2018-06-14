//http://nakzzi.xyz/java/Java-mysql%EC%97%B0%EB%8F%99.html �ڹ� �����ͺ��̽� ����


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class Test extends JFrame {
	static int row = 0;
	public Test (){
		int key = 0;
	
		String columnNames[] = {"�̸�","��������","��������","��������","����","���"};

		Object rowData[][] = {{"������",11,11,11,33,11}};
		
		DefaultTableModel defaultTableModel = new DefaultTableModel(rowData, columnNames);
		JTable jTable = new JTable(defaultTableModel);
		JScrollPane jsp = new JScrollPane(jTable);
		
		jsp.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("���� ���� ���α׷�");
		setBounds(450,250,950,300);
		setLayout(new GridLayout(0,2));
		
		JPanel panel1 = new JPanel(); 
		panel1.setLayout(new GridLayout(4,3,10,10));
		
		JLabel nameLabel = new JLabel("�̸�");
		nameLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JTextField nameField = new JTextField(10);
		
		JButton addButton = new JButton("�߰�");
		
		JLabel korLabel = new JLabel("��������");
		korLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
		korLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JTextField korField = new JTextField(10);
		
		JButton removeButton = new JButton("����");	
		
		JLabel engLabel = new JLabel("��������");
		engLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
		engLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JTextField engField = new JTextField(10);
		
		JButton modifyButton = new JButton("����");
		
		JLabel mathLabel = new JLabel("��������");
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
		

		removeButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = jTable.getSelectedRow();
				
				if (row == -1){return;}
				
				defaultTableModel.removeRow(row);
				defaultTableModel.fireTableDataChanged();
			}
		});
		
		jTable.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				int ro = jTable.getSelectedRow();
				row = ro;
				
				int column = jTable.getColumnCount();
				if (row == -1){return;}
				
				nameField.setText(String.valueOf(jTable.getValueAt(row, 0)));
				korField.setText(String.valueOf(jTable.getValueAt(row, 1)));
				engField.setText(String.valueOf(jTable.getValueAt(row, 2)));
				mathField.setText(String.valueOf(jTable.getValueAt(row, 3)));
					
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				return;
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				return;
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				return;
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				return;
			}			
		});
		
		modifyButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				int kor = Integer.parseInt(korField.getText());
				int eng = Integer.parseInt(engField.getText());
				int math = Integer.parseInt(mathField.getText());
				int sum = kor+eng+math;
				int Average = (int)sum/3;
				
				Object[] obj = {name,kor,eng,math,sum,Average};
				
				for(int i = 0; i < 6; i++){
					jTable.setValueAt(obj[i], row, i);
				}
				
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
