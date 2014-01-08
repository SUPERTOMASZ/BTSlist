package GUI;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;

public abstract class TemplaterFrame extends JFrame
{
	protected int width;
	protected int height;
	protected JTable tableView;
	protected JButton synchBut;
	protected JButton updateBut;
	protected JButton deleteBut;
	protected JButton addBut;
	protected JComboBox<String> categories;
	protected String[] categoriesTable;
	protected JTextArea enterArea;
	
	public TemplaterFrame(int width,int height)
	{
		this.width=width;
		this.height=height;
		setSize(width,height);
		setResizable(false);
		Toolkit tool=Toolkit.getDefaultToolkit();
		Dimension dim=tool.getScreenSize();
		setLayout(new GridLayout(3,1));
		setLocation((dim.width-width)/2, (dim.height-height)/2);
		setCategories(categoriesTable);
		setGui();
		setVisible(true);
		
	}
	public class MyPanel extends JPanel
	{
		
		
		
	}
	protected abstract void setCategories(String [] table);
	
	private void setGui()
	{
		this.tableView= new JTable();
		this.addBut=new JButton("dodaj");
		this.updateBut= new JButton("zmieñ");
		this.deleteBut= new JButton("usuñ");
		this.synchBut= new JButton("synchronizuj");
		this.categories= new JComboBox<String>(categoriesTable);
		this.enterArea= new JTextArea();
		
	}

}
