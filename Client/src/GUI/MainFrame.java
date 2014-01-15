package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import Data.Worker;
import javax.swing.JLabel;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private int width;
	private int height;
	private int screenWidth;
	private int screenHeight;
	private JTextField textField;
	private JTextField textField_1;
	private JTable workerTable;
	private JTable dutyTable;
	private JTable stationTable;
	private JComboBox workerCat ;
	private JComboBox stationCat;
	private JComboBox dutyCat;
	private JButton workerSearchBut;
	private JTextField textArea;
	private JButton dutySearchBut;
	private JButton stationSearchBut;
	private JButton workerAddBut;
	private JButton workerDelButton;
	private JButton workerUpButton;
	private JButton dutyAddBut;
	private JButton dutyDelBut;
	private JButton dutyUpBut;
	private JButton stationAddBut;
	private JButton stationDelBut;
	private JButton stationUpBut;
	private JButton workerSyncButton;
	private JButton dutySynBut;
	private JButton stationSynBut;
	private JLabel lblNazwisko_1;
	private JLabel lblData;
	private JLabel lblIdentyfikator;
	
	/**
	 * Create the frame.
	 */
	public MainFrame(int width,int height) {
	
		setResizable(false);
		getContentPane().setLayout(null);
		setTitle("BTS Maintenance System");
		Toolkit tool=Toolkit.getDefaultToolkit();
		this.width=width;
		this.height=height;
		Dimension dim=tool.getScreenSize();
		this.screenWidth=dim.width;
		this.screenHeight=dim.height;
		setLocation( (dim.width-width)/2, (dim.height-height)/2);
		setSize(800, 600);
		Color color= new Color(45,45,45);
		init();
		getContentPane().setBackground(color);
		
		JLabel lblNewLabel = new JLabel("Imi\u0119");
		lblNewLabel.setForeground(new Color(255, 165, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(20, 99, 100, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNazwisko = new JLabel("Nazwisko");
		lblNazwisko.setBackground(Color.ORANGE);
		lblNazwisko.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNazwisko.setForeground(new Color(255, 165, 0));
		lblNazwisko.setBounds(118, 99, 94, 14);
		getContentPane().add(lblNazwisko);
		
		lblNazwisko_1 = new JLabel("Nazwisko");
		lblNazwisko_1.setBackground(new Color(255, 165, 0));
		lblNazwisko_1.setForeground(new Color(255, 165, 0));
		lblNazwisko_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNazwisko_1.setBounds(280, 99, 94, 14);
		getContentPane().add(lblNazwisko_1);
		
		lblData = new JLabel("Data");
		lblData.setForeground(new Color(255, 165, 0));
		lblData.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblData.setBounds(399, 99, 75, 14);
		getContentPane().add(lblData);
		
		lblIdentyfikator = new JLabel("Identyfikator");
		lblIdentyfikator.setForeground(new Color(255, 165, 0));
		lblIdentyfikator.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIdentyfikator.setBounds(577, 99, 119, 14);
		getContentPane().add(lblIdentyfikator);
		setDefaultCloseOperation(EXIT_ON_CLOSE );
		setVisible(true);
	}
	private void init()
	{
		String[] workCat={"imiê","nazwisko"};
		this.workerCat = new JComboBox(workCat);
		this.workerCat.setBounds(10, 70, 250, 28);
		this.workerCat.setBackground(new Color(0,168,255));
		this.workerCat.setBorder(BorderFactory.createEmptyBorder());
		this.workerCat.setFont(new Font("Serif", Font.BOLD, 16));
		this.workerCat.setForeground(new Color(255,255,255));
		getContentPane().add(workerCat);
		String[] stationCatList={"nazwa","nazwaPTC","nazwaPTK","nrNet","nrPTK","nrPTC"};
		this.stationCat = new JComboBox(stationCatList);
		this.stationCat.setBounds(524, 70, 250, 28);
		this.stationCat.setBackground(new Color(0,168,255));
		this.stationCat.setBorder(BorderFactory.createEmptyBorder());
		this.stationCat.setFont(new Font("Serif", Font.BOLD, 16));
		this.stationCat.setForeground(new Color(255,255,255));
		getContentPane().add(stationCat);
		String [] dutyCatList={"nazwisko","data"};
		this.dutyCat = new JComboBox(dutyCatList);
		this.dutyCat.setBounds(270, 70, 244, 28);
		this.dutyCat.setBackground(new Color(0,168,255));
		this.dutyCat.setBorder(BorderFactory.createEmptyBorder());
		this.dutyCat.setFont(new Font("Serif", Font.BOLD, 16));
		this.dutyCat.setForeground(new Color(255,255,255));
		getContentPane().add(dutyCat);
		try {
			this.workerSearchBut= new JButton(
					new ImageIcon(
					ImageIO.read(getClass().getResource("/images/Searchicodesktop.gif"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.workerSearchBut.setBounds(213, 30, 47, 35);
		getContentPane().add(workerSearchBut);
		
		this.textArea = new JTextField();
		this.textArea.setBounds(270, 30, 197, 35);
		this.textArea.setBackground(new Color(0,0,0));
		this.textArea.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED , new Color(0,99,150), new Color(0,99,150)));
		this.textArea.setFont(new Font("Serif", Font.BOLD, 16));
		this.textArea.setForeground(new Color(255,255,255));
		getContentPane().add(textArea);
		this.textField = new JTextField();
		this.textField.setBounds(10, 30, 204, 35);
		this.textField.setColumns(10);
		this.textField.setBackground(new Color(0,0,0));
		this.textField.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED , new Color(0,99,150), new Color(0,99,150)));
		this.textField.setFont(new Font("Serif", Font.BOLD, 16));
		this.textField.setForeground(new Color(255,255,255));
		getContentPane().add(textField);
		try {
			this.dutySearchBut= new JButton(
					new ImageIcon(
					ImageIO.read(getClass().getResource("/images/Searchicodesktop.gif"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.dutySearchBut.setBounds(467, 30, 47, 35);
		getContentPane().add(dutySearchBut);
		
		try {
			this.stationSearchBut= new JButton(
					new ImageIcon(
					ImageIO.read(getClass().getResource("/images/Searchicodesktop.gif"))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.stationSearchBut.setBounds(727, 30, 47, 35);
		getContentPane().add(stationSearchBut);
		this.textField_1 = new JTextField();
		this.textField_1.setColumns(10);
		this.textField_1.setBounds(524, 30, 204, 35);
		this.textField_1.setBackground(new Color(0,0,0));
		this.textField_1.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED , new Color(0,99,150), new Color(0,99,150)));
		this.textField_1.setFont(new Font("Serif", Font.BOLD, 16));
		this.textField_1.setForeground(new Color(255,255,255));
		getContentPane().add(textField_1);
		this.workerTable = new JTable();
		this.workerTable.setBounds(10, 118, 204, 451);
		this.workerTable.setBackground(new Color(29,29,29));
		//temp
		ArrayList<Worker> tempWork= new ArrayList<Worker>();
		tempWork.add(new Worker("Mateusz","Kosior"));
		tempWork.add(new Worker("Mateusz","Kosior"));
		tempWork.add(new Worker("Mateusz","Kosior"));
		tempWork.add(new Worker("Mateusz","Kosior"));
		tempWork.add(new Worker("Mateusz","Kosior"));
		tempWork.add(new Worker("Mateusz","Kosior"));
		tempWork.add(new Worker("Mateusz","Kosior"));
		this.workerTable.setModel(new WorkerModel(tempWork));
		this.workerTable.setForeground(new Color(255,255,255));
		this.workerTable.setFont(new Font("Serif", Font.PLAIN, 20));
		getContentPane().add(workerTable);
		this.dutyTable = new JTable();
		this.dutyTable.setBounds(270, 118, 204, 451);
		this.dutyTable.setBackground(new Color(29,29,29));
		getContentPane().add(dutyTable);
		this.stationTable = new JTable();
		this.stationTable.setBounds(524, 118, 204, 451);
		this.stationTable.setBackground(new Color(29,29,29));
		getContentPane().add(stationTable);
		
		try {
			ImageIcon addIco=new ImageIcon(
					ImageIO.read(getClass().getResource("/images/addico.gif")));
			this.workerAddBut= new JButton(addIco);
			this.dutyAddBut= new JButton(addIco);
			this.stationAddBut=new JButton(addIco);
			ImageIcon edIco=new ImageIcon(
					ImageIO.read(getClass().getResource("/images/editico.gif")));
			this.workerUpButton=new JButton(edIco);
			this.stationUpBut=new JButton(edIco);
			this.dutyUpBut=new JButton(edIco);
			ImageIcon delIco=new ImageIcon(
					ImageIO.read(getClass().getResource("/images/subtico.gif")));
			this.workerDelButton= new JButton(delIco);
			this.stationDelBut= new JButton(delIco);
			this.dutyDelBut= new JButton(delIco);
			ImageIcon synIco=new ImageIcon(
					ImageIO.read(getClass().getResource("/images/updateicodesktop.gif")));
			this.workerSyncButton=new JButton(synIco);
			this.stationSynBut=new JButton(synIco);
			this.dutySynBut=new JButton(synIco);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
		this.workerAddBut.setBounds(220, 110, 45, 45);
		getContentPane().add(workerAddBut);
		this.workerDelButton.setBounds(220, 180, 45, 45);
		getContentPane().add(workerDelButton);
		this.workerUpButton.setBounds(220, 250, 45, 45);
		getContentPane().add(workerUpButton);
		this.dutyAddBut.setBounds(477, 110, 45, 45);
		getContentPane().add(dutyAddBut);
		this.dutyDelBut.setBounds(477, 180, 45, 45);
		getContentPane().add(dutyDelBut);

		this.dutyUpBut.setBounds(477, 250, 45, 45);
		getContentPane().add(dutyUpBut);

		this.stationAddBut.setBounds(733, 110, 45, 45);
		getContentPane().add(stationAddBut);
		this.stationDelBut.setBounds(733, 180, 45, 45);
		getContentPane().add(stationDelBut);
		this.stationUpBut.setBounds(733, 250, 45, 45);
		getContentPane().add(stationUpBut);
		
		this.workerSyncButton.setBounds(220, 320, 45, 45);
		getContentPane().add(workerSyncButton);

		this.dutySynBut.setBounds(477, 320, 45, 45);
		getContentPane().add(dutySynBut);
	
		this.stationSynBut.setBounds(733, 320, 45, 45);
		getContentPane().add(stationSynBut);
	}
}
