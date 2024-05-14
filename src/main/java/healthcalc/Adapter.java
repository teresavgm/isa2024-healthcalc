package healthcalc;

public class Adapter implements HealthHospital {

    private HealthCalc healthCalc;

    public Adapter(HealthCalc healthCalc) {
        this.healthCalc = healthCalc;
    }

    @Override
    public double bmr(Gender genero, int edad, float altura, int peso) {
        try {
            float alturaCM = 100*altura;
            float pesoKg = peso/1000;
            return healthCalc.basalMetabolicRate(pesoKg, (int) alturaCM, genero, edad);
        } catch (Exception e) {
            e.printStackTrace(); 
            return 0; 
        }
    }

    @Override
    public int pesoIdeal(Gender genero, float altura) {
        try {
            float alturaCM = 100*altura;
            return (int) healthCalc.idealWeight((int) alturaCM, genero);
        } catch (Exception e) {
            e.printStackTrace(); 
            return 0; 
        }
    }
}




