package healthcalc;

public class AdapterMain {
    public static void main(String[] args) {
        HealthCalc healthCalc = HealthCalcImpl.getInstance();
        HealthHospital adapter = new Adapter(healthCalc);

        // Utiliza el adapter para calcular el BMR
        double bmr = adapter.bmr('m', 50, (float) 1.72, 70000);
        System.out.println("Basal Metabolic Rate (BMR): " + bmr);

        // Utiliza el adapter para calcular el peso ideal
        int pesoIdeal = adapter.pesoIdeal('m', (float)1.5);
        System.out.println("Peso Ideal: " + pesoIdeal);


        

    }

}