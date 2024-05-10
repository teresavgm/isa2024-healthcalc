package healthcalc.gui;



import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JSpinner;

import javax.swing.JTextField;

public class vista {

	private JFrame frame;
	private JTextField textWeight;
	private JTextField textHeight;
	private JTextField textResultado;
	private JTextField textGender;

	private JSpinner textAge;
	private JButton btnClean;
	private JButton btnCalculateBMR;
	private JButton btnCalculateIdealWeight;
	
	
	/**
	 * Create the application.
	 */
	public vista() {
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(150, 203, 203));
		frame.setBounds(100, 100, 837, 342);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// JTextField para introducir el genero
		textGender = new JTextField();
		textGender.setColumns(10);
		textGender.setBounds(593, 185, 194, 29);
		frame.getContentPane().add(textGender);
		
		// JTextField para introducir el peso		
		textWeight = new JTextField();
		textWeight.setBounds(593, 72, 194, 29);
		frame.getContentPane().add(textWeight);
		textWeight.setColumns(10);
		
		// JTextField para introducir la altura
		textHeight = new JTextField();
		textHeight.setColumns(10);
		textHeight.setBounds(593, 128, 194, 29);
		frame.getContentPane().add(textHeight);

		textAge = new JSpinner();
		textAge.setFont(new Font("SansSerif", Font.PLAIN, 13));
		textAge.setBounds(593, 241, 194, 29);
		frame.getContentPane().add(textAge);
		
		//JTextFiel para mostrar el resultado
		textResultado = new JTextField();
		textResultado.setColumns(10);
		textResultado.setBounds(143, 225, 192, 39);
		frame.getContentPane().add(textResultado);
		textResultado.setEditable(false);
		
		
		
		//JLbel
		JLabel lblNewLabel = new JLabel("Weight (Kg):");
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.PLAIN, 19));
		lblNewLabel.setBounds(476, 67, 117, 40);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblHeightcnt = new JLabel("Height (cm):");
		lblHeightcnt.setFont(new Font("Sitka Subheading", Font.PLAIN, 19));
		lblHeightcnt.setBounds(476, 123, 117, 40);
		frame.getContentPane().add(lblHeightcnt);
		
		JLabel lblNewLabel_1_1 = new JLabel("Gender (w/m):");
		lblNewLabel_1_1.setFont(new Font("Sitka Subheading", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(468, 180, 148, 40);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Result:");
		lblNewLabel_1_1_1.setFont(new Font("Sitka Subheading", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(39, 225, 94, 40);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Health Calculator");
		lblNewLabel_1_1_1_1.setFont(new Font("Sitka Subheading", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(40, 23, 222, 40);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Age:");
		lblNewLabel_1_1_2.setFont(new Font("Sitka Subheading", Font.PLAIN, 18));
		lblNewLabel_1_1_2.setBounds(550, 236, 53, 40);
		frame.getContentPane().add(lblNewLabel_1_1_2);
	


		
		// Botones C�lculo de IdealWeight y BasalMR
		btnCalculateIdealWeight = new JButton("Calculate Ideal Weight");
		btnCalculateIdealWeight.setFont(new Font("Sitka Subheading", Font.PLAIN, 17));
		btnCalculateIdealWeight.setBounds(38, 96, 199, 67);
		frame.getContentPane().add(btnCalculateIdealWeight);

		btnCalculateBMR = new JButton("Calculate Basal BMR");
		btnCalculateBMR.setFont(new Font("Sitka Subheading", Font.PLAIN, 17));
		btnCalculateBMR.setBounds(251, 96, 188, 67);
		frame.getContentPane().add(btnCalculateBMR);
		
		//Boton para limpiar
		btnClean = new JButton("Clean");
		btnClean.setBackground(new Color(64, 128, 128));
		btnClean.setToolTipText("");
		btnClean.setFont(new Font("Sitka Subheading", Font.PLAIN, 17));
		btnClean.setBounds(345, 225, 94, 40);
		frame.getContentPane().add(btnClean);

		
		frame.pack();
		frame.setSize(880, 380);
		frame.setVisible(true);
	}

	public void setResults(float res) {
		textResultado.setText(String.valueOf(res));
	}

	public JTextField getWeightValue() {
		return textWeight;
	}
	public JTextField getHeightValue() {
		return textHeight;
	}
	public JTextField getResults() {
		return textResultado;
	}

	

	public int getGender(){
		String women = "w";
		String man = "m";
		if(	textGender.getText().equalsIgnoreCase(women)){
			return 0;
		}else if(textGender.getText().equalsIgnoreCase(man)){
			return 1;
		}else{
			return -1;
		}
	}

	public JSpinner getAge() {
		return textAge;
	}
	public JButton getBMR() {
		return btnCalculateBMR;
	}
	public JButton getIdealWeight() {
		return btnCalculateIdealWeight;
	}



	public void emptyHeight() {
		textHeight.setText("");
	}
	public void emptyWeight() {
		textWeight.setText("");
	}public void emptyResults() {
		textResultado.setText("");
	}public void emptyGender() {
		textGender.setText("");
	}public void emptyAge() {
		textAge.setValue("");
	}
	
	
	public void registrarControlador(ActionListener ctrl) {
		btnCalculateBMR.addActionListener(ctrl);
		btnCalculateBMR.setActionCommand("getBMR");
        
		btnCalculateIdealWeight.addActionListener(ctrl);
		btnCalculateIdealWeight.setActionCommand("getIdealW");

		btnClean.addActionListener(ctrl);
		btnClean.setActionCommand("clean");
        
	
	}


	
	
	public void errorInputsIW(String er) {
		JOptionPane.showMessageDialog(frame,
				er,
                "Entradas no validas para altura o g�nero",
                JOptionPane.ERROR_MESSAGE);
	}
	
	public void errorInputsBMR(String er) {
		JOptionPane.showMessageDialog(frame,
                er,
                "Entradas no v�lidas para altura, peso, g�nero o edad",
                JOptionPane.ERROR_MESSAGE);
	}
	
	public void faltanInputs() {
		JOptionPane.showMessageDialog(frame,
                "Introduzca los datos necesarios",
                "Error",
                JOptionPane.ERROR_MESSAGE);
	}
	
	
}