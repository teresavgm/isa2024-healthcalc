package healthcalc.gui;

import java.awt.EventQueue;

import healthcalc.HealthCalcImpl;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HealthCalcImpl healthCalc = HealthCalcImpl.getInstance();
					vista vista = new vista();
					controlador controlador = new controlador(healthCalc, vista);
					vista.registrarControlador(controlador);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}