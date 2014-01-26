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
import DataBase.DataBaseQuery;

public class StationAddEd extends JDialog {


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
	private JTextField numerField;
	private Station station;
	private JLabel log;
	private JTextField heightField;
	private JTextField PlayField;
	private JTextField PlusField;
	private JTextField typeField;
	private JTextField regionField;
	private JTextField ownerField;
	private JTextField PTKName;
	private JTextField PTCName;
	private JLabel lblAdres;
	private JLabel lblNazwaPtc;
	private JLabel lblNazwaPTK;
	private JLabel lblRegion;
	private JLabel lblWasciciel;
	private JLabel lblTyp;
	private JLabel lblWysokosc;
	private JLabel lblNumerPlus;
	private JTextField statNameField;
	private JLabel lblNazwaStacji;
	private JTextField stationHeight;
	private JLabel lblWysokoStacji;
	
	
	
	/**
	 * @wbp.parser.constructor
	 */
	public StationAddEd(ArrayList<Station> list)
	{
		setBounds(100, 100, 450, 654);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(45,45,45));
		this.list=list;
		initLabels();
		initTextFields();
		initButtons();
		setVisible(true);
		
	}
	public StationAddEd(ArrayList<Station> list,Station station)
	{
		setBounds(100, 100, 450, 481);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(45,45,45));
		this.list=list;
		this.station=station;
		initLabels();
		initTextFields();
		initButtons();
		setVisible(true);
		
		
	}
	private void initButtons()
	{

		
		
		JButton button = new JButton("Dodaj");
		button.setForeground(new Color(0, 168, 255));
		button.setFont(new Font("Arial", Font.BOLD, 16));

		button.setBorder(null);
		button.setBackground(new Color(15, 15, 15));
		button.setBounds(335, 581, 89, 23);
		getContentPane().add(button);
		button.addActionListener(new AddListener(list));
		
		JButton btnAnuluj = new JButton("Anuluj");
		btnAnuluj.setForeground(new Color(0, 168, 255));
		btnAnuluj.setFont(new Font("Arial", Font.BOLD, 16));

		btnAnuluj.setBorder(null);
		btnAnuluj.setBackground(new Color(15, 15, 15));
		btnAnuluj.setBounds(225, 581, 89, 23);
		btnAnuluj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				
			}
		});
		getContentPane().add(btnAnuluj);
		
		heightField = new JTextField();
		heightField.setForeground(new Color(247, 158, 17));
		heightField.setFont(new Font("Arial", Font.ITALIC, 14));
		heightField.setColumns(10);
		heightField.setBorder(null);
		heightField.setBackground(Color.BLACK);
		heightField.setBounds(174, 424, 250, 20);
		getContentPane().add(heightField);
		
		PlayField = new JTextField();
		PlayField.setForeground(new Color(247, 158, 17));
		PlayField.setFont(new Font("Arial", Font.ITALIC, 14));
		PlayField.setColumns(10);
		PlayField.setBorder(null);
		PlayField.setBackground(Color.BLACK);
		PlayField.setBounds(174, 472, 250, 20);
		getContentPane().add(PlayField);
		
		JLabel lblNrplay = new JLabel("numer Play");
		lblNrplay.setForeground(new Color(0, 168, 255));
		lblNrplay.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNrplay.setBounds(10, 475, 150, 17);
		getContentPane().add(lblNrplay);
		
		PlusField = new JTextField();
		PlusField.setForeground(new Color(247, 158, 17));
		PlusField.setFont(new Font("Arial", Font.ITALIC, 14));
		PlusField.setColumns(10);
		PlusField.setBorder(null);
		PlusField.setBackground(Color.BLACK);
		PlusField.setBounds(174, 448, 250, 20);
		getContentPane().add(PlusField);
		
		typeField = new JTextField();
		typeField.setForeground(new Color(247, 158, 17));
		typeField.setFont(new Font("Arial", Font.ITALIC, 14));
		typeField.setColumns(10);
		typeField.setBorder(null);
		typeField.setBackground(Color.BLACK);
		typeField.setBounds(174, 400, 250, 20);
		getContentPane().add(typeField);
		
		regionField = new JTextField();
		regionField.setForeground(new Color(247, 158, 17));
		regionField.setFont(new Font("Arial", Font.ITALIC, 14));
		regionField.setColumns(10);
		regionField.setBorder(null);
		regionField.setBackground(Color.BLACK);
		regionField.setBounds(174, 352, 250, 20);
		getContentPane().add(regionField);
		
		ownerField = new JTextField();
		ownerField.setForeground(new Color(247, 158, 17));
		ownerField.setFont(new Font("Arial", Font.ITALIC, 14));
		ownerField.setColumns(10);
		ownerField.setBorder(null);
		ownerField.setBackground(Color.BLACK);
		ownerField.setBounds(174, 376, 250, 20);
		getContentPane().add(ownerField);
		
		PTKName = new JTextField();
		PTKName.setForeground(new Color(247, 158, 17));
		PTKName.setFont(new Font("Arial", Font.ITALIC, 14));
		PTKName.setColumns(10);
		PTKName.setBorder(null);
		PTKName.setBackground(Color.BLACK);
		PTKName.setBounds(174, 328, 250, 20);
		getContentPane().add(PTKName);
		
		PTCName = new JTextField();
		PTCName.setForeground(new Color(247, 158, 17));
		PTCName.setFont(new Font("Arial", Font.ITALIC, 14));
		PTCName.setColumns(10);
		PTCName.setBorder(null);
		PTCName.setBackground(Color.BLACK);
		PTCName.setBounds(174, 304, 250, 20);
		getContentPane().add(PTCName);
		
		lblAdres = new JLabel("ulica");
		lblAdres.setForeground(new Color(0, 168, 255));
		lblAdres.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAdres.setBounds(10, 156, 150, 14);
		getContentPane().add(lblAdres);
		
		lblNazwaPtc = new JLabel("nazwa PTC");
		lblNazwaPtc.setForeground(new Color(0, 168, 255));
		lblNazwaPtc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNazwaPtc.setBounds(10, 306, 150, 14);
		getContentPane().add(lblNazwaPtc);
		
		lblNazwaPTK = new JLabel("nazwa PTK");
		lblNazwaPTK.setForeground(new Color(0, 168, 255));
		lblNazwaPTK.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNazwaPTK.setBounds(10, 329, 150, 14);
		getContentPane().add(lblNazwaPTK);
		
		lblRegion = new JLabel("region");
		lblRegion.setForeground(new Color(0, 168, 255));
		lblRegion.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblRegion.setBounds(10, 353, 150, 19);
		getContentPane().add(lblRegion);
		
		lblWasciciel = new JLabel("w\u0142asciciel");
		lblWasciciel.setForeground(new Color(0, 168, 255));
		lblWasciciel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWasciciel.setBounds(10, 377, 150, 14);
		getContentPane().add(lblWasciciel);
		
		lblTyp = new JLabel("typ");
		lblTyp.setForeground(new Color(0, 168, 255));
		lblTyp.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTyp.setBounds(10, 401, 150, 19);
		getContentPane().add(lblTyp);
		
		lblWysokosc = new JLabel("wysokosc");
		lblWysokosc.setForeground(new Color(0, 168, 255));
		lblWysokosc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWysokosc.setBounds(10, 425, 150, 19);
		getContentPane().add(lblWysokosc);
		
		lblNumerPlus = new JLabel("numer Plus");
		lblNumerPlus.setForeground(new Color(0, 168, 255));
		lblNumerPlus.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumerPlus.setBounds(10, 451, 150, 14);
		getContentPane().add(lblNumerPlus);
		
		statNameField = new JTextField();
		statNameField.setForeground(new Color(247, 158, 17));
		statNameField.setFont(new Font("Arial", Font.ITALIC, 14));
		statNameField.setColumns(10);
		statNameField.setBorder(null);
		statNameField.setBackground(Color.BLACK);
		statNameField.setBounds(174, 520, 250, 20);
		getContentPane().add(statNameField);
		
		lblNazwaStacji = new JLabel("nazwa stacji");
		lblNazwaStacji.setForeground(new Color(0, 168, 255));
		lblNazwaStacji.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNazwaStacji.setBounds(10, 521, 150, 14);
		getContentPane().add(lblNazwaStacji);
		
		stationHeight = new JTextField();
		stationHeight.setForeground(new Color(247, 158, 17));
		stationHeight.setFont(new Font("Arial", Font.ITALIC, 14));
		stationHeight.setColumns(10);
		stationHeight.setBorder(null);
		stationHeight.setBackground(Color.BLACK);
		stationHeight.setBounds(174, 544, 250, 20);
		getContentPane().add(stationHeight);
		
		lblWysokoStacji = new JLabel("wysoko\u015B\u0107 stacji");
		lblWysokoStacji.setForeground(new Color(0, 168, 255));
		lblWysokoStacji.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWysokoStacji.setBounds(10, 541, 150, 23);
		getContentPane().add(lblWysokoStacji);
		
		
	}
	private void initTextFields()
	{
		nrStaField = new JTextField();
		nrStaField.setBounds(174, 11, 250, 20);
		nrStaField.setBackground(new Color(0,0,0));
		nrStaField.setBorder(null);
		nrStaField.setForeground(new Color(247,158,17));
		nrStaField.setFont(new Font("Arial", Font.ITALIC, 14));
		getContentPane().add(nrStaField);
		nrStaField.setColumns(10);
		
		nrNetWorksField = new JTextField();
		nrNetWorksField.setColumns(10);
		nrNetWorksField.setBounds(174, 35, 250, 20);
		nrNetWorksField.setBackground(new Color(0,0,0));
		nrNetWorksField.setBorder(null);
		nrNetWorksField.setForeground(new Color(247,158,17));
		nrNetWorksField.setFont(new Font("Arial", Font.ITALIC, 14));
		getContentPane().add(nrNetWorksField);
		
		nrPTCField = new JTextField();
		nrPTCField.setColumns(10);
		nrPTCField.setBounds(174, 60, 250, 20);
		nrPTCField.setBackground(new Color(0,0,0));
		nrPTCField.setBorder(null);
		nrPTCField.setForeground(new Color(247,158,17));
		nrPTCField.setFont(new Font("Arial", Font.ITALIC, 14));
		getContentPane().add(nrPTCField);
		
		nrPTKField = new JTextField();
		nrPTKField.setColumns(10);
		nrPTKField.setBounds(174, 84, 250, 20);
		nrPTKField.setBackground(new Color(0,0,0));
		nrPTKField.setBorder(null);
		nrPTKField.setForeground(new Color(247,158,17));
		nrPTKField.setFont(new Font("Arial", Font.ITALIC, 14));
		getContentPane().add(nrPTKField);
		
		adrField = new JTextField();
		adrField.setColumns(10);
		adrField.setBounds(174, 157, 250, 20);
		adrField.setBackground(new Color(0,0,0));
		adrField.setBorder(null);
		adrField.setForeground(new Color(247,158,17));
		adrField.setFont(new Font("Arial", Font.ITALIC, 14));
		getContentPane().add(adrField);
		
		zip_codeField = new JTextField();
		zip_codeField.setColumns(10);
		zip_codeField.setBounds(174, 206, 250, 20);
		zip_codeField.setBackground(new Color(0,0,0));
		zip_codeField.setBorder(null);
		zip_codeField.setForeground(new Color(247,158,17));
		zip_codeField.setFont(new Font("Arial", Font.ITALIC, 14));
		getContentPane().add(zip_codeField);
		
		cityField = new JTextField();
		cityField.setColumns(10);
		cityField.setBounds(174, 280, 250, 20);
		cityField.setBackground(new Color(0,0,0));
		cityField.setBorder(null);
		cityField.setForeground(new Color(247,158,17));
		cityField.setFont(new Font("Arial", Font.ITALIC, 14));
		getContentPane().add(cityField);
		
		cordXField = new JTextField();
		cordXField.setColumns(10);
		cordXField.setBounds(174, 231, 250, 20);
		cordXField.setBackground(new Color(0,0,0));
		cordXField.setBorder(null);
		cordXField.setForeground(new Color(247,158,17));
		cordXField.setFont(new Font("Arial", Font.ITALIC, 14));
		getContentPane().add(cordXField);
		
		cordYField = new JTextField();
		cordYField.setColumns(10);
		cordYField.setBounds(174, 256, 250, 20);
		cordYField.setBackground(new Color(0,0,0));
		cordYField.setBorder(null);
		cordYField.setForeground(new Color(247,158,17));
		cordYField.setFont(new Font("Arial", Font.ITALIC, 14));
		getContentPane().add(cordYField);
		
		acc_desField = new JTextField();
		acc_desField.setColumns(10);
		acc_desField.setBounds(174, 109, 250, 20);
		acc_desField.setBackground(new Color(0,0,0));
		acc_desField.setBorder(null);
		acc_desField.setForeground(new Color(247,158,17));
		acc_desField.setFont(new Font("Arial", Font.ITALIC, 14));
		getContentPane().add(acc_desField);
		
		descField = new JTextField();
		descField.setColumns(10);
		descField.setBounds(174, 133, 250, 20);
		descField.setBackground(new Color(0,0,0));
		descField.setBorder(null);
		descField.setForeground(new Color(247,158,17));
		descField.setFont(new Font("Arial", Font.ITALIC, 14));
		getContentPane().add(descField);
		
		power_plantField = new JTextField();
		power_plantField.setColumns(10);
		power_plantField.setBounds(174, 496, 250, 20);
		power_plantField.setBackground(new Color(0,0,0));
		power_plantField.setBorder(null);
		power_plantField.setForeground(new Color(247,158,17));
		power_plantField.setFont(new Font("Arial", Font.ITALIC, 14));
		getContentPane().add(power_plantField);
		
		numerField = new JTextField();
		numerField.setColumns(10);
		numerField.setBounds(174, 181, 250, 20);
		numerField.setBackground(new Color(0,0,0));
		numerField.setBorder(null);
		numerField.setForeground(new Color(247,158,17));
		numerField.setFont(new Font("Arial", Font.ITALIC, 14));
		getContentPane().add(numerField);
	}
	private void initLabels()
	{
		JLabel stationNum = new JLabel("numer stacji");
		stationNum.setBounds(10, 11, 150, 17);
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
		nrPTK.setBounds(10, 84, 150, 14);
		nrPTK.setForeground(new Color(0,168,255));
		nrPTK.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(nrPTK);
		
		JLabel zip_code = new JLabel("kod pocztowy");
		zip_code.setBounds(10, 206, 150, 14);
		zip_code.setForeground(new Color(0,168,255));
		zip_code.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(zip_code);
		
		JLabel city = new JLabel("miasto");
		city.setBounds(10, 281, 150, 14);
		city.setForeground(new Color(0,168,255));
		city.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(city);
		
		JLabel cordX = new JLabel("wspolrzedna X");
		cordX.setBounds(10, 231, 150, 14);
		cordX.setForeground(new Color(0,168,255));
		cordX.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(cordX);
		
		JLabel cordY = new JLabel("wspolrzedna Y");
		cordY.setBounds(10, 256, 150, 14);
		cordY.setForeground(new Color(0,168,255));
		cordY.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(cordY);
		
		JLabel access_desc = new JLabel("opis dostepu");
		access_desc.setBounds(10, 109, 150, 14);
		access_desc.setForeground(new Color(0,168,255));
		access_desc.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(access_desc);
		
		JLabel descr = new JLabel("opis stacji");
		descr.setBounds(10, 133, 150, 14);
		descr.setForeground(new Color(0,168,255));
		descr.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(descr);
		
		JLabel power_plant = new JLabel("numer do elektrowni");
		power_plant.setBounds(10, 497, 150, 14);
		power_plant.setForeground(new Color(0,168,255));
		power_plant.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(power_plant);
		
		JLabel numberField = new JLabel("numer ulicy");
		numberField.setBounds(10, 181, 150, 14);
		numberField.setForeground(new Color(0,168,255));
		numberField.setFont(new Font("Tahoma", Font.BOLD, 14));
		getContentPane().add(numberField);
		
		log = new JLabel("");
		log.setForeground(new Color(255,255,255));
		log.setBounds(10, 590, 204, 14);
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
			System.out.println("null list "+(list==null));
			Station tempstation = new Station();
			try{
				
			
			
			tempstation.setStationNum(nrStaField.getText());
			tempstation.setNetWorksNum(nrNetWorksField.getText());
			tempstation.setPTCNum(nrPTCField.getText());
			tempstation.setPTKNum(nrPTKField.getText());
			tempstation.setOwner(ownerField.getText());
			tempstation.setStationName(statNameField.getText());
			tempstation.setPTCName(PTCName.getText());
			tempstation.setPTKName(PTKName.getText());
			tempstation.setRegion(regionField.getText());
			tempstation.setStreet(adrField.getText());
			tempstation.setStreetNo(numerField.getText());
			tempstation.setZip_Code(zip_codeField.getText());
			tempstation.setCity(cityField.getText());
			tempstation.setType(typeField.getText());
			tempstation.setCordX(Double.parseDouble(cordXField.getText()));
			tempstation.setCordY(Double.parseDouble(cordYField.getText()));
			Double.parseDouble(heightField.getText());
			Double.parseDouble(stationHeight.getText());
			tempstation.setHeight(heightField.getText());
			tempstation.setBuilding_height(stationHeight.getText());
			tempstation.setAccessDescribe(acc_desField.getText());
			tempstation.setStationDescribe(descField.getText());
			tempstation.setPlusNum(PlusField.getText());
			tempstation.setPlayNum(PlayField.getText());
			tempstation.setPowerPlantNum(power_plantField.getText());
			
			
			
			cityField.setText("");
			acc_desField.setText("");
			cordXField.setText("");
			cordYField.setText("");
			numerField.setText("");
			zip_codeField.setText("");
			adrField.setText("");
			nrStaField.setText("");
			nrNetWorksField.setText("");
			nrPTCField.setText("");
			nrPTKField.setText("");
			descField.setText("");
			PTCName.setText("");
			PTKName.setText("");
			regionField.setText("");
			ownerField.setText("");
			typeField.setText("");
			heightField.setText("");
			PlusField.setText("");
			PlayField.setText("");
			stationHeight.setText("");
			statNameField.setText("");
			power_plantField.setText("");
			log.setText("dodano");
			list.add(tempstation);
		
			new DataBaseQuery().insert(tempstation);
			
			}
			catch(NumberFormatException ex)
			{
				
				log.setText("zly format wspolrzednych");
			}
			
			
				
		}
		
	}
}
