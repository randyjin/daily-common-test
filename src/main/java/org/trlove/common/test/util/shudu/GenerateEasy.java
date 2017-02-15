package org.trlove.common.test.util.shudu;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.xml.namespace.QName;

public class GenerateEasy implements ActionListener{
	public static JPanel jp_easy = new JPanel();
	public static JPanel[] panel_easy = new JPanel[9];
	public static JButton jb_easy ;
	public static void init_panel_easy()
	{
		for(int m = 0; m < panel_easy.length; m++)
		{
			panel_easy[m] = new JPanel();
		}
	}
	int[][] EasyIdentityMatrix = {
			{0,1,0,1,0,1,0,1,1},
			{1,0,0,1,1,0,1,1,0},
			{1,0,1,1,0,1,1,0,0},
			{0,0,1,1,0,0,1,1,1},
			{0,0,1,1,0,1,0,1,1},
			{1,1,1,0,1,0,1,0,0},
			{0,1,1,0,1,0,1,0,1},
			{1,1,0,0,1,1,0,0,1},
			{1,1,0,0,1,1,0,1,0}
	};
	public static String[][] kong_easy = {
		{"_ ","_ ","_ ","_ ","_ ","_ ","_ ","_ ","_ "},
		{"_ ","_ ","_ ","_ ","_ ","_ ","_ ","_ ","_ "},
		{"_ ","_ ","_ ","_ ","_ ","_ ","_ ","_ ","_ "},
		{"_ ","_ ","_ ","_ ","_ ","_ ","_ ","_ ","_ "},
		{"_ ","_ ","_ ","_ ","_ ","_ ","_ ","_ ","_ "},
		{"_ ","_ ","_ ","_ ","_ ","_ ","_ ","_ ","_ "},
		{"_ ","_ ","_ ","_ ","_ ","_ ","_ ","_ ","_ "},
		{"_ ","_ ","_ ","_ ","_ ","_ ","_ ","_ ","_ "},
		{"_ ","_ ","_ ","_ ","_ ","_ ","_ ","_ ","_ "}
	};
	//String[] kong_easy = new String[9];
	String s ;
	int i = 0;
	int j = 0;
	public void actionPerformed(ActionEvent e) {
		MyFrame.jp2.setVisible(false);
		jp_easy.setBounds(0, 100, 1000, 900);                               //panel2�Ĳ���
		jp_easy.setBackground(Color.lightGray);
		jp_easy.setLayout(new GridLayout(3, 3, 10,10));
		for(i = 0; i < 9; i++)
		{
			MyFrame.panel2[i].setVisible(false);
			init_panel_easy();
			jp_easy.add(panel_easy[i]);
			panel_easy[i].setLayout(new GridLayout(3,3,3,3));
			for(j = 0; j < 9; j++)
			{
				MyFrame.jb2[j].setVisible(false);
				jb_easy = new JButton();
				panel_easy[i].add(jb_easy);
				if(EasyIdentityMatrix[i][j] == 0)
				{
					Seed.ChooseSeed();
					Seed.getArrayWithDiagonalSymmetry();
					jb_easy.setText(String.valueOf(Seed.result[i][j]));
					
					kong_easy[i][j] = jb_easy.getText();
					//System.out.print(kong_easy[i][j]);
					
				}
				else {
					jb_easy.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							MyJDialog mj = new MyJDialog(new MyFrame());    //ִ�й��캯���������Ի���
							
							MyJDialog.jc_dialog.addItemListener(new ItemListener() {               //����button����������
								public void itemStateChanged(ItemEvent e) {
									String num = e.getItem().toString();
									if(num == "1" | num == "2" | num =="3" | num == "4" | num =="5" | num == "6" | num =="7" | num =="8" | num =="9")
									{
										MyJDialog.jb_dialog_y.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												jb_easy = (JButton)arg0.getSource();
												jb_easy.setText(num);
												
												s = jb_easy.getText();
												//kong_easy[i][j] = jb_easy.getText();
												//System.out.print(s);
												
												mj.setVisible(false);
											}
										});
										MyJDialog.jb_dialog_n.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												jb_easy = (JButton)arg0.getSource();
												jb_easy.setText("");
											}
										});	
									}
								}
							});
							
							mj.container_dialog.add(MyJDialog.jc_dialog);
							mj.setVisible(true);
						}
					});
				}
				//�ж�
				/*if(j ==8)
				{
					System.out.println(kong_easy[i][j]);
				}
				else{
					System.out.print(kong_easy[i][j] + " ");
				}*/
				
				if(EasyIdentityMatrix[i][j] == 0){
					kong_easy[i][j] = jb_easy.getText();
				}
				else{
					kong_easy[i][j] = s;
				}
			}
		}
		MyFrame.container.add(jp_easy);
	}
	
}
