package healthcalc.gui;

import java.awt.event.ActionListener;

import healthcalc.Gender;
import healthcalc.HealthCalcImpl;
import healthcalc.Paciente;

import java.awt.event.ActionEvent;


public class controlador implements ActionListener{

	private HealthCalcImpl calc =  HealthCalcImpl.getInstance();

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
		Gender gender = null;

		if(genderInt == 0){
			gender = Gender.FEMALE;
		}else if(genderInt == 1){
			gender =Gender.MALE;
		} 
		Paciente p  = new Paciente(gender, 0, height, 0);

		try {
			float idealWeight = this.calc.idealWeight(p);
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

		Gender gender = null;

		if(genderText == 0){
			gender = Gender.FEMALE;
		}else if(genderText == 1){
			gender =Gender.MALE;
		} 
		Paciente p  = new Paciente(gender, age, height, weight);
		try {
			float bmr = this.calc.basalMetabolicRate(p);
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