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

import Data.Worker;
import DataBase.DataBaseQuery;

public class WorkerEd extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ArrayList<Worker> list;
	private Worker worker;
	private JTextField nameField;
	private JTextField surnameField;
	private JLabel log ;
	
	public WorkerEd(ArrayList<Worker>list,Worker worker)
	{
		
		this.list=list;
		this.worker=worker;
		initGui();
		fillGaps(worker);
		
		
	}
	private void initGui()
	{
		log= new JLabel("");
		log.setForeground(new Color(255,255,255));
		log.setBounds(29, 133, 197, 14);
		getContentPane().add(log);
		setBounds(100, 100, 450, 200);
		getContentPane().setLayout(null);
		getContentPane().setBackground((new Color(45,45,45)));
		
		JLabel lblNewLabel = new JLabel("Imie");
		lblNewLabel.setForeground(new Color(0,168,255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		lblNewLabel.setBounds(29, 23, 103, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nazwisko");
		lblNewLabel_1.setForeground(new Color(0,168,255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(29, 78, 103, 14);
		getContentPane().add(lblNewLabel_1);
		
		nameField = new JTextField();
		nameField.setBounds(142, 20, 183, 20);
		nameField.setBackground(new Color(0,0,0));
		nameField.setBorder(null);
		nameField.setForeground(new Color(247,158,17));
		nameField.setFont(new Font("Arial", Font.ITALIC, 16));
		getContentPane().add(nameField);
		nameField.setColumns(10);
		
		surnameField = new  JTextField();
		surnameField.setBackground(new Color(0,0,0));
		surnameField.setBounds(142, 75, 183, 20);
		surnameField.setBorder(null);
		surnameField.setForeground(new Color(247,158,17));
		surnameField.setFont(new Font("Arial", Font.ITALIC, 16));
		getContentPane().add(surnameField);
		surnameField.setColumns(10);
		
		JButton addBut = new JButton("Edytuj");
		addBut.setBackground(new Color(15,15,15));
		addBut.setBounds(335, 127, 89, 23);
		addBut.setForeground(new Color(0,168,255));
		addBut.setFont(new Font("Arial", Font.BOLD, 16));
		addBut.setBorder(null);
		addBut.addActionListener(new EdListener(list));
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

		setVisible(true);
	}
	private void fillGaps(Worker worker)
	{
		
			nameField.setText(worker.getName());
			surnameField.setText(worker.getSurname());
		
	}
	public class EdListener implements ActionListener
	{
		private ArrayList<Worker> list;
		public EdListener(ArrayList<Worker> list)
		{
			this.list=list;
			
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String name=DataBaseQuery.convertFromPolish(nameField.getText());
			String surname=DataBaseQuery.convertFromPolish(surnameField.getText());
			worker.setName(name);
			worker.setSurname(surname);
			list.add(worker);
			nameField.setText("");
			surnameField.setText("");
			new DataBaseQuery().update(worker);
			log.setText("edytowano pracownika");
			
		}
		
		
	}
}
