package healthcalc;


import java.awt.EventQueue;

import healthcalc.HealthCalcImpl;

public class AdapterMain {
    public static void main(String[] args) {
        HealthCalc healthCalc = HealthCalcImpl.getInstance();
        HealthHospital adapter = new Adapter(healthCalc);

        // Utiliza el adapter para calcular el BMR
        double bmr = adapter.bmr('m', 30, 175.0f, 70);
        System.out.println("Basal Metabolic Rate (BMR): " + bmr);

        // Utiliza el adapter para calcular el peso ideal
        int pesoIdeal = adapter.pesoIdeal('m', 175.0f);
        System.out.println("Peso Ideal: " + pesoIdeal);


        

    }

}