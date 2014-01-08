package GUI;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.jws.Oneway;
import javax.swing.JButton;
import javax.swing.JFrame;

public class IntroFrame extends JFrame
{
	private int width;
	private int height;
	private JButton stationBut;
	private JButton dutyBut;
	private JButton workerBut;
	
	public IntroFrame(int width,int height)
	{
		this.width=width;
		this.height=height;
		setSize(width,height);
		
		Toolkit tool=Toolkit.getDefaultToolkit();
		Dimension dim=tool.getScreenSize();
		setLayout(new GridLayout(3,1));
		setLocation((dim.width-width)/2, (dim.height-height)/2);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.stationBut=new JButton("Stacje");
		this.dutyBut=new JButton("Dy¿ury");
		this.workerBut=new JButton("Pracownicy");
		this.stationBut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		this.dutyBut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		this.workerBut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				
			}
		});
		add(stationBut);
		add(dutyBut);
		add(workerBut);
		
		
	}

}
