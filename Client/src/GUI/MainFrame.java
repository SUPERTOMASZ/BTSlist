package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.CellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import Data.Duty;
import Data.Station;
import Data.Worker;
import DataBase.DataBaseQuery;
import GUIListners.AddListener;
import GUIListners.DelListener;
import GUIListners.EdListener;
import GUIListners.SynchListner;
import Models.DutyModel;
import Models.StationModel;

public class MainFrame extends JFrame {


	private int width;
	private int height;
	private int screenWidth;
	private int screenHeight;
	private JTextField workerField;
	private JTextField stationField;
	private JTable workerTable;
	private JTable stationTable;
	private JTable dutyTable;
	private JComboBox workerCat ;
	private JComboBox stationCat;
	private JComboBox dutyCat;
	private JButton workerSearchBut;
	private JTextField dutyField;
	private JButton dutySearchBut;
	private JButton stationSearchBut;
	private JButton workerAddBut;
	private JButton workerDelButton;
	private JButton workerUpButton;
	private JButton dutyAddBut;
	private JButton dutyDelBut;
	private JButton dutyUpBut;
	private JButton stationAddBut;
	public static final String[] workCat={"imiê","nazwisko"};
	public static final String[] stationCatList={"nazwa","nazwaPTC","nazwaPTK","nrNet","nrPTK","nrPTC"};
	public static final String [] dutyCatList={"nazwisko","data"};
	private JButton stationDelBut;
	private JButton stationUpBut;
	private JButton workerSyncButton;
	private JButton dutySynBut;
	private JButton stationSynBut;
	private JLabel lblNazwisko_1;
	private JLabel lblData;
	private JLabel lblIdentyfikator;
	private ArrayList<Worker> workersAdd;
	private ArrayList<Worker> workersEd;
	private ArrayList<Worker> workersDel;
	private ArrayList<Duty> dutiesAdd;
	private ArrayList<Duty> dutiesEd;
	private ArrayList<Duty> dutiesDel;
	private ArrayList<Station> stationsAdd;
	private ArrayList<Station> stationsEd;
	private ArrayList<Station> stationsDel;
	private ArrayList<Worker> workeResultList;
	private ArrayList<Duty> dutyResultList;
	private ArrayList<Station> stationResultList;
	private JScrollPane workerScroolPanel;
	private JScrollPane dutyScroolPanel;
	private JScrollPane stationScroolPanel;

	
	
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
		//setSize(width, height);
		setSize(800,600);
		Color color= new Color(45,45,45);
		initLists();
		initCategoriesList();
		initLabels();
		initTables();
		initTextFields();
	
		initButtons();
		getContentPane().setBackground(color);

			initScroolPanels();
		setDefaultCloseOperation(EXIT_ON_CLOSE );
		setVisible(true);
	}
	
	private void initLists()
	{
		this.workersAdd= new ArrayList<Worker>();
		this.workersEd= new ArrayList<Worker>();
		this.workersDel= new ArrayList<Worker>();
		this.dutiesAdd= new ArrayList<Duty>();
		this.dutiesEd= new ArrayList<Duty>();
		this.dutiesDel= new ArrayList<Duty>();
		this.stationsAdd= new ArrayList<Station>();
		this.stationsEd= new ArrayList<Station>();
		this.stationsDel= new ArrayList<Station>();
		this.workeResultList=new ArrayList<Worker>();
		this.dutyResultList= new ArrayList<Duty>();
		this.stationResultList = new ArrayList<Station>();
	
	}
	private void initScroolPanels()
	{
		this.workerScroolPanel =new JScrollPane(workerTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		workerScroolPanel.setViewportBorder(null);
		workerScroolPanel.setBounds(10, 124, 202, 445);
		this.workerScroolPanel.getViewport().setBackground(new Color(29,29,29));
		this.workerScroolPanel.getViewport().setForeground(new Color(29,29,29));
		//this.workerScroolPanel.set
		this.workerScroolPanel.getViewport().setBorder(null);
		getContentPane().add(workerScroolPanel);
		
		dutyScroolPanel = new JScrollPane(dutyTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		dutyScroolPanel.setViewportBorder(null);
		dutyScroolPanel.setBounds(270, 119, 204, 450);
		this.dutyScroolPanel.getViewport().setBackground(new Color(29,29,29));
		this.dutyScroolPanel.getViewport().setForeground(new Color(29,29,29));
		getContentPane().add(dutyScroolPanel);
		
		stationScroolPanel = new JScrollPane(stationTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		stationScroolPanel.setViewportBorder(null);
		this.stationScroolPanel.getViewport().setBackground(new Color(29,29,29));
		this.stationScroolPanel.getViewport().setForeground(new Color(29,29,29));
		stationScroolPanel.setBounds(524, 119, 204, 450);
		getContentPane().add(stationScroolPanel);
	}
	private void initButtons()
	{
		try {
			ImageIcon icon = new ImageIcon(ImageIO.read(getClass().getResource("/images/Searchicodesktop.gif")));
			this.workerSearchBut= new JButton(icon);
			this.dutySearchBut=  new JButton(icon);
			this.stationSearchBut=new JButton(icon);
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
			
			/////////////
		} catch (IOException e) {
			e.printStackTrace();
		}

			SynchListner synListener = new SynchListner(this);
			this.workerSyncButton.addActionListener(synListener);
			this.dutySynBut.addActionListener(synListener);
			this.stationSynBut.addActionListener(synListener);
			AddListener addListener=new AddListener(this);
			this.workerAddBut.addActionListener(addListener);
			this.dutyAddBut.addActionListener(addListener);
			this.stationAddBut.addActionListener(addListener);
			
		this.workerSearchBut.setBounds(214,30,47,35);
	
		getContentPane().add(workerSearchBut);
		this.dutySearchBut.setBounds(467, 30, 47, 35);
		getContentPane().add(dutySearchBut);
		this.stationSearchBut.setBounds(727, 30, 47, 35);
		getContentPane().add(stationSearchBut);
		
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
		
		this.workerSearchBut.addActionListener(new SearchListener());
		this.dutySearchBut.addActionListener(new SearchListener());
		this.stationSearchBut.addActionListener(new SearchListener());
		
		this.workerUpButton.addActionListener(new EdListener(this));
		this.dutyUpBut.addActionListener(new EdListener(this));
		this.stationUpBut.addActionListener(new EdListener(this));
		
		this.workerDelButton.addActionListener(new DelListener(this));
		this.dutyDelBut.addActionListener(new DelListener(this));
		this.stationDelBut.addActionListener(new DelListener(this));
	}
	private void initCategoriesList()
	{
		
		this.workerCat = new JComboBox(workCat);
		this.workerCat.setBounds(10, 70, 250, 28);
		this.workerCat.setBackground(new Color(0,168,255));
		this.workerCat.setBorder(BorderFactory.createEmptyBorder());
		this.workerCat.setFont(new Font("Serif", Font.BOLD, 16));
		this.workerCat.setForeground(new Color(255,255,255));
		getContentPane().add(workerCat);
		
		
		this.stationCat = new JComboBox(stationCatList);
		this.stationCat.setBounds(524, 70, 250, 28);
		this.stationCat.setBackground(new Color(0,168,255));
		this.stationCat.setBorder(BorderFactory.createEmptyBorder());
		this.stationCat.setFont(new Font("Serif", Font.BOLD, 16));
		this.stationCat.setForeground(new Color(255,255,255));
		getContentPane().add(stationCat);
		
		
		this.dutyCat = new JComboBox(dutyCatList);
		this.dutyCat.setBounds(270, 70, 244, 28);
		this.dutyCat.setBackground(new Color(0,168,255));
		this.dutyCat.setBorder(BorderFactory.createEmptyBorder());
		this.dutyCat.setFont(new Font("Serif", Font.BOLD, 16));
		this.dutyCat.setForeground(new Color(255,255,255));
		getContentPane().add(dutyCat);
	}
	private void initLabels()
	{
		JLabel lblNewLabel = new JLabel("Imie");
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
	}
	
	private void initTables()
	{
		this.workerTable = new JTable();
		
		this.workerTable.setBackground(new Color(29,29,29));
		this.workerTable.setForeground(new Color(255,255,255));
		this.workerTable.setFont(new Font("Serif", Font.PLAIN, 20));
		///////////////////////////////
		this.dutyTable = new JTable();
		this.dutyTable.setForeground(Color.WHITE);
		this.dutyTable.setFont(new Font("Serif", Font.PLAIN, 20));
		this.dutyTable.setBackground(new Color(29,29,29));
		
		this.stationTable = new JTable();
		this.stationTable.setBackground(new Color(29,29,29));
		this.stationTable.setFont(new Font("Serif", Font.PLAIN, 20));
		this.stationTable.setForeground(new Color(255,255,255));
		this.stationTable.setFillsViewportHeight(true);
		getContentPane().add(stationTable);
	}
	private void initTextFields()
	{
		this.dutyField = new JTextField();
		this.dutyField.setBounds(270, 30, 197, 35);
		this.dutyField.setBackground(new Color(0,0,0));
		this.dutyField.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED , new Color(0,99,150), new Color(0,99,150)));
		this.dutyField.setFont(new Font("Serif", Font.BOLD, 16));
		this.dutyField.setForeground(new Color(255,255,255));
		getContentPane().add(dutyField);
		
		this.workerField = new JTextField();
		this.workerField.setBounds(10, 30, 204, 35);
		this.workerField.setColumns(10);
		this.workerField.setBackground(new Color(0,0,0));
		this.workerField.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED , new Color(0,99,150), new Color(0,99,150)));
		this.workerField.setFont(new Font("Serif", Font.BOLD, 16));
		this.workerField.setForeground(new Color(255,255,255));
		
		getContentPane().add(workerField);
		this.stationField = new JTextField();
		this.stationField.setColumns(10);
		this.stationField.setBounds(524, 30, 204, 35);
		this.stationField.setBackground(new Color(0,0,0));
		this.stationField.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED , new Color(0,99,150), new Color(0,99,150)));
		this.stationField.setFont(new Font("Serif", Font.BOLD, 16));
		this.stationField.setForeground(new Color(255,255,255));
		getContentPane().add(stationField);
	}
	
	
	public ArrayList<Worker> getWorkersAdd()
	{
		return workersAdd;
	}
	public ArrayList<Worker> getWorkersEd()
	{
		return workersEd;
	}
	
	public ArrayList<Worker> getWorkersDel()
	{
		return workersDel;
	}
	
	public ArrayList<Duty> getDutiesAdd()
	{
		return dutiesAdd;
	}
	
	public ArrayList<Duty> getDutiesEd()
	{
		return dutiesEd;
	}
	
	public ArrayList<Duty> getDutiesDel()
	{
		return dutiesDel;
	}
	
	public ArrayList<Station> getStationsAdd()
	{
		return stationsAdd;
	}
	
	public ArrayList<Station> getStationsEd()
	{
		return stationsEd;
	}
	
	public ArrayList<Station> getStationsDel()
	{
		return stationsDel;
	}
	public JButton getWorkerSyncButton() {
		return workerSyncButton;
	}
	public void setWorkerSyncButton(JButton workerSyncButton) {
		this.workerSyncButton = workerSyncButton;
	}
	public JButton getDutySynBut() {
		return dutySynBut;
	}
	public void setDutySynBut(JButton dutySynBut) {
		this.dutySynBut = dutySynBut;
	}
	public JButton getStationSynBut() {
		return stationSynBut;
	}
	public void setStationSynBut(JButton stationSynBut) {
		this.stationSynBut = stationSynBut;
	}
	public JButton getWorkerAddBut() {
		return workerAddBut;
	}
	public void setWorkerAddBut(JButton workerAddBut) {
		this.workerAddBut = workerAddBut;
	}
	public JButton getDutyAddBut() {
		return dutyAddBut;
	}
	public void setDutyAddBut(JButton dutyAddBut) {
		this.dutyAddBut = dutyAddBut;
	}
	public JButton getStationAddBut() {
		return stationAddBut;
	}
	public void setStationAddBut(JButton stationAddBut) {
		this.stationAddBut = stationAddBut;
	}
	public JTable getWorkerTable() {
		return workerTable;
	}
	public void setWorkerTable(JTable workerTable) {
		this.workerTable = workerTable;
	}
	public JTable getStationTable() {
		return stationTable;
	}
	public void setStationTable(JTable stationTable) {
		this.stationTable = stationTable;
	}
	public JTable getDutyTable() {
		return dutyTable;
	}
	public void setDutyTable(JTable dutyTable) {
		this.dutyTable = dutyTable;
	}
	public ArrayList<Worker> getWorkeResultList() {
		return workeResultList;
	}
	public void setWorkeResultList(ArrayList<Worker> workeResultList) {
		this.workeResultList = workeResultList;
	}
	public ArrayList<Duty> getDutyResultList() {
		return dutyResultList;
	}
	public void setDutyResultList(ArrayList<Duty> dutyResultList) {
		this.dutyResultList = dutyResultList;
	}
	public ArrayList<Station> getStationResultList() {
		return stationResultList;
	}
	public void setStationResultList(ArrayList<Station> stationResultList) {
		this.stationResultList = stationResultList;
	}
	
	public JButton getWorkerUpButton() {
		return workerUpButton;
	}
	public void setWorkerUpButton(JButton workerUpButton) {
		this.workerUpButton = workerUpButton;
	}
	public JButton getDutyUpBut() {
		return dutyUpBut;
	}
	public void setDutyUpBut(JButton dutyUpBut) {
		this.dutyUpBut = dutyUpBut;
	}
	public JButton getStationUpBut() {
		return stationUpBut;
	}
	public void setStationUpBut(JButton stationUpBut) {
		this.stationUpBut = stationUpBut;
	}
	public void setWorkersEd(ArrayList<Worker> workersEd) {
		this.workersEd = workersEd;
	}
	public void setDutiesEd(ArrayList<Duty> dutiesEd) {
		this.dutiesEd = dutiesEd;
	}
	public void setStationsEd(ArrayList<Station> stationsEd) {
		this.stationsEd = stationsEd;
	}
	public JButton getWorkerDelButton() {
		return workerDelButton;
	}
	public void setWorkerDelButton(JButton workerDelButton) {
		this.workerDelButton = workerDelButton;
	}
	public JButton getDutyDelBut() {
		return dutyDelBut;
	}
	public void setDutyDelBut(JButton dutyDelBut) {
		this.dutyDelBut = dutyDelBut;
	}
	public JButton getStationDelBut() {
		return stationDelBut;
	}
	public void setStationDelBut(JButton stationDelBut) {
		this.stationDelBut = stationDelBut;
	}
	public void setWorkersDel(ArrayList<Worker> workersDel) {
		this.workersDel = workersDel;
	}
	public void setDutiesDel(ArrayList<Duty> dutiesDel) {
		this.dutiesDel = dutiesDel;
	}
	public void setStationsDel(ArrayList<Station> stationsDel) {
		this.stationsDel = stationsDel;
	}

	class SearchListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e)
		{
			Object pattern=e.getSource();
			if(pattern.equals(workerSearchBut))
			{
				String keyword=workerField.getText();
				String category=(String) workerCat.getSelectedItem();
				workeResultList=(new DataBaseQuery().getWorkers(keyword, category));
				System.out.println(workeResultList.size());
				workerTable.setModel(new WorkerModel(workeResultList));
				
			}
			else if(pattern.equals(dutySearchBut))
			{
				String keyword=dutyField.getText();
				String category=(String) dutyCat.getSelectedItem();
				dutyResultList=(new DataBaseQuery().getDuties(keyword, category));
				System.out.println(dutyResultList.size());
				dutyTable.setModel(new DutyModel(dutyResultList));
				
			}
			else if(pattern.equals(stationSearchBut))
			{
				String keyword=stationField.getText();
				String category=(String) stationCat.getSelectedItem();
				stationResultList=(new DataBaseQuery().getBTS(keyword, category));
			
				stationTable.setModel(new StationModel(stationResultList));
				
			}
		
			
		}
		
		
		
	}
}
	
	