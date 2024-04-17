package healthcalc.gui;


import java.awt.event.ActionListener;

import healthcalc.HealthCalcImpl;

import java.awt.Color;
import java.awt.event.ActionEvent;


public class controlador implements ActionListener{

	private HealthCalcImpl calc = new HealthCalcImpl();
	private vista vista;
	
	public controlador(HealthCalcImpl calc, vista window) {
		this.calc = calc;
		this.vista = window;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		switch (comando) {
			
			case "getBMR":
				calculateBMR();
				break;
			case "getIdealW":	
				calculateIdealWeight();
			break;
			case "clean":
				Limpiar();
				break;

				
		}
	
    }

private void calculateIdealWeight() {
	try {
		int height = Integer.parseInt(vista.getHeightValue().getText());
		int genderInt = vista.getGender();
		char gender = 'e';

		if(genderInt == 0){
			gender = 'w';
		}else if(genderInt == 1){
			gender = 'm';
		} 

		try {
			float idealWeight = this.calc.idealWeight(height, gender);
			vista.setResults(idealWeight);
		} catch (Exception e1) {
			vista.errorInputsIW(e1.getMessage());
		} 
		
	} catch (Exception e0) {
		vista.faltanInputs();
	}

}


private void calculateBMR() {
	try {
		int height = Integer.parseInt(vista.getHeightValue().getText());
		float weight = Float.parseFloat(vista.getWeightValue().getText());
		Integer age = (Integer) vista.getAge().getValue();
		int genderText = vista.getGender();

		char gender = 'e';

		if(genderText == 0){
			gender = 'w';
		}else if(genderText == 1){
			gender = 'm';
		} 

		try {
			float bmr = this.calc.basalMetabolicRate(weight, height, gender, age);
			vista.setResults(bmr);
		} catch (Exception e1) {
			vista.errorInputsBMR(e1.getMessage());
		}
	} catch (Exception e0) {
		vista.faltanInputs();
	}

}

private void Limpiar() {
	vista.emptyWeight();
	vista.emptyHeight();
	vista.emptyGender();
	vista.emptyResults();
    vista.emptyAge();
}

}