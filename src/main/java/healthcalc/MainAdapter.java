package healthcalc;

public class MainAdapter {

    public static void main(String[] args) throws Exception {
        HealthCalc healthCalc = HealthCalcImpl.getInstance();
        HealthHospital adapter = new Adapter(healthCalc);

        // Utiliza el adapter para calcular el BMR

        Paciente paciente = new Paciente(Gender.FEMALE, 50, (float) 1.72, 70000);
        double bmr = adapter.bmr(paciente);
        System.out.println("Basal Metabolic Rate (BMR): " + bmr);

        // Utiliza el adapter para calcular el peso ideal
        int pesoIdeal = adapter.pesoIdeal(paciente);
        System.out.println("Peso Ideal: " + pesoIdeal);


        

    }

}