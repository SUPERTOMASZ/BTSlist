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

import Data.Duty;
import Data.Worker;
import DataBase.DataBaseQuery;

public class DutyAdd extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ArrayList<Duty> list;
	private JTextField nameField;
	private JTextField surnameField1;
	private JTextField dataField;
	JLabel log;
	public DutyAdd(ArrayList<Duty>list)
	{
		
		this.list=list;
		init();
		
		setVisible(true);
	}
	private void init()
	{
		getContentPane().setLayout(null);
		getContentPane().setBackground((new Color(45,45,45)));
		
		JLabel lblNewLabel = new JLabel("Data");
		lblNewLabel.setForeground(new Color(0,168,255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		lblNewLabel.setBounds(29, 98, 103, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nazwisko");
		lblNewLabel_1.setForeground(new Color(0,168,255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(29, 67, 103, 14);
		getContentPane().add(lblNewLabel_1);
		
		nameField = new JTextField();
		nameField.setBounds(142, 34, 183, 20);
		nameField.setBackground(new Color(0,0,0));
		nameField.setBorder(null);
		nameField.setForeground(new Color(247,158,17));
		nameField.setFont(new Font("Arial", Font.ITALIC, 16));
		getContentPane().add(nameField);
		nameField.setColumns(10);
		
		surnameField1 = new  JTextField();
		surnameField1.setBackground(new Color(0,0,0));
		surnameField1.setBounds(142, 65, 183, 20);
		surnameField1.setBorder(null);
		surnameField1.setForeground(new Color(247,158,17));
		surnameField1.setFont(new Font("Arial", Font.ITALIC, 16));
		getContentPane().add(surnameField1);
		surnameField1.setColumns(10);
		JLabel lblImie = new JLabel("Imie");
		lblImie.setForeground(new Color(0, 168, 255));
		lblImie.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblImie.setBounds(29, 36, 103, 14);
		getContentPane().add(lblImie);
		
		dataField = new JTextField();
		dataField.setForeground(new Color(247, 158, 17));
		dataField.setFont(new Font("Arial", Font.ITALIC, 16));
		dataField.setColumns(10);
		dataField.setBorder(null);
		dataField.setBackground(Color.BLACK);
		dataField.setBounds(142, 96, 183, 20);
		getContentPane().add(dataField);
		setBounds(100, 100, 450, 200);

		
		JButton addBut = new JButton("Dodaj");
		addBut.setBackground(new Color(15,15,15));
		addBut.setBounds(335, 127, 89, 23);
		addBut.setForeground(new Color(0,168,255));
		addBut.setFont(new Font("Arial", Font.BOLD, 16));
		addBut.setBorder(null);
		addBut.addActionListener(new AddListener(list));
		getContentPane().add(addBut);
		
		JButton cancelBut = new JButton("Anuluj");
		cancelBut.setBackground(new Color(15,15,15));
		cancelBut.setBounds(236, 127, 89, 23);
		cancelBut.setForeground(new Color(0,168,255));
		cancelBut.setFont(new Font("Arial", Font.BOLD, 16));
		cancelBut.setBorder(null);
		cancelBut.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
		});
		getContentPane().add(cancelBut);
		
		log = new JLabel("");
		log.setBounds(29, 133, 197, 14);
		log.setForeground(new Color(255,255,255));
		getContentPane().add(log);
		
		this.dataField.setText("rrrr-mm-dd");
		
	}
	public class AddListener implements ActionListener
	{
		private ArrayList<Duty> list;
		public AddListener(ArrayList<Duty> list)
		{
			this.list=list;
			
		}
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			
			
			if (dataField.getText().matches("\\d{4}-\\d{2}-\\d{2}")) 
			{
				
				System.out.println("pasuje");
				String name=nameField.getText();
				name=DataBaseQuery.convertFromPolish(name);
				String surname=surnameField1.getText();
				surname=DataBaseQuery.convertFromPolish(surname);
				int workerId=(new DataBaseQuery().getWorkerId(name, surname));
				if(workerId!=-1)
				{
					System.out.println(workerId);
					Duty duty= new Duty();
					Worker worker= new Worker();
					worker.setID(workerId);
					worker.setName(name);
					worker.setSurname(surname);
					duty.setWorker(worker);
					duty.setData(dataField.getText());
					list.add(duty);
					new DataBaseQuery().insert(duty);
					log.setText("dodano");
					nameField.setText("");
					surnameField1.setText("");
					dataField.setText("");
				}
				else
					log.setText("nie znaleziono pracownika");
					
				}
			else
				log.setText("zly format daty");
		}
		
	}
}
