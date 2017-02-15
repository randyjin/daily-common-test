package org.trlove.common.test.util.shudu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.StyledEditorKit.ForegroundAction;

public class MyFrame extends JFrame {
	public static Container container = new Container();                  //���е�ȫ�ֲ�����
	
	public JPanel jp1 = new JPanel();
	public JLabel jl1 = new JLabel();
	public JComboBox<String> jc1 = new JComboBox<String>(new MyComboBox());
	public JButton jb1 = new JButton();
	
	public static JPanel jp2 = new JPanel();                              //��ʼ�����еı���
	public static JPanel[] panel2 = new JPanel[9];
	public static JButton[] jb2 = new JButton[9];
	public static void init_panel()
	{
		for(int m = 0; m < panel2.length; m++)
		{
			panel2[m] = new JPanel();
		}
	}
	public static void init_button()
	{
		for(int n = 0; n < jb2.length; n++)
		{
			jb2[n] = new JButton("");
		}
	}
	
	public void MyFrame1()
	{
		container = this.getContentPane();                          //�������岼��
		this.setSize(1000, 1000);
		this.setTitle("SupSudoku");
		this.setVisible(true);
		this.setLayout(null);
		this.setBounds(0, 0, 1000, 1500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jp1.setBounds(0, 0, 1000, 100);                               //panel1�Ĳ���
		jp1.setBackground(Color.lightGray);
		jp1.setLayout(new FlowLayout(1,20,20));  
		jl1.setText("choose your level");
		jl1.setFont(new Font("Calibri", Font.BOLD, 30));
		jp1.add(jl1);
		jc1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				String item = arg0.getItem().toString();
				if(item == "Easy")
				{
					jb1.addActionListener(new GenerateEasy());
				}
				else if(item == "Medium")
				{
					jb1.addActionListener(new GenerateMedium());
				}
				else {
					jb1.addActionListener(new GenerateHard());
				}
			}
		});
		jp1.add(jc1);
		jb1.setText("generate");
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		jp1.add(jb1);
		container.add(jp1,BorderLayout.NORTH);
		
		
		jp2.setBounds(0, 100, 1000, 900);                               //panel2�Ĳ���
		jp2.setBackground(Color.lightGray);
		jp2.setLayout(new GridLayout(3, 3, 10,10));
		for(int i = 0; i < 9; i++)
		{
			init_panel();
			jp2.add(panel2[i]);
			panel2[i].setLayout(new GridLayout(3,3,3,3));
			init_button();
			for(int j = 0; j < 9; j++)
			{
				jb2[j].setText("");
				panel2[i].add(jb2[j]);
			}
		}
		container.add(jp2);
		
		
	}
	
	public class MyComboBox extends AbstractListModel<String> implements ComboBoxModel<String>
	{
		String SelectedItem = null;
		String[] test = {"Easy","Medium","Hard"};
		public String getElementAt(int index) {
			return test[index];
		}
		public int getSize() {
			return test.length;
		}
		public Object getSelectedItem() {
			return SelectedItem;
		}
		public void setSelectedItem(Object item) {
			SelectedItem = (String)item;
		}
	}
}

