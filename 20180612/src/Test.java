//http://nakzzi.xyz/java/Java-mysql%EC%97%B0%EB%8F%99.html �ڹ� �����ͺ��̽� ����

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;

public class Test extends JFrame {
	static int row = 0;
	

	String columnNames[] = {"�̸�","��������","��������","��������","����","���"};
	Object rowData[][] = {};

	public Test (){
		
		Score score = new Score();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("���� �������α׷�");
		setBounds(450,250,1200,320);
		setLayout(null);
		
		DefaultTableModel defaultTableModel = new DefaultTableModel(rowData, columnNames);
		JTable jTable = new JTable(defaultTableModel);
		JScrollPane jsp = new JScrollPane(jTable);
		jsp.setBorder(BorderFactory.createLineBorder(Color.black));
		jsp.setBounds(410, 10, 760, 260);
		 
		JLabel nameLabel = new JLabel("�̸�");
		nameLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBounds(10, 10, 120, 50);
		
		JTextField nameField = new JTextField(10);
		nameField.setBounds(140, 10, 120, 50);
		
		JButton addButton = new JButton("�߰�");
		addButton.setBounds(270, 10, 120, 50);
		
		JLabel korLabel = new JLabel("��������");
		korLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
		korLabel.setHorizontalAlignment(SwingConstants.CENTER);
		korLabel.setBounds(10, 70, 120, 50);
		
		JTextField korField = new JTextField(10);
		korField.setBounds(140, 70, 120, 50);
		
		JButton removeButton = new JButton("����");
		removeButton.setBounds(270, 70, 120, 50);
		
		JLabel engLabel = new JLabel("��������");
		engLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
		engLabel.setHorizontalAlignment(SwingConstants.CENTER);
		engLabel.setBounds(10, 130, 120, 50);
		
		JTextField engField = new JTextField(10);
		engField.setBounds(140, 130, 120, 50);
		
		JButton modifyButton = new JButton("����");
		modifyButton.setBounds(270, 130, 120, 50);
		
		JLabel mathLabel = new JLabel("��������");
		mathLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
		mathLabel.setHorizontalAlignment(SwingConstants.CENTER);
		mathLabel.setBounds(10, 190, 120, 50);
		
		JTextField mathField = new JTextField(10);
		mathField.setBounds(140, 190, 120, 50);
		
		JFrame alert = new JFrame();
		alert.setBounds(450, 250, 450, 250);
		
		
		addButton.addActionListener(new ActionListener(){
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				score.setName(nameField.getText());
 				score.setKor(Integer.parseInt(korField.getText()));
 				score.setEng(Integer.parseInt(engField.getText()));
 				score.setMath(Integer.parseInt(mathField.getText()));
 				score.setSum(score.getKor()+score.getEng()+score.getMath());
 				score.setAverage((int)score.getSum()/3);
 				
 				Object [] temporaryObject = {score.getName(), score.getKor(),score.getEng(), score.getMath(), score.getSum(), score.getAverage() };
 				defaultTableModel.addRow(temporaryObject);
 				nameField.setText("");
				korField.setText("");
				engField.setText("");
				mathField.setText("");
 				defaultTableModel.fireTableDataChanged();
 			}
			
		});
		

		removeButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				int row = jTable.getSelectedRow();
				
				if (row == -1){return;}
				
				defaultTableModel.removeRow(row);
				nameField.setText("");
				korField.setText("");
				engField.setText("");
				mathField.setText("");
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
				score.setName(nameField.getText());
 				score.setKor(Integer.parseInt(korField.getText()));
 				score.setEng(Integer.parseInt(engField.getText()));
 				score.setMath(Integer.parseInt(mathField.getText()));
 				score.setSum(score.getKor()+score.getEng()+score.getMath());
 				score.setAverage((int)score.getSum()/3);
 				
 				Object [] temporaryObject = {score.getName(), score.getKor(),score.getEng(), score.getMath(), score.getSum(), score.getAverage() };
				
				for(int i = 0; i < 6; i++){
					jTable.setValueAt(temporaryObject[i], row, i);
				}
				nameField.setText("");
				korField.setText("");
				engField.setText("");
				mathField.setText("");
				defaultTableModel.fireTableDataChanged();
				
			}
 		});

		add(nameLabel);
		add(nameField);
		add(addButton);
		add(korLabel);
		add(korField);
		add(removeButton);
		add(engLabel);
		add(engField);
		add(modifyButton);
		add(mathLabel);
		add(mathField);
	
		add(jsp);
			
		setVisible(true);
		
		
	}
	
	
	
	public static void main(String[] args){
		Test t = new Test();
	}
}