package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class IntroFrame extends JFrame {

	private Panel panel;
	private int width;
	private int height;
	private int screenWidth;
	private int screenHeight;
	public IntroFrame(int width,int height ) {
		this.panel= new Panel();
		setLayout(new BorderLayout());
		getContentPane().setLayout(null);
		setTitle("BTS Maintenance System");
		Toolkit tool=Toolkit.getDefaultToolkit();
		this.width=width;
		this.height=height;
		Dimension dim=tool.getScreenSize();
		this.screenWidth=dim.width;
		this.screenHeight=dim.height;
		setLocation( (dim.width-width)/2, (dim.height-height)/2);
		setSize(200, 300);
		Color color= new Color(45,45,45);
		add(new Panel(),BorderLayout.CENTER);
		//getContentPane().setBackground(color);

		setVisible(true);
		
	}
	class Panel extends JPanel
	{
		
		public Panel()
		{
			setLayout(null);
			setSize(width,height);
			setVisible(true);
	
		}
		@Override
		  protected void paintComponent(Graphics g) {
		    super.paintComponent(g);
		    // paint the background image and scale it to fill the entire space
		     BufferedImage img = null;
			try {
				System.out.println(getClass().getResource("/images/Intro.jpg"));
				img =  ImageIO.read(getClass().getResource("/images/Intro.jpg"));
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    g.drawImage(img, 0, 0, width, height, this);
		  }
		
	}

}
