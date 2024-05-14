package healthcalc;

public class Adapter implements HealthHospital {

    private HealthCalc healthCalc;

    public Adapter(HealthCalc healthCalc) {
        this.healthCalc = healthCalc;
    }

    @Override
    public double bmr(Paciente p) {
        try {
            float alturaCM = 100* p.height();
            float pesoKg = p.weight()/1000;
            return healthCalc.basalMetabolicRate(p);
        } catch (Exception e) {
            e.printStackTrace(); 
            return 0; 
        }
    }

    @Override
    public int pesoIdeal(Paciente p) {
        try {
            float alturaCM = 100*p.height();
            return (int) healthCalc.idealWeight(p);
        } catch (Exception e) {
            e.printStackTrace(); 
            return 0; 
        }
    }
}




