package org.trlove.common.test.util.shudu;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GenerateHard implements ActionListener{
	public static JPanel jp_hard = new JPanel();                          //easy�����еı���
	public static JPanel[] panel_hard = new JPanel[9];
	public static JButton jb_hard ;
	public static void init_panel_easy()
	{
		for(int m = 0; m < panel_hard.length; m++)
		{
			panel_hard[m] = new JPanel();
		}
	}
	int[][] HardIdentityMatrix = {
			{0,1,0,1,1,0,1,1,1},
			{0,0,0,1,1,1,1,1,1},
			{1,1,1,1,0,1,1,1,0},
			{0,1,1,1,0,1,0,1,1},
			{1,1,1,0,1,1,1,1,0},
			{0,1,0,0,1,1,1,1,1},
			{1,1,0,1,1,1,0,0,0},
			{1,1,1,1,0,0,1,0,1},
			{0,1,1,0,1,1,1,1,1}
	};
	int i = 0;
	int j =0;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MyFrame.jp2.setVisible(false);
		jp_hard.setBounds(0, 100, 1000, 900);                               //panel2�Ĳ���
		jp_hard.setBackground(Color.lightGray);
		jp_hard.setLayout(new GridLayout(3, 3, 10,10));
		for(i = 0; i < 9; i++)
		{
			MyFrame.panel2[i].setVisible(false);
			init_panel_easy();
			jp_hard.add(panel_hard[i]);
			panel_hard[i].setLayout(new GridLayout(3,3,3,3));
			for(j = 0; j < 9; j++)
			{
				MyFrame.jb2[j].setVisible(false);
				jb_hard = new JButton();
				panel_hard[i].add(jb_hard);
				if(HardIdentityMatrix[i][j] == 0)
				{
					Seed.ChooseSeed();
					Seed.getArrayWithDiagonalSymmetry();
					jb_hard.setText(String.valueOf(Seed.result[i][j]));
				}
				else {
					jb_hard.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							
							MyJDialog mj = new MyJDialog(new MyFrame());    //ִ�й��캯���������Ի���
							
							MyJDialog.jc_dialog.addItemListener(new ItemListener() {               //����button����������
								public void itemStateChanged(ItemEvent e) {
									String num = e.getItem().toString();
									if(num == "1" | num == "2" | num =="3" | num == "4" | num =="5" | num == "6" | num =="7" | num =="8" | num =="9")
									{
										MyJDialog.jb_dialog_y.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												jb_hard = (JButton)arg0.getSource();
												jb_hard.setText(num);
												mj.setVisible(false);
												
											}
										});
										MyJDialog.jb_dialog_n.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												jb_hard = (JButton)arg0.getSource();
												jb_hard.setText("");
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
				
				
				//�ж���Ӯ
			}
		}
		MyFrame.container.add(jp_hard);
		
	}
	
}
