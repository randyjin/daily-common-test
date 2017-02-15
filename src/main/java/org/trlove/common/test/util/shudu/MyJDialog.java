package org.trlove.common.test.util.shudu;

import java.awt.Container;
import java.awt.Font;

import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class MyJDialog extends JDialog{
	public static Container container_dialog;
	public static JComboBox<String> jc_dialog;
	public static JButton jb_dialog_y;
	public static JButton jb_dialog_n;
	public MyJDialog(MyFrame mf)
	{
		super(mf," ",true);
		this.setBounds(200, 200, 600, 400);
		this.setLayout(null);
		container_dialog = this.getContentPane();
		
		JLabel jl_dialog = new JLabel("choose a number");
		jl_dialog.setBounds(150, 5, 250, 80);
		jl_dialog.setFont(new Font("Calibri", Font.BOLD, 25));
		container_dialog.add(jl_dialog);
		
		jc_dialog = new JComboBox<>(new MyComboBox_dialog());
		jc_dialog.setBounds(150, 80, 250, 50);
		container_dialog.add(jc_dialog);
		
		jb_dialog_y = new JButton("YES");
		jb_dialog_y.setBounds(100, 200, 100, 30);
		container_dialog.add(jb_dialog_y);
		
		jb_dialog_n = new JButton("NO");
		jb_dialog_n.setBounds(350, 200, 100, 30);
		container_dialog.add(jb_dialog_n);
	}
	
	
	class  MyComboBox_dialog extends AbstractListModel<String> implements ComboBoxModel<String>
	{
		 String SelectedItem = null;
		 String[] number = {"1","2","3","4","5","6","7","8","9"};
		public String getElementAt(int index) {
			return number[index];
		}
		public int getSize() {
			return number.length;
		}
		public Object getSelectedItem() {
			return SelectedItem;
		}
		public void setSelectedItem(Object item) {
			SelectedItem = (String)item;
		}
	}
}
