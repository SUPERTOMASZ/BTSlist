package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Data.Station;

public class StationAddEd extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ArrayList<Station> list;
	private JTextField nrStaField;
	private JTextField nrNetWorksField;
	private JTextField nrPTCField;
	private JTextField nrPTKField;
	private JTextField adrField;
	private JTextField zip_codeField;
	private JTextField cityField;
	private JTextField cordXField;
	private JTextField cordYField;
	private JTextField acc_desField;
	private JTextField descField;
	private JTextField power_plantField;
	private JTextField heightField;
	private Station station;
	private JLabel log;
	
	/**
	 * @wbp.parser.constructor
	 */
	public StationAddEd(ArrayList<Station> list)
	{
		setBounds(100, 100, 450, 481);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(45,45,45));
		initLabels();
		initTextFields();
		initButtons();
		setVisible(true);
		this.list=list;
	}
	public StationAddEd(ArrayList<Station> list,Station station)
	{
		setBounds(100, 100, 450, 481);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(45,45,45));
		initLabels();
		initTextFields();
		initButtons();
		setVisible(true);
		this.list=list;
		this.station=station;
		
	}
	private void initButtons()
	{

		
		
		JButton button = new JButton("Dodaj");
		button.setForeground(new Color(0, 168, 255));
		button.setFont(new Font("Arial", Font.BOLD, 16));

		button.setBorder(null);
		button.setBackground(new Color(15, 15, 15));
		button.setBounds(335, 408, 89, 23);
		getContentPane().add(button);
		button.addActionListener(new AddListener(list));
		
		JButton btnAnuluj = new JButton("Anuluj");
		btnAnuluj.setForeground(new Color(0, 168, 255));
		btnAnuluj.setFont(new Font("Arial", Font.BOLD, 16));

		btnAnuluj.setBorder(null);
		btnAnuluj.setBackground(new Color(15, 15, 15));
		btnAnuluj.setBounds(236, 408, 89, 23);
		btnAnuluj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				
			}
		});
		getContentPane().add(btnAnuluj);
		
		
	}
	private void initTextFields()
	{
		nrStaField = new JTextField();
		nrStaField.setBounds(174, 8, 250, 20);
		nrStaField.setBackground(new Color(0,0,0));
		nrStaField.setBorder(null);
		nrStaField.setForeground(new Color(247,158,17));
		nrStaField.setFont(new Font("Arial", Font.ITALIC, 14));
		getContentPane().add(nrStaField);
		nrStaField.setColumns(10);
		
		nrNetWorksField = new JTextField();
		nrNetWorksField.setColumns(10);
		nrNetWorksField.setBounds(174, 33, 250, 20);
		nrNetWorksField.setBackground(new Color(0,0,0));
		nrNetWorksField.setBorder(null);
		nrNetWorksField.setForeground(new Color(247,158,17));
		nrNetWorksField.setFont(new Font("Arial", Font.ITALIC, 14));
		getContentPane().add(nrNetWorksField);
		
		nrPTCField = new JTextField();
		nrPTCField.setColumns(10);
		nrPTCField.setBounds(174, 58, 250, 20);
		nrPTCField.setBackground(new Color(0,0,0));
		nrPTCField.setBorder(null);
		nrPTCField.setForeground(new Color(247,158,17));
		nrPTCField.setFont(new Font("Arial", Font.ITALIC, 14));
		getContentPane().add(nrPTCField);
		
		nrPTKField = new JTextField();
		nrPTKField.setColumns(10);
		nrPTKField.setBounds(174, 82, 250, 20);
		nrPTKField.setBackground(new Color(0,0,0));
		nrPTKField.setBorder(null);
		nrPTKField.setForeground(new Color(247,158,17));
		nrPTKField.setFont(new Font("Arial", Font.ITALIC, 14));
		getContentPane().add(nrPTKField);
		
		adrField = new JTextField();
		adrField.setColumns(10);
		adrField.setBounds(174, 107, 250, 20);
		adrField.setBackground(new Color(0,0,0));
		adrField.setBorder(null);
		adrField.setForeground(new Color(247,158,17));
		adrField.setFont(new Font("Arial", Font.ITALIC, 14));
		getContentPane().add(adrField);
		
		zip_codeField = new JTextField();
		zip_codeField.setColumns(10);
		zip_codeField.setBounds(174, 132, 250, 20);
		zip_codeField.setBackground(new Color(0,0,0));
		zip_codeField.setBorder(null);
		zip_codeField.setForeground(new Color(247,158,17));
		zip_codeField.setFont(new Font("Arial", Font.ITALIC, 14));
		getContentPane().add(zip_codeField);
		
		cityField = new JTextField();
		cityField.setColumns(10);
		cityField.setBounds(174, 157, 250, 20);
		cityField.setBackground(new Color(0,0,0));
		cityField.setBorder(null);
		cityField.setForeground(new Color(247,158,17));
		cityField.setFont(new Font("Arial", Font.ITALIC, 14));
		getContentPane().add(cityField);
		
		cordXField = new JTextField();
		cordXField.setColumns(10);
		cordXField.setBounds(174, 182, 250, 20);
		cordXField.setBackground(new Color(0,0,0));
		cordXField.setBorder(null);
		cordXField.setForeground(new Color(247,158,17));
		cordXField.setFont(new Font("Arial", Font.ITALIC, 14));
		getContentPane().add(cordXField);
		
		cordYField = new JTextField();
		cordYField.setColumns(10);
		cordYField.setBounds(174, 207, 250, 20);
		cordYField.setBackground(new Color(0,0,0));
		cordYField.setBorder(null);
		cordYField.setForeground(new Color(247,158,17));
		cordYField.setFont(new Font("Arial", Font.ITALIC, 14));
		getContentPane().add(cordYField);
		
		acc_desField = new JTextField();
		acc_desField.setColumns(10);
		acc_desField.setBounds(174, 232, 250, 20);
		acc_desField.setBackground(new Color(0,0,0));
		acc_desField.setBorder(null);
		acc_desField.setForeground(new Color(247,158,17));
		acc_desField.setFont(new Font("Arial", Font.ITALIC, 14));
		getContentPane().add(acc_desField);
		
		descField = new JTextField();
		descField.setColumns(10);
		descField.setBounds(174, 257, 250, 20);
		descField.setBackground(new Color(0,0,0));
		descField.setBorder(null);
		descField.setForeground(new Color(247,158,17));
		descField.setFont(new Font("Arial", Font.ITALIC, 14));
		getContentPane().add(descField);
		
		power_plantField = new JTextField();
		power_plantField.setColumns(10);
		power_plantField.setBounds(174, 282, 250, 20);
		power_plantField.setBackground(new Color(0,0,0));
		power_plantField.setBorder(null);
		power_plantField.setForeground(new Color(247,158,17));
		power_plantField.setFont(new Font("Arial", Font.ITALIC, 14));
		getContentPane().add(power_plantField);
		
		heightField = new JTextField();
		heightField.setColumns(10);
		heightField.setBounds(174, 307, 250, 20);
		heightField.setBackground(new Color(0,0,0));
		heightField.setBorder(null);
		heightField.setForeground(new Color(247,158,17));
		heightField.setFont(new Font("Arial", Font.ITALIC, 14));
		getContentPane().add(heightField);
	}
	private void initLabels()
	{
		JLabel stationNum = new JLabel("numer stacji");
		stationNum.setBounds(10, 11, 150, 14);
		stationNum.setForeground(new Color(0,168,255));
		stationNum.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(stationNum);
		
		JLabel nrNetWorks = new JLabel("numer Net Works");
		nrNetWorks.setBounds(10, 36, 150, 14);
		nrNetWorks.setForeground(new Color(0,168,255));
		nrNetWorks.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(nrNetWorks);
		
		JLabel nrPTC = new JLabel("numer PTC");
		nrPTC.setBounds(10, 61, 150, 14);
		nrPTC.setForeground(new Color(0,168,255));
		nrPTC.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(nrPTC);
		
		JLabel nrPTK = new JLabel("numer PTK");
		nrPTK.setBounds(10, 85, 150, 14);
		nrPTK.setForeground(new Color(0,168,255));
		nrPTK.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(nrPTK);
		
		JLabel address = new JLabel("adres");
		address.setBounds(10, 110, 150, 14);
		address.setForeground(new Color(0,168,255));
		address.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(address);
		
		JLabel zip_code = new JLabel("kod pocztowy");
		zip_code.setBounds(10, 135, 150, 14);
		zip_code.setForeground(new Color(0,168,255));
		zip_code.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(zip_code);
		
		JLabel city = new JLabel("miasto");
		city.setBounds(10, 160, 150, 14);
		city.setForeground(new Color(0,168,255));
		city.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(city);
		
		JLabel cordX = new JLabel("wspolrzedna X");
		cordX.setBounds(10, 185, 150, 14);
		cordX.setForeground(new Color(0,168,255));
		cordX.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(cordX);
		
		JLabel cordY = new JLabel("wspolrzedna Y");
		cordY.setBounds(10, 210, 150, 14);
		cordY.setForeground(new Color(0,168,255));
		cordY.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(cordY);
		
		JLabel access_desc = new JLabel("opis dostepu");
		access_desc.setBounds(10, 235, 150, 14);
		access_desc.setForeground(new Color(0,168,255));
		access_desc.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(access_desc);
		
		JLabel descr = new JLabel("opis stacji");
		descr.setBounds(10, 260, 150, 14);
		descr.setForeground(new Color(0,168,255));
		descr.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(descr);
		
		JLabel power_plant = new JLabel("numer do elektrowni");
		power_plant.setBounds(10, 285, 150, 14);
		power_plant.setForeground(new Color(0,168,255));
		power_plant.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(power_plant);
		
		JLabel height = new JLabel("wysokosc");
		height.setBounds(10, 310, 150, 14);
		height.setForeground(new Color(0,168,255));
		height.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(height);
		
		log = new JLabel("");
		log.setForeground(new Color(255,255,255));
		log.setBounds(180, 414, 46, 14);
		getContentPane().add(log);
	}
	public class AddListener implements ActionListener
	{
		private ArrayList<Station> list;
		public AddListener(ArrayList<Station> list)
		{
			this.list=list;
			
		}
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			Station tempstation = new Station();
			tempstation.setCity(cityField.getText());
			cityField.setText("");
			tempstation.setAccessDescribe(acc_desField.getText());
			acc_desField.setText("");
			tempstation.setCordX(Double.parseDouble(cordXField.getText()));
			cordXField.setText("");
			tempstation.setCordY(Double.parseDouble(cordYField.getText()));
			cordYField.setText("");
			tempstation.setHeight(heightField.getText());
			heightField.setText("");
			tempstation.setZip_Code(zip_codeField.getText());
			zip_codeField.setText("");
			tempstation.setStreet(adrField.getText());
			adrField.setText("");
			tempstation.setStationNum(nrStaField.getText());
			nrStaField.setText("");
			tempstation.setNetWorksNum(nrNetWorksField.getText());
			nrNetWorksField.setText("");
			tempstation.setPTCNum(nrPTCField.getText());
			nrPTCField.setText("");
			tempstation.setPTKNum(nrPTKField.getText());
			nrPTKField.setText("");
			tempstation.setStationDescribe(descField.getText());
			descField.setText("");
			tempstation.setPowerPlantNum(power_plantField.getText());
			power_plantField.setText("");
			log.setText("dodano");
			list.add(tempstation);
				
		}
		
	}

}
