package org.trlove.common.test.util.shudu;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GenerateMedium implements ActionListener{
	public static JPanel jp_medium = new JPanel();
	public static JPanel[] panel_medium = new JPanel[9];
	public static JButton jb_medium ;
	public static void init_panel_easy()
	{
		for(int m = 0; m < panel_medium.length; m++)
		{
			panel_medium[m] = new JPanel();
		}
	}
	int[][] MediumIdentityMatrix = {
			{1,1,0,1,0,1,0,0,0},
			{1,0,1,0,0,1,1,1,1},
			{0,1,1,0,1,0,1,1,1},
			{1,1,1,0,0,1,0,1,1},
			{1,1,0,1,1,0,0,1,1},
			{0,0,1,1,0,0,1,1,1},
			{0,0,1,1,1,1,1,1,0},
			{1,1,0,0,1,1,1,0,1},
			{1,0,1,1,1,1,1,0,0}
	};
	int i = 0;
	int j = 0;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		MyFrame.jp2.setVisible(false);
		jp_medium.setBounds(0, 100, 1000, 900);                               //panel2�Ĳ���
		jp_medium.setBackground(Color.lightGray);
		jp_medium.setLayout(new GridLayout(3, 3, 10,10));
		for(i = 0; i < 9; i++)
		{
			MyFrame.panel2[i].setVisible(false);
			init_panel_easy();
			jp_medium.add(panel_medium[i]);
			panel_medium[i].setLayout(new GridLayout(3,3,3,3));
			for(j = 0; j < 9; j++)
			{
				MyFrame.jb2[j].setVisible(false);
				jb_medium = new JButton();
				panel_medium[i].add(jb_medium);
				if(MediumIdentityMatrix[i][j] == 0)
				{
					Seed.ChooseSeed();
					Seed.getArrayWithDiagonalSymmetry();
					jb_medium.setText(String.valueOf(Seed.result[i][j]));
				}
				else {
					jb_medium.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							
							MyJDialog mj = new MyJDialog(new MyFrame());    //ִ�й��캯���������Ի���
							
							MyJDialog.jc_dialog.addItemListener(new ItemListener() {               //����button����������
								public void itemStateChanged(ItemEvent e) {
									String num = e.getItem().toString();
									if(num == "1" | num == "2" | num =="3" | num == "4" | num =="5" | num == "6" | num =="7" | num =="8" | num =="9")
									{
										MyJDialog.jb_dialog_y.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												jb_medium = (JButton)arg0.getSource();
												jb_medium.setText(num);
												mj.setVisible(false);
												
											}
										});
										MyJDialog.jb_dialog_n.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												jb_medium = (JButton)arg0.getSource();
												jb_medium.setText("");
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
		MyFrame.container.add(jp_medium);
		
	}
	
}
